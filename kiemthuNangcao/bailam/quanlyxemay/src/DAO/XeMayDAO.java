/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NhanVien;
import Model.XeMay;
import java.util.ArrayList;
import java.util.List;
import jdbcPack.Jbdc;
import Model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utility.UtilityDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class XeMayDAO {

    private String Sql = "";

    public List<XeMay> SelectBySQl() {
        List<XeMay> list = new ArrayList<>();
        ResultSet r = Jbdc.executeQuery(Sql);
        try {
            while (r.next()) {
                XeMay xm = new XeMay();
                xm.setMaXeMay(r.getString("MaXeMay"));
                xm.setTenXe(r.getNString("TenXe"));
                xm.setMaHangXe(r.getString("MaHangXe"));
                xm.setGiaTien(r.getFloat("GiaTien"));
                xm.setHinh(r.getBytes("Hinh"));
                xm.setNgayNhap(r.getDate("NgayNhap"));
                xm.setMaNhanVien(r.getString("MaNV"));
                xm.setSoluong(r.getInt("Soluong"));
                list.add(xm);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(XeMayDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<XeMay> SelectAll() {
        Sql = "Select * from XeMay";
        return SelectBySQl();
    }

    public List<XeMay> SelectById(String id) {
        Sql = "Select * from XeMay where MaXeMay = '" + id + "'";
        return SelectBySQl();
    }

    public List<XeMay> FindbyNamebyIdbyCarmaker(String find) {
        Sql = """
              select * from XeMay xm
              join HangXe hx on hx.MaHangXe=xm.MaHangXe
              where TenXe like '%""" + find + "%' or MaXeMay like '" + find + "' or xm.MaHangXe like '" + find + "' or TenHang like '" + find + "'";
        return SelectBySQl();
    }

    public void suaHinh(XeMay x) {
        String sql = "update XeMay set Hinh=? where MaXeMay like ?";
        int t = Jbdc.executeUpdate(sql, x.getHinh(), x.getMaXeMay());
    }

    public int getLastId() {
        Sql = "select top 1 * from XeMay order by MaXeMay desc";
        List<XeMay> list = SelectBySQl();
        if (!list.isEmpty()) {
            String chuoiMaXe=list.get(0).getMaXeMay();
            String[] MchuoiMaXe=chuoiMaXe.split("X");
            int MaXe=Integer.parseInt(MchuoiMaXe[1]);
            return MaXe;        
        } else {
            return 0;
        }
    }

    public int Them(XeMay x) {
        String sql = "insert into XeMay (MaXeMay,TenXe,MaHangXe,GiaTien,MaNV,Soluong) values(?,?,?,?,?,?)";
        int t = Jbdc.executeUpdate(sql, x.getMaXeMay(), x.getTenXe(), x.getMaHangXe(), x.getGiaTien(), User.getUser().getMaNhanVien(), x.getSoluong());
        if (x.getHinh() != null) {
            suaHinh(x);
        }
        return t;
    }

    public int Sua(XeMay x) {
        String sql = "update XeMay set Tenxe=?,MaHangXe=?,GiaTien=?,NgayNhap=?,Soluong=? where MaXeMay like ?";
        int t = Jbdc.executeUpdate(sql, x.getTenXe(), x.getMaHangXe(), x.getGiaTien(), x.getNgayNhap(), x.getSoluong(), x.getMaXeMay());
        if (x.getHinh() != null) {
            suaHinh(x);
        }
        return t;
    }

    public int CapNhatSoluong(XeMay x, int SlCanXoa) {
        int t;
        int SoluongConlai = x.getSoluong() - SlCanXoa;
        String sql = "update XeMay set Soluong=? where MaXeMay like ?";
        t = Jbdc.executeUpdate(sql, SoluongConlai, x.getMaXeMay());
        return t;
    }

    public int Xoa(XeMay x) {
        String sql = "delete XeMay where MaXeMay = ?";
        int t = Jbdc.executeUpdate(sql, x.getMaXeMay());
        return t;
    }

//    public int Banxe(XeMay x,int Soluong){
//        
//    
//    }
}
