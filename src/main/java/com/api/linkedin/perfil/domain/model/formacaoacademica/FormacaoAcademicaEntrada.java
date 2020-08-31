package com.api.linkedin.perfil.domain.model.formacaoacademica;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.Year;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FormacaoAcademicaEntrada {

    @NotBlank(message = "{variavel.notblank}" + "formacao")
    @JsonProperty(value = "formacao")
    private String formacao;

    @NotBlank(message = "{variavel.notblank}" + "area_estudo")
    @JsonProperty(value = "area_estudo")
    private String areaEstudo;

    @NotBlank(message = "{variavel.notblank}" + "ano_inicio")
    @JsonProperty(value = "ano_inicio")
    private Year anoInicio;

    @NotBlank(message = "{variavel.notblank}" + "ano_fim")
    @JsonProperty(value = "ano_fim")
    private Year anoFim;

    @NotBlank(message = "{variavel.notblank}" + "nota")
    @JsonProperty(value = "nota")
    private String nota;

    @NotBlank(message = "{variavel.notblank}" + "descricao")
    @JsonProperty(value = "descricao")
    private String descricao;

    @NotBlank(message = "{variavel.notblank}" + "instituicao")
    @JsonProperty(value = "instituicao")
    private String instituicao;

}
