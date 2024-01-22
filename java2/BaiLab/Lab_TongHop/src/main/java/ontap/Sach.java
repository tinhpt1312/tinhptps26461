/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontap;

import java.io.Serializable;

/**
 *
 * @author Tinh
 */
public class Sach implements Serializable {
    String masach;
    String tensach;
    String theloai;

    public Sach() {
    }

    public Sach(String masach, String tensach, String theloai) {
        this.masach = masach;
        this.tensach = tensach;
        this.theloai = theloai;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }
    
    
}
