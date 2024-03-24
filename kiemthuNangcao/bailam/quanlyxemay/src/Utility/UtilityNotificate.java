/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class UtilityNotificate {
    public static int confirmDialog(String message){
    int result = JOptionPane.showOptionDialog(
                null,
                message,
                "Xác nhận",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Xác nhận", "Hủy bỏ"},
                "Xác nhận");

        if (result == JOptionPane.OK_OPTION) {
            return 1;
        } else {
            return 0;
        }
    
    }

}
