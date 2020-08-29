package com.api.linkedin.vaga.entity;

import com.api.linkedin.utils.enums.StatusVaga;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_vaga")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "empresa_id", nullable = false)
    private Long empresaId;

    @Column(name = "status", nullable = false)
    private StatusVaga statusVaga;

    @Column(name = "numero_candidaturas", nullable = false)
    private Long numeroCandidaturas;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "detalhes_vaga_fk", referencedColumnName = "id")
    private DetalhesVaga detalhesVaga;

}
