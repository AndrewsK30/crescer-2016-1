/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

/**
 *
 * @author andrews.silva
 */
public enum Comados {
    CD("cd"),LS("ls"),CAT("cat"),RM("rm"),RMDIR("rmdir") ;
    private final String nome;
    private Comados(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}
