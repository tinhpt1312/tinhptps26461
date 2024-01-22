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
public class Lab8Bai2 {
    public static void main(String[] args) {
        ArrayList<Integer> myarr = new ArrayList<Integer>();
        for(int i = 1; i<=10; i++){
            myarr.add(i);
        }
        for(int i = 0; i<myarr.size(); i++){
            System.out.println(myarr.get(i));
        }
    }
}
