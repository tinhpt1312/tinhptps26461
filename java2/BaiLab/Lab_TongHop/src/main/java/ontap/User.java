/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontap;

import java.io.Serializable;

/**
 *
 * @author Tinh
 */
public class User implements Serializable {
    String UserID;
    String passWord;
    String role;

    public User() {
    }

    public User(String UserID, String passWord, String role) {
        this.UserID = UserID;
        this.passWord = passWord;
        this.role = role;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
