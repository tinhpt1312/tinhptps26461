 /* Lab 6 */

 use QLDA;
 -- Ràng buộc khi thêm mới nhân viên thì mức lương phải lớn hơn 15000, nếu vi phạm thì xuất thông báo “luong phải >15000
 go
 create trigger trig_lab61_1
 on nhanvien
 for insert
 as 
	begin 
	declare @luong float
	set @luong = (select luong from inserted)
	if(@luong < 15000)
		begin print N'Lương phải trên 15000'
				rollback transaction
			end
		end
	go
	insert into nhanvien values 
	(N'Phạm', N'Thế', N'Tình', '016', '2010-12-13', N'Hưng Nguyên, Nghệ An', 'Nam', 20000, null, 5)
	go
 -- Ràng buộc khi thêm mới nhân viên thì độ tuổi phải nằm trong khoảng 18 <= tuổi <=65.
 create or alter trigger trig_lab61_2
 on nhanvien
 for insert
 as
	begin
	declare @ngaysinh datetime, @tuoi int
	set @ngaysinh = (select ngaysinh from inserted)
	set @tuoi = year(getdate()) - year(@ngaysinh)
	if(@tuoi <= 18 or @tuoi >= 65)
		begin print N'Độ tuổi k phù hợp'
				rollback transaction
		end
	end
go
insert into nhanvien values
(N'Phạm', N'Thế', N'Tình', '016', '2010-12-13', N'Hưng Nguyên, Nghệ An', 'Nam', 10000000, null, 5);
go
-- Ràng buộc khi cập nhật nhân viên thì không được cập nhật những nhân viên ở TP HCM
	create or alter trigger trig_lab61_3
	 on nhanvien
	 for update
	 as 
		begin 
		declare @dchi nvarchar(60)
		set @dchi = (select dchi from inserted)
		if(@dchi like '%TP hcm')
			begin print N'Phải là nhân viên ngoài TP HCM'
					rollback transaction
				end
			end
		go
	update nhanvien set luong = 2000 where manv like '003'
	go

-- Bài 2
-- Hiển thị tổng số lượng nhân viên nữ, tổng số lượng nhân viên nam mỗi khi có hành động thêm mới nhân viên.
	create trigger trig_lab62_1
	on nhanvien
	after insert
	as
		begin
			select count(case when UPPER(phai) = 'Nam' then 1 end) Nam,
			count(case when UPPER(phai) = N'Nữ' then 1 end) Nữ
			from nhanvien
		end
	go
	insert into nhanvien values
	(N'Phạm', N'Thế', N'Tình', '033', '2000-12-13', N'Hưng Nguyên, Nghệ An', 'Nam', 10000000, null, 5);
	go
-- Hiển thị tổng số lượng nhân viên nữ, tổng số lượng nhân viên nam mỗi khi có hành động cập nhật phần giới tính nhân viên
	create trigger trig_lab62_2
	on nhanvien
	after update
	as
		begin
			select count(case when UPPER(phai) = 'Nam' then 1 end) Nam,
			count(case when UPPER(phai) = N'Nữ' then 1 end) Nữ
			from nhanvien
		end
	go
	select * from nhanvien
	update nhanvien set phai = N'Nữ' where manv like '006'
	go
-- Hiển thị tổng số lượng đề án mà mỗi nhân viên đã làm khi có hành động xóa trên bảng DEAN
	create trigger trig_lab62_2
	on dean
	after delete
	as begin
		select ma_nvien, count(*) as soluong
		from phancong
		group by ma_nvien
	end
	go
-- Xóa nhân thân
	create trigger trig_xoaNT
	on nhanvien
	instead of delete
	as
	begin
		/* Xóa tất cả thân nhân của nhân viên này */
		delete from thannhan
		where ma_nvien in (select manv from deleted)
		/* Xóa nhân viên */
		delete from nhanvien where manv in(select manv from deleted)
	end
	go
	delete from nhanvien where manv = '013'
	go
-- Khi thêm 1 nhân viên mới thì tự động cho nhân viên đó tham gia dean với mada là 1
	create trigger trig_lab63_2
	on nhanvien
	instead of insert
	as begin
			insert into nhanvien select * from inserted
			insert into phancong values((select manv from inserted), 1, 1, 10)
		end
	go

-- Bài thêm:
	create or alter trigger trig_updateLuong
	on nhanvien
	instead of update
	as begin
		if update(luong)
		begin
			declare @luongTang float		
			set @luongTang = (select top 1 inserted.luong - deleted.luong
				from inserted inner join deleted on inserted.manv = deleted.manv)
			update nhanvien set luong = luong + (@luongTang * 2) where 
				manv in (select manv from inserted inner join phongban on inserted.phg = phongban.maphg where manv = trphg)
			update nhanvien set luong = luong + @luongTang where manv in (select inserted.manv from inserted) and 
									manv not in 
												(select manv from inserted inner join phongban on inserted.phg = phongban.maphg where manv = trphg)
		end
	end
	go
	update nhanvien set luong = luong + 0.5
	where nhanvien.phg = 1

			