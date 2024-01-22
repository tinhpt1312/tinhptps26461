/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab7;

/**
 *
 * @author Tinh
 */
public class XPoly {
    @Deprecated
    public static boolean isCardNumber(String number){
        Integer n = Integer.parseInt(number);
        
        int tong = 0;
        while(n>0){
            int a = n%10;
            n = n/10;
            tong+=a;
        }
        
        return tong % 2 == 0;
    }
}
