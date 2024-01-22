/*
	Tạo database Cửa hàng - ASM 2
	Ngày tạo: 4/12/2022
    Người thực hiện: Ps26461- Phạm Thế Tình
*/


  create database if not exists qlpx_ps26461;

  use qlpx_ps26461;

-- Tạo table cửa hàng
	create table cuahang(
		MaCH varchar(10) not null,
        TenCH varchar (30) not null,
        SDT int not null,
        Diachi varchar(150) not null,
        constraint pk_ch primary key(MaCH)
    );
    
-- Tạo table loại hàng
	create table loaihang(
		MaLoai varchar(10) not null,
        TenLoai varchar(30) not null,
        constraint pk_lh primary key(MaLoai)
    );
    
-- Tạo table mặt hàng
	create table mathang(
		MaMH varchar(10) not null,
        DonGia int not null,
        TenMH varchar(20) not null,
        DonViTinh varchar(20) not null,
        MaLoai varchar(10) not null,
        constraint pk_mh primary key(MaMH),
        constraint fk_mh_lh foreign key(maloai) references loaihang(maloai)
    );

-- Tạo table phiếu xuất hàng
	create table phieuxuathang(
		SoPX varchar(10) not null,
        NgayMua date not null,
        NguoiLap varchar(30) not null,
        MaCH varchar(10) not null,
        constraint pk_px primary key(SoPX),
        constraint fk_px_ch foreign key(MaCH) references cuahang(MaCH)
    );
    
    -- Tạo table phiếu xuất hàng chi tiết
	create table phieuxuathang_ct(
		MaMH varchar(10) not null,
        SoPX varchar(10) not null,
        SoLuong int	not null,
        ThanhTien int not null,
        constraint pk_pxct primary key(SoPX, MaMH),
        constraint fk_pxct_px foreign key(SoPX) references phieuxuathang(SoPX),
        constraint fk_pxct_mh foreign key(MaMH) references mathang(MaMH)
    );
    
    
    
    -- Insert thông tin 
		insert into cuahang values
		('CH001','Xuân Tây','0704738009','Quận 12'),
		('CH002','Xuân Đông','0704738008','Quận 11'),
		('CH003','Xuân Bắc','0704738006','Quận 10'),
		('CH004','Xuân Nam','0704738005','Quận 9'),
		('CH005','Thu Tây','0704738004','Quận 8');

		insert into loaihang values
		('LH001','Trái cây'),
		('LH002','Đồ gia dụng'),
		('LH003','Sách vở'),
		('LH004','Mì gói'),
		('LH005','Bánh kẹo');

		insert into mathang values
		('MH001',70000,'Dưa hấu','gram','LH001'),
		('MH002',100000,'Nồi','kg','LH002'),
		('MH003',20000,'Truyện Conan','cuốn','LH003'),
		('MH004',10000,'Mì hảo hảo','thùng','LH004'),
		('MH005',5000,'Bánh flan','cái','LH005');

		insert into phieuxuathang values
		('001','2019-01-15','Tuân','CH001'),
		('002','2019-02-15','Đinh','CH002'),
		('003','2019-03-15','Tuất','CH003'),
		('004','2019-04-15','Thư','CH004'),
		('005','2019-05-15','Toàn','CH005');

		insert into phieuxuathang_ct values
		('MH001','001','5','70000'),
		('MH002','002','10','80000'),
		('MH003','003','15','10000'),
		('MH004','004','17','200000'),
		('MH005','005','19','80000');
