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
public class Lab2bai4 {

    public static void main(String[] args) {
        int so;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("+-------------------------------+");
            System.out.println("+ 1: Giai phuong trinh bac 1    +");
            System.out.println("+ 2: Giai phuong trinh bac 2    +");
            System.out.println("+ 3: Tinh tien dien             +");
            System.out.println("+ 4: Ket thuc                   +");
            System.out.println("+-------------------------------+");
            System.out.print("Chuong trinh ban muon chon la: ");
            so = sc.nextInt();
            switch (so) {
                case 1:
                    Lab2bai1.b1();
                    break;
                case 2:
                    Lab2bai2.b2();
                    break;
                case 3:
                    Lab2bai3.b3();
                    break;
                case 4:
                    System.out.println("Cam on ban da su dung chuong trinh");
                    System.exit(0);
                default:
                    System.out.println("Khong hop le vui long chon lai");
            }
        } while (true);
    }
}
