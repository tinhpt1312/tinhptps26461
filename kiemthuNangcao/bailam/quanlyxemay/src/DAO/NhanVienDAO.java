/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jdbcPack.Jbdc;
import Model.PhuKien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.NhanVien;
import Model.XeMay;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {

    private String Sql = "";

    public List<NhanVien> SelectBySQl() {
        List<NhanVien> list = new ArrayList<>();
        ResultSet r = Jbdc.executeQuery(Sql);
        try {
            while (r.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(r.getString("MaNhanVien"));
                nv.setHovaTen(r.getNString("HoVaTen"));
                nv.setMatKhau(r.getString("MatKhau"));
                nv.setVaiTro(r.getBoolean("VaiTro"));
                nv.setMail(r.getString("Mail"));
                nv.setHinh(r.getBytes("Hinh"));
                nv.setNgaysinh(r.getDate("NgaySinh"));
                nv.setNgaybatdau(r.getDate("NgayBatDau"));
                nv.setNgayketthuc(r.getDate("NgayKetThuc"));
                list.add(nv);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(XeMayDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<NhanVien> SelectAll() {
        Sql = "Select * from NhanVien";
        return SelectBySQl();
    }

    public List<NhanVien> SelectById(String id) {
        Sql = "Select * from NhanVien where MaNhanVien like '" + id + "'";
        return SelectBySQl();
    }

    public List<NhanVien> SelectByIdByName(String find) {
        Sql = "Select * from NhanVien where MaNhanVien like '" + find + "' or HoVaTen like N'%" + find + "%'";
        return SelectBySQl();
    }

    public int getLastId() {
        Sql = "select top 1 * from NhanVien order by MaNhanVien desc";
        List<NhanVien> list = SelectBySQl();
        if (!list.isEmpty()) {
            String chuoiId = list.get(0).getMaNhanVien();
            String[] MchuoiId = chuoiId.split("NV");
            int id = Integer.parseInt(MchuoiId[1]);
            return id;
        } else {
            return 0;
        }
    }

    public NhanVien SelectByIdPass(String id, String pass) {
        Sql = "Select * from NhanVien where MaNhanVien like '" + id + "' and MatKhau like '" + pass + "'";
        List<NhanVien> list = SelectBySQl();
        if (list.isEmpty()) {
            return null;
        }
        {
            return list.get(0);
        }
    }

    public List<NhanVien> selectAllnvActive() {
        Sql = "Select * from NhanVien where NgayKetThuc is null or NgayKetThuc > getdate()";
        return SelectBySQl();
    }

    public List<NhanVien> selectAllnvDeactive() {
        Sql = "Select * from NhanVien where NgayKetThuc is not null and NgayKetThuc <= getdate()";
        return SelectBySQl();
    }

    public String SelectMailbyID(String find) {
        Sql = "Select * from NhanVien where MaNhanVien like '" + find + "'";
        String Mail = SelectBySQl().get(0).getMail();
        return Mail;
    }

    public int doiMatKhau(NhanVien x) {
        String sql = "update NhanVien set MatKhau=? where MaNhanVien like ?";
        int t = Jbdc.executeUpdate(sql, Utility.UtilityPass.MaHoaMK(x.getMatKhau()), x.getMaNhanVien());
        return t;
    }

    public void suaHinh(NhanVien x) {
        String sql = "update NhanVien set Hinh=? where MaNhanVien like ?";
        int t = Jbdc.executeUpdate(sql, x.getHinh(), x.getMaNhanVien());
    }

    public int Them(NhanVien x) {
        String sql = "insert into NhanVien (MaNhanVien,MatKhau,HoVaTen,VaiTro,Mail,NgaySinh,NgayBatDau,NgayKetThuc) values(?,?,?,?,?,?,?,?)";
        int t = Jbdc.executeUpdate(sql, x.getMaNhanVien(), Utility.UtilityPass.MaHoaMK(x.getMatKhau()), x.getHovaTen(), x.getVaiTro(), x.getMail(), x.getNgaysinh(), x.getNgaybatdau(), x.getNgayketthuc());
        if (x.getHinh() != null) {
            suaHinh(x);
        }
        return t;
    }

    public int Sua(NhanVien x) {
        String sql = "update NhanVien set MatKhau=?,HoVaTen=?,VaiTro=?,Mail=?,NgaySinh=?,NgayBatDau=?,NgayKetThuc=? where MaNhanVien like ?";
        int t = Jbdc.executeUpdate(sql, Utility.UtilityPass.MaHoaMK(x.getMatKhau()), x.getHovaTen(), x.getVaiTro(), x.getMail(), x.getNgaysinh(), x.getNgaybatdau(), x.getNgayketthuc(), x.getMaNhanVien());
        if (x.getHinh() != null) {
            suaHinh(x);
        }
        return t;
    }

    public int SuaKhongMatKhau(NhanVien x) {
        String sql = "update NhanVien set HoVaTen=?,VaiTro=?,Mail=?,NgaySinh=?,NgayBatDau=?,NgayKetThuc=? where MaNhanVien like ?";
        int t = Jbdc.executeUpdate(sql, x.getHovaTen(), x.getVaiTro(), x.getMail(), x.getNgaysinh(), x.getNgaybatdau(), x.getNgayketthuc(), x.getMaNhanVien());
        if (x.getHinh() != null) {
            suaHinh(x);
        }
        return t;
    }

    public int Xoa(NhanVien x) {
        String sql = "delete NhanVien where MaNhanVien = ?";
        int t = Jbdc.executeUpdate(sql, x.getMaNhanVien());
        return t;
    }

    public int suaNgayKetThuc(NhanVien x) {
        String sql = "update NhanVien set NgayKetThuc=? where MaNhanVien like ?";
        int t = Jbdc.executeUpdate(sql, x.getNgayketthuc(), x.getMaNhanVien());
        return t;
    }
}
