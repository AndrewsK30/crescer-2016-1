package br.com.crescer.aula3.dao;

import br.com.crescer.aula3.dto.Pessoa;
import br.com.crescer.aula3.util.ConnectionFactory;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 * @author Carlos H. Nonnemacher
 */
public class PessoaDAOTest {

    private static final String NOME_PESSOA = "Carlos H. Nonnemacher";

    private static PessoaDAO pessoaDAO;

    @BeforeClass
    public static void setBeforeClasse() {
        try {
            pessoaDAO = new PessoaDAO(ConnectionFactory.newConnection());
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Before
    public void setBefore() {
        final Pessoa pessoa = new Pessoa();
        pessoa.setNome(NOME_PESSOA);
        pessoaDAO.insert(pessoa);
    }

    @After
    public void tearDown() {
        pessoaDAO.findNome(NOME_PESSOA).forEach(pessoa -> {
            pessoaDAO.delete(pessoa);
        });
    }

    /**
     * Test of insert method, of class PessoaDAO.
     */
    @Test
    public void testInsert() {
        final Pessoa pessoa = new Pessoa();
        pessoa.setNome(PessoaDAOTest.class.getName());
        pessoaDAO.insert(pessoa);
        List<Pessoa> pessoas = pessoaDAO.findNome(PessoaDAOTest.class.getName());
        assertFalse("Insert não funcionou", pessoas.isEmpty());
        pessoas.forEach(p -> {
            pessoaDAO.delete(p);
        });
    }

    /**
     * Test of update method, of class PessoaDAO.
     */
    @Test
    public void testUpdate() {
        final Pessoa pessoa = new Pessoa();
        pessoa.setNome(PessoaDAOTest.class.getName());
        pessoaDAO.insert(pessoa);
        List<Pessoa> pessoas = pessoaDAO.findNome(PessoaDAOTest.class.getName());
        assertFalse("Insert não funcionou", pessoas.isEmpty());
        pessoas.forEach(p -> {
            p.setNome(NOME_PESSOA);
            pessoaDAO.update(p);
        });
        pessoas = pessoaDAO.findNome(NOME_PESSOA);
        assertFalse("A lista não pode ser vazia", pessoas.isEmpty());
        assertTrue("A deve conter + de 1 registro.", pessoas.size() > 1);
    }

    /**
     * Test of delete method, of class PessoaDAO.
     */
    @Test
    public void testDelete() {
        final Pessoa pessoa = new Pessoa();
        pessoa.setNome(PessoaDAOTest.class.getName());
        pessoaDAO.insert(pessoa);
        pessoaDAO.findNome(PessoaDAOTest.class.getName()).forEach(p -> {
            pessoaDAO.delete(p);
        });
        assertTrue("A lista deve ser vazia", pessoaDAO.findNome(PessoaDAOTest.class.getName()).isEmpty());
    }

    /**
     * Test of listAll method, of class PessoaDAO.
     */
    @Test
    public void testListAll() {
        final List<Pessoa> pessoas = pessoaDAO.listAll();
        assertNotNull("A lista não pode ser vazia", pessoas);
        assertFalse("A lista não pode ser vazia", pessoas.isEmpty());
    }

    /**
     * Test of findNome method, of class PessoaDAO.
     */
    @Test
    public void testFindNome() {
        assertNotNull("A lista não pode ser vazia", pessoaDAO.findNome(NOME_PESSOA));

    }

}
