/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.HangXe;
import Model.XeMay;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbcPack.Jbdc;

/**
 *
 * @author ADMIN
 */
public class HangXeDAO {
    private String Sql="";
    public List<HangXe> SelectBySQl(){
        List<HangXe> list=new ArrayList<>();
        ResultSet r=Jbdc.executeQuery(Sql);
        try {
            while (r.next()){
                HangXe hx=new HangXe();
                  hx.setMaHangXe(r.getString("MaHangXe"));
                  hx.setTenHang(r.getString("TenHang"));
                list.add(hx);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(XeMayDAO.class.getName()).log(Level.SEVERE, null, ex);  
            return null;
        }      
    }
    public List<HangXe> SelectAll(){
        Sql="Select * from HangXe";
        return SelectBySQl();   
    }
    public HangXe SelectIDbyName(String x){
        Sql="Select * from HangXe where TenHang like '"+x+"'";
        List<HangXe> list=SelectBySQl(); 
        if(list != null && !list.isEmpty()){
            return list.get(0);
        }else{
            return null;
        }
    }
    public HangXe SelectNamebyid(String x){
        Sql="Select * from HangXe where MaHangXe like '"+x+"'";        
       List<HangXe> list=SelectBySQl(); 
        if(list != null && !list.isEmpty()){
            return list.get(0);
        }else{
            return null;
        }
    }
}
