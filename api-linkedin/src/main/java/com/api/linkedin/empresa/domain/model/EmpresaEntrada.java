package com.api.linkedin.empresa.domain.model;

import com.api.linkedin.utils.enums.Setor;
import com.api.linkedin.utils.enums.TipoEmpresa;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
public class EmpresaEntrada {

    @NotBlank
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("site")
    private String site;

    @NotBlank
    @JsonProperty(value = "setor")
    @Enumerated(EnumType.STRING)
    private Setor setor;

    @NotBlank
    @JsonProperty("tipo_empresa")
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;

    @JsonProperty("url_logo")
    private String urlLogo;

    @JsonProperty("slogan")
    private String slogan;
}
