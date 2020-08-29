package com.api.linkedin.vaga.domain;

import com.api.linkedin.utils.enums.StatusVaga;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VagaSaida {

    @JsonProperty("id_empresa")
    private Long empresaId;

    @JsonProperty("status_vaga")
    private StatusVaga statusVaga;

    @JsonProperty("quantidade_candidaturas")
    private Long numeroCandidaturas;

    @JsonProperty("detalhes")
    private DetalhesVagaSaida detalhesVaga;

}
