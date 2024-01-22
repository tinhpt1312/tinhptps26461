/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi1;

import java.util.Scanner;

/**
 *
 * @author Tinh
 */
public class book {

    /* Fields */
    private String tenSach;
    Double giaSach;
    /* Constructor : hàm tạo */
        /* tham số*/
    public book() {

    }

    public book(String tenSach, double giaSach) {
        this.tenSach = tenSach;
        this.giaSach = giaSach;
    }
    

    /* Phương thức : methods */
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        //String tenSach;
        //Double giaSach;
        /*System.out.print("Nhập vào tên sách: ");
        tenSach = sc.nextLine();
        System.out.print("Nhập vào giá sách: ");
        giaSach = sc.nextDouble();*/
        System.out.print(" Tên sách: ");
        this.tenSach = sc.nextLine();
        System.out.print(" Giá sách: ");
        this.giaSach = sc.nextDouble();
    }

    public void xuat() {
        System.out.println(this.tenSach + " - " + this.giaSach);
    }
    
    public static void main(String[] args) {
        book b1 = new book();
        b1.nhap();
        b1.xuat();
        book b2 = new book("Bài tập java", 100.00);
        b2.xuat();
    }
    
        /* Getter & Setters */

    public String getTenSach() {
        return tenSach;
    }

    public Double getGiaSach() {
        return giaSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setGiaSach(Double giaSach) {
        this.giaSach = giaSach;
    }
    
    
}
