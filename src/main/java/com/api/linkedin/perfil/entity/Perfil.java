package com.api.linkedin.perfil.entity;

import com.api.linkedin.utils.enums.Setor;
import com.api.linkedin.utils.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone="GMT-3")
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @Column(nullable = false, name = "status")
    private Status status;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "titulo_perfil", nullable = false)
    private String tituloPerfil;

    @Column(name = "setor", nullable = false)
    private Setor setor;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "localidade_fk", referencedColumnName = "id")
    private Localidade localidade;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "informacoes_contato_fk", referencedColumnName = "id")
    private InformacoesContato informacoesContato;

}
