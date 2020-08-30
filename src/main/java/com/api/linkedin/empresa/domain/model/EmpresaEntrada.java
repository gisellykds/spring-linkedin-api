package com.api.linkedin.empresa.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
    private String setor;

    @NotBlank
    @JsonProperty("tipo_empresa")
    private String tipoEmpresa;

    @JsonProperty("url_logo")
    private String urlLogo;

    @JsonProperty("slogan")
    private String slogan;
}
