package DAO;

import Controller.DBConnection;
import Controller.XJdbc;
import Model.Phim;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PhimDAO extends RedFoxCinema<Phim, Object> {

    @Override
    public void insert(Phim p) {
        String sql = "insert into Phim values(?,?,?,?,?,?,?,?,?,?,?,?)";
        XJdbc.update(sql,
                p.getID(),
                p.getTenPhim(),
                p.getThoiLuong(),
                p.getGioiHanTuoi(),
                p.getNgayCongChieu(),
                p.getNgonNgu(),
                p.getDienVien(),
                p.getQuocGia(),
                p.getNSX(),
                p.getTomTat(),
                p.getTrangThai(),
                p.getID_LoaiPhim());
    }

    @Override
    public void update(Phim p) {
        String sql = "update Phim set tenphim=?, thoiluong=?,gioihantuoi=?,ngaycongchieu=?,ngonngu=?, dienvien=?,quocgia_sx=?,nsx=?,tomtat=?,trangthai=?,ID_loaiphim=? where ID_phim=?";
        XJdbc.update(sql,
                p.getTenPhim(),
                p.getThoiLuong(),
                p.getGioiHanTuoi(),
                p.getNgayCongChieu(),
                p.getNgonNgu(),
                p.getDienVien(),
                p.getQuocGia(),
                p.getNSX(),
                p.getTomTat(),
                p.getTrangThai(),
                p.getID_LoaiPhim(),
                p.getID());
    }

    @Override
    public void delete(Object id) {
        String sql = "delete from Phim where ID_phim=?";
        XJdbc.update(sql, id);
    }

    @Override
    public Phim selectById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Phim> selectAll() {
        String sql = "select * from Phim";
        return selectBySql(sql);
    }

    @Override
    protected List<Phim> selectBySql(String sql, Object... args) {
        List<Phim> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    Phim p = new Phim();
                    p.setID(rs.getString("ID_phim"));
                    p.setTenPhim(rs.getString("tenphim"));
                    p.setThoiLuong(rs.getInt("thoiluong"));
                    p.setGioiHanTuoi(rs.getInt("gioihantuoi"));
                    p.setNgayCongChieu(rs.getDate("ngaycongchieu"));
                    p.setNgonNgu(rs.getString("ngonngu"));
                    p.setDienVien(rs.getString("dienvien"));
                    p.setQuocGia(rs.getString("quocgia_sx"));
                    p.setNSX(rs.getString("nsx"));
                    p.setTomTat(rs.getString("tomtat"));
                    p.setTrangThai(rs.getString("trangthai"));
                    p.setID_LoaiPhim(rs.getInt("ID_loaiphim"));
                    list.add(p);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Phim> findPhim(String input) {
        List<Phim> list = new ArrayList<>();
        try {
            String sql = "select * from phim where ID_phim like '%" + input + "%' or tenphim like N'%" + input + "%'";
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Phim p = new Phim();
                p.setID(rs.getString("ID_phim"));
                p.setTenPhim(rs.getString("tenphim"));
                p.setThoiLuong(rs.getInt("thoiluong"));
                p.setGioiHanTuoi(rs.getInt("gioihantuoi"));
                p.setNgayCongChieu(rs.getDate("ngaycongchieu"));
                p.setNgonNgu(rs.getString("ngonngu"));
                p.setDienVien(rs.getString("dienvien"));
                p.setQuocGia(rs.getString("quocgia_sx"));
                p.setNSX(rs.getString("nsx"));
                p.setTomTat(rs.getString("tomtat"));
                p.setTrangThai(rs.getString("trangthai"));
                p.setID_LoaiPhim(rs.getInt("ID_loaiphim"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
