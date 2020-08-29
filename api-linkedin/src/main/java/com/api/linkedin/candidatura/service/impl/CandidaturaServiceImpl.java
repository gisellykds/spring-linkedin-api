package com.api.linkedin.candidatura.service.impl;

import com.api.linkedin.candidatura.domain.CandidaturaSaida;
import com.api.linkedin.candidatura.domain.mapper.CandidaturaMapper;
import com.api.linkedin.candidatura.domain.mapper.impl.CandidaturaMapperImpl;
import com.api.linkedin.candidatura.entity.Candidatura;
import com.api.linkedin.candidatura.repository.CandidaturaRepository;
import com.api.linkedin.candidatura.service.CandidaturaService;
import com.api.linkedin.perfil.entity.Usuario;
import com.api.linkedin.perfil.repository.UsuarioRepository;
import com.api.linkedin.utils.exception.ValidationUtil;
import com.api.linkedin.vaga.entity.Vaga;
import com.api.linkedin.vaga.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CandidaturaServiceImpl extends ValidationUtil implements CandidaturaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    private CandidaturaMapper candidaturaMapper = new CandidaturaMapperImpl();

    @Override
    public void candidatura(Long idVaga, Long idUsuario) {
        verificaUsuarioExiste(idUsuario);
        verificaVagaExiste(idVaga);
        Candidatura entity = new Candidatura(idVaga, idUsuario);
        candidaturaRepository.save(entity);
        iteraQuantidadeCandidaturasVaga(idVaga);
    }

    @Override
    public List<CandidaturaSaida> buscaCandidaturasPorVaga(Long idVaga) {
        verificaVagaExiste(idVaga);
        List<Candidatura> candidaturas = candidaturaRepository.findAllByIdVaga(idVaga);
        verificaListaVazia(candidaturas);
        return candidaturaMapper.mapToSaida(candidaturas);
    }

    @Override
    public CandidaturaSaida buscaCandidaturasPorVagaEUsuario(Long idVaga, Long idUsuario) {
        verificaUsuarioExiste(idUsuario);
        Candidatura candidatura = candidaturaRepository.findAllByIdVagaAndIdUsuario(idUsuario);
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

    private void verificaUsuarioExiste(Long idUsuario){
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        verificaIsPresente(usuario, "USUARIO-1");
    }

    private void verificaVagaExiste(Long idVaga){
        Optional<Vaga> vaga = vagaRepository.findById(idVaga);
        verificaIsPresente(vaga, "VAGA-1");
    }

    private void iteraQuantidadeCandidaturasVaga(Long idVaga){
        Optional<Vaga> entity = vagaRepository.findById(idVaga);
        Vaga vaga = entity.get();
        vaga.setNumeroCandidaturas(vaga.getNumeroCandidaturas() + 1);
        vagaRepository.save(vaga);
    }

}
