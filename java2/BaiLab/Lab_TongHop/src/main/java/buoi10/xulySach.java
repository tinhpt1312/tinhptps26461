/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Tinh
 */
public class xulySach {

    public static void main(String[] args) {
        Sach s = new Sach(50.0, "Bai tap C");
        /* */
 /* Ghi đối tượng vào đĩa */
//            try {
//                FileOutputStream f = new FileOutputStream("D:/sach.dat");
//                ObjectOutputStream fo = new ObjectOutputStream(f);
//                /* Ghi đối tượng s vào đĩa */
//                fo.writeObject(s);
//                /* Đóng file */
//                f.close(); fo.close();
//            } catch (IOException e) {
//                System.out.println("Loi file");
//        }
        /* Đọc file object */
        try {
            FileInputStream f = new FileInputStream("D:/sach.dat");
            ObjectInputStream fo = new ObjectInputStream(f);
            /* Ghi đối tượng s vào đĩa */
            s = (Sach) fo.readObject();
            /* Đóng file */
            f.close();
            fo.close();
            /* Xuất sách ra */
            System.out.println(s.getTenSach() + " : " + s.getGiaSach());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loi file");
        }
    }
}
