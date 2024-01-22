/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASMbosung;

/**
 *
 * @author Admin
 */
public abstract class nhanvien {
    String tenNV;
    String maNV;
    Double luongCB;
    String phongBan;
    public nhanvien() {
    }

    public nhanvien(String tenNV, String maNV, double luongCB, String phongBan) {
        this.tenNV = tenNV;
        this.maNV = maNV;
        this.luongCB = luongCB;
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
    public Double getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(Double luongCB) {
        this.luongCB = luongCB;
    }
    public String getPhongBan() {
        return phongBan;
    }
    

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
    public double getThueTN(){
        double thueTN;
        if(getLuong() >= 15000000){
            thueTN = getLuong() *  0.12;
        }else if(getLuong() < 15000000 && getLuong() >= 9000000){
            thueTN = getLuong() * 0.1;
        }else{
            thueTN = 0.0;
        }
        return thueTN;
    }
    abstract double getLuong();

    public void xuat() {
    }

    double getThuNhap() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
