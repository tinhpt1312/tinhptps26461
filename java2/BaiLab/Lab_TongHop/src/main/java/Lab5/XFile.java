/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Tinh
 */
public class XFile {

    public static byte[] read(String path) {
        byte[] data;
        try {
            FileInputStream fis = new FileInputStream(path);
            int n = fis.available();
            data = new byte[n];
            fis.read(data);
            fis.close();
            
        } catch (IOException e) {
            System.out.println("loi file");
            return null;
        }
        return data;
    }

    public static void write(String path, byte[] data) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream fo = new ObjectOutputStream(fos);
            fos.write(data);
            fo.close();
            fos.close();
            
        } catch (IOException e) {
            System.out.println("Loi file");
        }
    }

    public static Object readObject(String path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Object object = ois.readObject();
            ois.close();
            return object;
        } catch (IOException | ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }

    public static void writeObject(String path, Object object) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            System.out.println("loi file");
        }
    }

    public static void main(String[] args) {
        byte[] data = XFile.read("d:/Staff/staff.dat");
        XFile.write("d:/Staff/staff.dat", data);
    }

}
