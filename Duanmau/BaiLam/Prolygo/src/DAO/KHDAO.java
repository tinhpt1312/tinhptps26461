/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.KHOAHOC;
import Helper.DateHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

/**
 *
 * @author Tinh
 */
public class KHDAO {
    
    DateHelper DHL = new DateHelper();
    public void insert(KHOAHOC kh){
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "insert into KhoaHoc values(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, kh.getMaCD());
            st.setDouble(2, kh.getHocPhi());
            st.setInt(3, kh.getThoiLuong());
            st.setString(4,DHL.toString(kh.getNgayKG()));
            st.setString(5, kh.getGhiChu());
            st.setString(6, kh.getMaNV());
            st.setString(7,DHL.toString(kh.getNgayTao()));
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void update(KHOAHOC kh){
        try(Connection con = KetnoiDatabase.openConnection();){
            String sql = "update KhoaHoc set MaCD = ?, HocPhi = ?, ThoiLuong = ?,"
                    + " NgayKG = ?, GhiChu = ?, MaNV = ?, NgayTao = ? where MaKH = ?";
            PreparedStatement st = con.prepareStatement(sql); 
            st.setString(1, kh.getMaCD());
            st.setDouble(2, kh.getHocPhi());
            st.setInt(3, kh.getThoiLuong());
            st.setString(4, DHL.toString(kh.getNgayKG()));
            st.setString(5, kh.getGhiChu());
            st.setString(6, kh.getMaNV());
            st.setString(7,DHL.toString(kh.getNgayTao()));
            st.setInt(8, kh.getMaKH());
            st.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void delete(KHOAHOC kh){
        try(Connection con = KetnoiDatabase.openConnection();){
            String sql = "delete from KhoaHoc where MaKH = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,kh.getMaKH());
            st.executeUpdate();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
