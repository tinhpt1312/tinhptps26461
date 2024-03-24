/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Jbdc {
    private static String serverName="localhost";
    private static String dbName="QuanLyCHXe";
    private static String url = "jdbc:sqlserver://" +serverName + ":1433;databaseName=" + dbName + ";encrypt=false;trustServerCertificate=true";
    static Connection connect;
    static boolean checkconnect;
    
    public static boolean ConnectSQL(){       
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");              
            connect=DriverManager.getConnection(url,"sa","songlong"); 
            return checkconnect=true;
        }catch (SQLException ex) {
            System.out.println("ket noi that bai 1");
            return checkconnect=false;

        }
        catch (ClassNotFoundException ex) {
            System.out.println("ket noi that bai 2");
            return checkconnect=false;
        }
    }

    public static Connection getConnect() {
        return connect;
    }
    public static PreparedStatement preparedstatement(String sql,Object...args) throws SQLException{
        ConnectSQL();
        PreparedStatement pst=null;
        if(sql.trim().startsWith("{")){
            pst=connect.prepareCall(sql);
        }else{
            pst =connect.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pst.setObject(i + 1, args[i]);
        }
        return pst;
    }
    public static int executeUpdate(String sql,Object...args){
        try {
            PreparedStatement stmt=preparedstatement(sql, args);
            int i=stmt.executeUpdate();
            connect.close();
            return i;           
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ex.getErrorCode();
        }  
    }
    public static ResultSet executeQuery(String sql,Object...args){
        try {
            PreparedStatement stmt=preparedstatement(sql, args);           
            return stmt.executeQuery();
            
        } catch (SQLException ex) {
           
            
        }
        return null;
    }
    public static List<Object[]> getListObjects(String sql,String[]cot,Object...dulieu){
        List<Object[]> list=new ArrayList<>();
        ResultSet r=executeQuery(sql, dulieu);
        try {     
            while (r.next()) {
                Object[] item=new Object[cot.length];
                for (int i = 0; i < cot.length; i++) {
                    item[i]=r.getObject(cot[i]);
                }
                list.add(item);
            }
            connect.close();          
        } catch (SQLException ex) {
           
        }
        return list;
    }

 
}
