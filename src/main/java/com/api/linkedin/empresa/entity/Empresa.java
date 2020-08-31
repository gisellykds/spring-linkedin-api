package com.api.linkedin.empresa.entity;

import com.api.linkedin.utils.enums.Setor;
import com.api.linkedin.utils.enums.Status;
import com.api.linkedin.utils.enums.TipoEmpresa;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "id_perfil", nullable = false)
    private Long idPerfil;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "site", nullable = true)
    private String site;

    @Column(name = "setor", nullable = false)
    private Setor setor;

    @Column(name = "tipo_empresa", nullable = false)
    private TipoEmpresa tipoEmpresa;

    @Column(name = "imagem_logo", nullable = true)
    private String urlLogo;

    @Column(name = "slogan", nullable = true)
    private String slogan;

}
