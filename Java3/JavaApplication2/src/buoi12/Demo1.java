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
public class Demo1 {
    public static void main(String[] args) {
        try{
            InetAddress myHost = InetAddress.getLocalHost();
            System.out.println("Host Address: " +myHost.getHostAddress());
            System.out.println("Host Name: " +myHost.getHostName());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
