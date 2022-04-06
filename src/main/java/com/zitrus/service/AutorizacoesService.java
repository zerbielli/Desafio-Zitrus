package com.zitrus.service;

import com.zitrus.enums.SituacaoAutorizacao;
import com.zitrus.model.Autorizacoes;
import com.zitrus.repository.IProcedimentosRegrasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorizacoesService {

    @Autowired
    private IProcedimentosRegrasRepo procedimentosRegrasRepo;

    public Optional<Long> findAutorizacaoProcedimento(Autorizacoes autorizacoes) {
        return procedimentosRegrasRepo.findAutorizacaoProcedimento(
                autorizacoes.getProcedimento(),
                autorizacoes.getIdade(),
                autorizacoes.getSexo().getValue());
    }

    public SituacaoAutorizacao getSituacaoAutorizacao(Optional<Long> autorizacaoProcedimento) {
        return autorizacaoProcedimento.isPresent() ? SituacaoAutorizacao.AUTORIZADO : SituacaoAutorizacao.NAO_AUTORIZADO;
    }

}
