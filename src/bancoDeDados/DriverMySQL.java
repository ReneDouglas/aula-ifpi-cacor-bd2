package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverMySQL {

    public static Connection getConnection() {

        Connection con = null;
        try {
            String user = "root";
            String senha = "root";
            String url = "jdbc:mysql://localhost:3306/banco_java";

            con = DriverManager.getConnection(url, user, senha);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return con;
    }

}
