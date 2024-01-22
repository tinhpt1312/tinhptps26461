/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.TAIKHOAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Tinh
 */
public class LoginDAO {
    public boolean Login(TAIKHOAN us) {
        
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "select * from TAIKHOAN where tendangnhap=? and matkhau=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, us.getUser());
            stm.setString(2, us.getPass());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                if (rs.getInt("vaitro")==1) {
                    JOptionPane.showMessageDialog(null,"Bạn đăng nhập với vai trò nhân viên");
                } else if (rs.getInt("vaitro")==0) {
                    JOptionPane.showMessageDialog(null,"Bạn đăng nhập với vai trò quản lý");
                }else{
                    JOptionPane.showMessageDialog(null,"Bạn chưa được phân quyền ");
                    return false;
                }
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu sai");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
