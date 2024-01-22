/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author Tinh
 */
public class DICHVU {
    String madv;
    String tendv;
    Double giadv;
    String thongtindv;

    public DICHVU() {
    }

    public DICHVU(String madv, String tendv, Double giadv, String thongtindv) {
        this.madv = madv;
        this.tendv = tendv;
        this.giadv = giadv;
        this.thongtindv = thongtindv;
    }

    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public Double getGiadv() {
        return giadv;
    }

    public void setGiadv(Double giadv) {
        this.giadv = giadv;
    }

    public String getThongtindv() {
        return thongtindv;
    }

    public void setThongtindv(String thongtindv) {
        this.thongtindv = thongtindv;
    }
    
}
