/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package poly.com;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab2bai1 {

    public static void b1() {
        float a, b;
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap he so a: ");
        a = sc.nextFloat();
        System.out.print("Nhap he so b: ");
        b = sc.nextFloat();
        
        if(a != 0){
            float x = -b/a;
            System.out.printf("Phuong trinh co nghiem la: %.1f", x);
        }
        else if(b != 0){
            System.out.println("Phuong trinh vo nghiem");
        }
        else {
            System.out.println("Phuong trinh co vo so nghiem");
        }
    }
    public static void main(String[] args) {
        b1();
    }
}
