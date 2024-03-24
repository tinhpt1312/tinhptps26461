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
public class XeMay {
   private String MaXeMay;
   private String TenXe;
   private String MaHangXe;
   private float GiaTien;
   private Date NgayNhap;
   private byte[] Hinh;
   private String MaNhanVien;
   private int Soluong;

    public XeMay() {
    }

    public XeMay(String MaXeMay, String TenXe, String MaHangXe, float GiaTien, Date NgayNhap, byte[] Hinh, String MaNhanVien, int Soluong) {
        this.MaXeMay = MaXeMay;
        this.TenXe = TenXe;
        this.MaHangXe = MaHangXe;
        this.GiaTien = GiaTien;
        this.NgayNhap = NgayNhap;
        this.Hinh = Hinh;
        this.MaNhanVien = MaNhanVien;
        this.Soluong = Soluong;
    }



    public String getMaXeMay() {
        return MaXeMay;
    }

    public void setMaXeMay(String MaXeMay) {
        this.MaXeMay = MaXeMay;
    }

    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    public String getMaHangXe() {
        return MaHangXe;
    }

    public void setMaHangXe(String MaHangXe) {
        this.MaHangXe = MaHangXe;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    @Override
    public String toString() {
        return  "MaXeMay=" + MaXeMay + ",\n TenXe=" + TenXe + ",\n MaHangXe=" + MaHangXe + ",\n GiaTien=" + GiaTien + ",\n NgayNhap=" + NgayNhap + ",\n Hinh=" + Hinh + ",\n MaNhanVien=" + MaNhanVien ;
    }
    
    
    
}
