package br.com.crescer.aula2;

import br.com.crescer.aula2.exceptions.MeuFileException;
import java.io.File;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuFileUtilsTest {

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

    /**
     * Test of create method, of class MeuFileUtils.
     */
    @Test
    public void testCreate() {
        final MeuFileUtils meuFileUtils = new MeuFileUtils();
        assertFalse("O arquivo é nulo", meuFileUtils.create(null));
        assertTrue("Não criou o \"target/teste/1/tmp.txt\"", meuFileUtils.create("target/teste/1/tmp.txt"));
        assertTrue("Não criou o \"target/teste/1/2/3/\"", meuFileUtils.create("target/teste/1/2/3/"));
        assertTrue("Não criou o \"target/teste/tmp.txt\"", meuFileUtils.create("target/teste/tmp.txt"));
    }

    /**
     * Test of remove method, of class MeuFileUtils.
     */
    @Test(expected = MeuFileException.class)
    public void testRemove() throws MeuFileException {
        final MeuFileUtils meuFileUtils = new MeuFileUtils();
        assertTrue("Não criou o \"target/teste/tmp.txt\"", meuFileUtils.create("target/teste/tmp.txt"));
        assertTrue("Não removeu o \"target/teste/tmp.txt\"", meuFileUtils.remove("target/teste/tmp.txt"));
        assertTrue("Não criou o \"target/teste/tmp.txt\"", meuFileUtils.remove("target/teste"));
    }

    /**
     * Test of list method, of class MeuFileUtils.
     */
    @Test
    public void testList() {
        final MeuFileUtils meuFileUtils = new MeuFileUtils();
        assertFalse("Não listou o \"target/teste/tmp.txt\"", meuFileUtils.list("target").isEmpty());
        assertTrue("Não criou o \"target/teste/tmp.txt\"", meuFileUtils.create("target/teste/tmp.txt"));
        assertFalse("Não listou o \"target/teste/tmp.txt\"", meuFileUtils.list("target/teste/tmp.txt").isEmpty());
    }

    /**
     * Test of move method, of class MeuFileUtils.
     */
    @Test
    public void testMove() throws Exception {
        final MeuFileUtils meuFileUtils = new MeuFileUtils();
        assertTrue("Não criou o \"target/teste/tmp.txt\"", meuFileUtils.create("target/teste/tmp.txt"));
        assertTrue("Não moveu o \"target/teste/tmp.txt\" para ", meuFileUtils.move("target/teste/tmp.txt", "target/teste/tmp1.txt"));
        assertTrue("Não moveu o \"target/teste/tmp.txt\" para ", meuFileUtils.move("target/teste/tmp1.txt", "target/teste/2/tmp.txt"));
    }

}
