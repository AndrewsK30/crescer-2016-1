package com.br.crescer.controllers;

import com.br.crescer.entity.Pessoa;
import com.br.crescer.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrews
 */
@RestController
@RequestMapping("/rest/pessoa")
public class PessoaRest {

    @Autowired
    PessoaService service;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Pessoa> list() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pessoa save(@RequestBody Pessoa p) {
        return service.save(p);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Pessoa p) {
        service.delete(p.getId());
    }
}