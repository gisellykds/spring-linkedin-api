package com.api.linkedin.perfil.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PerfilEntrada {

    //@NotBlank(message = "{variavel.notblank}" + "nome")
    @JsonProperty(value = "nome")
    private String nome;

    //@NotBlank(message = "{variavel.notblank}" + "sobrenome")
    @JsonProperty(value = "sobrenome")
    private String sobrenome;

    //@NotBlank(message = "{variavel.notblank}" + "titulo_perfil")
    @JsonProperty(value = "titulo_perfil")
    private String tituloPerfil;

    //@NotBlank(message = "{variavel.notblank}" + "setor")
    @JsonProperty(value = "setor")
    private String setor;

    //@NotNull(message = "{variavel.notnull}" + "localidade")
    @JsonProperty(value = "localidade")
    private LocalidadeEntrada localidade;

    //@NotNull(message = "{variavel.notnull}" + "informacoes_contato")
    @JsonProperty(value = "informacoes_contato")
    private InformacoesContatoEntrada informacoesContato;

    //@NotNull(message = "{variavel.notnull}" + "experiencia_profissional")
    @JsonProperty(value = "experiencias_profissionais")
    private List<ExperienciaProfissionalEntrada> experienciaProfissional = new ArrayList<>();

    //@NotNull(message = "{variavel.notnull}" + "formacao_academica")
    @JsonProperty(value = "formacoes_academicas")
    private List<FormacaoAcademicaEntrada> formacaoAcademica = new ArrayList<>();

    //@NotNull(message = "{variavel.notnull}" + "licenca_certificado")
    @JsonProperty(value = "licencas_certificados")
    private List<LicencaCertificadoEntrada> licencaCertificado = new ArrayList<>();

}
