/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi10;

import java.io.Serializable;

/**
 *
 * @author Tinh
 */
public class Sach implements Serializable {
    private Double giaSach;
    private String tenSach;

    public Sach(Double giaSach, String tenSach) {
        this.giaSach = giaSach;
        this.tenSach = tenSach;
    }

    public Sach() {
    }

    public Double getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(Double giaSach) {
        this.giaSach = giaSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    
    
}
