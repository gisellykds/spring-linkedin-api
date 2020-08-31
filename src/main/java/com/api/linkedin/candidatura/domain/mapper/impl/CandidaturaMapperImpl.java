package com.api.linkedin.candidatura.domain.mapper.impl;

import com.api.linkedin.candidatura.domain.mapper.CandidaturaMapper;
import com.api.linkedin.candidatura.domain.model.CandidaturaSaida;
import com.api.linkedin.candidatura.entity.Candidatura;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CandidaturaMapperImpl implements CandidaturaMapper {

    @Override
    public List<CandidaturaSaida> mapToSaida(List<Candidatura> candidaturas) {
        return candidaturas.stream().map(this::mapToSaida).collect(toList());
    }

    @Override
    public CandidaturaSaida mapToSaida(Candidatura candidatura) {
        CandidaturaSaida saida = new CandidaturaSaida();
        saida.setIdVaga(candidatura.getIdVaga());
        saida.setIdPerfil(candidatura.getIdPerfil());
        saida.setDataCandidatura(candidatura.getDataCandidatura());
        return saida;
    }
}
