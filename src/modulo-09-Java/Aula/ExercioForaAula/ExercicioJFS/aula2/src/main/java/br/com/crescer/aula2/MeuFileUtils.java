package br.com.crescer.aula2;

import br.com.crescer.aula2.exceptions.MeuFileException;
import static br.com.crescer.aula1.MeuStringUtil.stringVazia;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuFileUtils {

    /**
     * 2. mk ${nome} // Vai criar o arquivo / diretório.
     *
     * @param fileName
     * @return true or false
     */
    public boolean create(final String fileName) {
        if (stringVazia(fileName)) {
            return false;
        }
        try {
            final File file = new File(fileName);
            if (file.getName().contains(".")) {
                create(fileName.replaceAll(file.getName(), ""));
                return file.exists() || file.createNewFile();
            } else {
                return file.exists() || file.mkdirs();
            }
        } catch (final IOException e) {
            System.err.format("IOException: %s", e);
        }
        return false;
    }

    /**
     * 3. rm ${nome} // Vai excluir o arquivo, caso for um diretório deve exibir
     * uma mensagem que o arquivo é invalido.
     *
     * @param fileName
     * @return true or false
     * @throws MeuFileException
     */
    public boolean remove(final String fileName) throws MeuFileException {
        if (stringVazia(fileName)) {
            return false;
        }
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        throw new MeuFileException();
    }

    /**
     * 4. ls ${nome} // Vai mostra o caminho absoluto, se for um diretório
     * listar o nome dos arquivos internos.
     *
     * @param path
     * @return nomes dos arquivos
     */
    public List<String> list(final String path) {
        final Stream<File> stream;
        File file = new File(path);
        if (file.isDirectory()) {
            stream = Stream.of(file.listFiles());
        } else {
            stream = Stream.of(file);
        }
        return stream.map(File::getAbsolutePath).collect(Collectors.toList());
    }

    /**
     * 5. mv ${nome} ${nome_novo} // Vai mover o arquivo, caso for um diretório
     * deve exibir uma mensagem que o arquivo é invalido.
     *
     * @param from
     * @param to
     * @return true or false
     * @throws MeuFileException
     */
    public boolean move(final String from, final String to) throws MeuFileException {
        if (stringVazia(from, to)) {
            return false;
        }
        final File fileFrom = new File(from);
        if (!fileFrom.exists() || fileFrom.isDirectory() || !to.contains(".")) {
            throw new MeuFileException();
        }
        final File fileTo = new File(to);
        create(to.replaceAll(fileTo.getName(), ""));
        return fileFrom.renameTo(fileTo);
    } 
}
