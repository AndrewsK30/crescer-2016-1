/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.DM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Andrews
 */
public class UtilsCSV<T> {

    private String arquivoCSV;
    private BufferedReader br = null;
    private String linha = "";
    private String csvDivisor = ",";
    private Repositorio repositorio = null;
    
    
    public UtilsCSV(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
    }
    
    public void importaDados(Class<T> objeto){
        try {

        br = new BufferedReader(new FileReader(arquivoCSV));
        while ((linha = br.readLine()) != null) {

            String[] dados = linha.split(csvDivisor);
            

        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
                e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    }
}
