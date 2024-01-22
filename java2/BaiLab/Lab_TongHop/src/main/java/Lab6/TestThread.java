/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6;

import java.util.ArrayList;

/**
 *
 * @author Tinh
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        oldThread ot = new oldThread();
        evenThread ev = new evenThread();
        Thread td1 = new Thread(ot);
        Thread td2 = new Thread(ev);
        td1.start();
        td1.join();
        td2.start();
        
    }
}
