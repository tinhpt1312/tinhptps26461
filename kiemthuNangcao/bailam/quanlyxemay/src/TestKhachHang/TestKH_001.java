package TestKhachHang;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import DAO.KhachHangDAO;
import Model.KhachHang;

public class TestKH_001 {
	KhachHangDAO dao = new KhachHangDAO();
	@Test
	public void TestShowKH() {
		List<KhachHang> list = dao.SelectAll();
		assertTrue(list != null);
	}
}
