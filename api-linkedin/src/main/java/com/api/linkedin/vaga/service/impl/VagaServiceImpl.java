package com.api.linkedin.vaga.service.impl;

import com.api.linkedin.empresa.entity.Empresa;
import com.api.linkedin.empresa.repository.EmpresaRepository;
import com.api.linkedin.utils.enums.NivelExperiencia;
import com.api.linkedin.utils.enums.StatusVaga;
import com.api.linkedin.utils.enums.TipoEmpregoVaga;
import com.api.linkedin.utils.validation.ValidationUtil;
import com.api.linkedin.vaga.domain.VagaEntrada;
import com.api.linkedin.vaga.domain.VagaSaida;
import com.api.linkedin.vaga.entity.DetalhesVaga;
import com.api.linkedin.vaga.entity.Vaga;
import com.api.linkedin.vaga.mapper.VagaMapper;
import com.api.linkedin.vaga.mapper.impl.VagaMapperImpl;
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
    private EmpresaRepository empresaRepository;
    @Autowired
    private DetalhesVagaRepository detalhesVagaRepository;

    private VagaMapper vagaMapper = new VagaMapperImpl();

    @Override
    public VagaSaida novo(VagaEntrada vagaEntrada, Long idEmpresa) {
        verificaEmpresaExisteValidaStatus(idEmpresa);
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

    private void verificaEmpresaExisteValidaStatus(Long idEmpresa) {
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        verificaIsPresente(empresa, "EMPRESA-1");
        verificaIsInativa(empresa.get().getStatus(), "EMPRESA-2");
    }

    private void verificaExisteValidaStatus(Long id) {
        Optional<Vaga> vaga = vagaRepository.findById(id);
        verificaIsPresente(vaga, "VAGA-1");
        verificaIsInativa(vaga.get().getStatusVaga(), "VAGA-2");
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


