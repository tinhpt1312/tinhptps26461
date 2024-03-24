/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class HoaDonChiTiet {   
    private int MaHoaDonCT ;
    private String MaHoaDon ;
    private String LoaiSanpham ;
    private String MaSanPham ;	
    private int Soluong ;
    private float GiaTien ;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int MaHoaDonCT, String MaHoaDon, String LoaiSanpham, String MaSanPham, int Soluong, float GiaTien) {
        this.MaHoaDonCT = MaHoaDonCT;
        this.MaHoaDon = MaHoaDon;
        this.LoaiSanpham = LoaiSanpham;
        this.MaSanPham = MaSanPham;
        this.Soluong = Soluong;
        this.GiaTien = GiaTien;
    }

    public int getMaHoaDonCT() {
        return MaHoaDonCT;
    }

    public void setMaHoaDonCT(int MaHoaDonCT) {
        this.MaHoaDonCT = MaHoaDonCT;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getLoaiSanpham() {
        return LoaiSanpham;
    }

    public void setLoaiSanpham(String LoaiSanpham) {
        this.LoaiSanpham = LoaiSanpham;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }
    
}
