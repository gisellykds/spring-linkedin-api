package com.api.linkedin.perfil.entity;

import com.api.linkedin.utils.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone="GMT-3")
    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @Column(nullable = false, name = "status")
    private Status status;

    public Usuario(){
        this.status = Status.ATIVO;
    }

}
