/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrews
 */
public class TesteMeuStringUtil {
     @Test
     public void StringNaoVazia() {
         String s = "Ola";
         boolean resultado = new MeuStringUtil().StringVazia(s);
         assertFalse(resultado);
     }
     @Test
     public void StringVazia() {
         String s = "";
         boolean resultado = new MeuStringUtil().StringVazia(s);
         assertTrue(resultado);
     }
     @Test
     public void StringNull() {
         String s = null;
         boolean resultado = new MeuStringUtil().StringVazia(s);
         assertTrue(resultado);
     }
     @Test
     public void DuasVogais() {
         String s = "Aibnhg";
         int resultado = new MeuStringUtil().NumeroVogais(s);
         assertEquals(resultado,2);
     }
     @Test
     public void DezVogais() {
         String s = "AiouiebnhesUgurE";
         int resultado = new MeuStringUtil().NumeroVogais(s);
         assertEquals(resultado,10);
     }
     @Test
     public void SemVogais() {
         String s = "bnhsgrvdvdvdSSDDD";
         int resultado = new MeuStringUtil().NumeroVogais(s);
         assertEquals(resultado,0);
     }
     @Test
     public void VogaisComEspaco3() {
         String s = "A i bnhs gro";
         int resultado = new MeuStringUtil().NumeroVogais(s);
         assertEquals(resultado,3);
     }
     @Test
     public void Vazio() {
         String s = "";
         int resultado = new MeuStringUtil().NumeroVogais(s);
         assertEquals(resultado,0);
     }
     @Test
     public void SoEspaco() {
         String s = "        ";
         int resultado = new MeuStringUtil().NumeroVogais(s);
         assertEquals(resultado,0);
     }
     
     @Test
     public void StringEhNulo() {
         String s = null;
         int resultado = new MeuStringUtil().NumeroVogais(s);
         assertEquals(resultado,0);
     }
     
     @Test
     public void NulasEhNulo() {
         String s = null;
         int resultado = new MeuStringUtil().NumeroVogais(s);
         assertEquals(resultado,0);
     }
          
     @Test
     public void StringReversa() {
         String s = "Andrews";
         String resultado = new MeuStringUtil().StringReversa(s);
         assertEquals(resultado,"swerdnA");
     }
     
     @Test
     public void StringVaziaReversa() {
         String s = "";
         String resultado = new MeuStringUtil().StringReversa(s);
         assertEquals(resultado,"");
     }
     
     @Test
     public void StringNullReversa() {
         String s = null;
         String resultado = new MeuStringUtil().StringReversa(s);
         assertEquals(resultado,"");
     }
     
     @Test
     public void EhPalidromo() {
         String s = "Ame a ema";
         boolean resultado = new MeuStringUtil().EhPalindromo(s);
         assertTrue(resultado);
     }
     
     @Test
     public void EhPalidromo2() {
         String s = "A sogra ma e amargosa";
         boolean resultado = new MeuStringUtil().EhPalindromo(s);
         assertTrue(resultado);
     }
     
     @Test
     public void NaoEhPalidromo() {
         String s = "Ola, tudo bem";
         boolean resultado = new MeuStringUtil().EhPalindromo(s);
         assertFalse(resultado);
     }
     
     @Test
     public void EspacoEhPalidromo() {
         String s = "   ";
         boolean resultado = new MeuStringUtil().EhPalindromo(s);
         assertTrue(resultado);
     }
     
     @Test
     public void NaoEhPalidromoVazio() {
         String s = "";
         boolean resultado = new MeuStringUtil().EhPalindromo(s);
         assertFalse(resultado);
     }
     
     @Test
     public void EhPalidromoNull() {
         String s = null;
         boolean resultado = new MeuStringUtil().EhPalindromo(s);
         assertFalse(resultado);
     }
     
     
}
