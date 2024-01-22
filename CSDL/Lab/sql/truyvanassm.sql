/*
	Truy vấn ASM 2 - Ps26461 Phạm Thế Tình
    Ngày tạo 4/12/2022
*/

use qlpx_ps26461;

-- 6.1. Hiển thị tất cả mặt hàng. Danh sách sắp xếp theo đơn giá tăng dần.
		select *
		from mathang
		order by TenMH asc;

-- 6.2. Hiển thị tất cả các mặt hàng thuộc loại hàng “Thời trang”. Thông tin gồm: mã mặt hàng, tên mặt hàng, đơn vị tính, đơn giá, tên loại hàng.
		select mh.Mamh , mh.TenMH , mh.Donvitinh , mh.Dongia , lh.Tenloai
		from mathang mh , loaihang lh
		where mh.Maloai = lh.Maloai and Tenloai like 'Thời Trang';
        
-- 6.3. Thống kê số mặt hàng theo loại hàng, thông tin gồm: mã loại hàng, tên loại hàng, tổng số mặt hàng. Danh sách sắp xếp theo tổng số mặt hàng giảm dần.
		select count(mathang.tenmh) as 'Tổng số hàng', loaihang.Maloai, loaihang.Tenloai 
		from loaihang join mathang on loaihang.maloai = mathang.maloai
        group by Maloai, tenloai
		order by count(mathang.tenmh) desc;
        
-- 6.4. Liệt kê số phiếu xuất, ngày xuất hàng, mã cửa hàng, tên mặt hàng, số lượng, đơn giá, thành tiền.
		select px.Sopx, px.Ngaymua , ch.Mach , mh.Tenmh, pxct.Soluong , mh.Dongia , pxct.Thanhtien 
		from phieuxuathang px , mathang mh , cuahang ch, phieuxuathang_ct pxct
        where px.sopx = pxct.sopx and px.mach = ch.mach and pxct.mamh = mh.mamh;
        
-- 6.5. Thống kế tổng số lần xuất hàng theo từng tháng trong năm 2021, thông tin gồm: tháng/năm, số lần xuất hàng.
		select count(soPX) as 'Tổng số lần xuất hàng' , month(ngayMua) as 'Tháng xuất hàng', year(ngaymua) as 'Năm xuất hàng'
		from phieuxuathang
		group by month(ngaymua);
        
-- 6.6. Liệt kê 5 mặt hàng có số lượng xuất kho nhiều nhất.
		select mathang.* , phieuxuathang_ct.soluong
		from mathang join phieuxuathang_ct on mathang.mamh = phieuxuathang_ct.mamh
		order by soluong asc limit 5;
        
        
-- 6.7. Thống kê số hàng nhập về cửa hàng “Chi nhánh quận 5”, thông tin hiển thị: Tên cửa hàng, số lần nhập hàng.
		select tenCH, count(phieuxuathang.maCH) as 'Số lần nhập hàng'
		from phieuxuathang join cuahang on phieuxuathang.mach = cuahang.mach
        where Diachi like 'quận 5';

-- 6.8. Thống kê tổng tiền hàng xuất kho theo ngày, thông tin hiển thị: Ngày xuất hàng, tổng thành tiền.
		select sum(phieuxuathang_ct.thanhtien) as 'Tổng tiền xuất kho' , phieuxuathang.ngaymua as 'Ngày xuất hàng'
		from phieuxuathang join phieuxuathang_ct on phieuxuathang.sopx = phieuxuathang_ct.sopx
        group by ngaymua;
        
-- 6.9. Cập nhật ngày xuất hàng là ngày hiện hành cho các phiếu xuất chưa có ngày xuất
		update phieuxuathang
		set ngayMua = '2021-02-16';
        
-- 6.10. Cập nhật đơn giá của “Đồng phục học sinh” giảm 10% trên đơn giá hiện tại.
		update mathang
		set dongia = dongia*0.9
		where TenMH = 'Đồng phục học sinh';
        
-- 6.11. Thực hiện xóa các cửa hàng chưa có thông tin xuất hàng.
		delete from cuahang
		where MaCH not in (
		select maCH
		from phieuxuathang
		);
        
-- 6.12. Liệt kê danh sách các mặt hàng có số lượng xuất hàng thấp nhất: Mã hàng, tên hàng, tổng số lượng xuất.
		select mathang.tenMH , mathang.mamh, count(phieuxuathang_ct.soluong) as 'Số lượng xuất kho'
		from phieuxuathang_ct join mathang on mathang.MaMH = phieuxuathang_ct.maMH
		group by mathang.maMH
		having sum(phieuxuathang_ct.soluong) <= all(
					select sum(phieuxuathang_ct.soluong) 
					from phieuxuathang_ct
					group by MAmh );
        
-- 6.13. Liệt kê những mặt hàng chưa từng xuất cho các cửa hàng, thông tin gồm: Mã mặt hàng, tên mặt hàng, tên loại hàng.
		select mathang.mamh, mathang.tenmh, loaihang.tenloai
		from mathang join loaihang on mathang.maLoai = loaihang.maLoai
		where maMH not in (
		select maMh
		from phieuxuathang_ct	
		);
