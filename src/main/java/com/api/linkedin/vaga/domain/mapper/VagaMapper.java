package com.api.linkedin.vaga.domain.mapper;

import com.api.linkedin.vaga.domain.model.VagaEntrada;
import com.api.linkedin.vaga.domain.model.VagaSaida;
import com.api.linkedin.vaga.entity.Vaga;

import java.util.List;

public interface VagaMapper {
    public Vaga mapToEntity(VagaEntrada vagaEntrada, Long idEmpresa);

    public VagaSaida mapToSaida(Vaga entity);

    public List<VagaSaida> mapToSaida(List<Vaga> entities);

}
