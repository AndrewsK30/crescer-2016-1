/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Andrews
 */
public  class MeuCalendarioUtil {
    Locale local = new Locale("pt", "BR");	

    public String DiaQueNasci(Calendar data){
       SimpleDateFormat dataFormato = new SimpleDateFormat("EEEE",local);
       return dataFormato.format(data.DAY_OF_WEEK);
    }
    
    //TODO: refazer pois, não foi obtido resultado
    public String TempoDecorrido(Calendar data){       
       Calendar dataAgora = Calendar.getInstance();
       dataAgora.add(Calendar.MONTH,-data.get(Calendar.MONTH));
       dataAgora.add(Calendar.YEAR,- data.get(Calendar.YEAR));
       dataAgora.add(Calendar.DAY_OF_MONTH,-data.get(Calendar.DAY_OF_MONTH));
       return dataAgora.get(Calendar.YEAR)+" ano(s),"+dataAgora.get(Calendar.MONTH)+" messe(s) e "+ dataAgora.get(Calendar.DAY_OF_MONTH)+" dia(s)";
    }

    public  static void main(String[] args){        
       System.out.println("Essa classe possui os seguintes metodos\n");
       System.out.println("String vazia(StringVazia)\n");
       System.out.println("Inverte String(StringReversa)\n");
       System.out.println("String é um palídromo(EhPalindromo)\n");        
    }   
    
}
