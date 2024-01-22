package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    public static Connection openConnection() throws Exception {
        //1. Nạp driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2.
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Agile;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "123";
        //3.
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }
}
