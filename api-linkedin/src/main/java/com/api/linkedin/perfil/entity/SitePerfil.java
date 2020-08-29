package com.api.linkedin.perfil.entity;

import com.api.linkedin.utils.enums.TipoSite;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_site")
public class SitePerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "site", nullable = false)
    private String site;

    @Column(name = "tipo_site", nullable = false)
    private TipoSite tipoSite;

}
