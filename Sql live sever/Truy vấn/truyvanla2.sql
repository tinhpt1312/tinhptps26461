

	use QLDA;

	-- Lab 2
	-- 1. Cho biết nhân viên có lương cao nhất	
		declare @maxLuong table (luong int, namenv nvarchar (15));
		insert into @maxLuong
		select luong, tennv from nhanvien where luong = (select max(luong) from nhanvien);
		select * from @maxLuong;

	-- 2. Cho biết họ tên nhân viên(HONV, TENLOT, TENNV) có mức lương trên mức lương trung bình của phòng nghiên cứu
		declare @t4 table (ma char(9), tenlot nvarchar(15), tennv nvarchar(15))
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

	-- 3. Với các phòng ban có lương trung bình trên 30000, liệt kê phòng ban và số lượng nhân viên của phòng ban đó
		declare @tbl table (nampb nvarchar(15), soluong int, tbluong float)
		insert into @tbl
			select tenphg, count(manv) as 'SoLuong', AVG(luong) as LuongTB
			from nhanvien nv inner join phongban pb on nv.phg = pb.maphg
			group by tenphg 
			having avg(luong) > 30000 ;
		select * from @tbl

	-- 4. Với mỗi phòng ban, cho biết tên phòng ban và số lượng đề án mà phòng ban đó chủ trì
		declare @ct table (tenphong nvarchar(15), soluong int)
		insert into @ct
			select tenphg, COUNT(mada) as SoLuongDeAn
			from dean inner join phongban on phongban.maphg = dean.phong
			group by phong, tenphg;
		select * from @ct;
	-- Bài tập thêm
	-- 1. Cho biết tên nhân viên và số thân nhân của mỗi nhân viên
	declare @btt1 table (ten nvarchar(15), soLuongNhanthan int)
	insert into @btt1
		select tennv, COUNT(ma_nvien) 
		from nhanvien inner join thannhan on nhanvien.manv = thannhan.ma_nvien 
		group by tennv, ma_nvien;
	select * from @btt1;
	-- 2. Cho biết lương trung bình của các Nhân viên Nam
	declare @btt2 table (LuongTB float)
	insert into @btt2
		select AVG(luong) 
		from nhanvien 
		where phai = 'Nam';
	select * from @btt2;
	-- 3. Danh sách Nhân viên : Mã NV, Tên NV chưa được phân công Đề án nào
	declare @btt3 table (ten nvarchar(15), manv char(9))
	insert into @btt3
		select tennv, manv
		from nhanvien
		where manv not in (
			select  manv
			from phancong  
		);
	select * from @btt3;
	-- 4. Đề án ( Tên Đề án, Tổng THời gian ) có tổng thời gian tham gia của nhân viên nhiều nhất
	declare @btt4 table (tenDA nvarchar(50), TongTime int)
	insert into @btt4
		select top 1 tenda, SUM(thoigian) 
		from dean inner join phancong on dean.mada = phancong.mada 
		group by tenda
		order by sum(thoigian) desc;
	select * from @btt4;