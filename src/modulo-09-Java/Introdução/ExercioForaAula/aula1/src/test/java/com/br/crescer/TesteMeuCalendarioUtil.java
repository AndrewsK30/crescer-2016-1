/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrews
 */
public class TesteMeuCalendarioUtil {
    
   
    @Test
    public void NasciQuarta() {
    Calendar calendario = Calendar.getInstance();
    calendario.set(Calendar.MONTH, 5);
    calendario.set(Calendar.DAY_OF_MONTH, 8);
    calendario.set(Calendar.YEAR,2016);
    String resposta = new MeuCalendarioUtil().DiaQueNasci(calendario);
    assertEquals(resposta,"Quarta-feira");
    }
    
    @Test
    public void NasciSexta() {
    Calendar calendario = Calendar.getInstance();
    calendario.set(1980, Calendar.JUNE , 3); 
    String resposta = new MeuCalendarioUtil().DiaQueNasci(calendario);
    assertEquals(resposta,"Terça-feira");
    }
}
