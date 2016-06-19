/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Carlos H. Nonnemacher
 */
public class ParcelatorTest {

    private Parcelator instance;
    private static final Date DATE = new Date();

    @Before
    public void setBefore() {
        instance = Parcelator.novoParcelamento(BigDecimal.TEN).quantidadeParcelas(3).taxaDeJuros(10.0d).primeiroVencimento(DATE);
    }

    /**
     * Test of novoParcelamento method, of class Parcelator.
     */
    @Test
    public void testNovoParcelamento() {
        assertNotNull(instance);
    }

    /**
     * Test of quantidadeParcelas method, of class Parcelator.
     */
    @Test
    public void testQuantidadeParcelas() {
        assertEquals(instance, instance.quantidadeParcelas(3));
    }

    /**
     * Test of taxaDeJuros method, of class Parcelator.
     */
    @Test
    public void testTaxaDeJuros() {
        assertEquals(instance, instance.taxaDeJuros(10.0d));
    }

    /**
     * Test of primeiroVencimento method, of class Parcelator.
     */
    @Test
    public void testPrimeiroVencimento() {
        assertEquals(instance, instance.primeiroVencimento(DATE));
    }

    /**
     * Test of calcular method, of class Parcelator.
     */
    @Test
    public void testCalcular() {
        Map<String, String> calcular = instance.calcular();
        assertNotNull(calcular);
    }

}
