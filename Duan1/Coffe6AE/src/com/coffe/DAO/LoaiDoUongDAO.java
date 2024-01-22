/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.LoaiDoUong;
import ENTITY.KhachHang;
import UTILS.Xjdbc;
import java.util.List;
import ENTITY.NhanVien;
import UTILS.Xjdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GIA HUY
 */
public abstract class LoaiDoUongDAO extends Coffee7AEDAO<LoaiDoUong, String>{
     @Override
    public void insert(LoaiDoUong loaiDoUong) {
        String sql = "insert into Loai_Do_Uong( Ma_loai,Ten_loai) values (?,?)";
        Xjdbc.update(sql, 
                    loaiDoUong.getMaLoai(),
                    loaiDoUong.getTenLoai()
        );
}
     @Override
    public void update(LoaiDoUong loaiDoUong) {
         String sql = "update LoaiDoUong SET Ten_loai = ?, Ma_loai = ? ";
         Xjdbc.update(sql, loaiDoUong.getTenLoai(),
         loaiDoUong.getMaLoai());
    }

    @Override
    public void delete(String MaLoai) {
        String sql = "DELETE FROM Loai_Do_Uong WHERE Ma_loai=?";
        Xjdbc.update(sql, MaLoai);
    }

    @Override
    public LoaiDoUong selectById(String MaLoai) {
         String sql = "SELECT * FROM Nhan_Vien WHERE Ma_nhan_vien=?";
        List<LoaiDoUong> list = selectBySql(sql, MaLoai);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiDoUong> selectAll() {
        String sql = "SELECT * FROM Loai_Do_Uong";
        return selectBySql(sql);
    }

    @Override
    protected List<LoaiDoUong> selectBySql(String sql, Object... args) {
        List<LoaiDoUong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while (rs.next()) {
                    LoaiDoUong loaiDoUong = new LoaiDoUong();
                    loaiDoUong.setMaLoai(rs.getString("Ma_loai"));
                    loaiDoUong.setTenLoai(rs.getString("Ten_loai"));
                    
                    list.add(loaiDoUong);
                }
            } finally {
                if (rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
