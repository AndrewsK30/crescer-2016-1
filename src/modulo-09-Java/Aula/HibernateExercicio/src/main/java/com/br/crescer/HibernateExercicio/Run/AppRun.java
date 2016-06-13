/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.HibernateExercicio.Run;

import com.br.crescer.DM.Repositorio;
import com.br.crescer.EntidadesBean.Produto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author andrews.silva
 */
public class AppRun {
     
    public static void main(String[] args){
       Repositorio repositorio = new Repositorio(Produto.class);
       List<Produto> produtos = repositorio.listar();
       
       for(Produto produto : produtos){
           System.out.println(produto.getNome());         
       }
    }
}
