/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ASM1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NhanVien {
    
    String ma, ten, loai;
    double luong; 
    
    public NhanVien(){
        
    }

    public NhanVien(String ma, String ten, String loai, double luong) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.luong = luong;
    }

    public NhanVien(String loai) {
        this.loai = loai;
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
        
    }
    public void xuat(){
        
    }
    public static void menu(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("+--------------------Assignment giai doan 1-----------------------+");
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("+   1. Nhap xuat danh sach nhan vien tu ban phim                  +");
        System.out.println("+   2. Xuat danh sach nhan vien ra man hinh                       +");
        System.out.println("+   3. Tim va hien thi nhan vien theo ma nhap tu ban phim         +");
        System.out.println("+   4. Xoa nhan vien theo ma nhap tu ban phim                     +");
        System.out.println("+   5. Cap nhat thong tin nhan vien theo ma nhap tu ban phim      +");
        System.out.println("+   6. Tim cac nhan vien theo khoan luong nhap tu ban phim        +");
        System.out.println("+   7. Sap xep nhan vien theo ho va ten                           +");
        System.out.println("+   8. Sap xep nhan vien theo thu nhap                            +");
        System.out.println("+   9. Xuat 5 nhan vien co thu nhap cao nhat                      +");
        System.out.println("+   0. Thoat                                                      +");
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("+--------------------Moi ban chon chuc nang!----------------------+");
        System.out.println("");
        System.out.printf("Chuc nang ban muon chon la: ");
    }

    public static void main(String[] args) {
        do {
            menu(args);
        } while (true);
    }
}
