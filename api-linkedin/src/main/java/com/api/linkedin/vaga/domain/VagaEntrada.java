package com.api.linkedin.vaga.domain;

import com.api.linkedin.utils.enums.NivelExperiencia;
import com.api.linkedin.utils.enums.TipoEmpregoVaga;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
public class VagaEntrada {

    @NotBlank
    @JsonProperty("cargo")
    private String cargo;

    @NotBlank
    @JsonProperty("funcoes_cargo")
    private String funcoesCargo;

    @JsonProperty(value = "nivel_experiencia", defaultValue = "NAO_APLICAVEL")
    @Enumerated(value = EnumType.STRING)
    private NivelExperiencia nivelExperiencia;

    @NotBlank
    @JsonProperty("descricao")
    private String descricao;

    @NotBlank
    @JsonProperty("endereco_cidade")
    private String enderecoCidade;

    @JsonProperty(value = "tipo_emprego", defaultValue = "PERIODO_INTEGRAL")
    @Enumerated(value = EnumType.STRING)
    private TipoEmpregoVaga tipoEmpregoVaga;

}
