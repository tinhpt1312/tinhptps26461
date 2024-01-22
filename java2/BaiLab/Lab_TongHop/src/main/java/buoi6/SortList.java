/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi6;

import Lab2.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Tinh
 */
public class SortList {
        public static void main(String[] args) {
        ArrayList<User> lUser = new ArrayList<>();
        // Thêm vào cuối
        lUser.add(new User("tuan", "111", "user"));
        lUser.add(new User("lan", "222", "admin"));
        lUser.add(new User("anh", "111", "user"));
        lUser.add(new User("yen", "222", "user"));
        /* Chưa sắp */
            for (User u : lUser) {
               
            }
             /* Tạo đối tượng comparator */
                Comparator<User> sxTen = new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                            return o1.getUserName().compareTo(o2.getUserName());
                    };
                };
                /* Sắp xếp */
                Collections.sort(lUser, Collections.reverseOrder(sxTen));
                System.out.println("Danh sach sau khi sap xep nguoc:  ");
                 for (User u : lUser) {
                            System.out.println(u.getUserName() + " " + u.getPassWord());
                }
    }
}
