import java.util.Scanner;

public class Lab6bai2 {
    private String tenSP;
    private Double giaSP;
    private String hangSp;

    public Lab6bai2() {
    }
    
    public Lab6bai2(String tenSP, Double giaSP, String hangSp) {
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.hangSp = hangSp;
    }
    
    public String getTenSP() {
        return tenSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public Double getGiaSP() {
        return giaSP;
    }
    public void setGiaSP(Double giaSP) {
        this.giaSP = giaSP;
    }
    public String getHangSp() {
        return hangSp;
    }

    public void setHangSp(String hangSp) {
        this.hangSp = hangSp;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap xuat san pham cong nghe");
        System.out.printf("Ten san pham: ");
        tenSP = sc.nextLine();
        System.out.printf("Gia san pham: ");
        giaSP = sc.nextDouble();
        sc.nextLine();
        System.out.printf("Hang san xuat: ");
        hangSp = sc.nextLine();
    }

    public void xuat(){
        System.out.println("-----------------");
        System.out.println("Ten san pham: " +tenSP);
        System.out.println("Gia san pham: " +giaSP);
        System.out.println("Hang san xuat: " +hangSp);
    }
}
