	
	use QLDuan;

	select * from NHANVIEN;

	-- câu 1: Các nhân viên làm việc tại phòng ban 04
	select *
	from NHANVIEN 
	where PHG = 4;

	-- câu 2: tìm các nhân viên có lương trên 30000
	select *
	from NHANVIEN
	where LUONG > 30000;

	-- câu 3: tìm các nhân viên có mức lương trên 25000 ở phòng số 4 hoặc các nhân viên có mức lương trên 30000 ở phòng số 5
	select * from NHANVIEN
	where (LUONG > 25000 and PHG = 4) or (LUONG > 30000 and PHG = 5);

	-- câu 4: cho biết họ tên đầy đủ của các nhân viên ở TPHCM
	select CONCAT (HONV , ' ', TENLOT, ' ', TENNV) as HoVaTen , NHANVIEN.DCHI
	from NHANVIEN
	where DCHI like '%TP HCM'

	-- câu 5: cho biết họ tên đầy đủ của các nhân viên có họ bắt đầu bằng kí tự N
	select * from NHANVIEN
	select CONCAT (HONV , ' ', TENLOT, ' ', TENNV) as HoVaTen 
	from NHANVIEN
	where HONV like 'N%'

	-- câu 6: CHo biết ngày sinh và địa chỉ của nhân viên Đinh Bá Tiến.
	select * from NHANVIEN
	select CONCAT (HONV , ' ', TENLOT, ' ', TENNV) as HoVaTen, NGSINH, DCHI  from NHANVIEN
	where TENNV like 'Tiên' or TENLOT like N'Bá';


	-- Bài thêm lab 1:
	-- 1. Danh sách các nhân viên có mã 001, 004, 006, 017
	select * from NHANVIEN
	where MANV = '001' or MANV = '004' or MANV = '006' or MANV = '017';

	-- 2. Các nhân viên sinh tháng 1/1965, hiển thị cột mã, tên, ngày sinh
	select MANV, TENNV, NGSINH from NHANVIEN
	where MONTH(NGSINH) = 1 and YEAR(NGSINH) = 1965;

	-- 3. các nhân viên không ở TPHCM
	select * from NHANVIEN
	where DCHI not like '%TP HCM';

	-- 4. số nhân viên của phòng số 5: phòng, số nv
	select NHANVIEN.PHG, COUNT(*) as SoNhanVien from NHANVIEN
	where PHG = 5 group by PHG;

	-- 5. danh sách nhân viên nữ: mã phòng, tên nv, tên phòng, phát.
	select TENNV, PHG, PHAI from NHANVIEN
	where PHAI = N'Nữ';

	-- 6. danh sách nhân viên quản lý cấp cao nhất.
	select * from NHANVIEN
	where MA_NQL is null;