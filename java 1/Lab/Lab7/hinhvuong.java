/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

/**
 *
 * @author
 */
public class hinhvuong extends ChuNhat{
    public hinhvuong(double canh){
        super(canh, canh);
    }
public void xuat(){
    System.out.printf("Chu vi HV la %f | Dien tich HV la %f",getChuVi(),getDienTich());
}
    
}
