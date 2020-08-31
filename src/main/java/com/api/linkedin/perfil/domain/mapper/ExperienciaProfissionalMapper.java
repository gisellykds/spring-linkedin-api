package com.api.linkedin.perfil.domain.mapper;

import com.api.linkedin.perfil.domain.model.experienciaprofissional.ExperienciaProfissionalEntrada;
import com.api.linkedin.perfil.domain.model.experienciaprofissional.ExperienciaProfissionalSaida;
import com.api.linkedin.perfil.entity.ExperienciaProfissional;

import java.util.List;

public interface ExperienciaProfissionalMapper {
    ExperienciaProfissionalSaida mapToSaida(ExperienciaProfissional entity);
    ExperienciaProfissionalSaida mapToSaida(List<ExperienciaProfissional> entity);

    ExperienciaProfissional mapToEntityUpdate(ExperienciaProfissionalEntrada experienciaProfissionalEntrada, ExperienciaProfissional banco);
    ExperienciaProfissional mapToEntity(ExperienciaProfissionalEntrada experienciaProfissionalEntrada, Long idPerfil);
}
