package com.api.linkedin.perfil.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailPerfilEntrada {

    @NotBlank
    @Email
    @JsonProperty(value = "email")
    private String email;

}
