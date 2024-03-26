package TestKhachHang;

import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.Test;

import DAO.KhachHangDAO;
import Model.KhachHang;

public class TestKH_003 {

	@Test
	public void TestUpdateKH() {
		KhachHangDAO dao = new KhachHangDAO();
		String IDKHtoUpdate = "KH001";
		List<KhachHang> toUpdate = dao.SelectbyIDbyNamebySdt(IDKHtoUpdate);
		
		for(KhachHang khachhang: toUpdate) {
			khachhang.setMaKhachHang("KH001");
			khachhang.setHovaTen("Phạm Huy Hoàng");
			khachhang.setNgaySinh(null);
			khachhang.setGioiTinh(true);
			khachhang.setSoDT("0389772833");
			dao.Sua(khachhang);
		}
		String hotenKHTest = "Phạm Huy Hoàng";
		List<KhachHang> listFindKH = dao.SelectbyIDbyNamebySdt(hotenKHTest);
		assertNotNull(listFindKH);
	}
}
