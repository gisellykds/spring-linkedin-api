package com.api.linkedin.utils.enums;

import com.api.linkedin.utils.exception.response.ApiLinkedinException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum Setor {
    ADMINISTRATIVO("ADMINISTRATIVO"),
    FINANCEIRO("FINANCEIRO"),
    RECURSOS_HUMANOS("RECURSOS_HUMANOS"),
    COMERCIAL("COMERCIAL"),
    OPERACIONAL("OPERACIONAL"),
    OUTRO("OUTRO");

    @Getter
    private String value;

    Setor(String value) {
        this.value = value;
    }

    public static Setor get(String text){
        for (Setor setor : Setor.values()){
            if (setor.getValue().equals(text)) {
                return setor;
            }
        }
        throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, "Campo 'setor' possui os seguintes valores: " + Arrays.asList(Setor.values()).toString());
    }

}
