/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import GioHang.SanPham;
import Model.PhuKien;
import Model.XeMay;

/**
 *
 * @author ADMIN
 */
public class UtilityConvert {

    public UtilityConvert() {
    }

    public static SanPham XemayToSanpham(XeMay x) {
        SanPham sp = new SanPham();
        sp.setMaSanPham(x.getMaXeMay());
        sp.setTenSanPham(x.getTenXe());
        sp.setLoaiSanPham("XeMay");
        sp.setGiatien(x.getGiaTien());
        return sp;
    }
    public static SanPham PhukienToSanpham(PhuKien x) {
        SanPham sp = new SanPham();
        sp.setMaSanPham(x.getMaPhuKien());
        sp.setTenSanPham(x.getTenPhuKien());
        sp.setLoaiSanPham("PhuKien");
        sp.setGiatien(x.getGiaTien());
        return sp;
    }
}
