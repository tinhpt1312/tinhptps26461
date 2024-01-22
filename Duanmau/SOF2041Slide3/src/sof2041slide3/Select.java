/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sof2041slide3;

import com.edusys.entity.NhanVien;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author teo
 */
public class Select {
    static NhanVien readFromResultSet(ResultSet rs) throws SQLException{
        NhanVien model=new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }
    public static void main(String[] args) {
        String sql="SELECT * FROM NhanVien";
       // String sql="SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql);
                //rs = JdbcHelper.executeQuery(sql,"TeoNV");
                while(rs.next()){
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        //----------
        System.out.println("MaNV \tHoten \t\tMatkhau \tVaitro");
        for(NhanVien t: list){
            System.out.println(t.getMaNV()+"\t"+t.getHoTen()+"\t"+t.getMatKhau()
                    +"\t\t"+t.getVaiTro());
        }
//          for (int i = 0;i<list.size();i++){
//              NhanVien t = list.get(i);
//              System.out.println(t.getMaNV()+"\t"+t.getHoTen()+"\t"+t.getMatKhau()
//                    +"\t\t"+t.getVaiTro());
//          }
    }
    
}
