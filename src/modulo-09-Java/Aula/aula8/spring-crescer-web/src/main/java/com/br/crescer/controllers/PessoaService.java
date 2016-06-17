/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 *
 * @author andrews.silva
 */
@Service
public class PessoaService {

    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Carlos H. Nonnemacher");
        p.setDataNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }

}
