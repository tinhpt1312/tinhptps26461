/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.util.Scanner;


public class ChuNhat {
    protected double rong;
    protected double dai;

    public ChuNhat() {
    }

    public ChuNhat(double rong, double dai) {
        this.rong = rong;
        this.dai = dai;
    }

    
    public double getChuVi() {
        return (dai+rong)*2;
    }


    public double getDienTich() {
        return dai*rong;
    }
    
    
    public double getRong() {
        return rong;
    }

    public void setRong(double rong) {
        this.rong = rong;
    }

    public double getDai() {
        return dai;
    }

    public void setDai(double dai) {
        this.dai = dai;
    }
    
    public void xuat(){
        
        System.out.printf("Chu Vi HCN la: %f| Dien Tich HCN la: %f", getChuVi(), getDienTich());
        
    }
}
