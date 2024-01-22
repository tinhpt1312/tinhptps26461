/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi12;

import java.net.InetAddress;

/**
 *
 * @author Tinh
 */
public class Demo2 {

    public static void main(String[] args) {
        try {
            InetAddress address[] = InetAddress.getAllByName("lms.poly.edu.vn");
            for (int i = 0; i < address.length; i++) {
                System.out.println("Address " + (i + 1) + ": " + address[i]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
