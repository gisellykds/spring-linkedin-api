package com.api.linkedin.perfil.domain.enums;

import lombok.Getter;

public enum StatusEnum {
    ATIVO("S"),
    INATIVO("N");

    @Getter
    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public StatusEnum get(String text){
        for (StatusEnum statusEnum : StatusEnum.values()){
            if (statusEnum.getValue().equals(text)) {
                return statusEnum;
            }
        }
        return null;
    }
}
