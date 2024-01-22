/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4_tulam;

/**
 *
 * @author Admin
 */
public class Main_tulam {

    public static void main(String[] args) {
        sanPham sp1 = new sanPham("Sp001", 100, 10);
        sanPham sp3 = new sanPham("Sp002", 1000);
        sanPham sp2 = new sanPham();
        sp1.nhap();
        System.out.println("");
        sp2.nhap();
        System.out.println("----------------------------------");
        sp1.xuat();
        System.out.println("");
        sp2.xuat();
        System.out.println("");
        sp3.xuat();
    }
}
