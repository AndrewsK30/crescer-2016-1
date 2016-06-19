package br.com.crescer.aula3.run;

import br.com.crescer.aula3.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @author Carlos H. Nonnemacher
 */
public class RunInsert {

    private static final Logger LOGGER = Logger.getLogger(RunInsert.class.getName());

    public static void main(String[] args) {
        String INSERT = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) "
                + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";

        try (final Connection connection = ConnectionFactory.newConnection();
                final PreparedStatement prepareStatement = connection.prepareStatement(INSERT)) {
            prepareStatement.setString(1, "'); DROP TABLE PESSOA; -- ");
            prepareStatement.executeUpdate();
        } catch (final SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }
}





