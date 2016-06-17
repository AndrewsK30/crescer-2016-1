/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.controllers;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andrews.silva
 */
@RestController
public class PessoaRest {
    
    @Autowired
    PessoaService service;
    
    @RequestMapping(value = "/current_date_timeJ")
    public Date date() {
        return new Date();
    }

    @ResponseBody
    @RequestMapping("/pessoa")
    public List<Pessoa> list() {
        return service.list();
    }
}