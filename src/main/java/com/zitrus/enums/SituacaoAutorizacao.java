package com.zitrus.enums;

public enum SituacaoAutorizacao {
    AUTORIZADO(1L, "Autorizado"),
    NAO_AUTORIZADO(2L, "Não Autorizado"),
    CANCELADO(3L, "Cancelado");

    private final Long value;
    private final String descricao;

    SituacaoAutorizacao(Long value, String descricao) {
        this.value = value;
        this.descricao = descricao;
    }

    public Long getValue() {
        return value;
    }

    public String getDescricao() {
        return descricao;
    }
}
