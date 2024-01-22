/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab3_TongHop {

    public static void Bai1(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("So ban muon kiem tra la: ");
        int a = sc.nextInt();
        boolean c = true;
        for (int i = 2; i < a - 1; i++) {
            if (a % i == 0) {
                c = false;
                break;
            }
        }
        if (c == true) {
            System.out.println(a + " la so nguyen to");
        } else {
            System.out.println(a + " khong phai so nguyen to");
        }
    }

    public static void Bai2(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Cuu chuong %d", i);
            System.out.println("");
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d x %d = %d", i, j, i * j);
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public static void Bai3(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("So phan tu ban muon co trong mang la: ");
        int a = sc.nextInt();
        int[] arr = new int[a];
        System.out.println("Nhap cac phan tu trong mang: ");
        for (int i = 0; i < a; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[0];
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("Mang sau khi duoc sap xep tang dan la");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
        int Min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            Min = Math.min(arr[i], Min);
        }
        System.out.println("");
        System.out.printf("Phan tu nho nhat trong mang la: %d", Min);
        System.out.println("");
        int tong = 0;
        int step = 0;
        float tbCong = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0) {
                tong = tong + arr[i];
                step++;
            }
        }
        tbCong = tong / step;
        System.out.println("");
        System.out.printf("Trung binh cong cac phan tu chia het cho 3 la: %.1f", tbCong);
    }

    public static void Bai4(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("So sinh vien ban muon luu la: ");
        int a = sc.nextInt();
        String[] sv = new String[a];
        float[] diem = new float[a];
        System.out.println("Nhap ten sv va diem sv trong mang");
        for (int i = 0; i < a; i++) {
            Scanner s = new Scanner(System.in);
            System.out.printf("Nhap ten cho sv thu [%d]: ", i + 1);
            sv[i] = s.nextLine();
            System.out.printf("Nhap diem cho sv thu [%d]: ", i + 1);
            diem[i] = s.nextFloat();
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                float temp = diem[0];
                if (diem[i] < diem[j]) {
                    temp = diem[j];
                    diem[j] = diem[i];
                    diem[i] = temp;
                    String svtemp = sv[i];
                    sv[i] = sv[j];
                    sv[j] = svtemp;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            System.out.println("");
            System.out.println("Ho ten: " + sv[i]);
            System.out.println("Diem = " + diem[i]);
            if (diem[i] >= 9) {
                System.out.println("Hoc luc xuat sac");
            } else if (diem[i] >= 7.5) {
                System.out.println("Hoc luc gioi");
            } else if (diem[i] >= 6.5) {
                System.out.println("Hoc luc kha");
            } else if (diem[i] >= 5) {
                System.out.println("Hoc luc TB");
            } else {
                System.out.println("Hoc luc yeu");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int so;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("+-------------------------------+");
            System.out.println("+ 1: Kiem tra so nguyen to      +");
            System.out.println("+ 2: In bang cuu chuong         +");
            System.out.println("+ 3: Mang so nguyen             +");
            System.out.println("+ 4: Nhap xuat sinh vien        +");
            System.out.println("+ 5: Ket thuc                   +");
            System.out.println("+-------------------------------+");
            System.out.print("Chuong trinh ban muon chon la: ");
            so = sc.nextInt();
            switch (so) {
                case 1:
                    Bai1(args);
                    break;
                case 2:
                    Bai2(args);
                    break;
                case 3:
                    Bai3(args);
                    break;
                case 4:
                    Bai4(args);
                    break;
                case 5:
                    System.out.println("Cam on ban da su dung chuong trinh");
                    System.exit(0);
                default:
                    System.out.println("Khong hop le vui long chon lai");
            }
        } while (true);
    }
}
