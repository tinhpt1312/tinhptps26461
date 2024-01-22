

	Create database QLDA;

	use QLDA;

	
	-- Tạo table nhân viên
	create table NHANVIEN(
		honv nvarchar(15) ,
		tenlot nvarchar(15),
		tennv nvarchar(15) ,
		manv nvarchar(9) ,
		ngsinh date ,
		dchi nvarchar(30),
		phai nvarchar(3) ,
		luong float ,
		ma_nql nvarchar(9),
		phg int not null,
		constraint pk_nv primary key(manv)
	);

	-- Tạo table phòng ban
	create table PHONGBAN(
		tenphg nvarchar(15) not null,
		ma_phg int not null,
		trphg nvarchar(9) not null,
		ng_nhanchuc date not null,
		constraint pk_pb primary key(ma_phg),
		constraint fk_pb_nv foreign key (trphg)
		references nhanvien (manv)
	);

	-- Tạo table địa điểm phòng ban
	create table DIADIEM_PHG(
		diadiem nvarchar(15) not null,
		maphg int not null,
		constraint pk_dd primary key(diadiem, maphg),
		constraint fk_dd_pb foreign key (maphg)
		references phongban(ma_phg)
	);

	-- Tạo table đề án
	create table DEAN(
		tenda nvarchar(15) not null,
		mada int not null,
		ddiem_da nvarchar(15) not null,
		phong int not null,
		constraint pk_da primary key (mada),
		constraint fk_da_pb foreign key (phong)
		references phongban(ma_phg)
	);

	-- Tạo table nhân thân
	create table THANNHAN(
		ma_nv nvarchar(9) not null,
		tentn nvarchar(15) not null,
		phai nvarchar(3) not null,
		ngsinh date not null,
		quanhe nvarchar(15) not null,
		constraint pk_tn primary key (ma_nv, tentn),
		constraint fk_tn_nv foreign key(ma_nv)
		references nhanvien(manv)
	);

	-- Tạo table công việc
	create table CONGVIEC(
		mada int not null,
		stt int not null,
		ten_cong_viec nvarchar(50) not null,
		constraint pk_cv primary key(mada, stt),
		constraint fk_cv_da foreign key(mada)
		references dean(mada)
	);

	-- Tạo table phân công
	create table PHANCONG(
		ma_nvien nvarchar(9) not null,
		mada int not null,
		stt int not null,
		thoigian float not null,
		constraint pk_pc primary key(ma_nvien, mada, stt),
		constraint fk_pc_nv foreign key(ma_nvien)
		references nhanvien(manv),
		constraint fk_pc_cv foreign key(mada, stt)
		references congviec(mada, stt)
	);

	
	alter table NHANVIEN 
	add constraint fk_nv_pb foreign key(phg) 
		references phongban (ma_phg);
	 drop database QLDA;

	insert into NHANVIEN values
	(N'Đinh', N'Bá', N'Tiến', '009', 11/02/1960, N'119 Cống Quỳnh, Tp HCM', N'Nam', 30000, 005, 5),
	(N'Nguyễn', N'Thanh', N'Tùng', '005', 20/08/1962, N'222 Nguyễn Văn Cừ, Tp HCM', N'Nam', 40000, 006, 5),
	(N'Bùi', N'Ngọc', N'Hằng', '007', 11/03/1954, N'332 Nguyễn Thái Học, Tp HCM', N'Nam', 25000, 001, 4),
	(N'Lê', N'Quỳnh', N'Như', '001', 01/02/1967, N'291 Hồ Văn Huê, Tp HCM', N'Nữ', 43000, 006, 4),
	(N'Nguyễn', N'Mạnh', N'Hùng', '004', 04/03/1967, N'95 Bà Rịa, Vũng Tàu', N'Nam', 38000, 005, 5),
	(N'Trần', N'Thanh', N'Tâm', '003', 04/05/1957, N'34 Mai Thi Lự, Tp HCM', N'Nam', 25000, 005, 5),
	(N'Trần', N'Hồng', N'Quang', '009', 01/09/1967, N'80 Lê Hồng Phong, Tp HCM', N'Nam', 25000, 001, 4),
	(N'Phạm', N'Văn', N'Vinh', '006', 01/01/1965, N'45 Trưng Vương, Hà Nội', N'Nữ', 55000, null, 1);

	insert into PHONGBAN values
	(N'Nghiên Cứu', 5, '005', 22/05/1978),
	(N'Điều Hành', 4, '008', 01/01/1985),
	(N'Nghiên Cứu', 5, '005', 22/05/1978);

	insert into THANNHAN values
	(005, N'Trinh', N'Nữ', 05/04/1976, N'Con gái'),
	(005, N'Khanh', N'Nam', 25/10/1974, N'Con trai'),
	(005, N'Phương', N'Nữ', 03/05/1948, N'Vợ chồng'),
	(001, N'Minh', N'Nữ', 05/04/1976, N'Con gái'),
	(005, N'Trinh', N'Nữ', 05/04/1976, N'Con gái'),
	(005, N'Trinh', N'Nữ', 05/04/1976, N'Con gái'),
	(005, N'Trinh', N'Nữ', 05/04/1976, N'Con gái');