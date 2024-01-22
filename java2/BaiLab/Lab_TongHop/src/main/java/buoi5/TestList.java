/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi5;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Tinh
 */
public class TestList {
    public static void main(String[] args) {
        ArrayList<Integer> lt = new ArrayList<Integer>();
        HashSet<Integer> ls = new HashSet<Integer>();
        
        /* Thêm vào cuối list */
        // Danh sách
        ls.add(6); ls.add(4); ls.add(6);
        System.out.println("Số pt = " + ls.size());
        System.out.println(ls.toString());
        // Tập hợp
        lt.add(6); lt.add(4); lt.add(6);
        System.out.println("Số pt = " + lt.size());
        System.out.println(lt.toString());
    }
}
