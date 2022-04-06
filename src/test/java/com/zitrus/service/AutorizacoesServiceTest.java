package com.zitrus.service;

import com.zitrus.enums.SituacaoAutorizacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AutorizacoesServiceTest {

    @Autowired
    AutorizacoesService autorizacoesService;

    @Test
    void getSituacaoAutorizacao_naoAutorizar() {
        assertEquals(SituacaoAutorizacao.NAO_AUTORIZADO, autorizacoesService.getSituacaoAutorizacao(Optional.empty()));
    }
    @Test
    void getSituacaoAutorizacao_autorizar() {
        assertEquals(SituacaoAutorizacao.AUTORIZADO, autorizacoesService.getSituacaoAutorizacao(Optional.of(1L)));
    }
}