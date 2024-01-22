/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import javax.swing.JFrame;

/**
 *
 * @author Tinh
 */
public class DemoForm extends JFrame {

    public static void main(String[] args) {
        DemoForm f = new DemoForm();
        
        f.setTitle("Quản lý sinh viên");
        f.setSize(600, 400);
        f.setLocationRelativeTo(null);
        /* Cho bảng hiện ra */
        f.setVisible(true);
    /*  */
        JFrame f1 = new JFrame();
        
        f1.setSize(800, 600);
        f1.setLocation(100, 100);
        f1.setVisible(true);
    }
}
