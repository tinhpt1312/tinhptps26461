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
public class Lab3baithem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Cuu chuong %d", i);
            System.out.println("");
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d x %d = %d", i, j, i * j);
                System.out.println("");
            }
            System.out.println("");
        }
    }
}
