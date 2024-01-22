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
public class Lab2bai3 {
    public static void b3 () {
        double soDien, tienDien;
        Scanner sc = new Scanner (System.in);
        System.out.print("nnhap so dien: ");
        soDien = sc.nextDouble();
        if(soDien <= 50){
            tienDien = soDien * 1000;
        }else{
            tienDien = (soDien * 1000) + (soDien - 50) * 1200;
        }
        System.out.println("tien dien là: " +tienDien);
    }
    public static void main(String[] args) {
        b3();
    }
}
