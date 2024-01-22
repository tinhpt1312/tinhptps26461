/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 */
public class DanhSachSinhVien {
    ArrayList<SinhVienPoly> list = new ArrayList<SinhVienPoly>();

    public void nhap() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ho ten Sinh Vien");
            String hoTen = sc.nextLine();
            if (hoTen == null || hoTen.equals("")) {
                break;
            }
            System.out.println("Nhap ten Nganh (IT/Biz)");
            String nganh = sc.nextLine();
            if (nganh.equalsIgnoreCase("IT")) {
                System.out.println("Diem Java la: ");
                double diemJava = sc.nextDouble();
                System.out.println("Diem Css la: ");
                double diemCss = sc.nextDouble();
                System.out.println("Diem Html la: ");
                double diemHtml = sc.nextDouble();
                SinhVienPoly newSV = new SinhVienIT(hoTen, nganh, diemJava, diemCss, diemHtml);
                list.add(newSV);
            } else if (nganh.equalsIgnoreCase("Biz")) {
                System.out.println("diem Marketing la: ");
                double diemMarketing = sc.nextDouble();
                System.out.println("diem Sales la: ");
                double diemSales = sc.nextDouble();
                SinhVienPoly newSV = new SinhVienBiz(hoTen, nganh, diemMarketing, diemSales);
                list.add(newSV);
            }
            sc.nextLine();
            System.out.printf("Ban co muon nhap them khong (Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                System.out.println("Nhap du lieu thanh cong!");
                break;
            }
        } while (true);
    }

    public void xuat() {
        for (SinhVienPoly sv : list) {
            System.out.printf("HoTen: %s | Nganh: %s | Diem: %.2f | hocLuc:%s\n", sv.getHoTen(), sv.getNganh(),
                    sv.getDiem(), sv.getHocLuc());
        }
    }

    public void xuatGioi() {
        for (SinhVienPoly sv : list) {
            if (sv.getHocLuc().equalsIgnoreCase("gioi")) {
                System.out.printf("HoTen: %s | Nganh: %s | Diem: %.2f | hocLuc:%s\n", sv.getHoTen(), sv.getNganh(),
                        sv.getDiem(), sv.getHocLuc());
            }
        }
    }

    Comparator<SinhVienPoly> comp = new Comparator<SinhVienPoly>() {
        @Override
        public int compare(SinhVienPoly o1, SinhVienPoly o2) {
            return Double.compare(o1.getDiem(), o2.getDiem());
        }

    };

    public void sapXepTheoDiem() {
        Collections.sort(list, comp);
        System.out.println("Sap xep tang dan theo diem");
        xuat();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do {
            System.out.println("Menu chuong trinh: ");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. xuat thong tin danh sach");
            System.out.println("3. xuat danh sach sinh vien co hoc luc gioi");
            System.out.println("4. xuat danh sach sinh vien theo diem");
            System.out.println("0. ket thuc");
            System.out.println("chon chuc nang: (1-5)");
            chon = sc.nextInt();
            if (chon != 0) {
                switch (chon) {
                    case 1:
                        nhap();
                        break;
                    case 2:
                        xuat();
                        break;
                    case 3:
                        xuatGioi();
                        break;
                    case 4:
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Nhap sai. Vui long nhap lai.");
                }
            }
        } while (true);
    }
}
