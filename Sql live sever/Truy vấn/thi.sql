
	use COM2034_ps26461_PhamTheTinh;

	create table DETAI(
		madt char(4) primary key,
		tendt nvarchar(50) not null,
		kinhphi money,
		noithuctap nvarchar(50)
	);

	create table HUONGDAN(
		masv int primary key,
		madt char(4),
		magv int,
		ketqua Decimal(5,2),
		constraint fk_hd_dt foreign key (madt) references DETAI(madt)
	);

	insert into DETAI values
	('DT01', 'GIS', 100, N'Nghệ An'),
	('DT02', 'ARC GIS', 500, N'Nam Định'),
	('DT03', 'Spatial DB', 100, N'Hà Tĩnh'),
	('DT04', 'MAP', 300, N'Quảng Bình');

	insert into HUONGDAN values
	(1, 'DT01', 13, 8.00),
	(2, 'DT03', 14, 0.00),
	(3, 'DT03', 12, 10.00),
	(5, 'DT04', 14, 7.00),
	(6, 'DT01', 13, null),
	(7, 'DT04', 11, 10.00),
	(8, 'DT03', 15, 6.00);

	-- Truy vấn các yêu cầu
	-- 1.
		select * from DETAI
		go
		create or alter view VI_MaxKinhPhi
		as
			select top 1 madt, tendt, kinhphi from DETAI order by kinhphi desc
		go
		select * from VI_MaxKinhPhi
		go
	-- 2. 
		create or alter function fThuctap (@madt char(4))
		returns table
		as
			return select * from HUONGDAN where madt = @madt
		go
		select * from dbo.fThuctap('DT03')
		go
	-- 3. 
		create proc sp_noithuctap @dchithuctap nvarchar(50)
		as
			begin
				if(@dchithuctap not in (select noithuctap from DETAI)) print N'Không tìm thấy địa chỉ này'
				else
					select * from DETAI where @dchithuctap = noithuctap
			end
		go
		exec sp_noithuctap N'Nghệ An'
		exec sp_noithuctap N'TP HCM'
		go
	-- 4.
		create or alter trigger trig_xoasv
		on HUONGDAN
		instead of delete
		as
				if(1 in(select masv from deleted))
				begin
					print N'Chỉ được xóa sinh viên có mã sinh viên khác 1'
					rollback transaction
				end
		go
		delete from HUONGDAN where masv = 1
		select * from HUONGDAN where ketqua is null
