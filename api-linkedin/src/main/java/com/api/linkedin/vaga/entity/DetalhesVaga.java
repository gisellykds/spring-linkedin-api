package com.api.linkedin.vaga.entity;

import com.api.linkedin.utils.enums.NivelExperiencia;
import com.api.linkedin.utils.enums.TipoEmpregoVaga;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_detalhes_vaga")
public class DetalhesVaga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "funcoes_cargo", nullable = false)
    private String funcoesCargo;

    @Column(name = "nivel_experiencia", nullable = false)
    private NivelExperiencia nivelExperiencia;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "endereco_cidade", nullable = false)
    private String enderecoCidade;

    @Column(name = "tipo_emprego", nullable = false)
    private TipoEmpregoVaga tipoEmpregoVaga;
}
