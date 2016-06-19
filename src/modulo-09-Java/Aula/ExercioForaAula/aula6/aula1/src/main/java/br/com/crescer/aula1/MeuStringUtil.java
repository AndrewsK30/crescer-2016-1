package br.com.crescer.aula1;

import java.text.Normalizer;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuStringUtil {

    /**
     * 1. Deve possuir um metodo que valide se String é vazia.
     *
     * @param names
     * @return true/false
     */
    public static boolean stringVazia(final String... names) {
        if (names == null) {
            return true;
        }
        for (final String s : names) {
            if (s == null || s.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 2. Deve possuir um metodo que conte o nº de vogais da String (a,e,i,o,u).
     *
     * @param s
     * @return nº de vogais
     */
    public int contaVogais(final String s) {
//        return stringVazia(s) ? 0
//                : s.toLowerCase().replaceAll("[^a]", "").length()
//                + s.toLowerCase().replaceAll("[^e]", "").length()
//                + s.toLowerCase().replaceAll("[^i]", "").length()
//                + s.toLowerCase().replaceAll("[^o]", "").length()
//                + s.toLowerCase().replaceAll("[^u]", "").length();
        return stringVazia(s) ? 0
                : s.toLowerCase().length() - s.toLowerCase().replaceAll("[aeiou]", "").length();
    }

    /**
     * 3. Deve possuir um metodo que inverta uma String.
     *
     * @param s
     * @return s
     */
    public String inverteString(final String s) {
        if (stringVazia(s)) {
            return s;
        }
        char[] array = new char[s.length()];
        for (int i = s.length(); i > 0; i--) {
            array[s.length() - i] = s.toCharArray()[i - 1];
        }
        return new String(array);
//        // Usando a forma simples.
//        return stringVazia(s) ? s : new StringBuilder(s).reverse().toString();
    }

    /**
     * 4. Deve possuir um metodo que identifique um palíndromo.("ovo", "Ame a
     * ema", "A sogra má e amargosa")
     *
     * @param s
     * @return true / false
     */
    public boolean palindromo(final String s) {
        if (stringVazia(s)) {
            return false;
        }
        String normalize = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\x00-\\x7F]", "").replaceAll("\\s", "").toLowerCase();
        return normalize.equalsIgnoreCase(inverteString(normalize));
    }

}
