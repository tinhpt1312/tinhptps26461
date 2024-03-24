/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jdbcPack.Jbdc;
import Model.HoaDon;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utility.UtilityDate;

/**
 *
 * @author ADMIN
 */
public class HoaDonDAO {

    private String Sql = "";

    public List<HoaDon> SelectBySQl() {
        List<HoaDon> list = new ArrayList<>();
        ResultSet r = Jbdc.executeQuery(Sql);
        try {
            while (r.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(r.getString("MaHoaDon"));
                hd.setMaKhachHang(r.getString("MaKhachHang"));
                hd.setMaNhanVien(r.getString("MaNV"));
                hd.setNgayTao(r.getDate("NgayTao"));
                hd.setTongTien(r.getFloat("TongTien"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(XeMayDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int getLastId() {
        Sql = "select top 1 * from HoaDon order by MaHoaDon desc";
        List<HoaDon> list = SelectBySQl();
        if (!list.isEmpty()) {
            String chuoiId = list.get(0).getMaHoaDon();
            String[] MchuoiId = chuoiId.split("HD");
            int id = Integer.parseInt(MchuoiId[1]);
            return id;
        } else {
            return 0;
        }
    }

    public List<HoaDon> SelectAll() {
        Sql = "Select * from HoaDon";
        return SelectBySQl();
    }

    public List<HoaDon> SelectById(String id) {
        Sql = "Select * from HoaDon where MaHoaDon like '" + id + "'";
        return SelectBySQl();
    }

    public int Them(HoaDon x) {
        String sql = "INSERT INTO HoaDon (MaHoaDon, MaKhachHang, MaNV) VALUES(?, ?, ?)";
        int t = Jbdc.executeUpdate(sql, x.getMaHoaDon(), x.getMaKhachHang(), User.getUser().getMaNhanVien());
        return t;
    }

    public int Sua(HoaDon x) {
        String sql = "update HoaDon set MaKhachHang=?,MaNV=?,TongTien=?,NgayTao=? where MaHoaDon like ?";
        int t = Jbdc.executeUpdate(sql, x.getMaKhachHang(), x.getMaNhanVien(), x.getTongTien(), x.getNgayTao(), x.getMaHoaDon());
        return t;
    }

    public int Xoa(HoaDon x) {
        String sql = "delete HoaDon where MaHoaDon = ?";
        int t = Jbdc.executeUpdate(sql, x.getMaHoaDon());
        return t;
    }
}
