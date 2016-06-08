/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer;

/**
 *
 * @author Andrews
 */
public  class  MeuStringUtil {
    public boolean StringVazia(String string){
        return string == null || string.isEmpty() || string.length() == 0 ? true : false;    
    }
    public int NumeroVogais(String string){
        if(string == null) return 0;
        int vogais = 0;
        for (int i = 0; i < string.length(); ++i) {
            switch(string.toLowerCase().charAt(i)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                vogais++;
                break;
            default:
            }
        }
        return vogais;    
    }
    public String StringReversa(String string){
        return string == null? "" : new StringBuffer(string).reverse().toString();    
    }
    
    public boolean EhPalindromo(String string){       
        if(this.StringVazia(string)) return false;
        String stringSemSpaco = string.replaceAll("\\s","");        
        return stringSemSpaco.equalsIgnoreCase(this.StringReversa(stringSemSpaco));    
    }
    
    public static void main(String[] args){        
       System.out.println("Essa classe possui os seguintes metodos:\n");
       System.out.println("String vazia(StringVazia):\n");
       System.out.println("Inverte String(StringReversa):\n");
       System.out.println("String é um palídromo(EhPalindromo):\n");
    }
    
}
    

