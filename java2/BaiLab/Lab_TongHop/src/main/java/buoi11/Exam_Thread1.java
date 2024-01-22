/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi11;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tinh
 */
public class Exam_Thread1 implements Runnable {

    @Override
    public void run() {
        for(int i = 1; i<=20 ; i++){
            System.out.println(+i + ".A");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {}
        }
    }
    public static void main(String[] args) {
        Exam_Thread1 td2 = new Exam_Thread1();
        Thread td = new Thread(td2); // Truyền runnable vào Thread
        td.start();
    }
}
