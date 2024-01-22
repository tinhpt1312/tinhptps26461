/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM;

/**
 *
 * @author Tinh
 */
public class nhanVienData {
    public Boolean isName(String str){
        String pattern = "(^[a-zA-Z\\\\sàáạã_-]{3,25}$){2,3}";
        return str.matches(pattern);
    }
    public Boolean isEmail(String str){
        String pattern = "\\w+@\\w+(\\.\\w+){1,2}";
        return str.matches(pattern);
    }
    
}
