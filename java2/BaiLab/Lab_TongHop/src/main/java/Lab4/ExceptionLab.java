/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.util.Scanner;

/**
 *
 * @author Tinh
 */
public class ExceptionLab {

    public static void main(String[] args) {
            try {
                Scanner sc = new Scanner(System.in);
                int[] m = {0, 2, 3};
                int i, k;
                System.out.print("Nhap i : ");
                i = Integer.parseInt(sc.nextLine()); //lỗi 3 nhập i bằng chữ
                k = m[i]; // lỗi 2 i > 2
                int x;
                x = -1 / (2 * k); // lỗi 1 k = 0 
                System.out.println("x = " + x);
            } catch (ArithmeticException ex) {
                System.out.println("Gia tri k hop le");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Mang chi co tu 3 gia tri tu 0 --> 2");
            } catch (NumberFormatException ex) {
                System.out.println("Vui long nhap so");
            }
    }


}
