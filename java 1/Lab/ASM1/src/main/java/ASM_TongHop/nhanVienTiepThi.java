/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM_TongHop;

/**
 *
 * @author Admin
 */
public class nhanVienTiepThi extends nhanvien {

    private double doanhSo;
    private double hoaHong;

    public nhanVienTiepThi(double doanhSo, double hoaHong) {
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    public nhanVienTiepThi(double doanhSo, double hoaHong, String tenNV, String maNV, double luongNV, String phongBan) {
        super(tenNV, maNV, luongNV, phongBan);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    public nhanVienTiepThi() {
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHoaHong() {
        return hoaHong;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
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
    
    public String getPhongBan(){
        return phongBan;
    }
    
    public void setPhongBan(String phongBan){
        this.phongBan = phongBan;
    }
    
    public double getThuNhap(){
        return luongNV + hoaHong;
    }

    @Override
    double getLuong() {
        return luongNV + hoaHong;
    }
}
