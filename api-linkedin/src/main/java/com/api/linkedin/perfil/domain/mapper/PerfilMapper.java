package com.api.linkedin.perfil.domain.mapper;

import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.entity.Perfil;
import org.mapstruct.Mapper;

@Mapper
public interface PerfilMapper {

    public Perfil mapToEntity(PerfilEntrada perfilEntrada);
}
