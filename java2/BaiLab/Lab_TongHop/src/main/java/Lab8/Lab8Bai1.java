/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab8;

import java.util.ArrayList;

/**
 *
 * @author Tinh
 */
public class Lab8Bai1 {
    public static void main(String[] args) {
        ArrayList l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2.2);
        l1.add(true);
        l1.add("Tinh");
        
       for(int i = 0; i <= l1.size()-1; i++){
           System.out.println(l1.get(i));
       }
    }
}
