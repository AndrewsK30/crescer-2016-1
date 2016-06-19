package br.com.crescer.aula3.dao;

import br.com.crescer.aula3.dto.Pessoa;
import br.com.crescer.aula3.interfaces.IPessoa;
import br.com.crescer.aula3.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos H. Nonnemacher
 */
public class PessoaDAO implements IPessoa {

    private static final String INSERT_PESSOA = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) VALUES ((SELECT NVL(MAX(ID_PESSOA), 0) + 1 FROM PESSOA), ?)";
    private static final String UPDATE_PESSOA = "UPDATE PESSOA SET NM_PESSOA = ? WHERE ID_PESSOA = ?";
    private static final String DELETE_PESSOA = "DELETE PESSOA WHERE ID_PESSOA = ?";
    private static final String LIST_ALL_PESSOA = "SELECT * FROM PESSOA";
    private static final String FIND_PESSOA_BY_NOME = "SELECT * FROM PESSOA WHERE UPPER(NM_PESSOA) LIKE ?";

    private final Connection connection;

    public PessoaDAO(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Pessoa pessoa) {
        if (pessoa.getId() == null) {
            try (final PreparedStatement prepareStatement = connection.prepareStatement(INSERT_PESSOA);) {
                prepareStatement.setString(1, pessoa.getNome());
                prepareStatement.executeUpdate();
            } catch (SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } else {
            this.update(pessoa);
        }

    }

    @Override
    public void update(Pessoa pessoa) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_PESSOA);) {
            prepareStatement.setString(1, pessoa.getNome());
            prepareStatement.setLong(2, pessoa.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        if (pessoa.getId() != null) {
            try (final PreparedStatement prepareStatement = connection.prepareStatement(DELETE_PESSOA);) {
                prepareStatement.setLong(1, pessoa.getId());
                prepareStatement.executeUpdate();
            } catch (SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        }
    }

    @Override
    public List<Pessoa> listAll() {
        List<Pessoa> pessoas = new ArrayList();
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(LIST_ALL_PESSOA);) {

            while (resultSet.next()) {
                final Pessoa pessoa = new Pessoa();
                pessoa.setId(resultSet.getLong("ID_PESSOA"));
                pessoa.setNome(resultSet.getString("NM_PESSOA"));
                pessoas.add(pessoa);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return pessoas;
    }

    @Override
    public List<Pessoa> findNome(String nome) {
        final List<Pessoa> pessoas = new ArrayList();
        if (nome != null) {
            try (final PreparedStatement prepareStatement = connection.prepareStatement(FIND_PESSOA_BY_NOME);) {
                prepareStatement.setString(1, "%" + nome.toUpperCase() + "%");
                try (final ResultSet resultSet = prepareStatement.executeQuery()) {
                    while (resultSet.next()) {
                        final Pessoa pessoa = new Pessoa();
                        pessoa.setId(resultSet.getLong("ID_PESSOA"));
                        pessoa.setNome(resultSet.getString("NM_PESSOA"));
                        pessoas.add(pessoa);
                    }
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        }
        return pessoas;
    }

}
