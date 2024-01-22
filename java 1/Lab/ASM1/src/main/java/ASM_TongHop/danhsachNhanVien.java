/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM_TongHop;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class danhsachNhanVien {
    ArrayList<nhanvien> list = new ArrayList<>();
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Ma nhan vien: ");
            String maNV = sc.nextLine();
            System.out.print("Ten nhan vien: ");
            String tenNV = sc.nextLine();
            System.out.print("Luong co ban: ");
            double luongNV = sc.nextDouble();
            System.out.print("Nhan vien tren thuoc ban nao(Hanh chinh / Tiep thi / Truong phong): ");
            String phongBan = new Scanner(System.in).nextLine();
            if(phongBan.equalsIgnoreCase("Hanh Chinh")){
                nhanvien newNV = new nhanVienHC(tenNV, maNV, luongNV, phongBan);
                list.add(newNV);
            }else if(phongBan.equalsIgnoreCase("Tiep Thi")){
                System.out.print("Doanh so: ");
                double doanhSo = sc.nextDouble();
                System.out.print("Hoa hong: ");
                double hoaHong = sc.nextDouble();
                nhanvien newNV = new nhanVienTiepThi(doanhSo, hoaHong, tenNV, maNV, luongNV, phongBan);
                list.add(newNV);
            }else if(phongBan.equalsIgnoreCase("Truong phong")){
                System.out.print("Luong trach nhiem: ");
                double luongTrachNhiem = sc.nextDouble();
                nhanvien newNV = new nhanVienTruongPhong(luongTrachNhiem, tenNV, maNV, luongNV, phongBan);
                list.add(newNV);
            }else{
                System.out.println("Vui long nhap phong ban hop le!");
            }
            sc.nextLine();
            System.out.print("Ban co muon nhap them nhan vien (Y/N): ");
            if(sc.nextLine().equalsIgnoreCase("N")){
                break;
            }
        }
    }
    public void xuat(){
        System.out.println("Danh sach thong tin nhan vien: ");
        System.out.printf("\t%-10s %-20s %-20s %10s\n", "Ma NV", "Ho ten", "Phong ban", "Luong");
        for(nhanvien nv: list){
            System.out.printf("\t%-10s %-20s %-20s %-10.2f\n", nv.getMaNV(), nv.getTenNV(), nv.getPhongBan(), nv.getLuong());
        }
    }
}
