/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM_TongHop;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class nhanVienTruongPhong extends nhanvien {

    double luongTrachNhiem;

    
    public nhanVienTruongPhong(double luongTrachNhiem) {
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public nhanVienTruongPhong(double luongTrachNhiem, String tenNV, String maNV, double luongNV, String phongBan) {
        super(tenNV, maNV, luongNV, phongBan);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public double getLuongTrachNhiem() {
        return luongTrachNhiem;
    }

    public void setLuongTrachNhiem(double luongTrachNhiem) {
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public nhanVienTruongPhong() {
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

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
    
    public double getThuNhap(){
        return luongNV + luongTrachNhiem;
    }

    @Override
    double getLuong() {
        return luongNV + luongTrachNhiem;
    }
}
