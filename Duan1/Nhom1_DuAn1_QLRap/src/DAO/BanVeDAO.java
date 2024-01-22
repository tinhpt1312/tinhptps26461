package DAO;

import Controller.DBConnection;
import static Controller.DBConnection.getConnection;
import Model.Phim;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BanVeDAO {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public List<Phim> getPhimList() {
        List<Phim> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from phim");
            while(rs.next()){
                Phim p=new Phim();
                p.setID(rs.getString(1));
                p.setTenPhim(rs.getString(2));
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BanVeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
}
