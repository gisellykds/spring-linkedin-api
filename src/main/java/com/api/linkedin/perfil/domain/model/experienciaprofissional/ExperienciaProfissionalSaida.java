package com.api.linkedin.perfil.domain.model.experienciaprofissional;

import com.api.linkedin.perfil.domain.model.localidade.LocalidadeSaida;
import com.api.linkedin.utils.enums.TipoEmprego;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.YearMonth;

@Data
public class ExperienciaProfissionalSaida {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "id_perfil")
    private Long idPerfil;

    @JsonProperty(value = "cargo")
    private String cargo;

    @NotBlank
    @JsonProperty(value = "tipo_emprego")
    private TipoEmprego tipoEmprego;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "empresa")
    private String empresa;

    @JsonProperty(value = "titulo_perfil", required = false, defaultValue = "true")
    private Boolean trabalhoAtual;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @JsonProperty(value = "mes_ano_inicio")
    private YearMonth mesInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy")
    @JsonProperty(value = "mes_ano_fim")
    private YearMonth mesFim;

    @JsonProperty(value = "localidade")
    private LocalidadeSaida localidade;


}
