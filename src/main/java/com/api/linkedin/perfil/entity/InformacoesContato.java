package com.api.linkedin.perfil.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<EmailPerfil> email = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "informacoes_site_fk", referencedColumnName = "id")
    private List<SitePerfil> site = new ArrayList<>();

}
