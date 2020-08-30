package com.api.linkedin.perfil.domain.model;

import com.api.linkedin.utils.enums.TipoEmprego;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.YearMonth;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExperienciaProfissionalEntrada {

    @NotBlank(message = "{variavel.notblank}" + "cargo")
    @JsonProperty(value = "cargo")
    private String cargo;

    @NotBlank(message = "{variavel.notblank}" + "tipo_emprego")
    @JsonProperty(value = "tipo_emprego")
    private TipoEmprego tipoEmprego;

    @NotBlank(message = "{variavel.notblank}" + "descricao")
    @JsonProperty(value = "descricao")
    private String descricao;

    @NotBlank(message = "{variavel.notblank}" + "empresa")
    @JsonProperty(value = "empresa")
    private String empresa;

    @JsonProperty(value = "titulo_perfil", required = false, defaultValue = "true") //modificar
    private Boolean trabalhoAtual;

//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @NotBlank(message = "{variavel.notblank}" + "mes_inicio")
    @JsonProperty(value = "mes_inicio")
    private YearMonth mesInicio;

//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @NotBlank(message = "{variavel.notblank}" + "mes_fim")
    @JsonProperty(value = "mes_fim", required = false)
    private YearMonth mesFim;

    @NotNull(message = "{variavel.notnull}" + "localidade")
    @JsonProperty(value = "localidade")
    private LocalidadeEntrada localidade;
}
