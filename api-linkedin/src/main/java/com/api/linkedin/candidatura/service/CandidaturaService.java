package com.api.linkedin.candidatura.service;

import com.api.linkedin.candidatura.domain.model.CandidaturaSaida;
import java.util.List;

public interface CandidaturaService {

    public void novo(Long idVaga, Long idUsuario);

    public List<CandidaturaSaida> buscaCandidaturasPorVaga(Long idVaga);

    public CandidaturaSaida buscaCandidaturasPorVagaEUsuario(Long idVaga, Long idUsuario);

    public List<CandidaturaSaida> buscaCandidaturasPorUsuario(Long idUsuario);

}
