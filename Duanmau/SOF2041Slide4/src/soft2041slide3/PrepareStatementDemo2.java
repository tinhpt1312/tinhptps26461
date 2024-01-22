/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft2041slide3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author teo
 */
public class PrepareStatementDemo2 {
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
              //String sql="select * from NhanVien where MaNV=?";
              String sql="select * from NhanVien";
              PreparedStatement statement =  connection.prepareStatement(sql);
              //statement.setString(1, "TeoLV");
              ResultSet resultSet =  statement.executeQuery();
              //4. Doc du lieu tu CSDL
              System.out.println("MaNV \tHoTen \t VaiTro");
              while(resultSet.next()){
                  String manv = resultSet.getString("MaNV");
                  String hoten = resultSet.getString("HoTen");
                  boolean role = resultSet.getBoolean("VaiTro");
                  System.out.println(manv+"\t"+hoten+"\t"+role);
              }
              //5. Dong ket noi den CSDL
              connection.close();
          }catch(Exception e){
              System.out.println(e);
          }
    }
}
