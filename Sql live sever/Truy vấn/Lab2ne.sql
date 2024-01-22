create database QLDA;

use QLDA;

create table phongban(
	tenphg nvarchar(15) not null,
	maphg int not null primary key,
	trphg varchar(9) not null,
	ng_nhanchuc date not null
)

create table dean(	
	tenda nvarchar(15) not null,
	mada int primary key,
	ddiem_da nvarchar(15) not null,
	phong int not null,
	constraint fk_dean_phongban foreign key(phong)
	references phongban(maphg)
)

create table diadiem_phg(
	maphg int not null,
	constraint fk_diadiem_phg_phongban foreign key(maphg)
	references phongban(maphg),
	diadiem nvarchar(15),
	primary key(maphg, diadiem)
)

create table nhanvien(
	honv nvarchar(15) not null,
	tenlot nvarchar(15) not null,
	tennv nvarchar(15) not null,
	manv varchar(9) primary key,
	ngaysinh date not null,
	dchi nvarchar(30) not null,
	phai nvarchar(3) not null,
	luong float not null,
	ma_nql varchar(9),
	constraint fK_nhanvien_nhanvien foreign key(ma_nql)
	references nhanvien(manv),
	phg int not null,
	constraint fk_nhanvien_phongban foreign key(phg)
	references phongban(maphg)
)

create table thannhan(
	ma_nvien varchar(9) not null,
	constraint fk_thannhan_nhanvien foreign key(ma_nvien)
	references nhanvien(manv),
	tentn nvarchar(15),
	primary key(ma_nvien, tentn),
	phai nvarchar(3) not null,
	ngsinh date not null,
	quanhe nvarchar(15) not null
)
create table congviec(
	mada int not null,
	constraint fk_congviec_dean foreign key(mada)
	references dean(mada),
	stt int ,
	primary key(mada, stt),
	ten_cong_viec nvarchar(50) not null
)

create table phancong(
	ma_nvien varchar(9) not null,
	mada int not null,
	stt int not null,
	thoigian float not null,
	primary key(ma_nvien, mada, stt),
	constraint fk_phancong_nhanvien foreign key(ma_nvien)
	references nhanvien(manv),
	constraint fk_phancong_congviec foreign key(mada, stt)
	references congviec(mada, stt)
)
alter table phongban 
add constraint fk_phongban_nhanvien
foreign key(trphg) 
references nhanvien(manv);


/*alter table nhanvien drop constraint fk_nhanvien_phongban;
alter table phongban drop constraint fk_phongban_nhanvien;
alter table nhanvien drop constraint fk_nhanvien_nhanvien;*/


insert into nhanvien
values
(N'Phạm', N'Văn', N'Vinh', '006', '01-01-1965', N'45 Trưng Vương, Hà Nội','Nam', 55000, NULL, 1),
(N'Nguyễn', N'Thạnh', N'Tùng', '005', '08-20-1963', N'22 Nguyễn Văn Cừ, tp HCM', 'Nam',40000, '006', 5),
(N'Đinh', N'Bá', N'Tiên', '009', '02-11-1960', N'119 Cống Quỳnh, tp HCM', 'Nam', 30000, '005', 5),
(N'Lê', N'QUỲNH', N'Như', '001', '02-01-1967', N'291 Hồ Văn Huế, tp HCM', N'Nữ',43000, '006', 4),
(N'Bùi', N'Ngọc', N'Hằng', '007', '03-11-1954', N'323 Nguyễn Thái Ngọc, tp HCM', N'Nữ',25000, '001', 4),
(N'Trần',N'Thanh',N'Tâm', '003', '05-04-1957', N'34 Mai Thị Lự, tp HCM', N'Nữ', 25000, '005', 5);

alter table nhanvien add constraint fk_nhanvien_nhanvien foreign key(ma_nql) references nhanvien(manv);

insert into phongban
values
(N'Nghiên cứu', 5, '005', '05-22-1979'),
(N'Điều hành', 4, '009', '01-01-1985'),
(N'Quản lý', 1, '006', '06-19-1971');

ALTER TABLE phongban 
ADD CONSTRAINT fk_phongban_nhanvien 
FOREIGN KEY (trphg) 
REFERENCES nhanvien (manv);
alter table nhanvien add constraint fk_nhanvien_phongban
foreign key (phg) references phongban(maphg);

alter table phongban add constraint fk_phongban_nhanvien foreign key(trphg) references nhanvien(manv);

select * from phancong;

insert into diadiem_phg
values
(1, 'tp HCM'),
(4, N'Hà Nội'),
(5, N'Vũng Tàu'),
(5,'Nha Trang'),
(5, 'tp HCM');

insert into dean
values
(N'Sản phẩm X', 1, N'Vũng Tàu', 5),
(N'Sản phẩm Y', 2, 'Nha Trang', 5),
(N'Sản phẩm Z', 3, 'tp HCM', 5),
(N'Tin học hóa', 10, N'Hà Nội', 4),
(N'Cáp quang', 20, 'tp HCM', 1),
(N'Đào tạo', 30, N'Hà Nội', 4);

insert into thannhan
values
('005', 'Trinh', N'Nữ', '04-05-1976', N'Con gái'),
('005', 'Khang', 'Nam', '10-25-1973', 'Con Trai'),
('005', N'Phương', N'Nữ', '05-03-1948', N'Vợ chồng'),
('001', 'Minh', 'Nam', '02-29-1932', N'Vợ chông'),
('009', N'Tiến', 'Nam', '01-01-1978', N'Con trai'),
('009', N'Châu', N'Nữ', '12-30-1978', N'Con gái'),
('009', N'Phương', N'Nữ', '05-05-1957', N'Vợ chông');

insert into congviec
values
(1, 1, N'Thiết kế sản phẩm X'),
(1, 2, N'Thử nghiệm sản phẩm X'),
(2, 1, N'Sản xuất sản phẩm Y'),
(2, 2, N'Quảng cáo sản phẩm Y'),
(3, 1, N'Khuyến mãi sản phẩm Z'),
(10, 1, N'Tin học hóa phòng nhân sự'),
(10, 2, N'Tin học hóa phòng kinh doanh'),
(20, 1, N'Lắp đặt cáp quang'),
(30, 1, N'Đào tạo nhân viên marketing'),
(30, 2, N'Đào tạo chuyên viên thiết kế');


insert into phancong
values
('009', 1, 1, 32),
('009', 2, 2, 8),
('003', 1, 1, 20),
('003', 2, 1, 20),
('001', 30, 1, 20),
('001', 20, 1, 15),
('006', 20, 1, 30),
('005', 3, 1, 10),
('005', 20, 1, 10),
('007', 30, 2, 30),
('007', 10, 2, 10);
