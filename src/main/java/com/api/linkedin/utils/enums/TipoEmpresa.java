package com.api.linkedin.utils.enums;

import com.api.linkedin.utils.exception.response.ApiLinkedinException;
import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum TipoEmpresa {
    PEQUENA("PEQUENA"),
    MEDIA("MEDIA"),
    GRANDE("GRANDE");

    @Getter
    private String value;

    private MessageSource messageSource;

    private TipoEmpresa(String value) {
        this.value = value;
    }

    public static TipoEmpresa get(String text){
        for (TipoEmpresa tipoEmpresa : TipoEmpresa.values()){
            if (tipoEmpresa.getValue().equals(text)) {
                return tipoEmpresa;
            }
        }
        throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, "Campo 'tipo_empresa' possui os seguintes valores: " + Arrays.asList(TipoEmpresa.values()));
    }
}
