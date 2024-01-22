/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi13;

import java.util.Scanner;

/**
 *
 * @author Tinh
 */
/* Cho nhập vào giá trị tháng kiểu enum --> xuất ra số ngày trong tháng */
enum MONTHS {
    JAN, FEB, MAR, APR, MAY, JUL, JUN, AUG, SEP, OCT, NOV, DEC
};

public class UseEnum {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MONTHS m; //Biến enum
        while (true) {
            try {
                System.out.print("Nhap thang: ");
                /* valueOf : biến đổi String --> enum */
                m = MONTHS.valueOf(sc.nextLine().toUpperCase());
                break; // Nhập đúng thoát vòng lặp xử lý tiếp
            } catch (IllegalArgumentException e) {
                System.out.println("Gia tri enum k hop le ");
            };
        }
        switch (m) {
            case JAN:
            case MAR:
            case MAY:
            case JUL:
            case AUG:
            case OCT:
            case DEC:
                System.out.println("Thang: " + m + " co 31 ngay ");
                break;
            case APR:
            case JUN:
            case SEP:
            case NOV:
                System.out.println("Thang: " + m + " co 30 ngay ");
                break;
            case FEB:
                System.out.println("Thang: " + m + " co 28 ngay ");
                break;

        }
    }
}
