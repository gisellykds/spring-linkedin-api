package com.api.linkedin.perfil.service.impl;

import com.api.linkedin.perfil.entity.Usuario;
import com.api.linkedin.perfil.repository.UsuarioRepository;
import com.api.linkedin.perfil.service.UsuarioService;
import com.api.linkedin.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends ValidationUtil implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void verificaUsuarioExisteValidaStatus(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        verificaIsPresente(usuario, "USUARIO-1");
        verificaIsInativa(usuario.get().getStatus(), "USUARIO-2");
    }

}
