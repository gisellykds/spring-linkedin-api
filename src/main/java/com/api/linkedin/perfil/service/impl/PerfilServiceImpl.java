package com.api.linkedin.perfil.service.impl;

import com.api.linkedin.perfil.domain.mapper.PerfilMapper;
import com.api.linkedin.perfil.domain.mapper.impl.PerfilMapperImpl;
import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.entity.Perfil;
import com.api.linkedin.perfil.repository.PerfilRepository;
import com.api.linkedin.perfil.service.PerfilService;
import com.api.linkedin.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilServiceImpl extends ValidationUtil implements PerfilService{
    @Autowired
    private PerfilRepository perfilRepository;

    private PerfilMapper perfilMapper = new PerfilMapperImpl();

    public Perfil novoPerfil(PerfilEntrada entrada) {
        Perfil entity = perfilMapper.mapToEntity(entrada);
        entity = perfilRepository.save(entity);
        return entity;
    }

    @Override
    public void verificaExisteValidaStatus(Long id) {
        Optional<Perfil> usuario = perfilRepository.findById(id);
        verificaIsPresente(usuario, "PERFIL-1");
        verificaIsInativa(usuario.get().getStatus(), "PERFIL-2");
    }

}
