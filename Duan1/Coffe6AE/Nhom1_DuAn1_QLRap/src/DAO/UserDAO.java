
package DAO;

import Controller.XJdbc;
import Model.User;

import java.awt.Color;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ttc
 */
public class UserDAO extends Model.User{
    List<User> list = new ArrayList<>();
    
    public void insert(User model){
        String sql="INSERT INTO Acc_Login (ID_nv, pass, role_nv) VALUES (?, ?, ?)";
        XJdbc.update(sql, 
                model.getId(), 
                model.getPass(), 
                model.getRole()
                );
    }
    public String selectRole(String manv){
        String sql = "Select chucvu_nv from NhanVien where ID_nv = ?";
        ResultSet rs = XJdbc.query(sql, manv);
        String chucvu = "";
        try {  
            while(rs.next()){
                chucvu = rs.getString("chucvu_nv");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chucvu;
    }

    
        public boolean validateForm(String userName , String passWord) {
        //Check mã nv
        if (userName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã nhân viên");
            return false;
        } else {
            //Check định dạng
            Pattern pMaNV = Pattern.compile("NV[0-9]{2}");
            Matcher mMaNV = pMaNV.matcher(userName);
            if (!mMaNV.matches()) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên nhập sai định dạng");
                return false;
            } else {
                //Check trùng
                for (User us : list) {
                    if (userName.equals(us.getId())) {
                        JOptionPane.showMessageDialog(null, "Đã tồn tại mã nhân viên này");
                        return false;
                    }
                }
            }
        }
        //Check pass
        if (passWord.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu");
            
            return false;
        } else {
            //Check định dạng
            Pattern pp = Pattern.compile("^[a-zA-Z0-9]+$", Pattern.CASE_INSENSITIVE);
            Matcher mp = pp.matcher(passWord);
            if (!mp.matches()) {
                JOptionPane.showMessageDialog(null, "Mật khẩu nhập sai định dạng");
                return false;
            } else {
            }
        }
        return true;
    }
}
