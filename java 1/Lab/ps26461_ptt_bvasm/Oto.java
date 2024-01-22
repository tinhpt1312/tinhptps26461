


import java.util.Scanner;


public class Oto {
    String loaiXe;
    String maXe;
    String mauXe;
    Double donGia;
    
    public Oto() {
    }
    public Oto(String maXe, String loaiXe , String mauXe, Double donGia) {
        this.loaiXe = loaiXe;
        this.maXe = maXe;
        this.mauXe = mauXe;
        this.donGia = donGia;
    }
    public String getLoaiXe() {
        return loaiXe;
    }
    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }
    public String getMaXe() {
        return maXe;
    }
    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }
    public String getMauXe() {
        return mauXe;
    }
    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }
    public Double getDonGia() {
        return donGia;
    }
    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.printf("Ma xe oto: ");
        maXe = sc.nextLine();
        System.out.printf("Loai xe oto : ");
        loaiXe = sc.nextLine();
        System.out.printf("Mau xe oto : ");
        mauXe = sc.nextLine();
        System.out.printf("Don gia oto : ");
        donGia = sc.nextDouble();
        sc.nextLine();
    }

    public void xuat(){
        System.out.println("Ma xe oto: " +maXe);
        System.out.println("Loai xe oto: " +loaiXe);
        System.out.println("Mau xe oto: " +mauXe);
        System.out.println("Don gia: " +donGia);
        System.out.println("");
    }
}
