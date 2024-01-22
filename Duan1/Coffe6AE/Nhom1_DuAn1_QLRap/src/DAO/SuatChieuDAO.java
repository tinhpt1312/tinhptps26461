package DAO;

import Controller.DBConnection;
import Controller.XJdbc;
import Model.SuatChieu;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SuatChieuDAO extends RedFoxCinema<SuatChieu, Object> {

    @Override
    public void insert(SuatChieu sc) {
        String sql = "insert into suatchieu values(?,?,?,?,?,?,?)";
        String maPhim=getMaPhim(sc.getTenPhim());
        XJdbc.update(sql,
                sc.getMaSuatChieu(),
                sc.getNgayChieu(),
                sc.getGioBatDau(),
                sc.getGioKetThuc(),
                maPhim,
                sc.getMaphong(),
                sc.getMaDinhDang());
    }

    @Override
    public void update(SuatChieu sc) {
        String sql="update suatchieu set ngaychieu=?,giobatdau=?,gioketthuc=?,ID_Phim=?,ID_Phongchieu=?,ID_dinhdangphim=? where ID_suatchieu=?";
        String maPhim=getMaPhim(sc.getTenPhim());
        XJdbc.update(sql,
                sc.getNgayChieu(),
                sc.getGioBatDau(),
                sc.getGioKetThuc(),
                maPhim,
                sc.getMaphong(),
                sc.getMaDinhDang(),
                sc.getMaSuatChieu());
    }

    @Override
    public void delete(Object id) {
        String sql="delete from suatchieu where ID_suatchieu=?";
        XJdbc.update(sql,id);
    }

    @Override
    public SuatChieu selectById(Object id) {
        String sql = "select * from suatchieu where ID_suatchieu=?";
        List<SuatChieu> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<SuatChieu> selectAll() {
        String sql = "select * from suatchieu";
        return selectBySql(sql);
    }

    @Override
    protected List selectBySql(String sql, Object... args) {
        List<SuatChieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {

                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    SuatChieu sc = new SuatChieu();
                    String tenphim = getTenPhim(rs.getString("ID_Phim"));
                    sc.setMaSuatChieu(rs.getString(1));
                    sc.setNgayChieu(String.valueOf(rs.getDate(2)));
                    sc.setGioBatDau(String.valueOf(rs.getTime(3)));
                    sc.setGioKetThuc(String.valueOf(rs.getTime(4)));
                    sc.setTenPhim(tenphim);
                    sc.setMaphong(rs.getString(6));
                    sc.setMaDinhDang(rs.getString(7));
                    list.add(sc);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;

    }

    public String getTenPhim(String ID_Phim) {
        String tenPhim = "";
        try {
            String sql = "select tenphim from phim where ID_phim=" + ID_Phim;
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                tenPhim = rs.getString("tenphim");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenPhim;
    }

    public String getMaPhim(String tenPhim) {
        String maPhim = "";
        try {
            String sql = "select ID_phim from phim where tenphim=N'" + tenPhim+"'";
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                maPhim = rs.getString("ID_Phim");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maPhim;
    }
}
