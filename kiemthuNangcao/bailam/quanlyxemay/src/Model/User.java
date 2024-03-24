/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class User {
    
    private static NhanVien user;

    public User() {
    }

    public User(NhanVien x) {
        this.user = x;
    }

    public static NhanVien getUser() {
        return user;
    }
    public static boolean isLogin(){
        if(user == null){
            return false;
        }else{
            return true;           
        }
    }
    public static void Logout(){
        user=null;
    }
    public void setUser(NhanVien x) {
        this.user = x;
    }
    public static boolean isTruongPhong(){          
        return user.getVaiTro();
    }
}
