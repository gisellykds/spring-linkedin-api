package com.api.linkedin.perfil.domain.enums;

import lombok.Getter;

public enum TipoEmpregoEnum {
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

    TipoEmpregoEnum(String value) {
        this.value = value;
    }

    public TipoEmpregoEnum get(String id){
        for (TipoEmpregoEnum tipoEmpregoEnum : TipoEmpregoEnum.values()){
            if (tipoEmpregoEnum.getValue().equals(id)) {
                return tipoEmpregoEnum;
            }
        }
        return DEFAULT;
    }
}
