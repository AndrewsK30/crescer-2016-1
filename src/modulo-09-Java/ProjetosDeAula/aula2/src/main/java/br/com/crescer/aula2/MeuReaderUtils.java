package br.com.crescer.aula2;

import br.com.crescer.aula2.exceptions.MeuReaderException;
import static br.com.crescer.aula1.MeuStringUtil.stringVazia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuReaderUtils {

    /**
     * Crie um metodo que receba o nome do arquivo e exiba seu conteúdo. O
     * arquivo tem deve ser apenas do tipo .txt, caso contrário exibir um
     * mensagem que o arquivo solicitado é incompatível. Caso não localizei,
     * exibir um mensagem que o mesmo não existe.
     *
     * @param fileName
     * @return
     * @throws MeuReaderException
     */
    public List<String> readLines(final String fileName, final String sufixo) throws MeuReaderException {
        final File file;
        if (stringVazia(fileName) || !fileName.contains(sufixo) || !(file = new File(fileName)).exists()) {
            throw new MeuReaderException();
        }
        try (final BufferedReader reader = getReader(file);) {
            return reader.lines().collect(Collectors.toList());
        } catch (final IOException e) {
            System.err.format("IOException: %s", e);
        }
        return null;
    }
    
    public List<String> readLines(final String fileName) throws MeuReaderException {
        return readLines(fileName, ".txt");
    }

    private BufferedReader getReader(File file) throws FileNotFoundException, IOException {
        return new BufferedReader(new FileReader(file));
    }

}
