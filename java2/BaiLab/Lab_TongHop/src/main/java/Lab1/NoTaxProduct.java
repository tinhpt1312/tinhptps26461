/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

/**
 *
 * @author Tinh
 */
public class NoTaxProduct extends Product {
//    private Integer thue = 0;
//    public NoTaxProduct(String name, Double price, Integer thue) {
//        super(name, price);
//        this.thue = thue;
//    }
    public NoTaxProduct(String name, Double price) {
        super(name, price);
    }

    public NoTaxProduct() {
    }
    
    @Override
    public double getImportTax() {
        return 0;
    }
}
