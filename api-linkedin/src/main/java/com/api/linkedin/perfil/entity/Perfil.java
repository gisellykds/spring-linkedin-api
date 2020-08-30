package com.api.linkedin.perfil.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "titulo_perfil", nullable = false)
    private String tituloPerfil;

    @Column(name = "setor", nullable = false)
    private String setor;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "localidade_fk", referencedColumnName = "id")
    private Localidade localidade;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "informacoes_contato_fk", referencedColumnName = "id")
    private InformacoesContato informacoesContato;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "perfil_experiencia_profissional_fk", referencedColumnName = "id")
    private List<ExperienciaProfissional> experienciaProfissional = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "perfil_formacao_academica_fk", referencedColumnName = "id")
    private List<FormacaoAcademica> formacaoAcademica = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "perfil_licenca_certificado_fk", referencedColumnName = "id")
    private List<LicencaCertificado> licencaCertificado = new ArrayList<>();

    @Column(nullable = false, name = "id_usuario")
    private Long idUsuario;

}
