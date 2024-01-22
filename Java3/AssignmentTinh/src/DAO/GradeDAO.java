/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.GRADE;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author Tinh
 */
public class GradeDAO {

    public void insert(GRADE sv) {
        try (Connection con = KetNoiCSDL.openConnection()) {
            String sql = "insert into GRADE values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sv.getMaSv());
            st.setFloat(2, sv.getDiemTa());
            st.setFloat(3, sv.getDiemTh());
            st.setFloat(4, sv.getDiemTc());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(GRADE sv) {
        try (Connection con = KetNoiCSDL.openConnection()) {
            String sql = "Delete from GRADE where Masv = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sv.getMaSv());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(GRADE sv) {
        try (Connection con = KetNoiCSDL.openConnection()) {
            String sql = "update GRADE set Tienganh = ?, Tinhoc = ?, GDTC = ? where Masv = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setFloat(1, sv.getDiemTa());
            st.setFloat(2, sv.getDiemTh());
            st.setFloat(3, sv.getDiemTc());
            st.setString(4, sv.getMaSv());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sapxepTA(GRADE sv) {
        try (Connection con = KetNoiCSDL.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select top 3 ID,st.MASV,Hoten,Tienganh,Tinhoc,GDTC from STUDENTS st inner join GRADE gr on st.MASV = gr.MASV order by Tienganh desc";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                sv.setID(rs.getInt("ID"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setMaSv(rs.getString("MaSV"));
                sv.setDiemTa(rs.getFloat("TiengAnh"));
                sv.setDiemTh(rs.getFloat("TinHoc"));
                sv.setDiemTc(rs.getFloat("GDTC"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void search(GRADE sv){
        try (Connection con = KetNoiCSDL.openConnection();) {
            String sql = "select gr.ID, st.Masv, st.HoTen, gr.Tienganh, gr.Tinhoc, gr.GDTC from STUDENTS st inner join GRADE gr on st.Masv = gr.Masv where st.Masv = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sv.getMaSv());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                sv.setID(rs.getInt("ID"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setMaSv(rs.getString("MaSV"));
                sv.setDiemTa(rs.getFloat("TiengAnh"));
                sv.setDiemTh(rs.getFloat("TinHoc"));
                sv.setDiemTc(rs.getFloat("GDTC"));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
