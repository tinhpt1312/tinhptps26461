/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Tinh
 */
public class DemoSQL {

    public static void main(String[] args) {
        try {
            //1. Nạp driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Loaded ...");

            //2. Định nghĩa  Connection URL
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=EMPDB;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String password = "songlong";

            //3. Kết nối CSDL bằng đối tượng Connection
            Connection con = DriverManager.getConnection(connectionUrl, user, password);
            System.out.println("Connected ...");

            String sql = "update Employee set age = ? where id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, 50);
            pstm.setInt(2, 5);
            int row = pstm.executeUpdate();
            System.out.println("Rows: " + row + " Update");
            //7. Đóng kết nối
            pstm.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
