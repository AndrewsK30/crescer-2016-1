/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.io.File;

/**
 *
 * @author andrews.silva
 */
public class MyFileUtil {
    private File file = null;
    private String diretorioAtual = "C:\\"; 
    
    public String getDirAtual(){
        return this.diretorioAtual.replace("\\\\", "\\");
    }
    public void setDirAtual(){
        
    }
}
