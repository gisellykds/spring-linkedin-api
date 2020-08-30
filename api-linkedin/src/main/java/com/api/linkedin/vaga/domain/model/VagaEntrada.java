package com.api.linkedin.vaga.domain.model;

import com.api.linkedin.utils.enums.NivelExperiencia;
import com.api.linkedin.utils.enums.TipoEmpregoVaga;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class VagaEntrada {

    @NotBlank
    @JsonProperty("cargo")
    private String cargo;

    @NotBlank
    @JsonProperty("funcoes_cargo")
    private String funcoesCargo;

    @NotBlank
    @JsonProperty(value = "nivel_experiencia")
    private String nivelExperiencia;

    @NotBlank
    @JsonProperty("descricao")
    private String descricao;

    @NotBlank
    @JsonProperty("endereco_cidade")
    private String enderecoCidade;

    @NotBlank
    @JsonProperty(value = "tipo_emprego")
    private String tipoEmpregoVaga;

}
