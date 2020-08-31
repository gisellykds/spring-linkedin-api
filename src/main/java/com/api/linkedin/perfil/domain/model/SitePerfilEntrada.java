package com.api.linkedin.perfil.domain.model;

import com.api.linkedin.utils.enums.TipoSite;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SitePerfilEntrada {

    @NotBlank
    @JsonProperty(value = "site")
    private String site;

    @NotBlank
    @JsonProperty(value = "tipo_site")
    private TipoSite tipoSite;
}
