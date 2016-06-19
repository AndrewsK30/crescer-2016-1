package br.com.crescer.aula2;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuWriterUtilsTest {

    private final static String FILE = "target/teste/teste.txt";

    @AfterClass
    public static void tearDownClass() throws Exception {
        final File file = new File("target/teste");
        deleteFiles(file);
        file.delete();
    }

    /**
     * Remove com recursividade.
     *
     * @param file
     */
    private static void deleteFiles(File file) {
        File[] listFiles = file.listFiles();
        Stream.of(listFiles).parallel().forEach(f -> {
            if (f.isDirectory()) {
                deleteFiles(f);
            }
            f.delete();
        });
    }

    @Before
    public void setBefore() {
        new MeuFileUtils().create(FILE);
    }

    /**
     * Test of writeLines method, of class MeuWriterUtils.
     */
    @Test
    public void testWriteLines() throws Exception {
        MeuWriterUtils instance = new MeuWriterUtils();
        instance.writeLines(FILE, "linha 1", "linha 2", "linha 3");
        List<String> readLines = new MeuReaderUtils().readLines(FILE);
        assertNotNull("A lista não pode ser nula", readLines);
        assertEquals("A lista deve conter 3 linhas", readLines.size(), 3);
        readLines.forEach(System.out::println);
    }

}
