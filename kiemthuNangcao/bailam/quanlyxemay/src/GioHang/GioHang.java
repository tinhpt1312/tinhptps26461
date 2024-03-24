/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GioHang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author ADMIN
 */
public class GioHang {
    private String MaKhachHang;
    private ArrayList<SanPham>ListSanPham=new ArrayList<>();

    public GioHang() {
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public ArrayList<SanPham> getListSanPham() {
        return ListSanPham;
    }

    public void setListSanPham(ArrayList<SanPham> ListSanPham) {
        this.ListSanPham = ListSanPham;
    }
    public boolean themSanPham(SanPham x){
        return ListSanPham.add(x);   
    }
    public boolean themSanPham(String masanpham,int soluong,String tensanpham,float giatien){
        SanPham sp=new SanPham(masanpham, tensanpham, soluong,giatien);
        return ListSanPham.add(sp);   
    }
    public boolean xoaSanPham(SanPham x){
        return ListSanPham.remove(x);
    }
    public boolean xoaSanPham(String masanpham){
        for (SanPham sp : ListSanPham) {
            if(sp.getMaSanPham().equals(masanpham)){
                return ListSanPham.remove(sp);           
            }
        }
        return false;
    }
    public float tongtien(){
        float tongtien=0;
        for (SanPham sp : ListSanPham) {
            tongtien+=sp.getGiatien()*sp.getSoluong();
        }
        return tongtien;
    }

    
}
