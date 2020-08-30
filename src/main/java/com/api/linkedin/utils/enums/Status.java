package com.api.linkedin.utils.enums;

import lombok.Getter;

public enum Status {
    ATIVO("S"),
    INATIVO("N");

    @Getter
    private String value;

    Status(String value) {
        this.value = value;
    }

    public static Status get(String text){
        for (Status status : Status.values()){
            if (status.getValue().equals(text)) {
                return status;
            }
        }
        return null;
    }
}
