package br.com.crescer.aula2;

import java.io.File;
import java.util.stream.Stream;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuReaderUtilsTest {

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
     * Test of readLines method, of class MeuWriterUtils.
     */
    @Test
    public void testReadLines() throws Exception {
        MeuReaderUtils instance = new MeuReaderUtils();
        assertNotNull("A lista não pode ser nula", instance.readLines(FILE));
    }

}
