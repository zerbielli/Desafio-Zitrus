package com.zitrus.controllers;

import com.zitrus.enums.Sexo;
import com.zitrus.enums.SituacaoAutorizacao;
import com.zitrus.model.Autorizacoes;
import com.zitrus.repository.IAutorizacoesRepo;
import com.zitrus.repository.IProcedimentosRepo;
import com.zitrus.service.AutorizacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Optional;


@RestController
public class IndexController {

    private static final String TO_INDEX = "redirect:/index";

    @Autowired
    AutorizacoesService autorizacoesService;
    @Autowired
    private IProcedimentosRepo procedimentosRepo;
    @Autowired
    private IAutorizacoesRepo autorizacoesRepo;

    @GetMapping("")
    public @ResponseBody
    ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @GetMapping("/index")
    public @ResponseBody
    ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("procedimentos", procedimentosRepo.findAll());
        model.addObject("sexos", Sexo.values());
        model.addObject("listAutorizacoes", autorizacoesRepo.findAllOrderId());

        return model;
    }

    @GetMapping("/autorizacoes")
    public @ResponseBody
    ModelAndView autorizacoes() {
        ModelAndView model = new ModelAndView("autorizacoes");
        model.addObject("listAutorizacoes", autorizacoesRepo.findAllOrderId());

        return model;
    }

    @PostMapping("/add")
    public ModelAndView save(@ModelAttribute("addAutorizacao") Autorizacoes autorizacoes) {
        if (autorizacoes != null) {
            Optional<Long> autorizacaoProcedimento = autorizacoesService.findAutorizacaoProcedimento(autorizacoes);
            autorizacoes.setSituacao(autorizacoesService.getSituacaoAutorizacao(autorizacaoProcedimento));
            autorizacoesRepo.save(autorizacoes);
        }
        return new ModelAndView(TO_INDEX);
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView("edit");
        Autorizacoes autorizacao = autorizacoesRepo.findById(id).orElse(null);
        model.addObject("procedimentos", procedimentosRepo.findAll());
        model.addObject("sexos", Sexo.values());
        model.addObject("editAutorizacao", autorizacao);

        return model;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("editAutorizacao") Autorizacoes autorizacao) {
        ModelAndView modelAndViewReturn = new ModelAndView(TO_INDEX);
        Autorizacoes auto = autorizacoesRepo.findById(autorizacao.getId()).orElse(null);
        if (Objects.isNull(auto)) return modelAndViewReturn;

        auto.setProcedimento(autorizacao.getProcedimento());
        auto.setIdade(autorizacao.getIdade());
        auto.setSexo(autorizacao.getSexo());
        Optional<Long> autorizacaoProcedimento = autorizacoesService.findAutorizacaoProcedimento(autorizacao);
        auto.setSituacao(autorizacoesService.getSituacaoAutorizacao(autorizacaoProcedimento));
        autorizacoesRepo.save(auto);

        return modelAndViewReturn;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable("id") long id) {
        Optional<Autorizacoes> autorizacoes = autorizacoesRepo.findById(id);
        if (autorizacoes.isPresent()) autorizacoesRepo.delete(autorizacoes.get());

        return new ModelAndView(TO_INDEX);
    }

    @GetMapping("/{id}/cancel")
    public ModelAndView cancel(@PathVariable("id") long id) {
        Optional<Autorizacoes> autorizacoes = autorizacoesRepo.findById(id);
        if (autorizacoes.isPresent()) {
            autorizacoes.get().setSituacao(SituacaoAutorizacao.CANCELADO);
            autorizacoesRepo.save(autorizacoes.get());
        }
        return new ModelAndView(TO_INDEX);
    }
}
