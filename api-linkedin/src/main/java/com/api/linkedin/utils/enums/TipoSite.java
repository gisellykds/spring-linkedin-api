package com.api.linkedin.utils.enums;

import lombok.Getter;

public enum TipoSite {
    PESSOAL("0"),
    CORPORATIVO("1"),
    BLOG("2"),
    FEED_RSS("3"),
    PORTFOLIO("4"),
    DEFAULT("");

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
        return DEFAULT;
    }
}
