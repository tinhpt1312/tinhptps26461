/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class SinhVienPoly {
    private String hoTen;
    private String nganh;

    public SinhVienPoly() {
    }

    public SinhVienPoly(String hoTen, String nganh) {
        this.hoTen = hoTen;
        this.nganh = nganh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    abstract double getDiem();

    public String getHocLuc() {
        String hocLuc = null;
        if (getDiem() > 9) {
            hocLuc = "Xuat sac";
        } else if (getDiem() >= 7.5) {
            hocLuc = "Gioi";
        } else if (getDiem() >= 6.5) {
            hocLuc = "Kha";
        } else if (getDiem() >= 5) {
            hocLuc = "Trung Binh";
        } else {
            hocLuc = "Yeu";
        }
        return hocLuc;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhap Ho ten sinh vien: ");
            hoTen = sc.nextLine();
            System.out.println("Nhap Nganh sinh vien: ");
            nganh = sc.nextLine();

        }
    }

    public void xuat() {
        System.out.printf("Ho ten:%s | Nganh:%s | Diem:%f | Hoc Luc: %s ", getHoTen(), getNganh(), getDiem(),
                getHocLuc());
    }

}
