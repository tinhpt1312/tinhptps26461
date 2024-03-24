/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.HoaDon;
import jdbcPack.Jbdc;
import Model.HoaDonChiTiet;
import Model.User;
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
public class HoaDonChiTietDAO {
    private String Sql="";
    public List<HoaDonChiTiet> SelectBySQl(){
        List<HoaDonChiTiet> list=new ArrayList<>();
        ResultSet r=Jbdc.executeQuery(Sql);
        try {
            while (r.next()){
                HoaDonChiTiet hdct=new HoaDonChiTiet();
                    hdct.setMaHoaDonCT(r.getInt("MaHoaDonCT"));
                    hdct.setMaHoaDon(r.getString("MaHoaDon"));
                    hdct.setLoaiSanpham(r.getString("LoaiSanPham"));
                    hdct.setMaSanPham(r.getString("MaSanPham"));
                    hdct.setSoluong(r.getInt("Soluong"));
                    hdct.setGiaTien(r.getFloat("GiaTien"));
                list.add(hdct);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(XeMayDAO.class.getName()).log(Level.SEVERE, null, ex);  
            return null;
        }      
    }
    public List<HoaDonChiTiet> SelectByHoaDon(String Mahoadon){
        Sql="select * from HoaDonChiTiet where MaHoaDon like '"+Mahoadon+"'";
        return SelectBySQl();   
    }
    public int Them(HoaDonChiTiet x){      
        String sql="INSERT INTO HoaDonChiTiet (MaHoaDon, LoaiSanpham, MaSanPham,Soluong,GiaTien) VALUES(?, ?, ?, ?, ?)";
        int t=Jbdc.executeUpdate(sql, x.getMaHoaDon(),x.getLoaiSanpham(),x.getMaSanPham(),x.getSoluong(),x.getGiaTien());
        return t;      
    }
}
