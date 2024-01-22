/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab7;

import java.util.Scanner;

/**
 *
 * @author Tinh
 */
enum Career {
    UDPM, TKTW, LTDĐ, TKĐH
}

public class PolyStudent {

    public String fullName;
    public Career career;

    public void print() {
        System.out.println("> Full Name: " + this.fullName);
        switch (this.career) {
            case UDPM:
                System.out.println("> Career: Ung dung phan mem");
                break;
            case TKTW:
                System.out.println("> Career: Thiet ke trang wed");
                break;
            case LTDĐ:
                System.out.println("> Career: Lap trinh di đong");
                break;
            case TKĐH:
                System.out.println("> Career: Thiet ke do hoa");
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PolyStudent sv = new PolyStudent();
        System.out.print("Nhap ten: ");
        sv.fullName = sc.nextLine();
        System.out.print("Nganh hoc: ");
        sv.career = Career.valueOf(sc.nextLine().toUpperCase());
//        sv.career = Career.valueOf("UDPM");\
    
        sv.print();
    }
}
