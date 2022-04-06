package com.zitrus.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SituacaoAutorizacaoTest {

    @Test
    void getValue() {
        Long autorizado = SituacaoAutorizacao.valueOf("AUTORIZADO").getValue();
        assertEquals(1L, autorizado);

        Long naoAutorizado = SituacaoAutorizacao.valueOf("NAO_AUTORIZADO").getValue();
        assertEquals(2L, naoAutorizado);

        Long cancelado = SituacaoAutorizacao.valueOf("CANCELADO").getValue();
        assertEquals(3L, cancelado);
    }

    @Test
    void getDescricao() {
        String autorizado = SituacaoAutorizacao.valueOf("AUTORIZADO").getDescricao();
        assertEquals("Autorizado", autorizado);

        String naoAutorizado = SituacaoAutorizacao.valueOf("NAO_AUTORIZADO").getDescricao();
        assertEquals("Não Autorizado", naoAutorizado);

        String cancelado = SituacaoAutorizacao.valueOf("CANCELADO").getDescricao();
        assertEquals("Cancelado", cancelado);
    }
}