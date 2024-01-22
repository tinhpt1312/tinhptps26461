package DAO;

import ENTITY.KhachHang;
import UTILS.Xjdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class KhachHangDAO extends Coffee7AEDAO<KhachHang, Integer> {

    @Override
    public void insert(KhachHang khachHang) {
        String sql = "insert into Khach_Hang( Ma_khach_hang, Ten, SDT, Dia_chi) values (?,?,?,?)";
        Xjdbc.update(sql,
                khachHang.getMaKhachHang(),
                khachHang.getTenKhachHang(),
                khachHang.getSoDienThoai(),
                khachHang.getDiaChi()
        );
    }

    @Override
    public void update(KhachHang khachHang) {
        String sql = "update Khach_Hang SET  Ten = ?, SDT = ?, Dia_chi = ? where Ma_khach_hang = ? ";
        Xjdbc.update(sql, khachHang.getTenKhachHang(),
                khachHang.getSoDienThoai(),
                khachHang.getDiaChi(),
                khachHang.getMaKhachHang()
        );
    }

    public void delete(Integer MaKhachHang) {
        String sql = "DELETE FROM Khach_Hang WHERE Ma_khach_hang=?";
        Xjdbc.update(sql, MaKhachHang);
    }

    @Override
    public KhachHang selectById(Integer MaKhachHang) {
        String sql = "SELECT * FROM Khach_Hang WHERE Ma_khach_hang=?";
        List<KhachHang> list = selectBySql(sql, MaKhachHang);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM Khach_Hang";
        return selectBySql(sql);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while (rs.next()) {
                    KhachHang khachHang = new KhachHang();
                    khachHang.setMaKhachHang(rs.getInt("Ma_khach_hang"));
                    khachHang.setTenKhachHang(rs.getString("Ten"));
                    khachHang.setSoDienThoai(rs.getString("SDT"));
                    khachHang.setDiaChi(rs.getString("Dia_chi"));
                    list.add(khachHang);
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
