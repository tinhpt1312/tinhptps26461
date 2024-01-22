/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NhanVienTiepThi extends NhanVien{
    private double doanhSo;
    private double hoaHong;

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

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    
    public void nhap(){
        super.nhap();
        Scanner s = new Scanner(System.in);
        System.out.printf("Nhap doanh so cua nv tiep thi: ");
        doanhSo = s.nextDouble();
        System.out.printf("Nhap hoa hong cua nv tiep thi: ");
        hoaHong = s.nextDouble();
    }
    public void xuat(){
        super.xuat();
    }
}
