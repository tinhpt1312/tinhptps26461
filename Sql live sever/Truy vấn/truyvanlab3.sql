/* 
	Lab 3 - SQL live sever
*/
 use QLDA;
-- Bài 1
-- Xuất định dạng tổng số giờ làm việc theo kiểu dec với 2 số thập phân
		select tenda, cast(SUM(thoigian) as dec (6,2))
		from dean inner join phancong on dean.mada = phancong.mada 
		group by tenda;

		select tenda, convert(dec(6,2), SUM(thoigian))
		from dean inner join phancong on dean.mada = phancong.mada 
		group by tenda;
-- xuất định dạng tổng số giờ làm việc kiểu varchar
		select tenda, cast(SUM(thoigian) as varchar (4))
		from dean inner join phancong on dean.mada = phancong.mada 
		group by tenda;

		select tenda, convert(varchar(4), SUM(thoigian))
		from dean inner join phancong on dean.mada = phancong.mada 
		group by tenda;

-- Xuất định dạng lương trung bình kiểu dec với 2 số thập phân, sử dụng dấu phẩy để phân biệt phần nguyên với phần thập phân
		select tenphg, replace(cast(AVG(luong) as dec (9,2)), '.', ',')
		from phongban pb inner join nhanvien nv on pb.maphg = nv.phg
		group by tenphg;

		select tenphg, replace(convert(dec(9,2), AVG(luong)), '.', ',')
		from phongban pb inner join nhanvien nv on pb.maphg = nv.phg
		group by tenphg;

-- xuất định dạng lương trung bình kiểu varchar. Sử dụng dấu phẩy tách cứ mỗi 3 chữ số trong chuỗi ra
		select tenphg, left (cast(AVG(luong) as varchar(10)), 3) 
		+ replace(cast(AVG(luong) as varchar (10)), left (cast(AVG(luong) as varchar(10)), 3), ',') as luongTB
		from phongban pb inner join nhanvien nv on pb.maphg = nv.phg
		group by tenphg;

		select tenphg, left (convert(varchar (10), AVG(luong)), 3) 
		+ replace(convert(varchar (10), AVG(luong)), left (convert(varchar (10), AVG(luong)), 3), ',') as luongTB
		from phongban pb inner join nhanvien nv on pb.maphg = nv.phg
		group by tenphg;

-- Bài 2:
-- Xuất định dạng tổng số giờ làm việc với hàm ceiling
		select tenda, CEILING(sum(thoigian)) as N'Tổng số giờ'
		from phancong pc inner join congviec cv on pc.mada = cv.mada inner join dean da on cv.mada = da.mada
		group by tenda;
-- Xuất định dạng tổng số giờ làm việc với hàn floor
		select tenda, FLOOR(sum(thoigian)) as N'Tổng số giờ'
		from phancong pc inner join congviec cv on pc.mada = cv.mada inner join dean da on cv.mada = da.mada
		group by tenda;
-- Xuất định dạng tổng số giờ làm việc làm tròn tới 2 chữ số thập phân
		select tenda, ROUND(sum(thoigian), 2)
		from phancong pc inner join congviec cv on pc.mada = cv.mada inner join dean da on cv.mada = da.mada
		group by tenda;
-- Cho biết họ tên nv có mức lương trên mức trung bình của phòng ban ngiên cứu
		select honv, tenlot, tennv, round(luong, 2) as luong
		from nhanvien nv inner join phongban pb on nv.phg = pb.maphg
		where tenphg like N'Nghiên cứu' and luong > (
			select AVG(luong)
			from nhanvien nv inner join phongban pb on nv.phg = pb.maphg
		);
-- Bài 3
-- dữ liệu cột honv được viết in hoa toàn bộ
		select upper(honv), tenlot, tennv, dchi, count(ma_nvien) as soThanNhan
		from nhanvien nv inner join thannhan tn on nv.manv = tn.ma_nvien
		group by honv, tenlot, tennv, dchi
		having count(ma_nvien) > 2;
-- dữ liệu tên lót được in hoa toàn bộ
		select honv, upper(tenlot) as tenLot, tennv, dchi, count(ma_nvien) as soThanNhan
		from nhanvien nv inner join thannhan tn on nv.manv = tn.ma_nvien
		group by honv, tenlot, tennv, dchi
		having count(ma_nvien) > 2;
-- dữ liệu tennv có kí tự thứ 2 viết hoa còn lại viết thường
		select honv, tenlot, replace(lower(tennv), SUBSTRING(tennv,2,1), upper(substring(tennv, 2, 1))) as ' ten nv', dchi,
		count(ma_nvien) as soThanNhan
		from nhanvien nv inner join thannhan tn on nv.manv = tn.ma_nvien
		group by honv, tenlot, tennv, dchi
		having count(ma_nvien) > 2;
-- dữ liệu cột địa chỉ chỉ hiện thị tên đường
		select honv, tenlot, tennv,SUBSTRING(dchi, CHARINDEX(' ', dchi) 
		, CHARINDEX(',', dchi) - CHARINDEX(' ', dchi) ) as 'Dia Chi', count(ma_nvien) as soThanNhan
		from nhanvien nv inner join thannhan tn on nv.manv = tn.ma_nvien
		group by honv, tenlot, tennv, dchi
		having count(ma_nvien) > 2;	
-- cho biết tên phòng ban và họ tên trưởng phòng của phòng ban có đông nhân viên nhất
		select top 1 tenphg, trphg,b.honv, b.tenlot , b.tennv, COUNT(a.manv) as soLuong,
		REPLACE(b.tennv , N'Tùng', 'Fpoly')
		from nhanvien a inner join phongban pb on a.phg = pb.maphg
		inner join nhanvien b on b.manv = pb.trphg
		group by tenphg, trphg, b.tennv,b.honv, b.tenlot
		order by soLuong desc;

-- Bài 4
-- cho biết nhân viên có năm sinh từ 1960 - 1965
		select *
		from nhanvien
		where year(ngaysinh) between 1960 and 1965;
-- cho biết tuổi các nhân viên cho đến hiện tại
		select *, year(getdate())- year(ngaysinh) as tuoi 
		from nhanvien;
-- dựa vào dữ liệu ngày sinh xem nhân viên sinh thứ mấy
		select *, datename(weekday, ngaysinh) as thu
		from nhanvien;
-- Cho biết số lượng nhân viên , tên trưởng phòng, ngày nhận chức
		select b.tennv as tenTruongPhong ,convert(varchar, ng_nhanchuc, 105) as ngayNhanChuc,  COUNT(a.manv) as soLuongNV
		from nhanvien a inner join phongban pb on a.phg = pb.maphg
		inner join nhanvien b on b.manv = pb.trphg
		group by b.tennv,ng_nhanchuc;