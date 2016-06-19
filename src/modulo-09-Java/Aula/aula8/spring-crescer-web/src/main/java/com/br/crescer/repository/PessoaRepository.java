/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.repository;


import com.br.crescer.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andrews
 */
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
