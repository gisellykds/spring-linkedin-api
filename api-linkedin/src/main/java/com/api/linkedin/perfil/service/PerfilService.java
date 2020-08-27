package com.api.linkedin.perfil.service;

import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.entity.Perfil;

public interface PerfilService {

    public Perfil novoPerfil(PerfilEntrada entrada);

}
