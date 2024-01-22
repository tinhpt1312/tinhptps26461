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
import java.util.ArrayList;

/**
 *
 * @author Tinh
 */
public class docGhiArrayList {

    ArrayList<Sach> list = new ArrayList<Sach>();

    public void writeFile(String fname) {
        /* Ghi ArrayList list vào đĩa với tên fname */
        try {
            FileOutputStream f = new FileOutputStream(fname);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            fo.writeObject(list);
            f.close();
            fo.close();
        } catch (IOException e) {
            System.out.println("Loi file");
        }
    }
    
    public void readFile(String fname){
        // Đọc file tên fname từ đĩa vào ArrayList
        try {
            FileInputStream f = new FileInputStream(fname);
            ObjectInputStream fo = new ObjectInputStream(f);
            // Đọc đối tượng arraylist từ file
            list = (ArrayList<Sach>) fo.readObject();
            f.close();
            fo.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loi file");
        }
    }
    
    public void fillToScreen(){
        // Xuất list ra màn hình
        System.out.println("DANH MUC SACH");
        for(Sach s : list){
            System.out.println(s.getTenSach() + " : " + s.getGiaSach());
        }
    }
    
    public docGhiArrayList (){
        /* sinh dữ liệu */ 
        // list.add(new Sach(50.0, "Bai tap C"));
        // list.add(new Sach(150.0, "Bai tap Java"));
        // list.add(new Sach(200.0, "Tho tinh Xuan Dieu"));
        // list.add(new Sach(1000000.0, "Bi kip tan gai ho Pham"));
        
        /* Ghi list vào đĩa */
        // writeFile("D:/nhasach.dat");
        /* Đọc file */
        readFile("D:/nhasach.dat");
        fillToScreen();
    }
    
    public static void main(String[] args) {
        new docGhiArrayList();
    }
            
}
