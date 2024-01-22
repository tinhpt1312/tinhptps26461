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
abstract public class HoaDontheogio extends HoaDon {

    /* Field */
    private Integer soGioThue;

    /* Hàm tạo */
    public HoaDontheogio(Integer soGioThue, String maHoaDon, String tenKhachHang, String maPhong, Double Gia) {
        super(maHoaDon, tenKhachHang, maPhong, Gia);
        this.soGioThue = soGioThue;
    }

    public HoaDontheogio() {
    }

    /* Phương thức */

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();/* gọi phương thức nhập của lớp cha */
        System.out.printf("So gio thue: ");
        this.soGioThue = sc.nextInt();
    }
    @Override
    public void xuat(){
        Scanner sc = new Scanner(System.in);
        super.xuat();
        System.out.println("So gio thue: " + this.soGioThue);
        System.out.println("Thanh tien = " + this.tinhThanhTien());
    }    
    @Override
    public Double tinhThanhTien(){
        return this.soGioThue * this.Gia;
    }
}
