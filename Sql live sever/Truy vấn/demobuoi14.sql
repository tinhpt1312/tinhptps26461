-- View
-- Tạo view xem thông tin nhân viên: 
	-- manv, tennv, tenphong, luong, thuetn = 10% luong
	use QLDA;
	go
	create view v_xemThongtinLuong
	as
		select manv, tennv, tenphg, luong, luong*0.1 as 'ThueTn'
		from nhanvien nv inner join phongban pb on nv.phg = pb.maphg
	go

	/* Dùng view như 1 table */
	select * from v_xemThongtinLuong where luong > 30000

	/* update view: sửa lương của 005 --> 200000 */
	update v_xemThongtinLuong set manv = '005' where luong = 200000
	go
	/* tạo view cho biết số thân nhân của từng nhân viên tennv, soth */
	create view V_sothannhan
	as
		select tennv, count(ma_nvien) as 'SothanNhan' 
		from thannhan tn inner join nhanvien nv on tn.ma_nvien = nv.manv
		group by tennv
	go
	select * from V_sothannhan