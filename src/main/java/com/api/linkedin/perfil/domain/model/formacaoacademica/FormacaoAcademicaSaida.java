package com.api.linkedin.perfil.domain.model.formacaoacademica;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Year;

@Data
public class FormacaoAcademicaSaida {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "id_perfil")
    private Long idPerfil;

    @JsonProperty(value = "formacao")
    private String formacao;

    @JsonProperty(value = "area_estudo")
    private String areaEstudo;

    @JsonProperty(value = "ano_inicio")
    private Year anoInicio;

    @JsonProperty(value = "ano_fim")
    private Year anoFim;

    @JsonProperty(value = "nota")
    private String nota;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "instituicao")
    private String instituicao;

}
