/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sof2041slide3;

import java.util.List;
import com.edusys.dao.ThongKeDAO;

/**
 *
 * @author teo
 */
public class Procedure {
    public static void main(String[] args) {
        ThongKeDAO tk = new ThongKeDAO();
        List<Object[]> nguoiHoc = tk.getDiemChuyenDe();
        for(Object[] t : nguoiHoc){
            System.out.println(t[0]+", "+t[1]+", "+t[2]+", "+t[3]);
        }
    }
}
