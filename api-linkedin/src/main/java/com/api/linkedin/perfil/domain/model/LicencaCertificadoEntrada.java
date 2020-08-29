package com.api.linkedin.perfil.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.YearMonth;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LicencaCertificadoEntrada {
    //@NotBlank(message = "{variavel.notblank}" + "nome")
    @JsonProperty(value = "nome")
    private String nome;

    //@NotBlank(message = "{variavel.notblank}" + "organizacao_emissora")
    @JsonProperty(value = "organizacao_emissora")
    private String organizacaoEmissora;

    @NotBlank(message = "{variavel.notblank}" + "codigo_credencial")
    @JsonProperty(value = "codigo_credencial")
    private String codigoCredencial;

    //@NotBlank(message = "{variavel.notblank}" + "url_credencial")
    @JsonProperty(value = "url_credencial")
    private String urlCredencial;

    //@NotBlank(message = "{variavel.notblank}" + "certificacao_expira")
    @JsonProperty(value = "certificacao_expira", defaultValue = "true")
    private Boolean certificacaoExpira;

    //@NotBlank(message = "{variavel.notblank}" + "mes_ano_emissao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @JsonProperty(value = "mes_ano_emissao")
    private YearMonth mesAnoEmissao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @JsonProperty(value = "mes_ano_expiracao")
    private YearMonth mesAnoExpiracao;
}
