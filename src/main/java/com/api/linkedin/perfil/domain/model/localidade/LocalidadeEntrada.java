package com.api.linkedin.perfil.domain.model.localidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalidadeEntrada {

    @NotBlank
    @JsonProperty(value = "pais")
    private String pais;

    @NotBlank
    @JsonProperty(value = "estado")
    private String estado;

    @NotBlank
    @JsonProperty(value = "cidade")
    private String cidade;
}
