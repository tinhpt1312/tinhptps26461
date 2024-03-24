/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import jdbcPack.Jbdc;

/**
 *
 * @author ADMIN
 */
public class ThongKeDAO {

    public List<Object[]> getThongKeloiNhuan(int Nam) {
        String[] cot = {
            "Thang", "Loinhuan", "Soluongdaban", "Xedaban", "PhuKienDaBan"
        };
        return Jbdc.getListObjects("{call ThongketheoThangtrongnam (?)}", cot, Nam);
    }
    public List<Object[]> getThongKeDoanhthuNV(int Nam,int thang) {
        String[] cot = {
            "Thang", "MaNhanVien", "TenNhanVien", "DoanhSo"
        };
        return Jbdc.getListObjects("{call ThongKeDoanhSoTheoThangVaNam (?,?)}", cot, Nam,thang);
    }
    public List<Object[]> getThongKeKhachmoi(int Nam) {
        String[] cot = {
            "Thang", "SoLuongKhachHangMoi"
        };
        return Jbdc.getListObjects("{call ThongKeVaLuuKhachHangMoi (?)}", cot, Nam);
    }
}
