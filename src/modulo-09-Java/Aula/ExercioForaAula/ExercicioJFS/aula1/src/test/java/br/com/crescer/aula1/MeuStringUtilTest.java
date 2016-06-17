package br.com.crescer.aula1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuStringUtilTest {

    /**
     * Test of stringVazia method, of class MeuStringUtil.
     */
    @Test
    public void testStringVazia() {
        MeuStringUtil meuStringUtil = new MeuStringUtil();
        assertTrue("A string é nula", meuStringUtil.stringVazia(null));
        assertTrue("A string é \"\"", meuStringUtil.stringVazia(""));
        assertTrue("A string é \"   \"", meuStringUtil.stringVazia("   "));
        assertFalse("A string é \"   x\"", meuStringUtil.stringVazia("   x"));
    }

    /**
     * Test of contaVogais method, of class MeuStringUtil.
     */
    @Test
    public void testContaVogais() {
        MeuStringUtil m = new MeuStringUtil();
        assertEquals("A string é nula", 0, m.contaVogais(null));
        assertEquals("A string \"\" tem 0 vogais", 0, m.contaVogais(""));
        assertEquals("A string \"carlos\" tem 2 vogais", 2, m.contaVogais("carlos"));
        assertEquals("A string \"aeiou\" tem 5 vogais", 5, m.contaVogais("aeiou"));
        assertEquals("A string \"CWI SOFTWARE\" tem 4 vogais", 4, m.contaVogais("CWI SOFTWARE"));
    }

    /**
     * Test of inverteString method, of class MeuStringUtil.
     */
    @Test
    public void testInverteString() {
        MeuStringUtil m = new MeuStringUtil();
        assertEquals("A string é nula", null, m.inverteString(null));
        assertEquals("A string é vazia", "", m.inverteString(""));
        assertEquals("A string é \"carlos\"", "solrac", m.inverteString("carlos"));
    }

    /**
     * Test of palindromo method, of class MeuStringUtil.
     */
    @Test
    public void testPalindromo() {
        MeuStringUtil m = new MeuStringUtil();
        assertFalse("A string é nula", m.palindromo(null));
        assertFalse("A string é vazia", m.palindromo(""));
        assertFalse("A string é \"carlos\"", m.palindromo("carlos"));
        assertTrue("A string é \"ovo\"", m.palindromo("ovo"));
        assertTrue("A string é \"Ame a ema\"", m.palindromo("Ame a ema"));
        assertTrue("A string é \"A sogra má e amargosa\"", m.palindromo("A sogra má e amargosa"));
    }

}
