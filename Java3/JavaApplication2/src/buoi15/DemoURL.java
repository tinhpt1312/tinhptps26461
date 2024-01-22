/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi15;

import java.net.URL;

/**
 *
 * @author Tinh
 */
public class DemoURL {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.facebook.com/tinh.phamthe.50/");
            System.out.println("Protocol: " +url.getProtocol());
            System.out.println("Host: " +url.getHost());
            System.out.println("Port: " +url.getPort());
            System.out.println("Part: " +url.getPath());
            System.out.println("File: " +url.getFile());
            System.out.println("Query: " +url.getQuery());
            System.out.println("Ref: " +url.getRef());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
