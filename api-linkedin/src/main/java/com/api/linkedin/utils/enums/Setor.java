package com.api.linkedin.utils.enums;

import lombok.Getter;

public enum Setor {
    ADMINISTRATIVO("0"),
    FINANCEIRO("1"),
    RECURSOS_HUMANOS("2"),
    COMERCIAL("3"),
    OPERACIONAL("4"),
    OUTRO("5");

    @Getter
    private String value;

    Setor(String value) {
        this.value = value;
    }

    public Setor get(String text){
        for (Setor setor : Setor.values()){
            if (setor.getValue().equals(text)) {
                return setor;
            }
        }
        return OUTRO;
    }
}
