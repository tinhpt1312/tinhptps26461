/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab3bai3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("So sinh vien ban muon luu la: ");
        int a = sc.nextInt();
        String[] sv = new String[a];
        float[] diem = new float[a];
        System.out.println("Nhap ten sv va diem sv trong mang");
        for (int i = 0; i < sv.length; i++) {
            System.out.printf("Nhap ten cho sv thu [%d]: ", i + 1);
            sv[i] = sc.nextLine();
            sc.nextLine();
            System.out.printf("Nhap diem cho sv thu [%d]: ", i + 1);
            diem[i] = sc.nextFloat();
        }
        for (int i = 0; i < diem.length; i++) {
            for (int j = 0; j < diem.length; j++) {
                float temp = diem[0];
                if (diem[i] < diem[j]) {
                    temp = diem[j];
                    diem[j] = diem[i];
                    diem[i] = temp;
                }
            }
        }
        sc.nextLine();
        for (int i = 0; i < diem.length; i++) {
            System.out.println("Ho ten: " + sv[i]);
            System.out.println("Diem = " + diem[i]);
            if (diem[i] >= 9) {
                System.out.println("Hoc luc xuat sac");
            } else if (diem[i] >= 7.5) {
                System.out.println("Hoc luc gioi");
            } else if (diem[i] >= 6.5) {
                System.out.println("Hoc luc kha");
            } else if (diem[i] >= 5) {
                System.out.println("Hoc luc TB");
            } else {
                System.out.println("Hoc luc yeu");
            }
            System.out.println("");
        }
    }
}
