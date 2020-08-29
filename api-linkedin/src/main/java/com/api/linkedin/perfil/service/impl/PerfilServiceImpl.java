package com.api.linkedin.perfil.service.impl;

import com.api.linkedin.perfil.domain.mapper.PerfilMapper;
import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.entity.Perfil;
import com.api.linkedin.perfil.entity.Usuario;
import com.api.linkedin.perfil.repository.PerfilRepository;
import com.api.linkedin.perfil.repository.UsuarioRepository;
import com.api.linkedin.perfil.service.PerfilService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService{
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    private PerfilMapper perfilMapper = Mappers.getMapper(PerfilMapper.class);

    public Perfil novoPerfil(PerfilEntrada entrada) {
        Usuario usuario = usuarioRepository.save(new Usuario());
        //verificaIsNotNull(usuario);

        Perfil entity = perfilMapper.mapToEntity(entrada, usuario.getId());

        return perfilRepository.save(entity);
    }


}
