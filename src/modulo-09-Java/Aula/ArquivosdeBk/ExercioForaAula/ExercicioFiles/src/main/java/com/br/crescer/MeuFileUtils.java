/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Andrews
 */
public class MeuFileUtils {
    File dir = null;
    
    MeuFileUtils(String cmd,String nome){
        this.dir = new File(nome);        
        switch (cmd){
            case "mk":
                mk();
                break;
            case "rm":
                rm();
                break;
            case "ls":
                ls();
                break;
            case "rem":
                rem();
                break; 
            default:
        }
    }
    
    MeuFileUtils(String cmd,String nome,String dirNov){
        this.dir = new File(nome);
        if(dir.isDirectory()) {
            System.out.println("O arquivo é inválido");
        }else{           
            mv(dirNov);
        }        
    }
    
    private void mk(){
        try {
            dir.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void mv(String dirNov){
        dir.renameTo(new File(dirNov));
    }
    
    private void rm(){
        if(dir.isDirectory()) {
            System.out.println("O arquivo é inválido");
        }else{           
            dir.delete();
        }
    }
    
    private void ls(){
        if(dir.isDirectory()) {
            for (final String arq : dir.list()) {
                System.out.println(arq+"\n");   
            }
        }else{ 
            System.out.println(dir.getAbsolutePath());           
        }
    }
    
    private void rem(){
        BufferedReader br = null;
        try {
        String linha;
        br = new BufferedReader(new FileReader(dir.getAbsolutePath()));
        while ((linha = br.readLine()) != null) {
            System.out.println(linha);
        }
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (br != null)br.close();
            }catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
