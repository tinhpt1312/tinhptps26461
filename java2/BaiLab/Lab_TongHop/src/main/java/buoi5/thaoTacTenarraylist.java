/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi5;

import Lab2.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tinh
 */
public class thaoTacTenarraylist {

    public static void main(String[] args) {
        ArrayList<User> lUser = new ArrayList<>();
        // Thêm vào cuối
        lUser.add(new User("tuan", "111", "user"));
        lUser.add(new User("lan", "222", "admin"));
        // chèn Bình trước lan
        lUser.add(1, new User("binh", "333", "user"));

                // Sửa 'Lan' thành 'Quang'
                // Cách 1
                User l = new User("quang", "333", "admin");
                lUser.set(1, l);

                // Cách 2
                User l1 = lUser.get(0);
                l1.setUserName("tinh");
        // Tìm kiếm và xóa
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap user name : ");
        String uname = sc.nextLine();
        int vitri = -1;
        for(User u : lUser){
            if(u.getUserName().equals(uname)){
                /* Ghi nhớ phần tử tìm được */
                vitri = lUser.indexOf(u);
                break;
            }
        }
        if (vitri < 0) System.out.println("Không tìm thấy ");
        else //System.out.println(lUser.get(vitri).getUserName() + " " + lUser.get(vitri).getPassWord());
                lUser.remove(vitri);
        // Xóa phần tử : Xóa quang o vi tri 1
        lUser.remove(1);
        // Duyệt qua list
        // Duyệt theo vị trí
        /* for(int i = 0; i<lUser.size(); i++){
            System.out.println(lUser.get(i).getUserName() + "" +  lUser.get(i).getPassWord());
        }*/
        // Duyệt theo đối tượng
        for (User u : lUser) {
            System.out.println(u.getUserName() + " " + u.getPassWord());
        }
    }
}
