/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi13;

/**
 *
 * @author Tinh
 */

enum Tuan {HAI, BA, TU, NAM, SAU, BAY, CHUANHAT};
public class Test_Enum {
    public static void main(String[] args) {
        Tuan thu; // Biến kiểu enum
        thu = Tuan.SAU; // Gán trị cho biến enum
        
        // Lấy giá trị của "BA" : valueOf
        System.out.println(Tuan.valueOf("BA"));
        
        // Lấy mảng tất cả giá trị của enum
        Tuan[] ts = Tuan.values();
        
        // Xuất mảng giá trị
        for(Tuan t: ts){
            System.out.println(t.ordinal()); //ordinal() lấy thứ tự
        }
    }
}
