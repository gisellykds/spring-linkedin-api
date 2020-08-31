package com.api.linkedin.perfil.domain.model.licencacertificado;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.YearMonth;

@Data
public class LicencaCertificadoSaida {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "id_perfil")
    private Long idPerfil;

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "organizacao_emissora")
    private String organizacaoEmissora;

    @JsonProperty(value = "codigo_credencial")
    private String codigoCredencial;

    @JsonProperty(value = "url_credencial")
    private String urlCredencial;

    @JsonProperty(value = "certificacao_expira", defaultValue = "true")
    private Boolean certificacaoExpira;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @JsonProperty(value = "mes_ano_emissao")
    private YearMonth mesAnoEmissao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @JsonProperty(value = "mes_ano_expiracao")
    private YearMonth mesAnoExpiracao;
}
