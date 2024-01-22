
	use QLDA;
	go
	-- Lab 7
	-- Nhập vào MaNV cho biết tuổi của nhân viên này
	create or alter function fTuoi(@manv nvarchar(9))
	returns int
	as
	begin
		declare @tuoi int
		select @tuoi = (year(getdate()) - year(ngaysinh)) from nhanvien where @manv = manv
		return @tuoi
	end
	go
	print cast(dbo.fTuoi('001') as varchar);
	go
	-- Nhập vào Manv cho biết số lượng đề án nhân viên này đã tham gia
	create function fDean(@manv nvarchar(9))
	returns int
	as
	begin
		declare @sodean int
		select @sodean = count(mada) from phancong where @manv = ma_nvien
		return @sodean
	end
	go
	print cast(dbo.fDean('001') as varchar);
	go

-- Truyền tham số vào phái nam hoặc nữ, xuất số lượng nhân viên theo phái
	create function fPhai(@phai nvarchar(4))
	returns int
	as
	begin
		declare @sonv int
		select @sonv = count(manv) from nhanvien where @phai = phai
		return @sonv
	end
	go
	print cast(dbo.fPhai('Nam') as varchar);
	go

-- Truyền tham số đầu vào là tên phòng, tính mức lương trung bình của phòng đó, Cho biết
-- họ tên nhân viên (HONV, TENLOT, TENNV) có mức lương trên mức lương trung bình
-- của phòng đó.
	create or alter function fLuongTB (@tenP nvarchar(30))
	returns table
	as
		return(select tenphg,honv, tenlot ,tennv 
				from nhanvien inner join phongban on nhanvien.phg = phongban.maphg 
				where @tenP = tenphg 
				and luong > (select AVG(luong) from nhanvien 
							where phg = (select maphg from phongban where tenphg = @tenP)))
	go
	select * from dbo.fLuongTB(N'Điều hành');
	go

-- Tryền tham số đầu vào là Mã Phòng, cho biết tên phòng ban, họ tên người trưởng phòng
-- và số lượng đề án mà phòng ban đó chủ trì.	create function fMaPhong (@MaP int)	returns @t1 table(TenPhg nvarchar(30), hoTrP nvarchar (30), tenLTrP nvarchar(30),tenTrP nvarchar(30) , SLDean int)	as		begin		insert into @t1 			select  tenphg, honv, tenlot, tennv, count(*) as SoLuong 			from dean da inner join phongban pb on da.phong = pb.maphg inner join nhanvien nv on pb.trphg = nv.manv			where maphg = @MaP group by honv, tenlot, tennv, tenphg		return		end	go	select * from dbo.fMaPhong(5);	go-- Hiển thị thông tin HoNV,TenNV,TenPHG, DiaDiemPhg.	create or alter view V_Lab71	as 		select honv, tennv, tenphg, diadiem		from nhanvien nv inner join phongban pb on nv.phg = pb.maphg 			inner join diadiem_phg dd on pb.maphg = dd.maphg	go	select * from V_Lab71	go-- Hiển thị thông tin TenNv, Lương, Tuổi.	create view V_Lab72	as		select tennv, luong, (year(GETDATE())- Year(ngaysinh)) as N'Tuổi' from nhanvien	go	select * from V_Lab72	go-- Hiển thị tên phòng ban và họ tên trưởng phòng của phòng ban có đông nhân viên nhất	create view V_Lab73	as		select top 1  pb.tenphg, nhanvien.honv, nhanvien.tennv, pb.trphg ,  count(nv.manv) as SoNV		from phongban pb inner join nhanvien nv on pb.maphg = nv.phg			inner join nhanvien on pb.trphg = nhanvien.manv		group by tenphg, nhanvien.tenlot, nhanvien.tennv, nhanvien.honv, pb.trphg		order by count(nv.manv) desc	go	select * from V_Lab73		