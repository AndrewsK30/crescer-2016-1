package br.com.crescer.aula3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Carlos H. Nonnemacher
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "CWI";
    private static final String PASS = "CWI";

    public static Connection newConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

}
