/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.NHANVIEN;
import GUI.KhoaHoc;
import GUI.MainFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Tinh
 */
public class LoginDao {

    public boolean Login(NHANVIEN nv) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "select * from NhanVien where Manv = ? and Matkhau = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, nv.getMaNV());
            stm.setString(2, nv.getMatKhau());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                nv.setMaNV(rs.getString("MaNV"));
                if (rs.getBoolean("Vaitro") == true) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                    return true;
                } else if (rs.getBoolean("Vaitro") == false) {
                    JOptionPane.showMessageDialog(null, "Nhân viên không đc cấp quyền");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
