package com.api.linkedin.perfil.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_localidade")
@Data
public class Localidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;
}
