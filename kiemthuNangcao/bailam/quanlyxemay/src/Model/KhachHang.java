/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class KhachHang {
   private String MaKhachHang;
   private String HovaTen;
   private Date NgaySinh;
   private boolean  GioiTinh;
   private String SoDT;
   private Date NgayDangKy;
   private String MaNhanVien;

    public KhachHang() {
    }

    public KhachHang(String MaKhachHang, String HovaTen, Date NgaySinh, boolean GioiTinh, String SoDT,  Date NgayDangKy, String MaNhanVien) {
        this.MaKhachHang = MaKhachHang;
        this.HovaTen = HovaTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SoDT = SoDT;
        this.NgayDangKy = NgayDangKy;
        this.MaNhanVien = MaNhanVien;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getHovaTen() {
        return HovaTen;
    }

    public void setHovaTen(String HovaTen) {
        this.HovaTen = HovaTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }



    public Date getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(Date NgayDangKy) {
        this.NgayDangKy = NgayDangKy;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "MaKhachHang=" + MaKhachHang + ", HovaTen=" + HovaTen + ", NgaySinh=" + NgaySinh + ", GioiTinh=" + GioiTinh + ", SoDT=" + SoDT + ", NgayDangKy=" + NgayDangKy + ", MaNhanVien=" + MaNhanVien + '}';
    }
    
}
