/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM1;

/**
 *
 * @author Admin
 */
public class NhanVienHanhChinh extends NhanVien{
    public NhanVienHanhChinh(String ma, String ten, double luong){
        super(ma, ten, "Hanh Chinh", luong);
    }
    public NhanVienHanhChinh(){
        super("Hanh Chinh");
    }
    public void nhap(){
        super.nhap();
    }
    public void xuat(){
        super.xuat();
    }
}
