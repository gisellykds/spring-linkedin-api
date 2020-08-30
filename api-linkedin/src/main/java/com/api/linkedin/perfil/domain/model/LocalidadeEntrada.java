package com.api.linkedin.perfil.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalidadeEntrada {

    @NotBlank(message = "{variavel.notblank}" + "pais")
    @JsonProperty(value = "pais")
    private String pais;

    @NotBlank(message = "{variavel.notblank}" + "estado")
    @JsonProperty(value = "estado")
    private String estado;

    @NotBlank(message = "{variavel.notblank}" + "cidade")
    @JsonProperty(value = "cidade")
    private String cidade;
}
