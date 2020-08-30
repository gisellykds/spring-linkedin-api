package com.api.linkedin.perfil.controller;

import com.api.linkedin.perfil.domain.model.PerfilEntrada;
import com.api.linkedin.perfil.entity.Perfil;
import com.api.linkedin.perfil.service.PerfilService;
import com.api.linkedin.utils.exception.response.ApiLinkedinException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/linkedin/perfil")
@Validated
@CrossOrigin
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public Perfil criar(@RequestBody @Valid @NotNull PerfilEntrada perfilEntrada) throws Exception {
        return perfilService.novoPerfil(perfilEntrada);
    }

}
