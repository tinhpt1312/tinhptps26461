/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi2;

/**
 *
 * @author Tinh
 */
public class TestDemo implements DemoInterface {

    @Override
    public void f1() {
        System.out.println("Chuc nang 1: ");
    }

    @Override
    public void f2() {
        System.out.println("Chuc nang 2: ");
    }

    @Override
    public void f3() {
        System.out.println("Chuc nang 3: ");
    }
    
    public static void main(String[] args) {
        TestDemo b1 = new TestDemo();
        b1.f1();
    }
}
