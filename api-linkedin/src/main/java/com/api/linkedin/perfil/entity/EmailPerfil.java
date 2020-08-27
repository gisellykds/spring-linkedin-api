package com.api.linkedin.perfil.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_email")
public class EmailPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

}
