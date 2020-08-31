package com.api.linkedin.perfil.domain.model.licencacertificado;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.YearMonth;

@Data
public class LicencaCertificadoEntrada {
    @NotBlank
    @JsonProperty(value = "nome")
    private String nome;

    @NotBlank
    @JsonProperty(value = "organizacao_emissora")
    private String organizacaoEmissora;

    @JsonProperty(value = "codigo_credencial")
    private String codigoCredencial;

    @JsonProperty(value = "url_credencial")
    private String urlCredencial;

    @NotBlank
    @JsonProperty(value = "certificacao_expira", defaultValue = "true")
    private Boolean certificacaoExpira;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @JsonProperty(value = "mes_ano_emissao")
    private YearMonth mesAnoEmissao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @JsonProperty(value = "mes_ano_expiracao")
    private YearMonth mesAnoExpiracao;
}
