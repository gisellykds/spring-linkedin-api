package com.api.linkedin.perfil.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailPerfilEntrada {

    @NotBlank(message = "{variavel.notblank}" + "email")
    @Email(message = "{email.invalid}")
    @JsonProperty(value = "email")
    private String email;

}
