package com.zitrus.enums;

public enum Sexo {
    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino");

    private final String value;
    private final String descricao;

    Sexo(String value, String descricao) {
        this.value = value;
        this.descricao = descricao;
    }

    public String getValue() {
        return value;
    }

    public String getDescricao() {
        return descricao;
    }
}
