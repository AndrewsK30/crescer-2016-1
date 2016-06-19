package br.com.crescer.aula2;

import br.com.crescer.aula2.exceptions.MeuReaderException;
import static br.com.crescer.aula1.MeuStringUtil.stringVazia;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuWriterUtils {

    /**
     * Crie um metodo que receba o nome do arquivo e exiba seu conteúdo. O
     * arquivo tem deve ser apenas do tipo .txt, caso contrário exibir um
     * mensagem que o arquivo solicitado é incompatível. Caso não localizei,
     * exibir um mensagem que o mesmo não existe.
     *
     * @param fileName
     * @param lines
     * @throws MeuReaderException
     */
    public void writeLines(final String fileName, final String... lines) throws MeuReaderException {
        writeLines(fileName, Arrays.asList(lines), ".txt");
    }
    
    public void writeLines(final String fileName, final List<String> lines, final String sufix) throws MeuReaderException {
        final File file;
        if (stringVazia(fileName) || !fileName.contains(sufix) || !(file = new File(fileName)).exists()) {
            throw new MeuReaderException();
        }
        try (final BufferedWriter writer = getWriter(file);) {
            lines.stream().forEach((string) -> {
                try {
                    writer.append(string);
                    writer.newLine();
                } catch (IOException e) {
                    System.err.format("IOException: %s", e);
                }
            });
        } catch (final IOException e) {
            System.err.format("IOException: %s", e);
        }

    }

    private BufferedWriter getWriter(File file) throws IOException {
        return new BufferedWriter(new FileWriter(file, true));
    }

}
