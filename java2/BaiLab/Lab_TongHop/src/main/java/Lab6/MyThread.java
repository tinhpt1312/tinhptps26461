/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6;



/**
 *
 * @author Tinh
 */
public class MyThread extends Thread {
     @Override
    public void run() {
        /* code sẽ chạy trong thread */
        for (int i = 1; i <= 10; i++) {
            System.out.println(+i);
            try {
                /* chờ 500ms second */
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
    public static void main(String[] args) {
        MyThread td1 = new MyThread();
        td1.start();
    }
}
