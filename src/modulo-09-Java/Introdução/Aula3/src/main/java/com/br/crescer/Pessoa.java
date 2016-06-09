/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer;

/**
 *
 * @author andrews.silva
 */
public class Pessoa {
    private  int id = 0;
    private  String nome;
    
    Pessoa (String nome, int id){
        this.nome = nome;
        this.id = id;
    }
    
    Pessoa (String nome){
        this.nome = nome;
    }
    
    public String getNome(){
     return this.nome;
    }
    
    public int getId(){
     return this.id;
    }
    
}
