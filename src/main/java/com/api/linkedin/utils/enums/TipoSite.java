package com.api.linkedin.utils.enums;

import com.api.linkedin.utils.exception.response.ApiLinkedinException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum TipoSite {
    PESSOAL("PESSOAL"),
    CORPORATIVO("CORPORATIVO"),
    BLOG("BLOG"),
    FEED_RSS("FEED_RSS"),
    PORTFOLIO("PORTFOLIO"),
    DEFAULT("DEFAULT");

    @Getter
    private String value;

    TipoSite(String value) {
        this.value = value;
    }

    public TipoSite get(String id){
        for (TipoSite tipoSite : TipoSite.values()){
            if (tipoSite.getValue().equals(id)) {
                return tipoSite;
            }
        }
        throw new ApiLinkedinException(HttpStatus.BAD_REQUEST, "Campo 'tipo_site' possui os seguintes valores: " + Arrays.asList(TipoSite.values()));
    }
}
