
	/* Lab 5 */
	-- Bài 1: 
	-- Xin chào
		use QLDA;
		go
		create procedure sp_hello @ten nvarchar(30)
		as 
			print N'Xin chào ' + @ten;
		go
		exec sp_hello N'Tình';
		go

	-- Tổng
		create procedure sp_tonghs @a int , @b int 
		As
			print N'Tổng là: ' + cast((@a + @b) as varchar(9))
		go
		exec sp_tonghs 3, 4;
		go
	-- Tổng từ 1 đến n
		create procedure sp_tongDay1 @n int
		As
			declare @tong int = 0, @sosochan int = 0;
			declare @i int = 0;
			while (@i <= @n) begin
				set @tong = @tong + @i
				set @i = @i + 2
				set @sosochan = @sosochan + 1
			end
			print N'Tổng = ' + cast(@tong as varchar(10))
			print N'Số số chẵn = ' + cast (@sosochan as varchar(10))
		go
		exec sp_tongDay1 100
		go
	-- Tính ucln
		create procedure sp_Ucln1 @m int, @n int
		as begin
			declare @a int = iif(@m > @n, @m, @n)
			declare @b int = iif(@n > @m, @m, @n)
			while (@a % @b != 0) begin
				declare @t int = @a
				set @a = @b
				set @b = @t % @b
			end
			return @b
		end
		/* sử dụng */
		declare @k int
		exec @k = sp_Ucln1 21,18
		print @k
		go

	-- Bài 2
	-- ➢ Nhập vào @Manv, xuất thông tin các nhân viên theo @Manv.
		create procedure sp_xemNV @Manv nvarchar(9)
		as
		if (@Manv not in (select manv from nhanvien))
		print N'K có nhân viên này'
		else
			select manv, tennv, phg from nhanvien
			where manv = @Manv
		go
		exec sp_xemNV @Manv = '030'
		go
	-- ➢ Nhập vào @MaDa (mã đề án), cho biết số lượng nhân viên tham gia đề án đó
		create or alter procedure sp_DA @MaDA nvarchar(9)
		as 
		if(@MaDA not in(select mada from dean))
		print N'K có đề án này'
		else
			select count(pc.ma_nvien) as N'tổng nhân viên', da.mada
			from dean da inner join phancong pc on da.mada = pc.mada
			where da.mada = @MaDA
			group by da.mada;
		go
		exec sp_DA '100'
		go

	-- Nhập vào @MaDa và @Ddiem_DA (địa điểm đề án), cho biết số lượng nhân viên tham 
	-- gia đề án có mã đề án là @MaDa và địa điểm đề án là @Ddiem_DA
		create or alter procedure sp_DADD @MaDA nvarchar(9), @Ddiem_DA nvarchar(30)
		as
		if(@MaDA not in(select mada from dean) and @Ddiem_DA not in(select ddiem_da from dean))
		print N'K có đề án này'
		else
			select count(pc.ma_nvien) as N'tổng nhân viên', da.mada, da.ddiem_da
			from dean da inner join phancong pc on da.mada = pc.mada
			where da.mada = @MaDA and da.ddiem_da = @Ddiem_DA
			group by da.mada, da.ddiem_da;
			-- select * from congviec
			-- select * from dean
		go
		exec sp_DADD '10', N'Hà Nam'
		go
	-- Nhập vào @Trphg (mã trưởng phòng), xuất thông tin các nhân viên có trưởng phòng là
	-- @Trphg và các nhân viên này không có thân nhân.
		create or alter procedure sp_soNVTrg @trgphong varchar(9)
		as
		if(@trgphong not in (select trphg from phongban))
		print N'k có trưởng phòng này'
		else
			-- select manv, honv, tenlot, tennv, dchi  
			-- from nhanvien nv inner join phongban pb on nv.phg = pb.maphg 
			-- select * from phongban
			-- exec sp_help phongban
			-- where pb.trphg = @trgphong;
			select * 
			from nhanvien inner join phongban on nhanvien.phg = phongban.maphg
			left outer join thannhan on thannhan.ma_nvien = nhanvien.manv
			where thannhan.ma_nvien is null and phongban.trphg = @trgphong;
			-- select * from thannhan
		go
		exec sp_soNVTrg '002'
		go

	-- ➢ Nhập vào @Manv và @Mapb, kiểm tra nhân viên có mã @Manv có thuộc phòng ban có
	-- mã @Mapb hay không
		create procedure sp_kiemTra @manv nvarchar(9), @phong int
		as
			if (@manv in (select manv from nhanvien where phg = @phong))
				print N'Nhân viên này thuộc phòng' + ' ' + cast(@phong as varchar(10))
			else print N'Nhân viên này không thuộc phòng' + ' ' + cast(@phong as varchar(10))
		go
		exec sp_kiemTra '001', 1
		go

	-- Bài 3:
	-- Thêm phòng ban có tên CNTT vào csdl QLDA, các giá trị được thêm vào dưới dạng
	-- tham số đầu vào, kiếm tra nếu trùng Maphg thì thông báo thêm thất bại.
		create or alter procedure sp_insertPhong1
			@tenphong nvarchar(30), @maphg int, @trphg varchar(9), @ngay date
		As
			/* kiểm tra xem phòng đã có chưa */
			if(@maphg in (select maphg from phongban)) 
				begin	print N'Thêm thất bại'
				end
			insert into phongban values
			(@tenphong, @maphg, @trphg, @ngay);
		go
		exec sp_insertPhong1 'CNTT', 13, '007', '2023-12-13'
		go
	-- Cập nhật phòng ban tên Công nghệ thành IT
		create or alter procedure sp_capnhat
		@tenphong nvarchar(30), @maphg int, @trphg varchar(9), @ngay date
		as
			update phongban set tenphg = 'IT'
			where tenphg = 'CNTT'
			insert into phongban values
			(@tenphong, @maphg, @trphg, @ngay);
		go
		exec sp_capnhat 'TinhNE', 007, '005', '2023-12-13';
		select * from phongban
		go
	-- Thêm một nhân viên vào bảng NhanVien, tất cả giá trị đều truyền dưới dạng tham số đầu vào với điều kiện:
	-- nhân viên này trực thuộc phòng IT
	--  Nhận @luong làm tham số đầu vào cho cột Luong, nếu @luong<25000 thì nhân
		--viên này do nhân viên có mã 009 quản lý, ngươc lại do nhân viên có mã 005 quản lý
	-- Nếu là nhân viên nam thi nhân viên phải nằm trong độ tuổi 18-65, nếu là nhân	viên nữ thì độ tuổi phải từ 18-60.
		create or alter procedure sp_lab5 @honv nvarchar(15), @tenlot nvarchar(15), @tennv nvarchar(15), @manv varchar(9)
		, @ngsinh date, @dchi nvarchar(30), @phai nvarchar(3), @luong float, @ma_ql nvarchar(9), @phg int
		As
		begin
			declare @tuoi int
			set @tuoi = year(getdate()) - year(@ngsinh)
			if(@phg in (select maphg from phongban where tenphg = 'IT'))
				begin 
					if((@phai = 'Nam' and (@tuoi > 18 and @tuoi < 65)) 
					or (@phai = N'Nữ' and (@tuoi > 18 and @tuoi < 60)))
					begin
						if @luong < 25000
							set @ma_ql = '009'
						else
							set @ma_ql = '005'
					end
					else
						print N'Không đúng tuổi'
				end
				else
				print N'K phải phòng IT'
		end
		go

		exec sp_lab5 N'Phạm', N'Thế', N'Tình', '012', '2010-12-13', N'Nghệ An', N'Nam', 20000, null, 7
		select * from nhanvien
	
