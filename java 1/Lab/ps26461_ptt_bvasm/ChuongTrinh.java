import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChuongTrinh {
    static ArrayList<LapTop> list = new ArrayList<>();

    public static void nhap() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            LapTop lp = new LapTop();
            lp.nhap();
            list.add(lp);
            System.out.printf("Ban co muon nhap them nua khong (Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                System.out.println("Nhap du lieu thanh cong!");
                break;
            }
        }
    }

    public static void xuat() {
        System.out.println("-----------------------");
        System.out.println("Danh sach LapTop: ");
        System.out.println("");
        for (LapTop lp : list) {
            lp.xuat();
        }
    }

    public static void tim() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.printf("Nhap ma san pham ma ban muon tim: ");
        String tim = sc.nextLine();
        boolean check = false;
        for (LapTop lt : list) {
            if (tim.equalsIgnoreCase(lt.getMaSP())) {
                System.out.println("");
                lt.xuat();
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Khong co san pham ban tim!");
        }
    }

    public static void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.printf("Nhap ma san pham ma ban muon xoa: ");
        String xoa = sc.nextLine();
        boolean check = false;
        for (LapTop lt : list) {
            if (xoa.equalsIgnoreCase(lt.getMaSP())) {
                System.out.println("");
                list.remove(lt);
                System.out.println("Xoa thanh cong!");
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Khong co san pham ban muon xoa!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Nhap LapTop");
            System.out.println("2. Xuat LapTop");
            System.out.println("3. Tim san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("0. Thoat chuong trinh");
            System.out.printf("Chon so: ");
            int so = sc.nextInt();
            switch (so) {
                case 1:
                    nhap();
                    break;
                case 2:
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
        } while (true);
    }
}
