/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class bai1 {
    public static double sum(double... nums) {
        double tong = 0;
        for (double item : nums) {
            tong += item;
        }
        return tong;
    }

    public static void main(String[] args) {
        double sum = sum(5, 6, 3, 6.7);
        System.out.println("Ket qua: " + sum);
    }
        
    }
        
