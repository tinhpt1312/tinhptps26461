/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class PhuKien {
   private String MaPhuKien;
   private String TenPhuKien;
   private float GiaTien;
   private byte[] Hinh;
   private String MaNv;
   private int Soluong;

    public PhuKien() {
    }

    public PhuKien(String MaPhuKien, String TenPhuKien, float GiaTien, byte[] Hinh, String MaNv, int Soluong) {
        this.MaPhuKien = MaPhuKien;
        this.TenPhuKien = TenPhuKien;
        this.GiaTien = GiaTien;
        this.Hinh = Hinh;
        this.MaNv = MaNv;
        this.Soluong = Soluong;
    }


    public String getMaPhuKien() {
        return MaPhuKien;
    }

    public void setMaPhuKien(String MaPhuKien) {
        this.MaPhuKien = MaPhuKien;
    }

    public String getTenPhuKien() {
        return TenPhuKien;
    }

    public void setTenPhuKien(String TenPhuKien) {
        this.TenPhuKien = TenPhuKien;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }

  

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    @Override
    public String toString() {
        return "PhuKien{" + "MaPhuKien=" + MaPhuKien + ", TenPhuKien=" + TenPhuKien + ", GiaTien=" + GiaTien + ", Hinh=" + Hinh + ", MaNv=" + MaNv + '}';
    }
   
   
}
