package db_crud;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by kassi on 20/01/2017.
 */
public class ConnectionFactory {
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/teste";

    public static Connection createConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        return connection;
    }
}
