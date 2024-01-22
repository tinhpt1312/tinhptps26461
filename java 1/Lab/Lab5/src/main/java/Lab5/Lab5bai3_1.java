package Lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lab5bai3_1<T> {
    ArrayList<Lab5bai3> list = new ArrayList<>();
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.printf("Nhap ten san pham: ");
            String tenSP = sc.nextLine();
            System.out.printf("Gia san pham: ");
            Double giaSP = sc.nextDouble();
            System.out.printf("Ban co muon nhap them khong (Y/N): ");
            sc.nextLine();
            list.add(new Lab5bai3(tenSP, giaSP));
            if(sc.nextLine().equalsIgnoreCase("N")){
                System.out.println("Nhap du lieu thanh cong!");
                break;
            }
        }
    }
    public void xuat(){
        Comparator<Lab5bai3> comp = new Comparator<Lab5bai3>() {
            @Override
            public int compare(Lab5bai3 o1, Lab5bai3 o2) {
                return Double.compare(o1.getGiaSP(), o2.getGiaSP());
            }
        };
        Collections.sort(list, comp);
        System.out.println("");
        System.out.println("Danh sach san pham:");
        System.out.printf("\t%-20s %-20s \n","Ten SP", "Gia SP");
        for(Lab5bai3 sp: list){
            System.out.printf("\t%-20s %-20.2f \n", sp.getTenSP(), sp.getGiaSP());
        }
    }
    public void timvaxoaSP(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap san pham ban muon xoa: ");
        String xoa = sc.nextLine();
        boolean check = false;
        for(Lab5bai3 sp: list){
            if(xoa.equalsIgnoreCase(sp.getTenSP())){
                System.out.println("");
                System.out.println("San pham ban muon xoa la: ");
                System.out.printf("\t%-20s %-20s \n","Ten SP", "Gia SP");
                System.out.printf("\t%-20s %-20.2f \n", sp.getTenSP(), sp.getGiaSP());
                check = true;
                break;
            }
        }
        if(check == false){
            System.out.println("Khong co san pham ban muon xoa!");
        }else{
            for(Lab5bai3 sp: list){
                if(xoa.equalsIgnoreCase(sp.getTenSP())){
                    list.remove(sp);
                    System.out.println("Xoa ten thanh cong!");
                    break;
                }
            }
            System.out.println("Danh sach san pham sau khi xoa: ");
            System.out.printf("\t%-20s %-20s \n","Ten SP", "Gia SP");
            for(Lab5bai3 sp: list){
                System.out.printf("\t%-20s %-20.2f \n", sp.getTenSP(), sp.getGiaSP());
            }
        }
    }
    public void tinhTB(){
        double TB = 0;
        double tong = 0;
        for(Lab5bai3 sp: list){
            tong += sp.getGiaSP();
        }
        TB = tong / list.size();
        System.out.println("Gia tong TB la: " +TB);
    }
    public void menu(){
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("--------------------------------");
            System.out.println("1. Nhap ten va gia san pham");
            System.out.println("2. Xuat va sap xep san pham");
            System.out.println("3. Tim va xoa san pham");
            System.out.println("4. Xuat gia trung binh san pham");
            System.out.println("0. Thoat");
            System.out.printf("Chuong trinh ban muon chon la: ");
            try{
                int so = sc.nextInt();
                switch(so){
                    case 0:
                        System.out.println("Cam on ban da su dung chuong trinh cua chung toi!"); 
                        System.exit(1);
                        break;
                    case 1:
                        System.out.println("------------------");
                        nhap();
                        break;
                    case 2:
                        System.out.println("--------------------");
                        xuat();
                        break;
                    case 3:
                        System.out.println("----------------------");
                        timvaxoaSP();
                        break;
                    case 4:
                        System.out.println("------------------------");
                        tinhTB();
                        break;
                    default:
                        System.out.println("Vui long nhap so 0 den 5");
                }
            }catch (Exception ex){
                System.out.println("Vui long nhap so!");
            }
        }while(true);
    }
}
