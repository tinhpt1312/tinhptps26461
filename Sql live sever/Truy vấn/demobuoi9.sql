
	/* 
		Cú pháp 
		Create Procedure <Tên thủ tục> <Tham số 1> <Kiểu>[in/out],
										<Tham số 2> <Kiểu>[in/out]...
		As Begin 
			/* Code của thủ tục */
			/* ... */
		end
		go 
	*/

	/* Thực hiện thủ tục */
	/* Exec <tên thủ tục> <tham số vào> = <giá trị>, <tham số ra> = <biến> out */
	/* VD1: tạo thủ tục xuất ra câu chào */
		create procedure HelloWorld
		as	
			print N'Chào bạn'
		go
	/* Thực hiện thủ tục */
		exec HelloWorld
		go
	/* Tạo thủ tục xem ds tất cả nhân viên */
		create procedure sp_dsnv
		as begin
			select * from nhanvien;
		end
		go
		exec sp_dsnv
		go
	/* Tạo thủ tục có tham số */
		create procedure HelloWorld1 @name nvarchar(20)
		as
			print N'Chào bạn' + ' ' + @name
		go
	/* Thực hiện */
		exec HelloWorld1 @name = N'Tuấn';
		exec HelloWorld1 N'Lan'
		go
	/* Lab 5 : Xuất thông tin nhân viên theo mã nhân viên */
		create procedure sp_xemDS @Manv nvarchar(9)
		as
		if (@Manv not in (select manv from nhanvien))
		print N'K có nhân viên này'
		else
			select manv, tennv, phg from nhanvien
			where manv = @Manv
		go
		exec sp_xemDS @Manv = '030'
		go

		create procedure sp_kiemTraNV @manv nvarchar(9),
			@phong int
		as
			if (@manv in (select manv from nhanvien where phg = @phong))
				print N'Nhân viên này thuộc phòng' + ' ' + cast(@phong as varchar(10))
			else print N'Nhân viên này không thuộc phòng' + ' ' + cast(@phong as varchar(10))
		go
		exec sp_kiemTraNV @manv = '001', @phong = 4
		go
	/* Viết thủ tục tính tổng 2 số A, B */
		create procedure sp_tinhTong @a int, @b int
		as
			print N'Tổng 2 số A và B là: ' + cast((@a + @b) as varchar(10))
		go
		exec sp_tinhTong 10, 22;
		go
	/* Thủ tục với tham số ra */
		create or alter procedure sp_tinhTong @a int, @b int, @c int out
		as
			set @c = @a + @b
		go
		declare @tong int;
		declare @m int = 9;
		exec sp_tinhTong 8, 11, @c = @tong out
		print N'Tổng = ' + cast(@tong as varchar(10))
		exec sp_tinhTong @a = @m, @b = 6, @c = @tong out
		print N'Tổng = ' + cast(@tong as varchar(10))
		go
	/* Viết thủ tục tính số nv của phòng, phòng là tham số vào, số nv là than số ra */
		create procedure sp_soNVPhong @phong int, @sonv int out 
		as
			select @sonv = count(*) from nhanvien
			where phg = @phong
		go
		declare @sonhanvien int
		exec sp_soNVPhong @phong = 1, @sonv = @sonhanvien out
		print N'Phòng 1 có: ' + cast(@sonhanvien as varchar(10))+ ' ' + N'Nhân viên'
		go
	/* Thủ tục với return */
		create or alter procedure sp_tinhTong @a int, @b int
		as 
			return @a + @b
		go
		
		declare @tong int;
		exec @tong = sp_tinhTong @a = 9, @b = 8
		print @tong