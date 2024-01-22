/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6;

/**
 *
 * @author Tinh
 */
public class Main {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread td1 = new Thread(mt);
        Thread td2 = new Thread(mt);
        td1.setPriority(Thread.MAX_PRIORITY);
        td2.setPriority(Thread.MIN_PRIORITY);
        td1.start();
        td2.start();
    }
}
