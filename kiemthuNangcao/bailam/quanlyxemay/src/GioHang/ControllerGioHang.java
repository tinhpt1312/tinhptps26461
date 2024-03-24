/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GioHang;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ControllerGioHang {
    public static ArrayList<GioHang> ListGioHang=new ArrayList<>();
    public static boolean ThemGioHang(String makhachhang){
        GioHang gh=new GioHang();
        gh.setMaKhachHang(makhachhang);
        return ListGioHang.add(gh);
    }
    public static GioHang getGioHang(String makhachhang){
        for (GioHang gh : ListGioHang) {
            if(gh.getMaKhachHang().equals(makhachhang)){
               return gh;
            }
        }
        return null;
    }
    public static boolean XoaGioHang(String makhachhang){
        for (GioHang gh : ListGioHang) {
            if(gh.getMaKhachHang().equals(makhachhang)){
               return ListGioHang.remove(gh);
            }
        }
        return false;
    }
    public static boolean ThemSanPhamChoKhach(String makhachhang,SanPham x){
        if(KiemtraTontai(makhachhang)){
            for (GioHang gh : ListGioHang) {
                if (gh.getMaKhachHang().equals(makhachhang)) {
                    
                    return gh.themSanPham(x);
                }
            } 
        }else{
            ThemGioHang(makhachhang);
            return ThemSanPhamChoKhach(makhachhang, x);           
        }
        return false;
    }
    public static boolean XoaSanPhamChoKhach(String makhachhang,SanPham x){
        for (GioHang gh : ListGioHang) {
            if (gh.getMaKhachHang().equals(makhachhang)) {
               return gh.xoaSanPham(x);
            }
        }
        return false;
    }
    public static boolean XoaSanPhamTheoMa(String makhachhang,String x){
        for (GioHang gh : ListGioHang) {
            if (gh.getMaKhachHang().equals(makhachhang)) {
               return gh.xoaSanPham(x);
            }
        }
        return false;
    }
    public static boolean XoaNhieuSanPhamChoKhach(String makhachhang,String MaSanPham){
        String[] mangMaSanPham=MaSanPham.split(",");
        boolean check=false;
        for (String MaSp : mangMaSanPham) {
           check=XoaSanPhamTheoMa(makhachhang, MaSp);
           if(check==false){
               break;
           }
        }
        return check;
    }
    public static boolean KiemtraTontai(String makhachhang){
        for (GioHang gh : ListGioHang) {
            if(gh.getMaKhachHang().equals(makhachhang)){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<GioHang> getListGioHang() {
        return ListGioHang;
    }

}
