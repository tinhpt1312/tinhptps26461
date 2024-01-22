/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author Tinh
 */
public class nhanVien implements Serializable {
    private String maNV, tenNV, tuoiNV, eMail, luongNV;

    public nhanVien() {
    }

    public nhanVien(String maNV, String tenNV, String tuoiNV, String eMail, String luongNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tuoiNV = tuoiNV;
        this.eMail = eMail;
        this.luongNV = luongNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getTuoiNV() {
        return tuoiNV;
    }

    public String geteMail() {
        return eMail;
    }

    public String getLuongNV() {
        return luongNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setTuoiNV(String tuoiNV) {
        this.tuoiNV = tuoiNV;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setLuongNV(String luongNV) {
        this.luongNV = luongNV;
    }
    
    
}
