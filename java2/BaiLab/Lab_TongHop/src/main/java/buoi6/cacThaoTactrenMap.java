/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi6;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Tinh
 */
public class cacThaoTactrenMap {

    public static void main(String[] args) {
        /* Khai báo */
        HashMap<String, String> tudien = new HashMap<String, String>();

        /* Nhập dữ liệu : tudien.put(key, value) */
        tudien.put("Book", "Sách");
        tudien.put("Home", "Mái ấm");
        tudien.put("Pen", "Cái bút");
        tudien.put("Animal", "Động vật");
        tudien.put("Money", "Tiền");

        /* Số phần tử: size() */
        System.out.println("tu dien co: " + tudien.size());

        /* Lấy giá trị theo key : map.get(key) */
        System.out.println("Từ animal có nghĩa: " + tudien.get("Animal"));

        /* Lấy tập các key của hashMap */
        Set<String> danhsachTu = tudien.keySet();

        /* Duyệt qua HashMap dùng khóa */
        System.out.println("Danh sach cac tu: ");
        for (String tu : danhsachTu) {
            System.out.println(tu + " : " + tudien.get(tu));
        }

        /* Nhập từ tùy ý và tra nghĩa */
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap tu can tra : ");
        String tuTra = sc.nextLine();
        Boolean has = false;
        for (String tu : danhsachTu) {
            if (tu.equalsIgnoreCase(tuTra)) {
                System.out.println("Nghia cua tu " + tuTra + "la : " + tudien.get(tu));
                has = true;
                break;
            }
        }
        if (!has) {
            System.out.println("Tu nay k co trong tu dien");
        }
    }
}
