package com.api.linkedin.utils.enums;

import com.api.linkedin.utils.exception.response.ApiLinkedinException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.util.Arrays;

public enum TipoEmprego {
    TEMPO_INTEGRAL("TEMPO_INTEGRAL"),
    MEIO_PERIODO("MEIO_PERIODO"),
    AUTONOMO("AUTONOMO"),
    FREELANCE("FREELANCE"),
    TEMPORARIO("TEMPORARIO"),
    ESTAGIO("ESTAGIO"),
    APRENDIZ("APRENDIZ"),
    INTERMITENTE("INTERMITENTE"),
    TERCEIRIZADO("TERCEIRIZADO"),
    TRAINEE("TRAINEE"),
    DEFAULT("DEFAULT");

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
        throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, "Campo 'tipo_emprego' possui os seguintes valores: " + Arrays.asList(TipoEmprego.values()).toString());
    }
}
