/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class bai4 {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Phuong trinh bac 2, ax^2 + bx + c");
        
        double delTa;
        
        System.out.printf("he so a: ");
        
        double a = sc.nextDouble();
        
        System.out.printf("he so b: ");
        
        double b = sc.nextDouble();
        
        System.out.printf("he so c: ");
        
        double c = sc.nextDouble();
        
        delTa = Math.pow(b,2) - 4*a*c;
        
        System.out.println("=======================================");
        
        System.out.printf("Delta: %.1f", delTa);
        
    }
}
