package br.com.crescer.aula3.util;

import br.com.crescer.aula2.exceptions.MeuReaderException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuSQLUtilsTest {

    private static MeuSQLUtils instance;
    private static Connection connection;

    @BeforeClass
    public static void setUpClass() {
        try {
            connection = ConnectionFactory.newConnection();
            connection.setAutoCommit(false);
            instance = new MeuSQLUtils(connection);
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        try {
            if (connection != null) {
                connection.rollback();
                connection.close();
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    /**
     * Test of runFile method, of class MeuSQLUtils.
     * @throws br.com.crescer.aula2.exceptions.MeuReaderException
     */
    @Test(expected = MeuReaderException.class)
    public void testRunFile() throws MeuReaderException {
        assertTrue("Instruções não foram executadas", instance.runFile(MeuSQLUtilsTest.class.getResource("/teste-run-file.sql").getFile()));
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery("SELECT COUNT(1) FROM PESSOA WHERE NM_PESSOA = 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA'");) {
            assertTrue("Deve retornar 1 registro", resultSet.next());
            assertEquals("Deve conter 5 registros AAAAAAAAAAAAAAAAAAAAAA", resultSet.getInt(1), 5);
        } catch (final SQLException e) {

        }
        instance.runFile(null);
    }

    /**
     * Test of executeQuery method, of class MeuSQLUtils.
     */
    @Test
    public void testExecuteQuery() throws MeuReaderException {
        assertTrue("Instruções não foram executadas", instance.runFile(MeuSQLUtilsTest.class.getResource("/teste-run-execute-query.sql").getFile()));
        final String pessoas = instance.executeQuery("SELECT * FROM PESSOA");
        System.out.println(pessoas);
        assertNotNull("Instruções não foram executadas", pessoas);
        assertFalse("Instruções não foram executadas", pessoas.isEmpty());
    }

    /**
     * Test of importCSV method, of class MeuSQLUtils.
     */
    @Test
    public void testImportCSV() throws Exception {
        assertTrue("Informações não importadas", instance.importCSV(MeuSQLUtilsTest.class.getResource("/import.csv").getFile()));
    }

    /**
     * Test of exportCSV method, of class MeuSQLUtils.
     */
    @Test
    public void testExportCSV() throws Exception {
        assertTrue("Informações não exportadas", instance.exportCSV("pessoas.csv", "select * from pessoa"));
    }

}
