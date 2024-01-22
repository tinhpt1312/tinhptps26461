/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Nguyen Dinh Dung
 */
public class KhachHang {
    String ID ;
    String Hoten;
    String Diachi;
    String Sdt;
    String Email;
    String Gioitinh;
    String Ngaydangky;

    public KhachHang() {
    }

    public KhachHang(String ID, String Hoten, String Diachi, String Sdt, String Email, String Gioitinh, String Ngaydangky) {
        this.ID = ID;
        this.Hoten = Hoten;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
        this.Email = Email;
        this.Gioitinh = Gioitinh;
        this.Ngaydangky = Ngaydangky;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getNgaydangky() {
        return Ngaydangky;
    }

    public void setNgaydangky(String Ngaydangky) {
        this.Ngaydangky = Ngaydangky;
    }

    
    
    
}

