/*
	Phạm Thế Tình - ps26461
    Truy vấn lab 6
    Ngày thực hiện 29/11/2022
*/

use ps26461_lab5;

-- 1. Truy vấn hiện các thông tin (Mã hóa đơn, ngày lập, tổng tiền, tên khách hàng)
select hd.MAHD, NGAYLAPHD, TONGTIEN, concat(HoVaTenLot,' ',Ten) as 'Tên Khách Hàng'
from hoadon hd, khachhang kh
where hd.MAKH = kh.MAKH;

-- 2. Truy vấn hiển thị các thông tin(mã hóa đơn, ngày lập, tổng tiên, nhân viên)
select hd.MAHD, NGAYLAPHD, TONGTIEN, concat(HoVaTenLot,' ',Ten) as 'Tên Nhân Viên'
from hoadon hd, nhanvien nv
where hd.MANV = nv.MANV;

-- 3. Truy vấn hiển thị các thông tin(mã hóa đơn, ngày lập, tổng tiền, tên nhân viên, tên khách hàng)
select hd.MAHD, NGAYLAPHD, TONGTIEN, concat(kh.HoVaTenLot,' ',kh.Ten) as 'Tên khách hàng' ,concat(nv.HoVaTenLot,' ',nv.Ten) as 'Tên Nhân Viên'
from hoadon hd, nhanvien nv, khachhang kh
where hd.MAKH = kh.MAKH and hd.MANV = nv.MANV;

-- 4. Đếm tổng số khách hàng theo quận
select  count(MAKH) as 'Tổng khách hàng theo quận'
from khachhang kh
where DIACHI like 'quận%';

-- 5. Hiển thị tất cả thông tin trong bảng khách hàng, mã hóa đơn, ngày lập, lưu ý: Lấy tất cả khách hàng (có hóa đơn và không có hóa đơn).
select kh.maKH, concat(HoVaTenLot,'',Ten) as 'Ten Khach hang' , kh.diachi , kh.email, kh.DienThoai, hd.maHD,hd.ngaylapHD
from khachhang kh , hoadon hd
where kh.maKH = hd.maKH;

-- 6. Hiển thị các thông tin (mã hóa đơn, ngày lập, tên khách hàng, số điện thoại), chỉ hiển thị các thông tin mà trạng thái là “chưa thanh toán”
select hd.MAHD, NGAYLAPHD, concat(HoVaTenLot,' ',Ten) as 'Tên Khách Hàng', DIENTHOAI, TRANGTHAI
from khachhang kh, hoadon hd
where hd.MAKH = kh.MAKH
and trangthai like 'chưa thanh toán';

-- 7. Hiển thị các thông tin (Mã hóa đơn, ngày lập, số lượng mua, tổng tiền, tên sản phẩm) của các hóa đơn trong tháng 7
select hoadon.MaHD,NgayLapHD,SoLuongMua,TongTien,TenSP
from hoadon hd, hoadonchitiet ct, sanpham sp
where hd.MaHD = ct.MaHD
and NgayLapHD like '07%';

-- 8. Hiển thị các thông tin (mã hóa đơn, ngày lập, tổng tiền, tên khách hàng), điều kiện là chỉ hiển thị thông tin của khách hàng ở quận 1
select hd.MAHD, NGAYLAPHD, TONGTIEN, concat(HoVaTenLot,' ',Ten) as 'Tên Khách Hàng', DIACHI
from hoadon hd, khachhang kh
where hd.MAKH = kh.MAKH and DIACHI like '%1%';

-- 9. Hiển thị thông tin (mã hóa đơn, ngày lập hóa đơn, tổng tiền hóa đơn, số lượng mua, mã sản phẩm, tên sản phẩm) với điều kiện chỉ hiển thị các sản phẩm có giá >10 triệu
select hd.maHD, hd.ngaylapHD, hd.TongTien, sp.soluong, sp.maSP, sp.tenSP
from hoadon hd , sanpham sp, hoadonchitiet
where hd.maHD = hoadonchitiet.maHD and tongtien>10000000;

-- 10. Hiển thị thông tin (mã hóa đơn, ngày lập hóa đơn, tổng tiền hóa đơn, số lượng mua, mã sản phẩm, tên sản phẩm, giá sản phẩm, tên khách hàng), điều kiện khách hàng tên Khoa
select hd.MAHD, hd.NGAYLAPHD , concat(HoVaTenLot,' ',Ten) as 'Tên Khách Hàng', sp.MASP, sp.TENSP, sp.GIASP, ct.SoLuongMua, hd.TONGTIEN
from hoadon hd, hoadonchitiet ct, khachhang kh, sanpham sp
where hd.MAKH = kh.MAKH and hd.MAHD = ct.MAHD and Ten like 'Khoa';

-- 11. Hiển thị maHoaDon, ngàyMuahang, tổng số tiền đã mua trong từng hoá đơn. Chỉ hiển thị những hóa đơn có tổng số tiền >=500.000 và sắp xếp theo thứ tự giảm dần của cột tổng tiền.
select maHD , ngaylapHD as 'ngayMuahang' , TongTien
from hoadon
where TongTien >= 500000
order by TongTien desc;

-- 12. Hiển thị danh sách các khách hàng chưa mua hàng lần nào
select MAKH, concat(HoVaTenLot,' ',Ten) as 'Tên Khách Hàng'
from khachhang
where MAKH not in(
	select MAKH from hoadon
);

-- 13. Hiển thị danh sách các khách hàng chưa mua hàng lần nào kể từ tháng 1/1/2016
select kh.MAKH , kh.TEN , hd.ngaylapHD
from hoadon hd , khachhang kh
where kh.MAKH = hd.MAKH and ngaylapHD > '2016/1/1';

-- 14. Hiển thị mã sản phẩm, tên sản phẩm bán chạy nhất
select sanpham.MASP, TENSP, hoadonchitiet.SoLuongMua
from sanpham join hoadonchitiet on sanpham.MASP = hoadonchitiet.MASP
group by MASP 
having sum(SoLuongMua) >= all(
	select sum(SoLuongMua)
    from hoadonchitiet
    group by MASP
);

-- 15. Hiển thị 5 khách hàng có tổng số tiền mua hàng nhiều nhất trong năm 2016
select kh.MAKH,kh.Ten,hd.TongTien, hd.ngaylapHD
from khachhang kh , hoadon hd 
where kh.maKH = hd.maKH and year(ngaylapHD)=2016
order by TongTien desc limit 5;

-- 16. Hiển thị tên sản phẩm có lượt đặt mua nhỏ hơn lượt mua trung bình các các sản phẩm
select avg(SoLuongMua)
from hoadonchitiet;
