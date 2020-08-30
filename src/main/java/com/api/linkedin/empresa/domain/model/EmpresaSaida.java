package com.api.linkedin.empresa.domain.model;

import com.api.linkedin.utils.enums.Setor;
import com.api.linkedin.utils.enums.Status;
import com.api.linkedin.utils.enums.TipoEmpresa;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmpresaSaida {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_usuario")
    private Long idUsuario;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("site")
    private String site;

    @JsonProperty("setor")
    private Setor setor;

    @JsonProperty("tipo_empresa")
    private TipoEmpresa tipoEmpresa;

    @JsonProperty("url_logo")
    private String urlLogo;

    @JsonProperty("slogan")
    private String slogan;

}
