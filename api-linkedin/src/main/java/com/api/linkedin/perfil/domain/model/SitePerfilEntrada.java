package com.api.linkedin.perfil.domain.model;

import com.api.linkedin.perfil.domain.enums.TipoSiteEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SitePerfilEntrada {

    @NotBlank(message = "{variavel.notblank}" + "site")
    @JsonProperty(value = "site")
    private String site;

    @NotBlank(message = "{variavel.notblank}" + "tipo_site")
    @JsonProperty(value = "tipo_site")
    private TipoSiteEnum tipoSiteEnum;
}
