package com.api.linkedin.candidatura.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_candidatura")
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "id_vaga", nullable = false)
    private Long idVaga;

    @Column(name = "id_perfil", nullable = false)
    private Long idPerfil;

    @Column(name = "data_candidatura", nullable = false)
    private LocalDate dataCandidatura;

    public Candidatura(Long idVaga, Long idPerfil){
        this.idVaga = idVaga;
        this.idPerfil = idPerfil;
    }
}
