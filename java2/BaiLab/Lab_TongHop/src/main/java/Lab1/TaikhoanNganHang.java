/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tinh
 */
public class TaikhoanNganHang {

    protected String maTK;
    protected String hoTen;
    protected Integer soDuTK;
    ArrayList<TaikhoanNganHang> list = new ArrayList<>();

    public TaikhoanNganHang(String maTK, String hoTen, Integer soDuTK) {
        this.maTK = maTK;
        this.hoTen = hoTen;
        this.soDuTK = soDuTK;
    }

    public TaikhoanNganHang() {
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getSoDuTK() {
        return soDuTK;
    }

    public void setSoDuTK(Integer soDuTK) {
        this.soDuTK = soDuTK;
    }
    
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhap thong tin tai khoan ");
            System.out.printf("Ma tai khoan: ");
            this.maTK = sc.nextLine();
            System.out.printf("Ho va ten: ");
            this.hoTen = sc.nextLine();
            System.out.printf("So du tai khoan: ");
            this.soDuTK = sc.nextInt();
            list.add(new TaikhoanNganHang(maTK, hoTen, soDuTK));
            break;
        }

    }

    public void xuat() {
        System.out.println("Xuat thong tin tai khoan: ");
        System.out.println("Ma tai khoan: " + this.maTK);
        System.out.println("Ho va ten: " + this.hoTen);
        System.out.println("So du: " + this.soDuTK);
    }

    public void rutTien() {
        Integer rutTien;
        Scanner sc = new Scanner(System.in);
        System.out.printf("So tien can rut la: ");
        rutTien = sc.nextInt();
        if (soDuTK >= rutTien) {
            soDuTK = soDuTK - rutTien;
            System.out.println("Giao dich thanh cong");
        } else {
            System.out.println("So du khong du");
        }
    }

    public void guiTien() {
        Integer guiTien;
        Scanner sc = new Scanner(System.in);
        System.out.printf("So tien can gui la: ");
        guiTien = sc.nextInt();
        soDuTK = soDuTK + guiTien;
        System.out.println("Gui tien thanh cong");
    }

    public void menu() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("+   1. Nhap thong tin");
            System.out.println("+   2. Xuat thong tin");
            System.out.println("+   3. Rut tien ");
            System.out.println("+   4. Gui tien");
            System.out.println("+   0. Thoat");
            System.out.println("");
            System.out.printf("Chuc nang ban muon chon la: ");
            try {
                int so = sc.nextInt();
                switch (so) {
                    case 0 -> {
                        System.out.println("Cam on ban da su dung chuong trinh cua chung toi!");
                        System.exit(1);
                    }
                    case 1 -> {
                        System.out.println("------------------");
                        nhap();
                    }
                    case 2 -> {
                        System.out.println("--------------------");
                        xuat();
                    }
                    case 3 -> {
                        System.out.println("----------------------");
                        rutTien();
                    }
                    case 4 -> {
                        System.out.println("------------------------");
                        guiTien();
                    }
                    default -> System.out.println("Vui long nhap so 0 den 4");
                }
            } catch (Exception ex) {
                System.out.println("Vui long nhap so!");
            }
        } while (true);
    }

    public static void main(String[] args) {
        TaikhoanNganHang tk = new TaikhoanNganHang();
        tk.menu();

    }
}
