/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi15;

import java.util.ArrayList;

/**
 *
 * @author Tinh
 */
public class Test2 {
    public static void main(String[] args) {
        ArrayList l1 = new ArrayList<>(); // k Generic
        l1.add(12);
        l1.add("Tuan");
        l1.add(true);
        l1.add(45.7);
        
        Integer i = (Integer)l1.get(0); // Bắt buộc phải type cast
        ArrayList<Integer> l2 = new ArrayList<Integer>(); // Generic
        l2.add(34);
        // l2.add("binh"); //bắt lỗi lúc dịch
        Integer k = l2.get(0); // k cần type cast
        
        ArrayList<String> l3 = new ArrayList<String>();// generic
        l3.add("trung");
    }
}
