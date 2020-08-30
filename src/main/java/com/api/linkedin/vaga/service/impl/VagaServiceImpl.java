package com.api.linkedin.vaga.service.impl;

import com.api.linkedin.empresa.service.EmpresaService;
import com.api.linkedin.utils.enums.NivelExperiencia;
import com.api.linkedin.utils.enums.StatusVaga;
import com.api.linkedin.utils.enums.TipoEmpregoVaga;
import com.api.linkedin.utils.validation.ValidationUtil;
import com.api.linkedin.vaga.domain.mapper.VagaMapper;
import com.api.linkedin.vaga.domain.mapper.impl.VagaMapperImpl;
import com.api.linkedin.vaga.domain.model.VagaEntrada;
import com.api.linkedin.vaga.domain.model.VagaSaida;
import com.api.linkedin.vaga.entity.DetalhesVaga;
import com.api.linkedin.vaga.entity.Vaga;
import com.api.linkedin.vaga.repository.DetalhesVagaRepository;
import com.api.linkedin.vaga.repository.VagaRepository;
import com.api.linkedin.vaga.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VagaServiceImpl extends ValidationUtil implements VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private DetalhesVagaRepository detalhesVagaRepository;

    @Autowired
    private EmpresaService empresaService;

    private VagaMapper vagaMapper = new VagaMapperImpl();

    @Override
    public VagaSaida novo(VagaEntrada vagaEntrada, Long idEmpresa) {
        empresaService.verificaEmpresaExisteValidaStatus(idEmpresa);
        Vaga entity = vagaRepository.save(vagaMapper.mapToEntity(vagaEntrada, idEmpresa));
        return vagaMapper.mapToSaida(entity);
    }

    @Override
    public void encerraCandidaturas(Long id) {
        verificaExisteValidaStatus(id);
        vagaRepository.encerraCandidatura(id);
    }

    @Override
    public VagaSaida buscaId(Long id) {
        Optional<Vaga> vaga = vagaRepository.findById(id);
        verificaIsPresente(vaga, "VAGA-1");
        return vagaMapper.mapToSaida(vaga.get());
    }

    @Override
    public List<VagaSaida> buscaTodas() {
        List<Vaga> vaga = vagaRepository.findAll();
        verificaListaVazia(vaga);
        return vagaMapper.mapToSaida(vaga);
    }

    @Override
    public List<VagaSaida> buscaTodasEmAberto() {
        List<Vaga> vaga = vagaRepository.findAllByStatusVaga(StatusVaga.ABERTO);
        verificaListaVazia(vaga);
        return vagaMapper.mapToSaida(vaga);
    }

    @Override
    public List<VagaSaida> buscaTodasPorEmpresa(Long empresaId) {
        List<Vaga> vagas = vagaRepository.findAllByEmpresaId(empresaId);
        verificaListaVazia(vagas);
        return vagaMapper.mapToSaida(vagas);
    }

    @Override
    public List<VagaSaida> buscaTodasPorNivelExperiencia(NivelExperiencia nivelExperiencia) {
        List<DetalhesVaga> detalhesVagas = detalhesVagaRepository.findAllByNivelExperiencia(nivelExperiencia);
        List<Vaga> vagas = vagaRepository.findAll();
        verificaListaVazia(vagas);
        verificaListaVazia(detalhesVagas);

        return vagaMapper.mapToSaida(buscaVagasPorDetalhes(detalhesVagas, vagas));
    }

    @Override
    public List<VagaSaida> buscaTodasPorTipoEmpregoVaga(TipoEmpregoVaga tipoEmpregoEnum) {
        List<DetalhesVaga> detalhesVagas = detalhesVagaRepository.findAllByTipoEmpregoVaga(tipoEmpregoEnum);
        List<Vaga> vagas = vagaRepository.findAll();
        verificaListaVazia(vagas);
        verificaListaVazia(detalhesVagas);
        return vagaMapper.mapToSaida(vagas);
    }

    @Override
    public void verificaExisteValidaStatus(Long id) {
        Optional<Vaga> vaga = vagaRepository.findById(id);
        verificaIsPresente(vaga, "VAGA-1");
        verificaIsInativa(vaga.get().getStatusVaga(), "VAGA-2");
    }

    @Override
    public void verificaExiste(Long id) {
        Optional<Vaga> vaga = vagaRepository.findById(id);
        verificaIsPresente(vaga, "VAGA-1");
    }

    @Override
    public void iteraQuantidadeCandidaturas(Long idVaga) {
        Optional<Vaga> entity = vagaRepository.findById(idVaga);
        Vaga vaga = entity.get();
        vaga.setNumeroCandidaturas(vaga.getNumeroCandidaturas() + 1);
        vagaRepository.save(vaga);
    }

    private List<Vaga> buscaVagasPorDetalhes(List<DetalhesVaga> detalhesVagas, List<Vaga> vagas) {
        List<Vaga> saida = new ArrayList<>();
        verificaListaVazia(vagas);
        verificaListaVazia(detalhesVagas);

        for (DetalhesVaga detalhesVaga : detalhesVagas) {
            for (Vaga vaga : vagas) {
                if (vaga.getDetalhesVaga().getId().equals(detalhesVaga.getId())) {
                    saida.add(vaga);
                }
            }
        }
        return saida;
    }

}


