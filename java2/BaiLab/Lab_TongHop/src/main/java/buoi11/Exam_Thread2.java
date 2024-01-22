/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi11;

/**
 *
 * @author Tinh
 */
public class Exam_Thread2 {

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 30; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 6; i++) {
                    System.out.println("<3");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        Thread td1 = new Thread(r1);
        Thread td2 = new Thread(r2);
        td1.start();
        td2.start();
    }
}
