package com.api.linkedin.perfil.domain.enums;

import lombok.Getter;

public enum TipoSiteEnum {
    PESSOAL("0"),
    CORPORATIVO("1"),
    BLOG("2"),
    FEED_RSS("3"),
    PORTFOLIO("4"),
    DEFAULT("");

    @Getter
    private String value;

    TipoSiteEnum(String value) {
        this.value = value;
    }

    public TipoSiteEnum get(String id){
        for (TipoSiteEnum tipoSiteEnum : TipoSiteEnum.values()){
            if (tipoSiteEnum.getValue().equals(id)) {
                return tipoSiteEnum;
            }
        }
        return DEFAULT;
    }
}
