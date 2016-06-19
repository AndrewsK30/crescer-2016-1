package br.com.crescer.aula3.util;

import br.com.crescer.aula2.MeuFileUtils;
import br.com.crescer.aula2.MeuReaderUtils;
import br.com.crescer.aula2.MeuWriterUtils;
import br.com.crescer.aula2.exceptions.MeuReaderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuSQLUtils {

    private final Connection connection;

    public MeuSQLUtils(final Connection connection) {
        this.connection = connection;
    }

    /**
     * 1. Deve possuir um metodo que execute as instruções contidas dentro de um
     * arquivo, o mesmo tem que ser um ".sql".
     *
     * @param filename
     * @throws br.com.crescer.aula2.exceptions.MeuReaderException
     */
    public boolean runFile(final String filename) throws MeuReaderException {
        MeuReaderUtils reader = new MeuReaderUtils();
        String script = String.join(" ", reader.readLines(filename, ".sql"));
        try (final Statement statement = connection.createStatement();) {
            for (String sql : script.split(";")) {
                statement.execute(sql);
            }
            return true;
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return false;
    }

    public String executeQuery(final String query) {
        return executeQuery(query, "|", true);
    }

    public String executeQuery(final String query, final String delimiter, final boolean header) {
        final StringBuilder sb = new StringBuilder();
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query);) {
            final ResultSetMetaData metaData = resultSet.getMetaData();
            if (header) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    sb.append(metaData.getColumnName(i));
                    sb.append(delimiter);
                }
            }
            sb.append("\n");
            while (resultSet.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    sb.append(resultSet.getObject(metaData.getColumnName(i)));
                    sb.append(delimiter);
                }
                sb.append("\n");
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return sb.toString();
    }

    public boolean importCSV(final String filename) throws MeuReaderException {
        final MeuReaderUtils reader = new MeuReaderUtils();
        final List<String> lines = reader.readLines(filename, ".csv");
        try (final PreparedStatement p = connection.prepareStatement("insert into "
                + "pessoa(id_pessoa, nm_pessoa) values (?, ?)");) {
            for (final String line : lines) {
                int i = 0;
                for (final String coluna : line.split(";")) {
                    i++;
                    p.setObject(i, coluna);
                }
                p.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return false;
    }

    public boolean exportCSV(final String filename, final String query) throws MeuReaderException {
        final String result = executeQuery(query, ";", true);
        new MeuFileUtils().create(filename);
        final MeuWriterUtils writer = new MeuWriterUtils();
        writer.writeLines(filename, Stream.of(result).collect(Collectors.toList()), filename.replaceAll("(\\.*)", "$1"));
        return true;
    }

}
