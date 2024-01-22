/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TextField Example");
        JTextField textField = new JTextField(20);
        

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Thực hiện hành động khi có thay đổi (thêm văn bản)
                System.out.println("Văn bản đã thay đổi: " + textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Thực hiện hành động khi có thay đổi (xóa văn bản)
                System.out.println("Văn bản đã thay đổi: " + textField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Đã thay đổi thuộc tính của văn bản (ít được sử dụng cho JTextField)
            }
        });

        frame.add(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

