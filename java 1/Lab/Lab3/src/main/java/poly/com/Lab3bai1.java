/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab3bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("So ban muon kiem tra la: ");
        int a = sc.nextInt();
        boolean c = true;
        for (int i = 2; i < a - 1; i++) {
            if (a % i == 0) {
                c = false;
                break;
            }
        }
        if (c == true) {
            System.out.println(a + " la so nguyen to");
        } else {
            System.out.println(a + " khong phai so nguyen to");
        }
    }
}
