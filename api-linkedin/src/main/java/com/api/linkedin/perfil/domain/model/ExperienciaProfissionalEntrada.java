package com.api.linkedin.perfil.domain.model;

import com.api.linkedin.perfil.domain.enums.TipoEmpregoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExperienciaProfissionalEntrada {

    @NotBlank(message = "{variavel.notblank}" + "cargo")
    @JsonProperty(value = "cargo")
    private String cargo;

    @NotBlank(message = "{variavel.notblank}" + "tipo_emprego")
    @JsonProperty(value = "tipo_emprego")
    private TipoEmpregoEnum tipoEmprego;

    @NotBlank(message = "{variavel.notblank}" + "descricao")
    @JsonProperty(value = "descricao")
    private String descricao;

    @NotBlank(message = "{variavel.notblank}" + "empresa")
    @JsonProperty(value = "empresa")
    private String empresa;

    @JsonProperty(value = "titulo_perfil", required = false, defaultValue = "true")
    private Boolean trabalhoAtual;

    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @NotBlank(message = "{variavel.notblank}" + "mes_inicio")
    @JsonProperty(value = "mes_inicio")
    private LocalDate mesInicio;

    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @NotBlank(message = "{variavel.notblank}" + "mes_fim")
    @JsonProperty(value = "mes_fim", required = false)
    private LocalDate mesFim;

    @NotNull(message = "{variavel.notnull}" + "localidade")
    @JsonProperty(value = "localidade")
    private LocalidadeEntrada localidade;
}
