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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "localidade_fk", referencedColumnName = "id")
    private Localidade localidade;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "informacoes_contato_fk", referencedColumnName = "id")
    private InformacoesContato informacoesContato;

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "perfil_experiencia_profissional_fk", referencedColumnName = "id")
    private List<ExperienciaProfissional> experienciaProfissional = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "perfil_formacao_academica_fk", referencedColumnName = "id")
    private List<FormacaoAcademica> formacaoAcademica = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "perfil_licenca_certificado_fk", referencedColumnName = "id")
    private List<LicencaCertificado> licencaCertificado = new ArrayList<>();

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id")
    private Usuario usuario;

}
