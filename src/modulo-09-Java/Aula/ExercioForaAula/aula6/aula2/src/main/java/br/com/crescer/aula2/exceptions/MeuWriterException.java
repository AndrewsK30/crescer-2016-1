package br.com.crescer.aula2.exceptions;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuWriterException extends Exception {

    public MeuWriterException() {
        super("Arquivo é invalido");
    }

}
