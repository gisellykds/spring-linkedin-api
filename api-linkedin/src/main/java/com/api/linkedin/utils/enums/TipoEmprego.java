package com.api.linkedin.utils.enums;

import lombok.Getter;

public enum TipoEmprego {
    TEMPO_INTEGRAL("0"),
    MEIO_PERIODO("1"),
    AUTONOMO("2"),
    FREELANCE("3"),
    TEMPORARIO("4"),
    ESTAGIO("5"),
    APRENDIZ("6"),
    INTERMITENTE("7"),
    TERCEIRIZADO("8"),
    TRAINEE("9"),
    DEFAULT("");

    @Getter
    private String value;

    TipoEmprego(String value) {
        this.value = value;
    }

    public TipoEmprego get(String id){
        for (TipoEmprego tipoEmprego : TipoEmprego.values()){
            if (tipoEmprego.getValue().equals(id)) {
                return tipoEmprego;
            }
        }
        return DEFAULT;
    }
}
