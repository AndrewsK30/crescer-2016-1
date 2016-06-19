package br.com.crescer.aula3.run;

import br.com.crescer.aula3.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carlos H. Nonnemacher
 */
public class RunDDL {

    public static void main(String[] args) {
        final String ddl = "CREATE TABLE PESSOA ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";
        try (final Connection connection = ConnectionFactory.newConnection()) {
            try (final Statement statement = connection.createStatement()) {
                statement.executeUpdate(ddl);
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

}
