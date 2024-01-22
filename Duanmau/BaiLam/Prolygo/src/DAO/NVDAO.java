/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.NHANVIEN;
import DAO.KetnoiDatabase;
import java.sql.*;
/**
 *
 * @author Tinh
 */
public class NVDAO {
    
    public void insert(NHANVIEN nv){
        try(Connection con = KetnoiDatabase.openConnection();){
            String sql = "insert into NhanVien values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,nv.getMaNV());
            st.setString(2,nv.getMatKhau());
            st.setString(3,nv.getHoTen());
            st.setBoolean(4,nv.isVaiTro());
            st.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void delete(NHANVIEN nv){
        try(Connection con = KetnoiDatabase.openConnection();){
            String sql = "delete from nhanvien where manv = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,nv.getMaNV());
            st.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void update(NHANVIEN nv){
        try(Connection con = KetnoiDatabase.openConnection()){
            String sql = "update Nhanvien set matkhau = ?, hoten = ?, vaitro = ? where manv = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,nv.getMatKhau());
            st.setString(2,nv.getHoTen());
            st.setBoolean(3,nv.isVaiTro());
            st.setString(4,nv.getMaNV());
            st.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
