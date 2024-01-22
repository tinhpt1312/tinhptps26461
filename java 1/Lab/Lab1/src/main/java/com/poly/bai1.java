/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        
        System.out.printf("Ho và tên: ");
        
        String name = sc.nextLine();
        
        System.out.printf("Ðiêm TB: ");
        
        double diemTB = sc.nextDouble();
        
        System.out.println("=======================================");
        
        System.out.printf("Ho và tên: %s, Ðiêm: %.1f", name, diemTB);
    }
}
