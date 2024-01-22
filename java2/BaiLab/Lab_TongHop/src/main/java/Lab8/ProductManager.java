/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab8;

/**
 *
 * @author Tinh
 */
public class ProductManager {

    public static void main(String[] args) {
        Product p1 = new Product("IPhone X", 10000.0);
        Product p2 = new Product("IPhone 11", 30000.0);

        ProductDAO dao = new ProductDAO();
        dao.add(p1);
        dao.add(p2);

        dao.read("d:/pro.dat");

        ProductDAO dao2 = new ProductDAO();
        dao2.load("d:/pro.dat");
        Product p = dao2.find("IPhone X");
        System.out.println(">Name: " + p.name);
        System.out.println(">Gia: " + p.price);
    }
}
