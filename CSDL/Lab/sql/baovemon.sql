/*
	Bảo vệ môn cơ sở dữ liệu
    ca thi 1 - ngày 14/12/2022
    Phạm Thế Tình - Ps26461
*/

-- Tạo database quản lý bài hát
	
    create database if not exists COM2012_ps26461_qlbaihat;
    
    use com2012_ps26461_qlbaihat;
    
    create table loaibaihat(
		MaTL varchar(4) not null,
        TenTL varchar(50) not null,
        constraint pk_lbh primary key(MaTL)
    );
    
    create table baihat(
		MaBH varchar(4) not null,
        TenBH varchar(50) not null,
        LoiBH varchar(200) not null,
        NhacSi varchar(30) not null,
        TheLoai varchar(4) not null,
        constraint pk_bh primary key(MaBH),
        constraint fk_bh_lbh foreign key(TheLoai) references loaibaihat(MaTL)
    );
    
    
    
    -- Insert thông tin
    
		insert into loaibaihat values
        ('TL01', 'Trữ Tình'),
        ('TL02', 'Cổ Điển'),
        ('TL03', 'POP'),
        ('TL04', 'Bolero'),
        ('TL05', 'Cách mạng');
        
        insert into baihat values
        ('BH01', 'Dấu chân địa đàng', 'Chưa có lời', 'Trịnh Công Sơn', 'TL01'),
        ('BH02', 'Chiều một mình qua phố', 'Chưa có lời', 'Trịnh Công Sơn', 'TL01'),
        ('BH03', 'Gõ cửa trái tim', 'Chưa có lời', 'Vĩnh Sử', 'TL04'),
        ('BH04', 'Cầu tre kỉ niệm', 'Chưa có lời', 'Vĩnh Sử', 'TL04'),
        ('BH05', 'Bay', 'Chưa có lời', 'Nguyễn Hải Phong', 'TL03');