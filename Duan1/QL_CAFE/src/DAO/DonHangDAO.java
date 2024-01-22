/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.DonHang;
import UTILS.Xjdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DonHangDAO extends Coffee7AEDAO<DonHang, Integer> {
    
    public void insert(DonHang DonHang) {
        String sql = "insert into Don_Hang(Ma_don_hang, Ngay_dat_hang, Ten_do_uong, Ma_loai, Size, Tong_tien, Ma_hinh_thuc, Ghi_chu, Ma_khach_hang, Ma_nhan_vien)\n"
                + "values(?,?,?,?,?,?,?,?,?,?);";
        Xjdbc.update(sql,
                DonHang.getMaDonHang(),
                DonHang.getNgayDatHang(),
                DonHang.getTenDoUong(),
                DonHang.getMaLoai(),
                DonHang.getSizeDoUong(),
                DonHang.getTongTien(),
                DonHang.getMaHinhThuc(),
                DonHang.getGhiChu(),
                DonHang.getMaKhachHang(),
                DonHang.getMaNhanVien());
    }
    
    public void update(DonHang DonHang) {
        String sql = "update Don_Hang set Ngay_dat_hang =? , Ten_do_uong= ?, Ma_loai = ? , Size =?, Tong_tien = ?, Ma_hinh_thuc = ?, \n"
                + "Ghi_chu = ?, Ma_khach_hang = ?, Ma_nhan_vien =  ? where Ma_don_hang = ?";
        Xjdbc.update(sql,
                DonHang.getNgayDatHang(),
                DonHang.getTenDoUong(),
                DonHang.getMaLoai(),
                DonHang.getSizeDoUong(),
                DonHang.getTongTien(),
                DonHang.getMaHinhThuc(),
                DonHang.getGhiChu(),
                DonHang.getMaKhachHang(),
                DonHang.getMaNhanVien(),
                DonHang.getMaDonHang());
    }
    
    public void delete(Integer DonHang) {
        String sql = "DELETE delete from Ban where Ma_don_hang = ?";
        Xjdbc.update(sql, DonHang);
    }
    
    public List<DonHang> selectAll() {
        String sql = "SELECT * FROM DonHang";
        return selectBySql(sql);
    }
    
    public DonHang selectById(Integer So_ban) {
        String sql = "SELECT * FROM Ban WHERE Ma_don_hang=?";
        List<DonHang> list = selectBySql(sql, So_ban);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<DonHang> selectBySql(String sql, Object... args) {
        List<DonHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while (rs.next()) {
                    DonHang DonHang = new DonHang();
                    DonHang.setMaDonHang(rs.getInt("Ma_don_hang"));
                    DonHang.setNgayDatHang(rs.getDate("Ngay_dat_hang"));
                    DonHang.setTenDoUong(rs.getString("Ten_do_uong"));
                    DonHang.setMaLoai(rs.getString("Ma_loai"));
                    DonHang.setTongTien(rs.getFloat("Tong_tien"));
                    DonHang.setMaHinhThuc(rs.getString("Ma_hinh_thuc"));
                    DonHang.setGhiChu(rs.getString("Ghi_chu"));
                    DonHang.setMaKhachHang(rs.getInt("Ma_khach_hang"));
                    DonHang.setMaNhanVien(rs.getInt("Ma_nhan_vien"));
                    list.add(DonHang);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
