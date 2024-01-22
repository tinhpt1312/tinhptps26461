import java.util.ArrayList;
import java.util.Scanner;

public class quanlyOto {
    static ArrayList<Oto> list = new ArrayList<>();

    public static void nhap() {
        while (true) {
            Oto xehoi = new Oto();
            xehoi.nhap();
            list.add(xehoi);
            Scanner sc = new Scanner(System.in);
            System.out.printf("Ban co muon nhap them nua khong (Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                System.out.println("Nhap du lieu thanh cong!");
                break;
            }
        }
    }

    public static void xuat() {
        System.out.println("");
        System.out.println("--------------------------");
        for (Oto xehoi : list) {
            xehoi.xuat();
        }
    }

    public static void tim() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.printf("Nhap ma Oto ma ban muon tim: ");
        String tim = sc.nextLine();
        boolean check = false;
        for (Oto lt : list) {
            if (tim.equalsIgnoreCase(lt.getMaXe())) {
                System.out.println("");
                lt.xuat();
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Khong co Oto ban tim!");
        }
    }

    public static void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.printf("Nhap ma Oto ma ban muon xoa: ");
        String xoa = sc.nextLine();
        boolean check = false;
        for (Oto lt : list) {
            if (xoa.equalsIgnoreCase(lt.getMaXe())) {
                System.out.println("");
                list.remove(lt);
                System.out.println("Xoa thanh cong!");
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Khong co Oto ban muon xoa!");
        }
    }

    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Nhap Oto");
            System.out.println("2. Xuat Oto");
            System.out.println("3. Tim san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("0. Thoat chuong trinh");
            System.out.printf("Chon so: ");
            try {
                int so = sc.nextInt();
                switch (so) {
                    case 1:
                        System.out.println("Quan ly xe co");
                        nhap();
                        break;
                    case 2:
                        System.out.println("Danh sach xe co: ");
                        xuat();
                        break;
                    case 3:
                        tim();
                        break;
                    case 4:
                        xoa();
                        break;
                    case 0:
                        System.out.println("Thank kiu!");
                        System.exit(1);
                    default:
                        System.out.println("Chon lai!");
                }
            } catch (Exception ex) {
                System.out.println("Nhap so!");
            }
        } while (true);
    }
}
