package com.api.linkedin.vaga.mapper;

import com.api.linkedin.vaga.domain.VagaEntrada;
import com.api.linkedin.vaga.domain.VagaSaida;
import com.api.linkedin.vaga.entity.Vaga;
import java.util.List;

public interface VagaMapper {
    public Vaga mapToEntity(VagaEntrada vagaEntrada, Long idEmpresa);

    public VagaSaida mapToSaida(Vaga entity);

    public List<VagaSaida> mapToSaida(List<Vaga> entities);

}
