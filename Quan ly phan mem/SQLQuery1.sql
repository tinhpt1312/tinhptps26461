create database QLKS;
	go
	use QLKS
create table NhanVien (
	 MaNV nvarchar (5) not null primary key,
	 Hoten nvarchar(50) not null,
	 Email nvarchar(30) not null,
	 Diachi nvarchar(225) not null,
	 SĐT nvarchar(20) not null 
 )
 create table TaiKhoan(
	 TenDangNhap nvarchar(5) not null,
	 Matkhau nvarchar(20) not null,
	 VaiTro bit not null,
	foreign key (TenDangNhap) references NhanVien(MaNV)
)
create table KhachHang(
	MaKH nvarchar(10) not null primary key,
	Hoten nvarchar(50) not null,
	CCCD nvarchar(12) not null,
	GioiTinh bit,
	DiaChi nvarchar(225) not null,
	SĐT nvarchar(12) not null, 
	QuocTich nvarchar(50) not null
)
 create table DichVu (
	 MaDV nvarchar(10) not null primary key,
	 TenDV nvarchar(225) not null,
	 Gia float not null,
	 ThongtinDV nvarchar(225) not null
 )
 create table Phong(
	 MaPhong nvarchar(10) not null primary key,
	 MaLoaiPhong nvarchar(10) not null,
	 TinhTrang nvarchar(225) not null, 
	 foreign key (MaLoaiPhong) references LoaiPhong(MaLoaiPhong)
 )
 create table LoaiPhong(
	 MaLoaiPhong nvarchar(10) primary key,
	 TenLP nvarchar(50) not null,
	 Gia float
 )
 create table KieuThue(
	 MaKieuThue int primary key,
	 TenKieuThue nvarchar(20),
	 Gia float
 )
 create table ThietBi (
	 MaTB nvarchar(50) not null primary key,
	 TenTB nvarchar(225) not null,
	 MaLoaiPhong nvarchar(10) not null,
	 SoLuong int not null,
	 foreign key (MaLoaiPhong) references LoaiPhong(MaLoaiPhong)
 )
 create table TraPhong(
	 MaTraPhong nvarchar(5) not null primary key,
	 NgayTra date,
	 PhuThu float
 )
 create table HoaDon (
	 MaHD nvarchar(10) not null primary key,
	 MaNV nvarchar(5) not null,
	 MaKH nvarchar(10) not null,
	 MaPhieuThue nvarchar(10) not null,
	 MaPhieu nvarchar(5) not null,
	 NgaylapHD date not null,
	 NgayxuatHD date not null,
	 TongTien float not null,
	 foreign key (MaNV) references NhanVien(MaNV),
	 foreign key (MaKH) references KhachHang(MaKH),
	 foreign key (MaPhieuThue) references PhieuThuePhong(MaPhieuThue),
	 foreign key (MaPhieu) references PhieuThuDV(MaPhieu)
 )
 create table PhieuThuDV (
	 MaPhieu nvarchar(5) not null primary key, 
	 MaKH nvarchar(10) not null,
	 MaPhong nvarchar(10) not null,
	 foreign key (MaPhong) references Phong(MaPhong),
	 foreign key (MaKH) references KhachHang(MaKH)
 )
 create table PhieuThuePhong (
	 MaPhieuThue nvarchar(10) not null primary key,
	 MaKH nvarchar(10) not null,
	 MaKieuThue int not null,
	 foreign key (MaKH) references KhachHang(MaKH),
	 foreign key (MaKieuThue) references KieuThue(MaKieuThue)
 )
 create table ChiTietPhieuTP(
	 MaPhieuThue nvarchar(10) not null primary key,
	 MaPhong nvarchar(10) not null,
	 MaKH nvarchar(10) not null,
	 HoTenKH nvarchar(30) not null,
	 CCCD nvarchar(12) not null,
	 NgayNhan date not null,
	 NgayTraDuKien date not null,
	 NgayTraThucTe date not null,
	 ThanhTien float,
	 foreign key (MaPhong) references Phong(MaPhong),
	 foreign key (MaKH) references KhachHang(MaKH)
 )
 create table ChiTietPhieuThueDV(
	 MaPhieu nvarchar(5) not null primary key,
	 MaDV nvarchar(10) not null,
	 DonGia float not null,
	 SoLuong int not null,
	 ThanhTien float,
	 foreign key (MaDV) references DichVu(MaDV)
 )
 create table CTHoaDon(
	 MaHD nvarchar(10) not null primary key,
	 MaPhieuThue nvarchar(10) not null,
	 MaPhieu nvarchar(5) not null,
	 MaTraPhong nvarchar(5) not null,
	 PhuThu float,
	 TienPhong float,
	 TienDichVu float,
	 HinhThucTT nvarchar(30),
	 ThanhTien float,
	 foreign key (MaPhieuThue) references ChiTietPhieuTP(MaPhieuThue),
	 foreign key (MaPhieu) references ChiTietPhieuThueDV(MaPhieu)
 )

	  insert into NhanVien values 
	  ('NV01',N'Phạm Thị Thuý Huyền', N'huyen@gmail.com', N'Hải Dương','0909090050'),
	  ('NV02',N'Lê Thanh Trường', N'truong@gmail.com',N'Biên Hoà','0909090096'),
	  ('NV03','Nguyễn Thanh Ngân',N'ngan@gmail.com', N'Bình Định','090909094'),
	  ('NV04','Đỗ Minh Tâm', N'tam@gmail.com',N'Đồng Nai','0909090050'),
	  ('NV05','Phạm Thế Tình', N'tinh@gmail.com', N'Nghệ An','0909090010')

	  go 
	  insert into TaiKhoan(TenDangNhap,Matkhau,VaiTro) values
	  ('NV01','Huyen01@',1),
	  ('NV02','Truong01@',0),
	  ('NV03','Ngan01@',0),
	  ('NV04','Tam01@',1),
	  ('NV05','Tinh01@',0)
	  go 
	   insert into KieuThue values
	  (01,'Theo giờ', 100000),
	  (02,'Qua đêm', 300000),
	  (03,'Theo ngày',550000)
	  go