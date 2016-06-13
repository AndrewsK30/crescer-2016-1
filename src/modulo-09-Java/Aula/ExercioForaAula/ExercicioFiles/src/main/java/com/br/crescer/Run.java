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
public class Run {
    public static void main( String[] args){
        String[] argss = new String[20];
        argss[0] = "rem";
        argss[1] = "C:\\Users\\Andrews\\Documents\\crescer-2016-1\\src\\modulo-09-Java\\Introdução\\Aula2\\src\\main\\java\\br\\com\\crescer";
        if(args.length == 2){
            new MeuFileUtils(argss[0],argss[1]);
        }else if(args.length == 3){
            new MeuFileUtils(argss[0],argss[1],argss[2]);
        }
    }
}
