import java.util.Scanner;





public class LapTop {
    String maSP;
    String tenSP;
    Double canNang;
    public LapTop() {
    }
    public LapTop(String maSP, String tenSP, Double canNang) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.canNang = canNang;
    }
    public String getMaSP() {
        return maSP;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    public String getTenSP() {
        return tenSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public Double getCanNang() {
        return canNang;
    }
    public void setCanNang(Double canNang) {
        this.canNang = canNang;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ma san pham: ");
        maSP = sc.nextLine();
        System.out.printf("Ten san pham: ");
        tenSP = sc.nextLine();
        System.out.printf("Can nang: ");
        canNang = sc.nextDouble();
        System.out.println("");
    }

    public void xuat(){
        System.out.println("Ma san pham: " +maSP);
        System.out.println("Ten san pham: " +tenSP);
        System.out.println("Can nang: " +canNang);
        System.out.println("");
    }
}
