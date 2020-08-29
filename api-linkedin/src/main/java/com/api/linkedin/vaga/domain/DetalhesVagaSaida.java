package com.api.linkedin.vaga.domain;

import com.api.linkedin.utils.enums.NivelExperiencia;
import com.api.linkedin.utils.enums.TipoEmpregoVaga;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DetalhesVagaSaida {

    @JsonProperty("cargo")
    private String cargo;

    @JsonProperty("funcoes_cargo")
    private String funcoesCargo;

    @JsonProperty("nivel_experiencia")
    private NivelExperiencia nivelExperiencia;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("endereco_cidade")
    private String enderecoCidade;

    @JsonProperty("tipo_emprego")
    private TipoEmpregoVaga tipoEmpregoVaga;


}
