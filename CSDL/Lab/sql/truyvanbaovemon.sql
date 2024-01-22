/*
	Truy vấn bảo vệ môn
    Phạm Thế Tình - ps26461
    Ngày 14/12/2022
*/

	use com2012_ps26461_qlbaihat;
    
-- 1. Hiển thị toàn bộ bài hát, sắp xếp theo thứ tự TheLoai giảm dần, cùng tên thì sắp theo NhacSi tăng dần.
	select *
    from baihat
    order by NhacSi asc;

-- 2. Hiện thị những bài hát có TenBH có chứa chữ C
	select *
    from baihat
    where TenBH like '%c%';
    
-- 3. Hiện thị các thông tin bài hát không thuộc thể loại ‘Bolero’, thông tin gồm: MaBH, TenBH, NhacSi và TenLoai.
	select MaBH, TenBH, NhacSi, TenTL
    from baihat join loaibaihat on baihat.TheLoai = loaibaihat.MaTL
    where tentl not like 'Bolero';
    
-- 4. Hiển thị các nhạc sĩ có ít nhất 2 bài hát, thông tin gồm: Tên nhạc sĩ, số lượng bài hát.
	select NhacSi, count(MaBH) as 'Số lượng bài hát'
    from baihat
    group by NhacSi
    having count(MaBH) >= 2;

-- 5. Thống kê số lượng bài hát theo từng loại (hiển thị cả các loại chưa có bài hát nào).
	select theloai ,count(MaTL)
    from baihat bh left join loaibaihat lbh on bh.TheLoai = lbh.MaTL
    group by theloai;

	select TenTL
    from loaibaihat
    where MaTL not in(
		select TheLoai from baihat
	);
    
-- 6. Cho biết Thể loại nào có số bài hát nhiều nhất, gồm: Mã Loại, Tên loại, Số lượng bài 
	select MaTL, TenTL, count(MaTL) as 'Số Lượng Bài Hát' 
    from baihat bh join loaibaihat lbh on bh.TheLoai = lbh.MaTL
	group by TenTL
    order by count(MaTL) desc;

-- 7. Tạo bảng LuuBaiHat, lưu lại các bài hát thuộc thể loại ‘POP’ và ‘Trữ tình’.
	select *
    into LuuBaiHat
	from baihat bh join loaibaihat lbh on bh.TheLoai = lbh.MaTL
    where TenTL like 'Pop' and 'Trữ Tình';
