package com.api.linkedin.perfil.service;

import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.entity.Perfil;
import org.springframework.context.MessageSource;

public interface PerfilService {

    public Perfil novoPerfil(PerfilEntrada entrada) throws Exception;

}
