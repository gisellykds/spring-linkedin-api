package com.api.linkedin.perfil.domain.mapper;

import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.entity.Perfil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PerfilMapper {

    @Mappings({
            @Mapping(target = "localidade.id", ignore = true)//,
            //@Mapping(target = "informacoesContato.email.id", ignore = true)
//            @Mapping(target = "localidade.id", ignore = true)
//            @Mapping(target = "localidade.id", ignore = true),
    })
    public Perfil mapToEntity(PerfilEntrada perfilEntrada, Long idUsuario);
}
