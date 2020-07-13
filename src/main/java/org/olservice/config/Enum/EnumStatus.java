package org.olservice.config.Enum;

public enum EnumStatus {

    INATIVO("inativo"),
    ATIVO("ativo");


    private String descricao;

    EnumStatus(String ativo) {
        this.descricao = ativo;
    }

    public String getDescricao() {
        return descricao;
    }
}
