/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.controllers;

/**
 *
 * @author andrews.silva
 */
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Strings;

@Controller
public class Example {
   
    
    @RequestMapping(value = "/")
    String toIndex(@RequestParam(required = false) String name,Model model) {
        model.addAttribute("name", name!=null?name:"sem parametro");
        return "index";
    }
    
    @ResponseBody
    @RequestMapping(value = "/current_date_timesada")
    public Date date() {
        return new Date();
    }
    
    @ResponseBody
    @RequestMapping(value = "/pessoaJ.json", method = RequestMethod.POST)
    public List<Pessoa> list(@RequestBody Pessoa p) {
        p.setDataNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }

}
