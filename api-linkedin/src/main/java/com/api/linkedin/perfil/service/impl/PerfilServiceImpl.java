package com.api.linkedin.perfil.service.impl;

import com.api.linkedin.perfil.domain.mapper.PerfilMapper;
import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.entity.Perfil;
import com.api.linkedin.perfil.repository.PerfilRepository;
import com.api.linkedin.perfil.service.PerfilService;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;
    private PerfilMapper perfilMapper;

    public Perfil novoPerfil(PerfilEntrada entrada){
        Perfil entity = perfilMapper.mapToEntity(entrada);
        return perfilRepository.save(entity);
    }
}
