package com.api.linkedin.utils.enums;

import com.api.linkedin.utils.exception.response.ApiLinkedinException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum  TipoEmpregoVaga {
    TEMPO_INTEGRAL("TEMPO_INTEGRAL"),
    MEIO_PERIODO("MEIO_PERIODO"),
    CONTRATO("CONTRATO"),
    TEMPORARIO("TEMPORARIO"),
    VOLUNTARIO("VOLUNTARIO"),
    ESTAGIO("ESTAGIO");

    @Getter
    private String value;

    TipoEmpregoVaga(String value) {
        this.value = value;
    }

    public static TipoEmpregoVaga get(String id){
        for (TipoEmpregoVaga tipoEmprego : TipoEmpregoVaga.values()){
            if (tipoEmprego.getValue().equals(id)) {
                return tipoEmprego;
            }
        }
        throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, "Campo 'tipo_emprego' possui os seguintes valores: " + Arrays.asList(TipoEmpregoVaga.values()).toString());
    }
}
