package com.api.linkedin.perfil.entity;

import com.api.linkedin.utils.enums.TipoEmprego;
import lombok.Data;

import javax.persistence.*;
import java.time.YearMonth;

@Data
@Entity
@Table(name = "tb_experiencia")
public class ExperienciaProfissional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "id_perfil", nullable = false)
    private Long idPerfil;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "tipo_emprego", nullable = false)
    private TipoEmprego tipoEmprego;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @Column(name = "empresa", nullable = false)
    private String empresa;

    @Column(name = "trabalho_atual", nullable = false)
    private Boolean trabalhoAtual;

    @Column(name = "mes_inicio", nullable = false)
    private YearMonth mesInicio;

    @Column(name = "mes_fim", nullable = true)
    private YearMonth mesFim;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "localidade_fk", referencedColumnName = "id")
    private Localidade localidade;

}
