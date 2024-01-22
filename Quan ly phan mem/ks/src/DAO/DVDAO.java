/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.DICHVU;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Tinh
 */
public class DVDAO {
    public void insert(DICHVU dv) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "insert into dichvu values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, dv.getMadv());
            st.setString(2, dv.getTendv());
            st.setDouble(3, dv.getGiadv());
            st.setString(4, dv.getThongtindv());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(DICHVU dv) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "delete from ChuyenDe where MaDV = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, dv.getMadv());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(DICHVU dv) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "update DICHVU set tendv=?, gia=?, thongtindv=? where madv = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, dv.getTendv());
            st.setDouble(2, dv.getGiadv());
            st.setString(3, dv.getThongtindv());
            st.setString(4, dv.getMadv());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
