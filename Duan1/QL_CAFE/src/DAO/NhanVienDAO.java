package DAO;

import ENTITY.NhanVien;
import UTILS.Xjdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends Coffee7AEDAO<NhanVien, Integer> {

    @Override
    public void insert(NhanVien nhanVien) {
        String sql = "INSERT INTO Nhan_Vien(Ma_nhan_vien, Ten, Luong, Gio_lam, Gioi_tinh, CCCD, So_dien_thoai, Dia_chi, Vai_tro, Ten_DN, MK, Hinh, Trang_thai_lam_viec) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Xjdbc.update(sql,
                nhanVien.getMaNhanVien(),
                nhanVien.getTen(),
                nhanVien.getLuong(),
                nhanVien.getGioLam(),
                nhanVien.isGioiTinh(),
                nhanVien.getCanCuocCongDan(),
                nhanVien.getSoDienThoai(),
                nhanVien.getDiaChi(),
                nhanVien.getVaiTro(),
                nhanVien.getTenDangNhap(),
                nhanVien.getMatKhau(),
                nhanVien.getHinh(),
                nhanVien.getTrangThaiLamViec()
        );
    }

    @Override
    public void update(NhanVien nhanVien) {
        String sql = "UPDATE Nhan_Vien SET Ten = ?, Luong = ?, Gio_lam = ?, Gioi_tinh = ?, CCCD = ?, So_dien_thoai = ?, Dia_chi = ?, Vai_tro = ?, Ten_DN = ?, MK = ?, Hinh = ?, Trang_thai_lam_viec = ? WHERE Ma_nhan_vien = ?";
        Xjdbc.update(sql,
                nhanVien.getTen(),
                nhanVien.getLuong(),
                nhanVien.getGioLam(),
                nhanVien.isGioiTinh(),
                nhanVien.getCanCuocCongDan(),
                nhanVien.getSoDienThoai(),
                nhanVien.getDiaChi(),
                nhanVien.getVaiTro(),
                nhanVien.getTenDangNhap(),
                nhanVien.getMatKhau(),
                nhanVien.getHinh(),
                nhanVien.getTrangThaiLamViec(),
                nhanVien.getMaNhanVien()
        );
    }

    @Override
    public void delete(Integer MaNhanVien) {
        String sql = "DELETE FROM Nhan_Vien WHERE Ma_nhan_vien=?";
        Xjdbc.update(sql, MaNhanVien);
    }

    @Override
    public NhanVien selectById(Integer MaNhanVien) {
        String sql = "SELECT * FROM Nhan_Vien WHERE Ma_nhan_vien=?";
        List<NhanVien> list = selectBySql(sql, MaNhanVien);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM Nhan_Vien";
        return selectBySql(sql);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setMaNhanVien(rs.getInt("Ma_nhan_vien"));
                    nhanVien.setTen(rs.getString("Ten"));
                    nhanVien.setLuong(rs.getFloat("Luong"));
                    nhanVien.setGioLam(rs.getInt("Gio_lam"));
                    nhanVien.setGioiTinh(rs.getBoolean("Gioi_tinh"));
                    nhanVien.setCanCuocCongDan(rs.getString("CCCD"));
                    nhanVien.setSoDienThoai(rs.getString("So_dien_thoai"));
                    nhanVien.setDiaChi(rs.getString("Dia_chi"));
                    nhanVien.setVaiTro(rs.getString("Vai_tro"));
                    nhanVien.setTenDangNhap(rs.getString("Ten_DN"));
                    nhanVien.setMatKhau(rs.getString("MK"));
                    nhanVien.setHinh(rs.getString("Hinh"));
                    nhanVien.setTrangThaiLamViec(rs.getBoolean("Trang_thai_lam_viec"));
                    list.add(nhanVien);
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
