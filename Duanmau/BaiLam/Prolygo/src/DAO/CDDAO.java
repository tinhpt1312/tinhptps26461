/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.CHUYENDE;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Tinh
 */
public class CDDAO {

    public void insert(CHUYENDE cd) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "insert into ChuyenDe values(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cd.getMaCD());
            st.setString(2, cd.getTenCD());
            st.setDouble(3, cd.getHocPhi());
            st.setInt(4, cd.getThoiLuong());
            st.setString(5, cd.getHinh());
            st.setString(6, cd.getMoTa());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(CHUYENDE cd) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "delete from ChuyenDe where MaCD = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cd.getMaCD());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(CHUYENDE cd) {
        try (Connection con = KetnoiDatabase.openConnection();) {
            String sql = "update CHUYENDE set tencd=?, thoiluong=?, hocphi=?, hinh=?, mota=? where macd = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cd.getTenCD());
            st.setInt(2, cd.getThoiLuong());
            st.setDouble(3, cd.getHocPhi());
            st.setString(4, cd.getHinh());
            st.setString(5, cd.getMoTa());
            st.setString(6, cd.getMaCD());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
