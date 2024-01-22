/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft2041slide3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



/**
 *
 * @author teo
 */
public class PrepareStatementDemo1 {
    public static void main(String[] args) {
          String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
          String dburl = "jdbc:sqlserver://localhost;database=Polypro";
          String username = "sa";
          String password = "";  
        
          try{
              //1. Nap driver
              Class.forName(driver);
              //2. Mo ket noi den CSDL
              Connection connection = DriverManager.getConnection(dburl, username, password);
              //3. Tao PreparedStatament va thuc thi cau lenh SQL
              String sql="INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) "
                      + "VALUES (?,?,?,?)";
              PreparedStatement statement =  connection.prepareStatement(sql);
              statement.setString(1, "TeoLV3");
              statement.setString(2, "123");
              statement.setString(3, "Lê Văn Tèo3");
              statement.setBoolean(4, true);
              statement.executeUpdate();
              //4. Dong ket noi den CSDL
              connection.close();
          }catch(Exception e){
              System.out.println(e);
          }
    }
}
