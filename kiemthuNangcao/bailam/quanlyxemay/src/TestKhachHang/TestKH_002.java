package TestKhachHang;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import DAO.KhachHangDAO;
import Model.KhachHang;

public class TestKH_002 {

	@Test
	public void TestNewKH() {
		KhachHang newKH = new KhachHang();
		newKH.setMaKhachHang("KH001");
		newKH.setHovaTen("Phạm Thế Tình");
		newKH.setNgaySinh(null);
		newKH.setGioiTinh(true);
		newKH.setSoDT("0339444203");
		
		KhachHangDAO dao = new KhachHangDAO();
		dao.Them(newKH);
		List<KhachHang> list = dao.SelectbyIDbyNamebySdt("KH001");
		assertTrue(list.size() >= 1);
	}
}
