package com.api.linkedin.candidatura.service.impl;

import com.api.linkedin.candidatura.domain.mapper.CandidaturaMapper;
import com.api.linkedin.candidatura.domain.mapper.impl.CandidaturaMapperImpl;
import com.api.linkedin.candidatura.domain.model.CandidaturaSaida;
import com.api.linkedin.candidatura.entity.Candidatura;
import com.api.linkedin.candidatura.repository.CandidaturaRepository;
import com.api.linkedin.candidatura.service.CandidaturaService;
import com.api.linkedin.perfil.entity.Usuario;
import com.api.linkedin.perfil.repository.UsuarioRepository;
import com.api.linkedin.utils.validation.ValidationUtil;
import com.api.linkedin.vaga.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidaturaServiceImpl extends ValidationUtil implements CandidaturaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Autowired
    private VagaService vagaService;

    private CandidaturaMapper candidaturaMapper = new CandidaturaMapperImpl();

    @Override
    public void novo(Long idVaga, Long idUsuario) {
        verificaUsuarioExiste(idUsuario);
        vagaService.verificaExisteValidaStatus(idVaga);
        Candidatura entity = new Candidatura(idVaga, idUsuario);
        candidaturaRepository.save(entity);
        vagaService.iteraQuantidadeCandidaturas(idVaga);
    }

    @Override
    public List<CandidaturaSaida> buscaCandidaturasPorVaga(Long idVaga) {
        vagaService.verificaExiste(idVaga);
        List<Candidatura> candidaturas = candidaturaRepository.findAllByIdVaga(idVaga);
        verificaListaVazia(candidaturas);
        return candidaturaMapper.mapToSaida(candidaturas);
    }

    @Override
    public CandidaturaSaida buscaCandidaturasPorVagaEUsuario(Long idVaga, Long idUsuario) {
        verificaUsuarioExiste(idUsuario);
        Candidatura candidatura = candidaturaRepository.findAllByIdVagaAndIdUsuario(idVaga, idUsuario);
        verificaIsNotNull(candidatura, "COD-1");
        return candidaturaMapper.mapToSaida(candidatura);
    }

    @Override
    public List<CandidaturaSaida> buscaCandidaturasPorUsuario(Long idUsuario) {
        verificaUsuarioExiste(idUsuario);
        List<Candidatura> candidaturas = candidaturaRepository.findAllByIdUsuario(idUsuario);
        verificaListaVazia(candidaturas);
        return candidaturaMapper.mapToSaida(candidaturas);
    }

    private void verificaUsuarioExiste(Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        verificaIsPresente(usuario, "USUARIO-1");
    }


}
