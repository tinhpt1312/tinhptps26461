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
public class bai2 {
    public static double sum(double... nums) {
        double tong = 0;
        for (double item : nums) {
            tong += item;
        }
        return tong;
    }

    public static double min(double ... nums) {
        double min = nums[0];
        for (double item : nums) {
            min = Math.min(min, item);
        }
        return min;
    }

    public static double max(double ... nums) {
        double max = nums[0];
        for (double item : nums) {
            max = Math.max(max, item);
        }
        return max;
    }


    public static void main(String[] args) {

        double ketqua;
        ketqua= max(5, 6, 3, 6.7);
        System.out.println("Min la: " + ketqua);
    }
}
