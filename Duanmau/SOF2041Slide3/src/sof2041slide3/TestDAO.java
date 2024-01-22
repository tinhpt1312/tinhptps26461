/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sof2041slide3;

import com.edusys.dao.NguoiHocDAO;
import com.edusys.entity.NguoiHoc;
import com.edusys.utils.XDate;

/**
 *
 * @author teo
 */
public class TestDAO {
    public static void main(String[] args) {
        NguoiHoc nh1 = new NguoiHoc();
        
        nh1.setDienThoai("0903414749");
        nh1.setEmail("teo@gmail.com");
        nh1.setGhiChu("ghi chu");
        nh1.setGioiTinh(true);
        nh1.setHoTen("Le Van Ech");
        nh1.setMaNH("Ps1112");
        nh1.setMaNV("TeoNV");
        nh1.setNgaySinh(XDate.toDate("2023-09-25","yyyy-MM-dd"));
       
        //----------------
//        NguoiHoc nh2 = new NguoiHoc("PS004", "Tui Ne", 
//                XDate.toDate("2000-03-06","yyyy-MM-dd"), 
//                true, "0903414749", "ps000@gmail.com", "Ghi chu ...", "TeoNV");
        //----------------
        NguoiHocDAO t = new NguoiHocDAO();
        t.insert(nh1);
       // t.insert(nh2);
    }
}
