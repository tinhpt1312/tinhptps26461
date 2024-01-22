
 -- BIẾN VÔ HƯỚNG

	declare @ten nvarchar(50)
	declare @k int, @r float = 3.45
	declare @ngay date
	-- Go dùng để giải phóng bộ nhớ
	-- Máy chỉ hiểu từ go này tới go kế tiếp sau go đều biến mất
	-- Gán giá trị cho biến
	set @ten = N'Tuấn';
	set @k = 5;

	-- Xuất
	-- print 'gia tri cua K = ' + cast(@k as varchar(30))
	select @k as N'Giá trị của K';
	go

	-- Viết chương trình tính chu vi tam giác có 3 cạnh 8, 5, 9
	declare @a int = 8, @b int = 5, @c int = 9
	declare @chuVi int = @a + @b + @c
	print 'Chu vi tam giac co 3 canh lan luot 8, 5, 9 la: ' + cast(@chuVi as varchar(30))
	go

	-- Cho biết lương cao, thấp nhất của nhân viên lưu vào biến
	use QLDuan;
	declare @minLuong float
	-- lấy lương thấp nhất gán cho biến minLuong
	select @minLuong = min(luong) from NHANVIEN
	-- xuất ra
	select @minLuong as N'Lương thấp nhất là: '
	go

	-- Cho biết lương trung bình của các nhân viên phòng 5
	declare @tbLuong float
	-- Lấy lương trung bình các nhân viên phòng 5
	select @tbLuong = AVG(luong) from NHANVIEN where PHG = 5;
	select @tbLuong as N'Lương trung bình các nhân viên phòng 5'
	go

 -- BIẾN TABLE
	
	declare @t1 table (ma int primary key, luong float check (luong > 0));

	-- Thêm dữ liệu vào bảng
	insert into @t1 values (1, 456), (2, 678);
	-- Sửa lương người 2 thanh 1000
	update @t1 set luong = 1000 where ma = 2;
	-- Xóa người có mã 1
	delete from @t1 where ma = 1;
	-- lưu ý: không dùng alter với biến table
	/* alter table @t1
	add tennv varchar(30); */
	-- Xuất
	select * from @t1;

	go

	-- Các nhân viên gồm có manv, luong của các nhân viên nam dùng biến Table
	declare @t2 table (manv char(3), tennv nvarchar(50));
	insert into @t2
		select MANV, TENNV from NHANVIEN where PHAI like N'Nam';
	select count(*) as N'Số NV' from @t2;
	select * from @t2;
	go

	-- Cho biết mã nhân viên, tên nhân viên có lương cao nhất phòng 5
	declare @t3 table (manv char(3), tennv nvarchar(50));
	insert into @t3
		select MANV, TENNV from NHANVIEN where luong = (select max(LUONG) from NHANVIEN where PHG = 5);
	select * from @t3;
	go

	-- CHo biết họ tên nhân viên có mức lương trên mức lương trung bình của phòng nghiên cứu
	declare @t4 table (ma char(3), tenlot nvarchar(40), tennv nvarchar(10))
	insert into @t4
		select MANV, TENLOT, TENNV 
		from NHANVIEN 
		where LUONG > (
			select AVG(LUONG) 
			from NHANVIEN nv inner join PHONGBAN pb on nv.PHG = pb.MAPHG  
			where pb.TENPHG = N'Nghiên cứu' 
			group by TENPHG 
		);

	select * from @t4;
	go
