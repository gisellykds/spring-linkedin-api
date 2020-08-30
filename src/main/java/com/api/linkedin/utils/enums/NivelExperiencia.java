package com.api.linkedin.utils.enums;

import com.api.linkedin.utils.exception.response.ApiLinkedinException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum NivelExperiencia {
    ESTAGIO("ESTAGIO"),
    ASSISTENTE("ASSISTENTE"),
    JUNIOR("JUNIOR"),
    PLENO_SENIOR("PLENO_SENIOR"),
    DIRETOR("DIRETOR"),
    EXECUTIVO("EXECUTIVO"),
    NAO_APLICAVEL("NAO_APLICAVEL");

    @Getter
    private String value;

    NivelExperiencia(String value) {
        this.value = value;
    }

    public static NivelExperiencia get(String text){
        for (NivelExperiencia nivelExperiencia : NivelExperiencia.values()){
            if (nivelExperiencia.getValue().equals(text)) {
                return nivelExperiencia;
            }
        }
        throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, "Campo 'nivel_experiência' possui os seguintes valores: " + Arrays.asList(NivelExperiencia.values()).toString());
    }
}
