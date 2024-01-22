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
public class Exam_Thread extends Thread {

    @Override
    public void run() {
        /* code sẽ chạy trong thread */
        for (int i = 1; i <= 10; i++) {
            System.out.println(+i);
            try {
                /* chờ 200ms second */
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
    public static void main(String[] args) {
        Exam_Thread td1 = new Exam_Thread(); // tạo 1 luồng
        /* thực hiện code Run trong Thread */
        td1.start();
    }

}
