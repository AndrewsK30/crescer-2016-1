package br.com.crescer.aula3.run;

import br.com.crescer.aula3.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carlos H. Nonnemacher
 */
public class RunSelect {

    public static void main(String[] args) {

        final String query = "SELECT * FROM PESSOA";

        try (final Connection connection = ConnectionFactory.newConnection()) {
            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        System.out.format("%d, %s\n", resultSet.getRow(), resultSet.getString(2));
                    }
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }

    }

}
