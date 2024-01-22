
	use qlnhatro;
	go
-- Bài 1
-- 1. Tạo ba Stored Procedure (SP) với các tham số đầu vào phù hợp
-- insert bảng người dùng
	create or alter proc sp_asm1 @mand varchar(6), @tennd nvarchar(50),@gtnd nvarchar(10),
						@dienthoai varchar(12), @diachi ntext, @quan nvarchar(30), @email varchar(30)
	as	

			if(@mand is null or @tennd is null or @gtnd is null or @dienthoai is null
				or @diachi is null or @quan is null or @email is null) 
				begin
					print N'Thêm thất bại'
				end
			else
				begin
				insert into nguoidung values
				(@mand, @tennd, @gtnd, @dienthoai, @diachi, @quan, @email);
				print N'Thêm thành công'
				end
	go
	exec sp_asm1 '111', N'Tình', 'Nam', '1234', null, 'quan 9', 'tinh@gmail.com';
	exec sp_asm1 '111', N'Tình', 'Nam', '1234', N'101/2 Lê Văn Việt', 'quan 9', 'tinh@gmail.com';
	select * from nguoidung
	go

-- insert bảng nhà trọ
	create or alter proc sp_asm2 @mant varchar(6), @dientich float,@giaphong float, @mand varchar(6),
						 @diachi ntext, @quan nvarchar(30),@mota nvarchar(100), @ngaydang date, @maloai varchar(6)
	as	

			if(@mant is null or @dientich is null or @giaphong is null or @mota is null
				or @diachi is null or @quan is null or cast(@ngaydang as varchar(30)) is null or @maloai is null or @mand is null) 
				begin
					print N'Thêm thất bại'
				end
			else
				begin
				insert into nhatro values
				(@mant, @dientich, @giaphong, @diachi, @quan, @mota, @ngaydang, @maloai, @mand);
				print N'Thêm thành công'
				end
	go
	exec sp_asm2 '111', 100.2, 1000000, null, 'quan 9', null, null, 'nt01', '123';
	exec sp_help nhatro
	go
-- insert bảng đánh giá
	create or alter proc sp_asm3 @madg int, @ngaydanhgia date,@noidung nvarchar(160), @like_dis bit,
							 @manhatro varchar(6) , @mand varchar(6)
		as	

				if(@madg is null or @ngaydanhgia is null or @noidung is null or @like_dis is null
					or @manhatro is null or @mand is null) 
					begin
						print N'Thêm thất bại'
					end
				else
					begin
					insert into danhgia values
					(@madg, @ngaydanhgia, @noidung, @like_dis, @manhatro, @mand);
					print N'Thêm thành công'
					end
		go
	exec sp_help danhgia
	go

