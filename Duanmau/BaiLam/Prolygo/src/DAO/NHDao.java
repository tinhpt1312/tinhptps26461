/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.NGUOIHOC;
import Helper.DateHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Tinh
 */
public class NHDao {
    DateHelper DHL = new DateHelper();
    public void insert(NGUOIHOC nh) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "insert into NguoiHoc values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nh.getMaNH());
            st.setString(2, nh.getHoTen());
            st.setString(3, DHL.toString(nh.getNgaySinh()));
            st.setBoolean(4, nh.isGioiTinh());
            st.setString(5, nh.getDienThoai());
            st.setString(6, nh.getEmail());
            st.setString(7, nh.getGhiChu());
            st.setString(8, nh.getMaNV());
            st.setString(9, DHL.toString(nh.getNgayDK()));
            st.setString(10,nh.getTrinhDo());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(NGUOIHOC nh) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "delete from NGUOIHOC where MaNH = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nh.getMaNH());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(NGUOIHOC nh) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "update NGUOIHOC set HoTen=?,NgaySinh=?,GioiTinh=?,DienThoai=?,Email=?,GhiChu=?,MaNV=?,NgayDK=?,TrinhDo=? where MaNH=?";
            PreparedStatement st = con.prepareStatement(sql);    
            st.setString(1, nh.getHoTen());
            st.setString(2, DHL.toString(nh.getNgaySinh()));
            st.setBoolean(3, nh.isGioiTinh());
            st.setString(4, nh.getDienThoai());
            st.setString(5, nh.getEmail());
            st.setString(6, nh.getGhiChu());
            st.setString(7, nh.getMaNV());
            st.setString(8, DHL.toString(nh.getNgayDK()));
            st.setString(9,nh.getTrinhDo());
            st.setString(10, nh.getMaNH());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
