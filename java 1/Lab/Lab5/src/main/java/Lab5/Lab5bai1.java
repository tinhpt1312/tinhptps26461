/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab5bai1 {
    ArrayList<Double> list = new ArrayList<>();
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap danh sach so thuc");
        while (true) {            
            System.out.printf("Nhap so: ");
            double so = sc.nextDouble();
            list.add(so);
            sc.nextLine();
            System.out.printf("Ban co muon nhap them so thuc khong (Y/N): ");
            if(sc.nextLine().equalsIgnoreCase("N")){
                break;
            }
        }
    }
    public void xuat(){
        System.out.println("Danh sach so thuc: ");
        for(Double st: list){
            System.out.print("   " +st);
        }
    }
    public void tong(){
        double flag = 0;
        for(double st: list){
            flag += st;
        }
        System.out.println("");
        System.out.printf("Tong mang so thuc: %.2f", flag );
    }
}
