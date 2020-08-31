package com.api.linkedin.perfil.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InformacoesContatoEntrada {

    @JsonProperty(value = "emails")
    private Set<EmailPerfilEntrada> email = new HashSet<>();

    @JsonProperty(value = "sites")
    private Set<SitePerfilEntrada> site = new HashSet<>();

}
