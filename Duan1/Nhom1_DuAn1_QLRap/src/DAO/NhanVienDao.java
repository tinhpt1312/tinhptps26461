/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.XJdbc;

import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ttc
 */
public class NhanVienDao extends RedFoxCinema<NhanVien, Object> {

    @Override
    public void insert(NhanVien model) {
        String sql = "insert into NhanVien(ID_nv, hoten_nv, gioitinh_NV, sdt_NV, namsinh_NV, chucvu_NV,tinhtrang_NV) values(?,?,?,?,?,?,?)";
        XJdbc.update(sql, model.getMaNV(), model.getTenNV(), model.getGioiTinh(), model.getSdt(), model.getNamSinh(), model.getChucVu(), model.getTinhTrang());
    }

    @Override
    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET hoten_nv = ?, gioitinh_NV =?, sdt_NV =? ,namsinh_NV = ? , chucvu_NV = ? , tinhtrang_NV = ?  WHERE ID_nv=?";
        XJdbc.update(sql, model.getTenNV(), model.getGioiTinh(), model.getSdt(), model.getNamSinh(), model.getChucVu(), model.getTinhTrang(), model.getMaNV());
    }

    @Override
    public void delete(Object id) {
        String sql = "delete from NhanVien WHERE ID_nv=?";
        XJdbc.update(sql, id);
    }

    public List<NhanVien> findNhanVien(String input) {
        List<NhanVien> list = new ArrayList<>();
        try {
            String sql = "select * from NhanVien where ID_nv like '%" + input + "%' or hoten_nv like N'%" + input + "%'";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("ID_nv"));
                nv.setTenNV(rs.getString("hoten_nv"));
                nv.setGioiTinh(rs.getString("gioitinh_nv"));
                nv.setSdt(rs.getString("sdt_nv"));
                nv.setNamSinh(rs.getString("namsinh_nv"));
                nv.setChucVu(rs.getString("chucvu_nv"));
                nv.setTinhTrang(rs.getString("tinhtrang_nv"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String returnID(String manv) {
        String sql = "select count(*) from NhanVien where ID_nv=?";
        XJdbc.query(sql, manv);
        return manv;
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    NhanVien entity = new NhanVien();
                    entity.setMaNV(rs.getString("ID_nv"));
                    entity.setTenNV(rs.getString("hoten_nv"));
                    entity.setGioiTinh(rs.getString("gioitinh_nv"));
                    entity.setSdt(rs.getString("sdt_nv"));
                    entity.setNamSinh(rs.getString("namsinh_nv"));
                    entity.setChucVu(rs.getString("chucvu_nv"));
                    entity.setTinhTrang(rs.getString("tinhtrang_nv"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    @Override
    public NhanVien selectById(Object id) {
        return null;
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "Select * from NhanVien";
        return this.selectBySql(sql);
    }

}
