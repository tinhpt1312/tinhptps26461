
	use QLDA;

	select * into phongban1
	from phongban
	select * into nhanvien1
	from nhanvien
	select * into thannhan1
	from thannhan
	go
	-- 
	create trigger xoaNV
	on nhanvien1
	instead of delete
	as
	begin
		/* Xóa tất cả thân nhân của nhân viên này */
		delete from thannhan1
		where ma_nvien in (select manv from deleted)
		/* Xóa nhân viên */
		delete from nhanvien1 where manv in(select manv from deleted)
	end
	go
	delete from nhanvien1 where manv = '001'

	select * from nhanvien1
	go
	
	/* tạo trigger khi xóa phòng nào thì chuyển nhân viên đó qua phòng 4 */

	create trigger xoaNV_roichuyen
	on phongban1
	instead of delete
	as
	begin
		/* chuyển tất cả nv phòng bị xóa sang phòng 4 */
		update nhanvien1 set phg = 4
		where phg in(select maphg from deleted)
		/* Xóa phòng */
		delete from phongban1 where maphg in (select maphg from deleted)
	end
	delete from phongban1 where maphg = 1
	select phg, manv from nhanvien1
	select * from phongban1

	/* khi chèn vào 1 địa điểm mới trong table DiaDiem_Phong thì hiện ra danh sách mới các địa điểm của phòng đó */
	select * into diadiem_phg1
	from diadiem_phg
	select * from diadiem_phg1
	go
	create trigger trig_diadiem1
	on diadiem_phg1
	instead of insert
	as begin
		insert into diadiem_phg1 
			select * from inserted;
		select * from diadiem_phg1 
		where maphg in (select maphg from inserted)
	end
	go
	insert into diadiem_phg1 values (1, N'Nghệ AN');