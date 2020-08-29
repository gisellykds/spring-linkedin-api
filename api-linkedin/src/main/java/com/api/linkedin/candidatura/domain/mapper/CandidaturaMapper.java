package com.api.linkedin.candidatura.domain.mapper;

import com.api.linkedin.candidatura.domain.CandidaturaSaida;
import com.api.linkedin.candidatura.entity.Candidatura;

import java.util.List;

public interface CandidaturaMapper {
    List<CandidaturaSaida> mapToSaida(List<Candidatura> candidaturas);

    CandidaturaSaida mapToSaida(Candidatura candidatura);

}
