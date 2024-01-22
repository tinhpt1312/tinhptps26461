/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab6;

/**
 *
 * @author Tinh
 */
public class evenThread extends Thread {
    @Override
    public void run() {
        /* code sẽ chạy trong thread */
        for (int i = 1; i <= 10; i++) {
            if(i % 2 == 0){
                System.out.println(+i);
            }
            try {
                /* chờ 500ms second */
                Thread.sleep(15);
            } catch (InterruptedException ex) {
            }
        }
    }
}
