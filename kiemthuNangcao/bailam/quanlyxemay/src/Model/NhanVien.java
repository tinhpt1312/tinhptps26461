/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVien {

    private String MaNhanVien;
    private String MatKhau;
    private String HovaTen;
    private boolean VaiTro;
    private String Mail;
    private byte[] Hinh;
    private Date Ngaysinh;
    private Date Ngayketthuc;
    private Date Ngaybatdau;

    public NhanVien() {
    }

    public NhanVien(String MaNhanVien, String MatKhau, String HovaTen, boolean VaiTro, String Mail, byte[] Hinh, Date Ngaysinh, Date Ngayketthuc, Date Ngaybatdau) {
        this.MaNhanVien = MaNhanVien;
        this.MatKhau = MatKhau;
        this.HovaTen = HovaTen;
        this.VaiTro = VaiTro;
        this.Mail = Mail;
        this.Hinh = Hinh;
        this.Ngaysinh = Ngaysinh;
        this.Ngayketthuc = Ngayketthuc;
        this.Ngaybatdau = Ngaybatdau;
    }



    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHovaTen() {
        return HovaTen;
    }

    public void setHovaTen(String HovaTen) {
        this.HovaTen = HovaTen;
    }

    public Boolean getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }



    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public Date getNgayketthuc() {
        return Ngayketthuc;
    }

    public void setNgayketthuc(Date Ngayketthuc) {
        this.Ngayketthuc = Ngayketthuc;
    }

    public Date getNgaybatdau() {
        return Ngaybatdau;
    }

    public void setNgaybatdau(Date Ngaybatdau) {
        this.Ngaybatdau = Ngaybatdau;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "MaNhanVien=" + MaNhanVien + ", MatKhau=" + MatKhau + ", HovaTen=" + HovaTen + ", VaiTro=" + VaiTro + ", Mail=" + Mail + ", Hinh=" + Hinh + ", Ngaysinh=" + Ngaysinh + ", Ngayketthuc=" + Ngayketthuc + ", Ngaybatdau=" + Ngaybatdau + '}';
    }

    


}
