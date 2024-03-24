/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GioHang;

/**
 *
 * @author ADMIN
 */
public class SanPham {
    private String MaSanPham;
    private String LoaiSanPham;
    private String TenSanPham;
    private int Soluong;
    private float giatien;

    public SanPham() {
    }

    public SanPham(String MaSanPham, String TenSanPham, int Soluong, float giatien) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.Soluong = Soluong;
        this.giatien = giatien;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
        char[] kytu=new char[2];
        MaSanPham.getChars(0, 2, kytu, 0);
        if(kytu[0]=='X' || kytu[0]=='x'){
            this.LoaiSanPham="XeMay";
        }
        else if(kytu[0]=='p' || kytu[0]=='P' && kytu[1]=='k' || kytu[1]=='K'){
            this.LoaiSanPham="PhuKien";
        }
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public float getGiatien() {
        return giatien;
    }

    public void setGiatien(float giatien) {
        this.giatien = giatien;
    }

    public String getLoaiSanPham() {
        return LoaiSanPham;
    }

    public void setLoaiSanPham(String LoaiSanPham) {
        this.LoaiSanPham = LoaiSanPham;
    }
    
}
