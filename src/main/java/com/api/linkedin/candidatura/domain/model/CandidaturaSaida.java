package com.api.linkedin.candidatura.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CandidaturaSaida {

    private Long idVaga;

    private Long idPerfil;

    private LocalDate dataCandidatura;

}
