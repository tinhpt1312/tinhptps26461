/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM_TongHop;

/**
 *
 * @author Admin
 */
public abstract class nhanvien {

    String tenNV;
    String maNV;
    double luongNV;
    String phongBan;
    public nhanvien() {
    }

    public nhanvien(String tenNV, String maNV, double luongNV, String phongBan) {
        this.tenNV = tenNV;
        this.maNV = maNV;
        this.luongNV = luongNV;
        this.phongBan = phongBan;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
    
    
    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public double getLuongNV() {
        return luongNV;
    }

    public void setLuongNV(double luongNV) {
        this.luongNV = luongNV;
    }
    abstract double getLuong();
}
