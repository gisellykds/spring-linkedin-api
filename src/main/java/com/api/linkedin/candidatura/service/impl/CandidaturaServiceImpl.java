package com.api.linkedin.candidatura.service.impl;

import com.api.linkedin.candidatura.domain.mapper.CandidaturaMapper;
import com.api.linkedin.candidatura.domain.mapper.impl.CandidaturaMapperImpl;
import com.api.linkedin.candidatura.domain.model.CandidaturaSaida;
import com.api.linkedin.candidatura.entity.Candidatura;
import com.api.linkedin.candidatura.repository.CandidaturaRepository;
import com.api.linkedin.candidatura.service.CandidaturaService;
import com.api.linkedin.perfil.service.PerfilService;
import com.api.linkedin.utils.validation.ValidationUtil;
import com.api.linkedin.vaga.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidaturaServiceImpl extends ValidationUtil implements CandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private VagaService vagaService;

    private CandidaturaMapper candidaturaMapper = new CandidaturaMapperImpl();

    @Override
    public void novo(Long idVaga, Long idPerfil) {
        perfilService.verificaExisteValidaStatus(idPerfil);
        vagaService.verificaExisteValidaStatus(idVaga);
        CandidaturaSaida procuraExistencia = buscaCandidaturasPorVagaEUsuario(idVaga, idPerfil);
        verificaIsNull(procuraExistencia, "CANDIDATURA-1");
        Candidatura entity = new Candidatura(idVaga, idPerfil);
        candidaturaRepository.save(entity);
        vagaService.iteraQuantidadeCandidaturas(idVaga);
    }

    @Override
    public List<CandidaturaSaida> buscaCandidaturasPorVaga(Long idVaga) {
        vagaService.verificaExiste(idVaga);
        List<Candidatura> candidaturas = candidaturaRepository.findByIdVaga(idVaga);
        verificaListaVazia(candidaturas);
        return candidaturaMapper.mapToSaida(candidaturas);
    }

    @Override
    public CandidaturaSaida buscaCandidaturasPorVagaEUsuario(Long idVaga, Long idPerfil) {
        perfilService.verificaExisteValidaStatus(idPerfil);
        vagaService.verificaExisteValidaStatus(idVaga);
        Candidatura candidatura = candidaturaRepository.findByIdVagaAndIdPerfil(idVaga, idPerfil);
        verificaIsNotNull(candidatura, "COD-1");
        return candidaturaMapper.mapToSaida(candidatura);
    }

    @Override
    public List<CandidaturaSaida> buscaCandidaturasPorUsuario(Long idPerfil) {
        perfilService.verificaExisteValidaStatus(idPerfil);
        List<Candidatura> candidaturas = candidaturaRepository.findByIdPerfil(idPerfil);
        verificaListaVazia(candidaturas);
        return candidaturaMapper.mapToSaida(candidaturas);
    }


}
