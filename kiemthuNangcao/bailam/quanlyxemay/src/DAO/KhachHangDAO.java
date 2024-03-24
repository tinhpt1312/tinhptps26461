/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jdbcPack.Jbdc;
import Model.KhachHang;
import Model.User;
import Model.XeMay;
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
public class KhachHangDAO {

    private String Sql = "";

    public List<KhachHang> SelectBySQl() {
        List<KhachHang> list = new ArrayList<>();
        ResultSet r = Jbdc.executeQuery(Sql);
        try {
            while (r.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(r.getString("MaKhachHang"));
                kh.setHovaTen(r.getNString("HoVaTen"));
                kh.setNgaySinh(r.getDate("NgaySinh"));
                kh.setGioiTinh(r.getBoolean("GioiTinh"));
                kh.setSoDT(r.getString("SoDienThoai"));
                kh.setNgayDangKy(r.getDate("NgayDangky"));
                kh.setMaNhanVien(r.getString("MaNV"));
                list.add(kh);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(XeMayDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<KhachHang> SelectAll() {
        Sql = "Select * from KhachHang";
        return SelectBySQl();
    }

    public List<KhachHang> SelectById(String id) {
        Sql = "Select * from KhachHang where MaKhachHang = '" + id + "'";
        return SelectBySQl();
    }

    public List<KhachHang> SelectbyIDbyNamebySdt(String find) {
        Sql = """
            select * from KhachHang
            where MaKhachHang like '""" + find + "'\n"
                + "	or HoVaTen like '%" + find + "%'\n"
                + "	or SoDienThoai like'%" + find + "%'";
        return SelectBySQl();
    }

    public int getLastId() {
        Sql = "select top 1 * from KhachHang order by MaKhachHang desc";
        List<KhachHang> list = SelectBySQl();
        if (!list.isEmpty()) {
            String chuoiMaKhach = list.get(0).getMaKhachHang();
            String[] MchuoiMaKhach = chuoiMaKhach.split("KH");
            int MaKhach = Integer.parseInt(MchuoiMaKhach[1]);
            return MaKhach;
        } else {
            return 0;
        }
    }

    public int Them(KhachHang x) {
        String sql = "insert into KhachHang (MaKhachHang,HoVaTen,NgaySinh,GioiTinh,SoDienThoai,MaNV)  values(?,?,?,?,?,?)";
        int t = Jbdc.executeUpdate(sql, x.getMaKhachHang(), x.getHovaTen(), x.getNgaySinh(), x.isGioiTinh(), x.getSoDT(), User.getUser().getMaNhanVien());
        return t;
    }

    public int Sua(KhachHang x) {
        String sql = "update KhachHang set HoVaTen=?,NgaySinh=?,GioiTinh=?,SoDienThoai=?,MaNV=? where MaKhachHang like ?";
        int t = Jbdc.executeUpdate(sql, x.getHovaTen(), x.getNgaySinh(), x.isGioiTinh(), x.getSoDT(), x.getMaNhanVien(), x.getMaKhachHang());
        return t;
    }

    public int Xoa(KhachHang x) {
        String sql = "delete KhachHang where MaKhachHang = ?";
        int t = Jbdc.executeUpdate(sql, x.getMaKhachHang());
        return t;
    }
}
