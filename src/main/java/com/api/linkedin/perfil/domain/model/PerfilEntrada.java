package com.api.linkedin.perfil.domain.model;

import com.api.linkedin.perfil.domain.model.localidade.LocalidadeEntrada;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PerfilEntrada {

    @NotBlank
    @JsonProperty(value = "nome")
    private String nome;

    @NotBlank
    @JsonProperty(value = "sobrenome")
    private String sobrenome;

    @NotBlank
    @JsonProperty(value = "titulo_perfil")
    private String tituloPerfil;

    @NotBlank
    @JsonProperty(value = "setor")
    private String setor;

    @NotNull
    @JsonProperty(value = "localidade")
    private LocalidadeEntrada localidade;

    @NotNull
    @JsonProperty(value = "informacoes_contato")
    private InformacoesContatoEntrada informacoesContato;

}
