package com.api.linkedin.perfil.domain.model.localidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocalidadeSaida {
    @JsonProperty(value = "pais")
    private String pais;

    @JsonProperty(value = "estado")
    private String estado;

    @JsonProperty(value = "cidade")
    private String cidade;

}
