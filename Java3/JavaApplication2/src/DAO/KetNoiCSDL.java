/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tinh
 */
public class KetNoiCSDL {

    public static Connection openConnection() throws Exception {
        //1. Nạp driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2.
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Demo10;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "songlong";
        //3.
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }
}
