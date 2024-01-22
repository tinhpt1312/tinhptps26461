/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sof2041slide3;

import com.edusys.utils.XJdbc;

/**
 *
 * @author teo
 */
public class Insert {
    public static void main(String[] args) {
        String sql="INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql,"TeoLV4","123","Lê Văn Tèo", true);
    }
}
