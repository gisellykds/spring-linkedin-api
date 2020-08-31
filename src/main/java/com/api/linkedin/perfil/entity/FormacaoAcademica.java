package com.api.linkedin.perfil.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Year;

@Data
@Entity
@Table(name = "tb_formacao_academica")
public class FormacaoAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "id_usuario")
    private Long idPerfil;

    @Column(name = "formacao", nullable = false)
    private String formacao;

    @Column(name = "area_estudo", nullable = false)
    private String areaEstudo;

    @Column(name = "ano_inicio", nullable = false)
    private Year anoInicio;

    @Column(name = "ano_fim", nullable = false)
    private Year anoFim;

    @Column(name = "nota", nullable = true)
    private String nota;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @Column(name = "instituicao", nullable = false)
    private String instituicao;

}
