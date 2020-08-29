package com.api.linkedin.vaga.mapper.impl;

import com.api.linkedin.utils.enums.StatusVaga;
import com.api.linkedin.vaga.domain.DetalhesVagaSaida;
import com.api.linkedin.vaga.domain.VagaEntrada;
import com.api.linkedin.vaga.domain.VagaSaida;
import com.api.linkedin.vaga.entity.DetalhesVaga;
import com.api.linkedin.vaga.entity.Vaga;
import com.api.linkedin.vaga.mapper.VagaMapper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class VagaMapperImpl implements VagaMapper {
    public Vaga mapToEntity(VagaEntrada vagaEntrada, Long idEmpresa) {
        Vaga entity = new Vaga();

        entity.setEmpresaId(idEmpresa);
        entity.setNumeroCandidaturas(0L);
        entity.setStatusVaga(StatusVaga.ABERTO);
        entity.setDetalhesVaga(mapToEntity(vagaEntrada));

        return entity;
    }

    public VagaSaida mapToSaida(Vaga entity) {
        VagaSaida saida = new VagaSaida();

        saida.setNumeroCandidaturas(entity.getNumeroCandidaturas());
        saida.setStatusVaga(entity.getStatusVaga());
        saida.setEmpresaId(entity.getEmpresaId());
        saida.setDetalhesVaga(mapToSaida(entity.getDetalhesVaga()));

        return saida;
    }

    @Override
    public List<VagaSaida> mapToSaida(List<Vaga> entities) {
        return entities
                .stream()
                .map(this::mapToSaida)
                .collect(toList());
    }

    private DetalhesVaga mapToEntity(VagaEntrada vagaEntrada){
        DetalhesVaga entity = new DetalhesVaga();

        entity.setCargo(vagaEntrada.getCargo());
        entity.setDescricao(vagaEntrada.getDescricao());
        entity.setEnderecoCidade(vagaEntrada.getEnderecoCidade());
        entity.setFuncoesCargo(vagaEntrada.getFuncoesCargo());
        entity.setNivelExperiencia(vagaEntrada.getNivelExperiencia());
        entity.setTipoEmpregoVaga(vagaEntrada.getTipoEmpregoVaga());

        return entity;
    }

    private DetalhesVagaSaida mapToSaida(DetalhesVaga entity){
        DetalhesVagaSaida saida = new DetalhesVagaSaida();

        saida.setCargo(entity.getCargo());
        saida.setDescricao(entity.getDescricao());
        saida.setEnderecoCidade(entity.getEnderecoCidade());
        saida.setFuncoesCargo(entity.getFuncoesCargo());
        saida.setNivelExperiencia(entity.getNivelExperiencia());
        saida.setTipoEmpregoVaga(entity.getTipoEmpregoVaga());
        return saida;
    }

}
