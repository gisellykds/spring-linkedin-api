package com.api.linkedin.perfil.domain.model.formacaoacademica;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Year;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FormacaoAcademicaEntrada {

    @NotBlank
    @JsonProperty(value = "formacao")
    private String formacao;

    @NotBlank
    @JsonProperty(value = "area_estudo")
    private String areaEstudo;

    @NotNull
    @JsonProperty(value = "ano_inicio")
    private Year anoInicio;

    @NotNull
    @JsonProperty(value = "ano_fim")
    private Year anoFim;

    @NotBlank
    @JsonProperty(value = "nota")
    private String nota;

    @NotBlank
    @JsonProperty(value = "descricao")
    private String descricao;

    @NotBlank
    @JsonProperty(value = "instituicao")
    private String instituicao;

}
