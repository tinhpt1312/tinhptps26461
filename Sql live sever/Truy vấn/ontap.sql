
	
	use ontap;
	
	create table PHIEUNHAP(
		mapn varchar(10) not null primary key,
		ngaylap date not null,
		nhacc nvarchar(50) not null,
		ghichu nvarchar(50) not null,
		
	);

	create table SANPHAM(
		masp varchar(10) not null primary key,
		tensp nvarchar(50) not null,
		slton int null,
		quicach nvarchar(50) null
	);

	create table CT_PNHAP(
		mapn varchar(10) not null,
		masp varchar(10) not null,
		slmua int not null,
		dongia money not null,
		primary key(mapn, masp),
		constraint fk_pn_ct foreign key(mapn) references PHIEUNHAP(mapn),
		constraint fk_sp_ct foreign key(masp) references SANPHAM(masp)
	);

	insert into PHIEUNHAP values
	('PN01', '2023-06-14', N'Công ty TNHH Phương Ngân', N'Hàng dễ vỡ'),
	('PN02', '2022-12-13', N'Công ty TNHH nhựa Long Thành', N'Hàng đúng mẫu mã trên bao bì'),
	('PN03', '2023-04-15', N'Thế giới di động', N'Kiểm tra hàng hóa trước khi nhận');

	insert into SANPHAM values
	('SP01', N'Hoa đà lạt', 100, N'100% nguyên seal, bao bì nhãn mác đầy đủ'),
	('SP02', N'Thùng đá', 1312, N'like new 99%'),
	('SP03', N'Iphone 14 pro max', 50, N'còn đầy đủ hàng từ like new đến nguyên siu');

	insert into CT_PNHAP values
	('PN01', 'SP01', 20, 2000000),
	('PN01', 'SP02', 100, 3210000),
	('PN01', 'SP03', 2, 50100000),
	('PN02', 'SP01', 12, 120000),
	('PN02', 'SP02', 200, 6420000),
	('PN02', 'SP03', 1, 26700000),
	('PN03', 'SP01', 30, 3000000),
	('PN03', 'SP02', 400, 12840000),
	('PN03', 'SP03', 5, 254000000);

	select * from PHIEUNHAP
	select * from SANPHAM
	select * from CT_PNHAP
	go
-- 1.
	create or alter proc sp_themSp @masp varchar(10), @tensp nvarchar(50), @tonkho int, @quicach nvarchar(50)
	as
		insert into SANPHAM values
		(@masp, @tensp, @tonkho, @quicach)
		print N'Thêm thành công'
	go
	exec sp_themSp 'SP04', 'PS4', 10, N'Cục wifi đời mới';
	go

-- 2.	
	create or alter proc sp_timSp @mapn varchar(10)
	as
		begin 
			if(@mapn not in (select mapn from PHIEUNHAP))	print N'Không có phiếu nhập này'
			else
				select pn.mapn, PHIEUNHAP.ngaylap, pn.masp, pn.slmua, (pn.slmua * pn.dongia) as N'Thành tiền'
				from CT_PNHAP pn inner join SANPHAM sp on  pn.masp = sp.masp 
								inner join PHIEUNHAP on pn.mapn = PHIEUNHAP.mapn
				where @mapn = pn.mapn
		end
	go
	exec sp_timSp 'PN01'
	exec sp_timSp 'PN10'
	go

-- 3.
	create or alter proc sp_ngaylap @thoigianmax date , @thoigianmin date
	as 
		begin
		select *
		from PHIEUNHAP where ngaylap between @thoigianmin and @thoigianmax
		end
	go
	exec sp_ngaylap '2023-06-13', '2023-06-17'
	go

-- 4.
	create function fSanPham (@masp varchar(10))
	returns int
	as
	begin
		declare @slsanpham int
		select @slsanpham = sum(slmua) from CT_PNHAP where @masp = masp
		return @slsanpham
	end
	go
	print cast(dbo.fSanPham('SP01') as varchar);
	go
-- 5.
	create or alter function fSlhienco (@masp varchar(10))
	returns int 
	as
	begin 
		declare @slhienco int
		select @slhienco = sp.slton + sum(pn.slmua) from SANPHAM sp inner join CT_PNHAP pn on sp.masp = pn.masp
		group by sp.slton, pn.slmua, sp.masp
		having @masp = sp.masp
		return @slhienco
	end
	go
	print cast(dbo.fSlhienco('SP01') as varchar);
	go
-- 6.
	create view V_xemTop3
	as
		select top 3 sp.masp, sp.tensp, sum(slmua) as N'Tổng lượt mua',(ct.slmua * ct.dongia) as N'Thành tiền'  
		from SANPHAM sp inner join CT_PNHAP ct on sp.masp = ct.masp
		group by sp.masp, sp.tensp, slmua, dongia
		order by sum(slmua) desc
	go
	select * from V_xemTop3
	go
-- 7.
	create view V_xemPN
	as
	select distinct phieunhap.mapn, phieunhap.ngaylap, phieunhap.nhacc
		from PHIEUNHAP inner join CT_PNHAP ct on phieunhap.mapn = ct.mapn
		where phieunhap.mapn in (select top 3 ct.mapn from CT_PNHAP
										group by mapn
										order by sum(slmua) desc)
	go
	select * from V_xemPN
	go
-- 10.
	create or alter function fCau10()
	returns table 
	as
		return select top 1 * from SANPHAM order by slton desc
	go
	select * from dbo.fCau10()
	go

