/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tinh
 */
public class Product implements DAO {

    @Override
    public void insert() {
        System.out.println("Thuc hien thanh cong");
    }

    @Override
    public void update() {
        System.out.println("Thuc hien thanh cong");
    }

    @Override
    public void select() {
        System.out.println("Thuc hien thanh cong");
    }

    @Override
    public void Delete() {
        System.out.println("Thuc hien thanh cong");
    }

    private String name;
    private Double price;

    ArrayList<Product> list = new ArrayList<>();

    public Product() {

    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

//    Double ImportTax;
    public String getName() {
        return name;
    }

    public Double getprice() {
        return price;
    }

    public double getImportTax() {
        return price * 0.1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setprice(Double price) {
        this.price = price;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        Integer loaiSp;
        do {
            System.out.print(" Nhap ten san pham: ");
            this.name = sc.nextLine();
            System.out.print(" Nhap gia san pham: ");
            this.price = sc.nextDouble();
            sc.nextLine();
            System.out.printf("San pham cua ban co thue k (1. Khong thue/ 2. Co thue): ");
            loaiSp = sc.nextInt();
            if (loaiSp == 1) {
                //Product newSP = new NoTaxProduct(name, price, 0);
                list.add(new NoTaxProduct(name, price));
            } else if (loaiSp == 2) {
                list.add(new Product(name, price));
            }
            sc.nextLine();
            System.out.printf("Ban co muon nhap them khong (Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        } while (true);
    }

    public void xuat() {
        System.out.println("Danh sach san pham: ");
        System.out.printf("\t%-20s %-20s %-20s\n", "Ten San Pham", "Gia San Pham", "Thue VAT");
        for (Product sp : list) {
            System.out.printf("\t%-20s %-20.2f %-20.2f\n", sp.getName(), sp.getprice(), sp.getImportTax());
        }
        System.out.println("");
        System.out.println("Thuc hien cac buoc thao tac CSDL: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("+   1. Insert");
        System.out.println("+   2. Select");
        System.out.println("+   3. Update ");
        System.out.println("+   4. Delete");
        System.out.printf("Chuc nang ban muon chon la: ");
        int so = sc.nextInt();
        switch (so) {
            case 1 -> {
                System.out.println("------------------");
                insert();
            }
            case 2 -> {
                System.out.println("--------------------");
                select();
            }
            case 3 -> {
                System.out.println("----------------------");
                update();
            }
            case 4 -> {
                System.out.println("------------------------");
                Delete();
            }
            default ->
                System.out.println("Vui long nhap so 1 den 4");
        }
    }

    public static void main(String[] args) {
        Product sp1 = new Product();
        sp1.nhap();
        sp1.xuat();

    }
}
