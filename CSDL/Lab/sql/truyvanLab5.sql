	/*
		ps26461 - Phạm Thế Tình
        Lab 5 - Ngày thực hiện 23/11/2022
    */
    
    use ps26461_lab5;

-- Hiển thị tất cả thông tin trong bảng khách hàng
select*
from khachhang;

-- Hiển thị 3 khách hàng đầu tiên trong bảng khách hàng bao gồm: mã khách hàng, họ tên, email và số điện thoại
select MaKH, HoVaTenLot, Ten, Email, DienThoai
from khachhang limit 3;

-- Hiển thị khách hàng có tên bắt đầu bằng chữ 'H' trong đó cột 'HovaTen' ghét từ 2 cột 'HoVaTenLot' và 'Ten'
select concat_ws(' ', HoVaTenLot, Ten) as HoVaTen
from khachhang
where Ten like 'H___%';

-- Hiển thị thông tin các cột của bảng khách hàng có địa chỉ ở quận 1 hoặc quận 3
select *
from khachhang
where DiaChi = 'Quận 3' or DiaChi = 'Quận 1';

-- Hiển thị thông tin các sản phẩm có số lượng trong khoảng từ 20 đến 30
select *
from sanpham
where SoLuong between 20 and 30;

-- Hiển thị tất cả các hóa đơn của nhân viên có mã là ‘NV002’
select *
from hoadon
where MaNV = 'NV002';

-- Hiển thị mã hóa đơn, mã khách hàng, tổng tiền của các hóa đơn có tổng tiền > 20000000
select MaHD, MaKH, TongTien
from hoadon
where TongTien > 20000000;

-- Hiển thị giá cao nhất và trung bình giá của sản phẩm
select max(GiaSP),avg(GiaSP)
from sanpham;

-- Hiển thị giá trung bình của sản phẩm
select avg(GiaSP)
from sanpham;

-- Cho biết có bao nhiêu sản phẩm trong bảng sản phẩm
select count(*) as 'Số lượng sản phẩm'
from sanpham;

-- Hiển thị tất cả thông tin hóa đơn và sắp xếp theo thứ tự Tổng tiền tăng dần
select *
from hoadon
order by TongTien asc;

-- Hiển thị tất cả thông tin các sản phẩm theo thứ tự giá giảm dần
select *
from sanpham
order by GiaSP desc;

-- Hiển thị tổng tiền của các hóa đơn và nhóm theo mã nhân viên
select TongTien, MaNV
from hoadon
order by manv;

-- Hiển thị tổng tiển của các hóa đơn và nhóm theo mã khách hàng, chỉ hiển thị các khách hàng có tổng tiền >8000000
select tongtien, makh
from hoadon
where TongTien >= 8000000
order by makh;