/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class HangXe {
   private String MaHangXe;
   private String TenHang;

    public HangXe() {
    }

    public HangXe(String MaHangXe, String TenHang) {
        this.MaHangXe = MaHangXe;
        this.TenHang = TenHang;
    }

    public String getMaHangXe() {
        return MaHangXe;
    }

    public void setMaHangXe(String MaHangXe) {
        this.MaHangXe = MaHangXe;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }


    @Override
    public String toString() {
        return "HangXe{" + "MaHangXe=" + MaHangXe + ", TenHang=" + TenHang ;
    }
    
}
