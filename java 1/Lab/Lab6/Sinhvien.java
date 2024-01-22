import java.util.Scanner;

public class Sinhvien {
    private String hoTen;
    private String Phone;
    private String CCCD;
    private String Email;

    public Sinhvien() {
    }

    public Sinhvien(String hoTen, String phone, String cCCD, String email) {
        this.hoTen = hoTen;
        Phone = phone;
        CCCD = cCCD;
        Email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String cCCD) {
        CCCD = cCCD;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("Ho ten: ");
            hoTen = sc.nextLine();
            if (hoTen == null || hoTen.equals("")) {
                System.out.println("khong hop le vui long nhap lai!");
            } else {
                break;
            }
        } while (true);
        SinhvienData dt = new SinhvienData();
        do {
            System.out.printf("So dien thoai: ");
            Phone = sc.nextLine();
            if (dt.isPhone(Phone)) {
                break;
            } else {
                System.out.println("khong hop le vui long nhap lai!");
            }
        } while (true);
        do {
            System.out.printf("CCCD: ");
            CCCD = sc.nextLine();
            if (dt.isCCCD(CCCD)) {
                break;
            } else {
                System.out.println("khong hop le vui long nhap lai!");
            }
        } while (true);
        do {
            System.out.printf("Email: ");
            Email = sc.nextLine();
            if (dt.isEmail(Email)) {
                break;
            } else {
                System.out.println("khong hop le vui long nhap lai!");
            }
        } while (true);
    }

    public void xuat(){
        System.out.printf("Ho ten: %-20s Phone: %-20s CCCD: %-20s Email: %-20s \n", hoTen, Phone, CCCD, Email);
    }
}
