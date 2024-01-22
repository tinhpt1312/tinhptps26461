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
public class bai2 {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        
        double cv, dt, nhoNhat;
        
        System.out.printf("Chiêu dài: ");
        
        double cd = sc.nextDouble();
        
        System.out.printf("Chiêu rông: ");
        
        double cr = sc.nextDouble();
        
        cv = (cd + cr)*2;
        dt = cd * cr;
        nhoNhat = Math.min(cd, cr);
        
        System.out.println("=======================================");
        
        System.out.printf("Chu vi: %.1f, Dien tich: %.1f, Min: %.1f", cv, dt, nhoNhat);
    }
}
