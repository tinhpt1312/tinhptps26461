/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.*;


/**
 *
 * @author Tinh
 */
public class userDAO {
    
    public void insert(user us){
        try(Connection con = JDBCUtil.openConnection();){
            String sql = "insert into users values(?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,us.getUsernamee());
            st.setString(2,us.getPasswordd());
            st.setString(3,us.getRolee());
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
