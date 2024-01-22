	
	
	use QLDA;

	-- Lab 4
	-- Bài 1: Viết chương trình xem xét có tăng lương cho nhân viên hay không. Hiển thị cột thứ 1 là TenNV, cột thứ 2 nhận giá trị
	-- 1. “TangLuong” nếu lương hiện tại của nhân viên nhở hơn trung bình lương trong phòng mà nhân viên đó đang làm việc và ngược lại
	
		select tennv, avgluong, luong,
			case
			when luong >= avgluong then N'Không tăng lương'
			else N'Tăng lương'
			end as ghiChu
		from nhanvien
		inner join(
			select nhanvien.phg , avg(luong) as avgluong
			from nhanvien
			group by nhanvien.phg
		) as subquery on nhanvien.phg = subquery.phg;

	-- 2. Viết chương trình phân loại nhân viên dựa vào mức lương.
	-- Nếu lương nhân viên nhỏ hơn trung bình lương mà nhân viên đó đang làm việc thì xếp loại “nhanvien”, ngược lại xếp loại “truongphong"
		select tennv, luong,
			case
			when luong >= avgluong then N'Trưởng phòng'
			else N'Nhân viên'
			end as ChucVu
		from nhanvien
		inner join(
			select nhanvien.phg , avg(luong) as avgluong
			from nhanvien
			group by nhanvien.phg
		) as subquery on nhanvien.phg = subquery.phg;

	-- Viết chương trình hiển thị tên NV như hình
		select manv, iif(phai = 'Nam', 'Mr. ' + tennv, 'Ms. ' + tennv), phai
		from nhanvien;
	-- Viết chương trình tính thuế mà nhân viên phải đóng theo công thức
		select tennv, luong, 
		thue = case when luong between 0 and 25000 then luong*0.1
					when luong between 25000 and 30000 then luong*0.12
					when luong between 30000 and 40000 then luong*0.15
					when luong between 40000 and 50000 then luong*0.2
					else luong*0.25
		end
		from nhanvien;

	-- Bài 2:
	-- 1. ➢ Cho biết thông tin nhân viên (HONV, TENLOT, TENNV) có MaNV là số chẵn.
		/* select honv, tenlot, tennv, manv
		from nhanvien
		where manv %2 = 0;
		select * from nhanvien; */
		declare @dem int = 2;
		while @dem < (select count (manv) from nhanvien)
			begin 
				select honv, tenlot, tennv, manv 
				from nhanvien where cast (manv as int) = @dem
				set @dem = @dem + 2;
			end
			go;
		/* declare @nvchan int ;
		select @nvchan = cast (manv as int) from nhanvien
			if(@nvchan %2 = 0) 
			begin select honv, tenlot, tennv, manv from nhanvien
			end else
			begin print 'k co nhan vien nao'
			end */
	-- 2. Cho biết thông tin nhân viên (HONV, TENLOT, TENNV) có MaNV là số chẵn nhưng không tính nhân viên có MaNV là 4.
		declare @dem int = 2;
		while @dem < (select count (manv) from nhanvien)
			begin 
			if @dem =4
				begin 
				set  @dem = @dem + 2
				continue;
				end
			select honv, tenlot, tennv, manv from nhanvien where cast (manv as int) = @dem
			set @dem = @dem + 2;
			end
	-- Bài 3:
	-- ➢ Thực hiện chèn thêm một dòng dữ liệu vào bảng PhongBan theo 2 bước 
	-- 1. o Nhận thông báo “ thêm dư lieu thành cong” từ khối Try
		Begin try
			insert into phongban values
			('ak47', 1, 'tp1', null);
			print N'Thêm dữ liệu thành công'
		end try
		begin catch 
			print N'Thêm dữ liệu thất bại'
		end catch

	-- ➢ Viết chương trình khai báo biến @chia, thực hiện phép chia @chia cho số 0 và dùng RAISERROR để thông báo lỗi.
		declare @chia float
		begin try
			set	@chia = 10/0
		end try
		begin catch 
			declare @err_mss nvarchar(2000)
			declare @err_state int
			declare @err_severity int
			select @err_mss = error_number(),
				   @err_severity = ERROR_SEVERITY(),
				   @err_state = ERROR_STATE()
			raiserror(@err_mss, @err_severity, @err_state)
		end catch
		go

	-- Bài tập thêm
	-- Tính tổng lương nhân viên nam , tổng lương nhân viên nữ phòng nghiên cứu. Hiển thị theo cột
		select sum(iif(phai = 'Nam' , luong, 0)) as LuongNam, sum(iif(phai = N'Nữ', luong, 0)) as LuongNu
		from phongban pb inner join nhanvien nv on nv.phg = pb.maphg
		where pb.tenphg = N'Nghiên cứu';
	-- Hiển thị thông tin nhân viên gồm 3 cột :manv, tennv, chức danh. 
	-- CỘt chức danh xác định như sau : nếu nhân viên này là quản lý hiển thị 'Quản lý', 
	-- nếu cột ma_nql là null hiển thị 'Sếp', còn lại hiển thị 'Nhân viên'
		select manv, tennv, (case 
						when nhanvien.ma_nql is null then N'Sếp'
						when nhanvien.manv in(select trphg from phongban) then N'Trưởng phòng'
						else N'Nhân viên'
						end)  as ChucDanh
			from nhanvien
	-- Tăng lương cho nhân viên phòng Nghiên cứu 5000, các phòng còn lại 1000
	update nhanvien set luong = iif(pb.tenphg = N'Nghiên cứu', luong + 5000, luong + 1000)
	from nhanvien nv inner join phongban pb on nv.phg = pb.maphg;
	select * from nhanvien;