/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jdbcPack.Jbdc;
import Model.PhuKien;
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
public class PhuKienDAO {

    private String Sql = "";

    public List<PhuKien> SelectBySQl() {
        List<PhuKien> list = new ArrayList<>();
        ResultSet r = Jbdc.executeQuery(Sql);
        try {
            while (r.next()) {
                PhuKien pk = new PhuKien();
                pk.setGiaTien(r.getFloat("GiaTien"));
                pk.setHinh(r.getBytes("Hinh"));
                pk.setMaNv(r.getString("MaNV"));
                pk.setMaPhuKien(r.getString("MaPhuKien"));
                pk.setTenPhuKien(r.getNString("TenPhuKien"));
                pk.setSoluong(r.getInt("Soluong"));
                list.add(pk);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(XeMayDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<PhuKien> SelectAll() {
        Sql = "Select * from PhuKien";
        return SelectBySQl();
    }

    public List<PhuKien> SelectById(String id) {
        Sql = "Select * from PhuKien where MaPhuKien = '" + id + "'";
        return SelectBySQl();
    }

    public List<PhuKien> FindbyNamebyID(String find) {
        Sql = "Select * from PhuKien where MaPhuKien like '" + find + "' or TenPhuKien like N'%" + find + "%'";
        return SelectBySQl();
    }

    public int getLastId() {
        Sql = "select top 1 * from PhuKien order by MaPhuKien desc";
        List<PhuKien> list = SelectBySQl();
        if (!list.isEmpty()) {
            String chuoiId = list.get(0).getMaPhuKien();
            String[] MchuoiId = chuoiId.split("PK");
            int id = Integer.parseInt(MchuoiId[1]);
            return id;
        } else {
            return 0;
        }
    }

    public void suaHinh(PhuKien x) {
        String sql = "update PhuKien set Hinh=? where MaPhuKien like ?";
        int t = Jbdc.executeUpdate(sql, x.getHinh(), x.getMaPhuKien());
    }

    public int Them(PhuKien x) {
        String sql = "insert into PhuKien (MaPhuKien,TenPhuKien,GiaTien,MaNV,Soluong) values(?,?,?,?,?)";
        int t = Jbdc.executeUpdate(sql, x.getMaPhuKien(), x.getTenPhuKien(), x.getGiaTien(), x.getMaNv(), x.getSoluong());
        if (x.getHinh() != null) {
            suaHinh(x);
        }
        return t;
    }

    public int Sua(PhuKien x) {
        String sql = "update PhuKien set TenPhuKien=?,GiaTien=?,Soluong=? where MaPhuKien like ?";
        int t = Jbdc.executeUpdate(sql, x.getTenPhuKien(), x.getGiaTien(), x.getSoluong(), x.getMaPhuKien());
        if (x.getHinh() != null) {
            suaHinh(x);
        }
        return t;
    }

    public int CapNhatSoluong(PhuKien x, int SlCanXoa) {
        int t;
        int SoluongConlai = x.getSoluong() - SlCanXoa;
        String sql = "update PhuKien set Soluong=? where MaPhuKien like ?";

        t = Jbdc.executeUpdate(sql, SoluongConlai, x.getMaPhuKien());

        return t;
    }

    public int Xoa(PhuKien x) {
        String sql = "delete PhuKien where MaPhuKien = ?";
        int t = Jbdc.executeUpdate(sql, x.getMaPhuKien());
        return t;
    }
}