-- Bài 2: truy vấn thông tin
-- 1. Viết một SP với các tham số đầu vào phù hợp. 
	-- SP thực hiện tìm kiếm thông tin của phòng trọ thỏa mãn điều kiện tìm kiếm theo: 
		-- Quận, phạm vi diện tích, phạm vi ngày đăng tin, khoảng giá tiền, loại hình nhà trọ.

	
	go
	create or alter proc sp_select_nhatro 
			@quan nvarchar(30) = N'%', @loainhatro nvarchar(30) = N'%',
			@DientichMin real = null, @DientichMax real = null,
			@NgaydangMin date = null, @NgaydangMax date = null,
			@GiaphongMin money = null, @GiaphongMax money = null
		as
		if @DientichMax is null
			begin	select @DientichMax = max(dientich) from nhatro
			end
		if @DientichMin is null
			begin	select @DientichMin = min(dientich) from nhatro
			end
		if @NgaydangMax is null
			begin	select @NgaydangMax = max(ngaydang) from nhatro
			end
		if @NgaydangMin is null
			begin	select @NgaydangMin = min(ngaydang) from nhatro
			end
		if @GiaphongMax is null
			begin	select @GiaphongMax = max(giaphong) from nhatro
			end
		if @GiaphongMin is null
			begin	select @GiaphongMin = min(giaphong) from nhatro
			end
		select (N'Cho thuê phòng tại ' + cast(nhatro.diachi as varchar) + ', ' + cast(nhatro.quan as varchar) ) as N'Địa chỉ',
		 replace(convert(varchar, dientich, 103), '.', ',') + ' m2' as N'Diện tích',
		 format(giaphong,'N', 'vi_VN') as N'Giá phòng', nhatro.mota, convert(varchar, ngaydang, 105) as N'Ngày đăng',
		 iif(nguoidung.gioitinh = 'Nam', 'A. ' + nguoidung.tennguoidung, 'C. ' + nguoidung.tennguoidung) as N'Người đăng',
		 nguoidung.dienthoai as N'Điện thoại liên hệ', (cast(nguoidung.diachi as nvarchar) + ', ' + nguoidung.quan) as N'Địa chỉ'
		from nhatro inner join nguoidung on nhatro.manguoidung = nguoidung.manguoidung inner join loainha on 
		 nhatro.maloai = loainha.maloai
		 where (dientich<=@DientichMax) and (dientich >= @DientichMin) and (ngaydang <= @NgaydangMax) and (ngaydang >= @NgaydangMin)
				and (giaphong <= @GiaphongMax) and (giaphong >= @GiaphongMin) and (nhatro.quan like @quan) and (loainha.tenloai like @loainhatro)
		order by ngaydang
	go
	exec sp_select_nhatro @Loainhatro = N'Chung cư'
	select * from loainha
	go

	--Viết một hàm có các tham số đầu vào tương ứng với tất cả các cột của bảng NGUOIDUNG. 
		--Hàm này trả về mã người dùng (giá trị của cột khóa chính của bảng NGUOIDUNG) thỏa mãn các giá trị được truyền vào tham số
	create or alter function fNguoiDung (@mand varchar(6) = N'%', @tennd nvarchar(50)= N'%', @gioitinh nvarchar(10)= N'%', 
								@dienthoai varchar(12)= N'%', @diachi ntext= N'%', @quan nvarchar(30)= N'%', @email varchar(30)= N'%')
	returns table
	return
		(select manguoidung from nguoidung where @mand like manguoidung and @tennd like tennguoidung and @gioitinh like gioitinh
			and @dienthoai like dienthoai and @diachi like diachi and @quan like quan and @email like email)
	
	
	select nhatro.manhatro, loainha.tenloai, (replace(convert(varchar, dientich, 103), '.', ',')) as N'Diện tích',
		format(giaphong,'N', 'vi_VN') as N'Giá phòng', (cast(nguoidung.diachi as nvarchar) + ', ' + nguoidung.quan) as N'Địa chỉ',
		nhatro.mota, nhatro.ngaydang, nguoidung.tennguoidung as N'Tên người đăng'
		from nhatro inner join nguoidung on nhatro.manguoidung = nguoidung.manguoidung inner join loainha on 
		 nhatro.maloai = loainha.maloai
		where nhatro.manguoidung in(select manguoidung from dbo.fNguoiDung('1111', N'Tình', 'Nam', '1234',N'101/2 Lê văn việt', 'quan 9', 'tinh@gmail.com'))
	go
	
	select * from nguoidung
	exec sp_help nguoidung
	go
	/* c. Viết hàm có tham số đầu vào là mã nhà trọ (cột khóa chính của bảng NHATRO).
	Hàm này trả về tổng số LIKE và DISLIKE của nhà trọ này.*/
	create or alter function fn_likeordislike(@manhatro varchar(8))
	returns @t1 table(soluonglike int, soluongdislike int)
	as begin
		insert into @t1 
			select sum(iif(danhgia.like_dislike = 1, 1, 0)) as soLuongLike, sum(iif(danhgia.like_dislike = 0, 1, 0)) as soLuongDislike
			from nhatro inner join danhgia on nhatro.manhatro = danhgia.manhatro
			group by nhatro.manhatro
			having nhatro.manhatro = @manhatro
		return
	end
	go
	select * from dbo.fn_likeordislike('nt004')
	go
	/*d. Tạo một View lưu thông tin của TOP 2 nhà trọ có số người dùng LIKE nhiều nhất gồm
	các thông tin sau:
	- Diện tích
	- Giá
	- Mô tả
	- Ngày đăng tin
	- Tên người liên hệ
	- Địa chỉ
	- Điện thoại
	- Email*/
	create or alter view V_top2NhaTro
	as
		select nhatro.manhatro, nhatro.dientich, nhatro.giaphong, nhatro.mota, nhatro.ngaydang, nguoidung.tennguoidung, nguoidung.diachi,
				nguoidung.dienthoai, nguoidung.email
		from nhatro inner join nguoidung on nhatro.manguoidung = nguoidung.manguoidung
		where nhatro.manhatro in (
							select top 2 danhgia.manhatro from danhgia
							where like_dislike = 1
							group by manhatro
							order by count(*) desc
							)
	go

	--Thuc hien
	select * from V_top2NhaTro
	go
	/* e. Viết một Stored Procedure nhận tham số đầu vào là mã nhà trọ (cột khóa chính của
	bảng NHATRO). SP này trả về tập kết quả gồm các thông tin sau: 
	- Mã nhà trọ
	- Tên người đánh giá
	- Trạng thái LIKE hay DISLIKE
	- Nội dung đánh giá*/
	create or alter proc sp_ttDanhGiaNhaTro @manhatro nvarchar(6) = null
	as begin
		if @manhatro is null begin print 'Ma nha tro khong duoc de trong' return end

		if not exists(select * from nhatro where manhatro = @manhatro ) begin print 'Ma nha tro khong ton tai' return end

		if not exists(
					select nhatro.manhatro, nguoidung.tennguoidung, iif(danhgia.like_dislike = 1,'Like','Dislike') as likeOrDislike, danhgia.noidung
					from nhatro inner join danhgia on nhatro.manhatro = danhgia.manhatro
								inner join nguoidung on danhgia.manguoidung = nguoidung.manguoidung
					where nhatro.manhatro = @manhatro)
		begin print'Nha tro khong co ai danh gia' return end

		select nhatro.manhatro, nguoidung.tennguoidung as tenNguoiDanhGia, iif(danhgia.like_dislike = 1,'Like','Dislike') as likeOrDislike, danhgia.noidung
		from nhatro inner join danhgia on nhatro.manhatro = danhgia.manhatro
					inner join nguoidung on danhgia.manguoidung = nguoidung.manguoidung
		where nhatro.manhatro = @manhatro
	end
	go
	-- Thuc hien
	exec sp_ttDanhGiaNhaTro 'nt004'
	go
	-- Y3 - 3
	/*1. Viết một SP nhận một tham số đầu vào kiểu int là số lượng DISLIKE. SP này thực hiện
	thao tác xóa thông tin của các nhà trọ và thông tin đánh giá của chúng, nếu tổng số lượng
	DISLIKE tương ứng với nhà trọ này lớn hơn giá trị tham số được truyền vào.
	Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác
	xóa thực hiện không thành công.*/
	--
	select danhgia.manhatro, count(*) from danhgia 
					where like_dislike = 0
					group by manhatro
					having count(*) > 2
					go
	-- Bai lm
	create or alter proc sp_xoaTheoDislike(@sl int)
	as begin
		begin try
			declare @tb table(mant varchar(10))
				insert into @tb	
					select danhgia.manhatro from danhgia 
					where like_dislike = 0
					group by manhatro
					having count(*) > @sl
			begin transaction
				delete from danhgia where danhgia.manhatro in (select * from @tb)
				delete from nhatro where nhatro.manhatro in (select * from @tb)
				print 'Xoa thanh cong'
			commit transaction
		end try
		begin catch
			rollback transaction
			print 'Xoa that bai'
		end catch
	end
	go
	-- Du lieu test
	insert into nhatro
	values
	('11', 11, 1000000, 'aa', 'aa', 'aa', '2023-06-01', 'ln003', 'nd001'),
	('12', 11, 1000000, 'aaa', 'aaa', 'aaa', '2023-06-09', 'ln003', 'nd001')
	insert into danhgia
	values
	(11, '2023-06-05', 'ma', 0,'11', 'nd002'),
	(12, '2023-06-05', 'ma', 0,'11', 'nd002'),
	(13, '2023-06-05', 'ma', 0,'11', 'nd002'),
	(14, '2023-06-05', 'ma', 0,'12', 'nd002'),
	(15, '2023-06-05', 'ma', 0,'12', 'nd002'),
	(16, '2023-06-05', 'ma', 0,'12', 'nd002')
	delete from nhatro where manhatro = '11' or manhatro = '12'
	delete from danhgia where madanhgia between 11 and 16
	select * from nhatro
	select * from danhgia
	go
	-----
	-- thuc hien
	exec sp_xoaTheoDislike 2
	go
	/*2. Viết một SP nhận hai tham số đầu vào là khoảng thời gian đăng tin. SP này thực hiện
	thao tác xóa thông tin những nhà trọ được đăng trong khoảng thời gian được truyền vào
	qua các tham số.
	Lưu ý: SP cũng phải thực hiện xóa thông tin đánh giá của các nhà trọ này.
	Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác
	xóa thực hiện không thành công.*/
	create or alter proc sp_XoaTheoNgay(@minngay date, @maxngay date)
	as begin
		begin try
			declare @tb table (mant varchar(10))
			insert into @tb 
				select nhatro.manhatro from nhatro where nhatro.ngaydang between @minngay and @maxngay

			begin transaction
				delete from danhgia where danhgia.manhatro in (select mant from @tb)
				delete from nhatro where nhatro.manhatro in (select mant from @tb)
				print 'Xoa thanh cong'
			commit transaction
		end try
		begin catch
			print'Xoa that bai'
			rollback transaction
		end catch
	end
	go
	-- thuc hien
	exec sp_XoaTheoNgay '2023-06-01', '2023-06-09'
	go
	-- Y4
	/*Tạo Trigger ràng buộc khi thêm, sửa thông tin nhà trọ phải thỏa mãn các điều kiện sau:
	• Diện tích phòng >=8 (m2)
	• Giá phòng >=0*/
	create or alter trigger trig_suaTTNhaTro
	on nhatro
	for update, insert
	as begin
		declare @dem int = 0
		select @dem = count(*) from(select maloai from inserted where dientich < 8 or giaphong < 0) as sbquery
	if @dem > 0 
	begin
		print N'Diện tích phòng phai >=8 và giá phòng phai >=0'
		rollback transaction
	end
	end
	-- test
	select * from nhatro
	update nhatro set dientich = 3 where maloai = 'ln001'
	insert into nhatro
	values
	('110', 1, 1000000, 'aa', 'aa', 'aa', '2023-06-01', 'ln003', 'nd001')
	go
	/*Tạo Trigger để khi xóa thông tin người dùng
	• Nếu có các đánh giá của người dùng đó thì xóa cả đánh giá
	• Nếu có thông tin liên hệ của người dùng đó trong nhà trọ thì sửa thông tin liên hệ
	sang người dùng khác hoặc để trống thông tin liên hệ*/
	create or alter trigger trig_xoaTTNguoiDung
	on nguoidung
	instead of delete
	as begin
		delete from danhgia where danhgia.manguoidung in (select manguoidung from deleted)
		update nhatro set manguoidung = 'nd001' where nhatro.manguoidung in (select manguoidung from deleted)
		delete from nguoidung where nguoidung.manguoidung in (select manguoidung from deleted)
	end
	go

	-- Du lieu test
	select * from nhatro
	select * from nguoidung
	select * from danhgia

	insert into nhatro
	values
	('100', 11, 1000000, 'aa', 'aa', 'aa', '2023-06-01', 'ln003', '100')
	exec sp_asm1 '100','khang','Nam','9099292','Tra vinh','quan1','khanggg.com'
	exec sp_asm3 '100', '2023-06-01', 'Haha', 1, '100', '100'

	delete from nhatro where manhatro = '100'
	------
	-- Su dung trigger
	delete from nguoidung where manguoidung = '100' 