/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi2;

import java.util.Scanner;

/**
 *
 * @author Tinh
 */
abstract public class HoaDon {

    /* Field */
    protected String maHoaDon;
    protected String tenKhachHang;
    protected String maPhong;
    protected Double Gia;

    /*Hàm tạo*/
    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String tenKhachHang, String maPhong, Double Gia) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.maPhong = maPhong;
        this.Gia = Gia;
    }

    /*Phương thức*/
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ma hoa don: ");
        this.maHoaDon = sc.nextLine();
        System.out.printf("Ten khach hang: ");
        this.tenKhachHang = sc.nextLine();
        System.out.printf("Ma Phong: ");
        this.maPhong = sc.nextLine();
        System.out.printf("Don gia: ");
        this.Gia = sc.nextDouble();
    }

    public void xuat() {
        System.out.println("-------------------------");
        System.out.println("\t Hoa Don ");
        System.out.println("-------------------------");
        System.out.println("Ma Hoa Don: " + this.maHoaDon);
        System.out.println("Ten khach hang: " + this.tenKhachHang);
        System.out.println("Ma phong: " + this.maPhong);
        System.out.println("Don gia: " + this.Gia);
    }

    abstract public Double tinhThanhTien();
    /* Phương thức trìu tượng */
}
