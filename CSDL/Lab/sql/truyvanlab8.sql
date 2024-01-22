/*
	Truy vấn Lab 8 
    ps26461 - Phạm Thế Tình
    Ngày lập 6/12/2022
*/

	use ps26461_lab5;
    
    -- 1. Tạo chỉ mục UNIQUE trên cột điện thoại của bảng khách hàng
    create 	unique index uni_dienthoai_khachhang
		on khachhang(dienthoai);
    
    -- 2. Tạo chỉ mục UNIQUE trên cột email của bảng khách hàng
    create unique index uni_email_khachhang
		on khachhang(email);
        
	-- Tạo user mới và cấp quyền
    
    CREATE USER 'user'@'localhost‘ IDENTIFIED BY ‘123';
    grant ALL PRIVILEGES ON ps26461_lab5 to 'user'@'localhost';
    
    -- 1.Hiển thị danh sách các sản phẩm ‘Hàng xách tay’, có giá nhỏ hơn 5 mươi triệu. Thông tin gồm: Mã sp, tên sp, giá
    
    select masp, tensp, giasp
    from sanpham
    where Mota like 'Hàng xách tay' and giasp < 50000000;
    
    -- 2.Cho biết số lượng hóa đơn chưa thanh toán của từng khách hàng. Thông tin gồm: Mã kh, tên kh, số lượng HD chưa TT
    select hoadon.makh, khachhang.ten, count(hoadon.mahd) as 'Số hóa đơn chưa thanh toán'
    from hoadon join khachhang on hoadon.makh = khachhang.makh
    where trangthai like 'chưa thanh toán'
    group by MaKH;
     
     -- 3. Thêm 1 hóa đơn mới (thông tin tự cho).
     insert into hoadon 
     values ('HD1312', '2019-12-13', '3000000', 'Đã thanh toán', 'NV001', 'KH1312');
     
     -- 4. Cập nhật trạng thái ‘Đã thanh toán’ và ngày lập HD là ngày hiện tại cho hóa đơn ‘HD002’
     update hoadon
     set trangthai = 'Đã thanh toán' ,ngaylaphd = '2022-12-07'
     where mahd = 'HD002';
     
     -- 5. Cho biết thông tin các nhân viên đã bán hàng cho khách hàng ‘KH001’. Thông tin hiển thị: MaNV, Họ tên NV, Số ĐT
     select nhanvien.manv , nhanvien.hovatenlot, nhanvien.ten, nhanvien.dienthoai
     from nhanvien, khachhang
     where makh = 'kh001'
     group by manv;
     
     -- 6. Danh sách các sản phẩm có trong nhiều hơn 2 hóa đơn.
	select ct.MaSP , count(maHD) as ' Số lượng hóa đơn'
	from hoadonchitiet ct join sanpham sp on ct.MaSP = sp.MaSP
	group by ct.maSP
	having count(maHD)>=2;
     