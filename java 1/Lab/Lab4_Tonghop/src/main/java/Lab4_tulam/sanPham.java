/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4_tulam;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class sanPham {
    private  String tenSP;
    private double donGia;
    private double giamGia;

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public sanPham(String tenSP, double donGia, double giamGia) {
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }

    public sanPham(String tenSP, double donGia) {
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.giamGia = 0;
    }
    
    
    public sanPham() {
    }
    
    private double getThueNK(){
        return donGia * 0.1;
    }
    
    public void xuat(){
        System.out.println("Ten san pham: " + tenSP);
        System.out.println("Don gia: " + donGia);
        System.out.println("Giam gia: " + giamGia);
        System.out.println("Thue nhap khau: " + getThueNK());
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ten san pham: ");
        tenSP = sc.nextLine();
        
        System.out.printf("Don gia: ");
        donGia = sc.nextDouble();
        
        System.out.printf("Giam gia: ");
        giamGia = sc.nextDouble();
    }
}
