package com.api.linkedin.perfil.domain.model.experienciaprofissional;

import com.api.linkedin.perfil.domain.model.localidade.LocalidadeEntrada;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.YearMonth;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExperienciaProfissionalEntrada {

    @NotBlank
    @JsonProperty(value = "cargo")
    private String cargo;

    @NotBlank
    @JsonProperty(value = "tipo_emprego")
    private String tipoEmprego;

    @JsonProperty(value = "descricao")
    private String descricao;

    @NotBlank
    @JsonProperty(value = "empresa")
    private String empresa;

    @JsonProperty(value = "titulo_perfil", required = false, defaultValue = "true")
    private Boolean trabalhoAtual;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @NotBlank
    @JsonProperty(value = "mes_ano_inicio")
    private YearMonth mesInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @JsonProperty(value = "mes_ano_fim")
    private YearMonth mesFim;

    @JsonProperty(value = "localidade")
    private LocalidadeEntrada localidade;

}
