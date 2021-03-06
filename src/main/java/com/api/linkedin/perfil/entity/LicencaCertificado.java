package com.api.linkedin.perfil.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.YearMonth;

@Data
@Entity
@Table(name = "tb_licenca_certificado")
public class LicencaCertificado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long idPerfil;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "organizacao_emissora ", nullable = false)
    private String organizacaoEmissora;

    @Column(name = "codigo_credencial", nullable = false)
    private String codigoCredencial;

    @Column(name = "url_credencial", nullable = false, unique = true)
    private String urlCredencial;

    @Column(name = "certificacao_expira", nullable = false)
    private Boolean certificacaoExpira;

    @Column(name = "mes_ano_emissao", nullable = false)
    private YearMonth mesAnoEmissao;

    @Column(name = "mes_ano_expiracao", nullable = true)
    private YearMonth mesAnoExpiracao;
}
