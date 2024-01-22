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
public class Lab2bai2 {
    
        public static void b2() {
        float a, b, c;
        Scanner sc = new Scanner (System.in);
            System.out.print("Nhap he so a: ");
            a = sc.nextFloat();
            System.out.print("Nhap he so b: ");
            b = sc.nextFloat();
            System.out.print("Nhap he so c: ");
            c = sc.nextFloat();
            double delTa = Math.pow(b, 2) - 4*a*c;
        if(delTa < 0){
            System.out.println("phuong trinh vo nghiem");
        }else if(delTa == 0){
            float x = -b/(2*a);
            System.out.printf("phuong trinh co nghiem kep la: %.1f", x);
        }else{
            if(a == 0){
                if(b == 0){
                   if(c == 0){
                       System.out.println("phuong trinh co vo so nghiem");
                   }else{
                       System.out.println("phuong trinh vo nghiem");
                   }
                }else{
                    float x = -c/b;
                    System.out.printf("phuong trinh co nghiem la: %.1f", x);
                }
            }else{
                double x1 = (-b + Math.sqrt(delTa))/(2 * a);
                double x2 = (-b - Math.sqrt(delTa))/(2 * a);
                System.out.println("Phuong trinh co 2 nghiem la");
                System.out.printf("x1 = %.1f, x2 = %.1f", x1, x2);
            }
        }
    }
    public static void main(String[] args) {
        b2();
    }
}
