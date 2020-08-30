package com.api.linkedin.perfil.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_informacao_contato")
public class InformacoesContato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "informacoes_email_fk", referencedColumnName = "id")
    private Set<EmailPerfil> email = new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "informacoes_site_fk", referencedColumnName = "id")
    private Set<SitePerfil> site = new HashSet<>();

}
