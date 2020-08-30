package com.api.linkedin.perfil.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InformacoesContatoEntrada {

    @NotNull(message = "{variavel.notnull}" + "emails")
    @JsonProperty(value = "emails")
    private Set<EmailPerfilEntrada> email = new HashSet<>();

    @NotNull(message = "{variavel.notnull}" + "sites")
    @JsonProperty(value = "sites")
    private Set<SitePerfilEntrada> site = new HashSet<>();

}
