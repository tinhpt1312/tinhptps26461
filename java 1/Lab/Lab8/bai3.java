/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author ADMIN
 */
public class bai3 {
    public static double sum(double... nums) {
        double tong = 0;
        for (double item : nums) {
            tong += item;
        }
        return tong;
    }

    public static double min(double... nums) {
        double min = nums[0];
        for (double item : nums) {
            min = Math.min(min, item);
        }
        return min;
    }

    public static double max(double... nums) {
        double max = nums[0];
        for (double item : nums) {
            max = Math.max(max, item);
        }
        return max;
    }

    public static String toUpperFirstChar(String name) {
        String[] ars = name.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ars.length; i++) {
            String item = ars[i];
            if (!item.equals("")) {
                String ch = item.substring(0, 1).toUpperCase();
                item = ch + item.substring(1).toLowerCase();
                sb.append(item).append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String ten = toUpperFirstChar(" pham the tinh");
        System.out.println(ten);
    }
}
