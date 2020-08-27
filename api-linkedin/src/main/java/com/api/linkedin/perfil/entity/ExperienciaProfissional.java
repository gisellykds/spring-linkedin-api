package com.api.linkedin.perfil.entity;

import com.api.linkedin.perfil.domain.enums.TipoEmpregoEnum;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_experiencia")
public class ExperienciaProfissional {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "tipo_emprego", nullable = false)
    private TipoEmpregoEnum tipoEmprego;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "empresa", nullable = false)
    private String empresa;

    @Column(name = "trabalho_atual", nullable = false)
    private Boolean trabalhoAtual;

    @Column(name = "mes_inicio", nullable = false)
    private LocalDate mesInicio;

    @Column(name = "mes_fim", nullable = false)
    private LocalDate mesFim;

    @OneToOne
    @JoinColumn(name = "localidade_fk", referencedColumnName = "id")
    private Localidade localidade;

}
