create database qlnhatro
use qlnhatro

create table loainha(
maloai varchar(6) primary key,
tenloai nvarchar(15) not null
)
create table nhatro(
manhatro varchar(6) primary key,
dientich float not null check(dientich > 0),
giaphong float not null check(giaphong > 0),
diachi ntext not null,
quan nvarchar(15) not null,
mota nvarchar(50) null,
ngaydang date not null,
maloai varchar(6) not null,
constraint fk_nhatro_loainha foreign key(maloai)
references loainha(maloai),
manguoidung varchar(6) not null 
/*constraint fk_nhatro_nguoidung foreign key(manguoidung)
references nguoidung(manguoidung)*/
)
create table nguoidung(
manguoidung varchar(6) primary key,
tennguoidung nvarchar(25) not null,
gioitinh nvarchar(5) not null,
dienthoai varchar(12) not null,
diachi ntext not null,
quan nvarchar(15) not null,
email varchar(30) not null
)
create table danhgia(
madanhgia int primary key,
ngaydanhgia date not null,
noidung nvarchar(80) null,
like_dislike bit not null,
manhatro varchar(6) not null ,
constraint fk_danhgia_nhatro foreign key(manhatro)
references nhatro(manhatro),
manguoidung varchar(6) null
constraint fk_danhgia_nguoidung foreign key(manguoidung)
references nguoidung(manguoidung)
)
alter table nhatro 
add constraint fk_nhatro_nguoidung foreign key(manguoidung)
references nguoidung(manguoidung)
insert into loainha
values
('ln001', N'Chung cư'),
('ln002', N'Nhà riêng'),
('ln003', N'Phòng trọ')

insert into nguoidung
values
('nd001', N'Đăng Khôi',N'Nam','084881234', N'12, đường Quang Trung, phường 1',N'Quận 12','khoi1234@gmail.com'),
('nd002', N'Trần Phong',N'Nam','084999999', N'20, đường Quang Trung, phường 10',N'Quận 10','phong1234@gmail.com'),
('nd003', N'Đăng Khải',N'Nam','077881234', N'12, đường Nguyễn Huệ, phường 1',N'Quận 8','khai1234@gmail.com'),
('nd004', N'Khôi Nguyên',N'Nam','0987552234', N'33, đường Quang Trung, phường 4',N'Quận 12','nguyenaa234@gmail.com'),
('nd005', N'Hà Mi',N'Nữ','07719991299', N'9, đường Quang Trung, phường 1',N'Quận 1','miimimimimi@gmail.com'),
('nd006', N'Ngọc Quỳnh',N'Nữ','09191919191', N'12, đường Hà Khiêm, phường 1',N'Quận 10','quynhquanque@gmail.com'),
('nd007', N'Thiên Ân',N'Nữ','089902344', N'12, đường Trung An, phường 1',N'Quận 2','ananaanna@gmail.com'),
('nd008', N'Thúy Huyền',N'Nữ','09999999', N'92, đường Quang Trung, phường 1',N'Quận 12','huyenhahahah@gmail.com'),
('nd009', N'Nguyễn Quốc',N'Nam','0901111111', N'120, đường Quang Trung, phường 10',N'Quận 12','quoc1234@gmail.com'),
('nd010', N'Nguyệt Ánh',N'Nữ','0844445555', N'129, đường Quang Trung, phường 4',N'Quận 12','anh122344@gmail.com')

insert into nhatro
values
('nt001', 10, 1000000, N'120, đường Quang Trung, phường 1',N'Quận 12',N'Đẹp, sạch','05-12-2023', 'ln003', 'nd001'),
('nt002', 8, 800000, N'220, đường Quang Trung, phường 6',N'Quận 12',N'Mới','05-14-2023', 'ln002', 'nd002'),
('nt003', 12, 500000, N'550, đường Nguyễn Huệ, phường 1',N'Quận 9',N'Mới xây','05-10-2023', 'ln001', 'nd008'),
('nt004', 9, 1300000, N'330, đường Quang Trung, phường 5',N'Quận 12',N'Khách mới dọn','05-05-2023', 'ln003', 'nd003'),
('nt005', 11, 1000000, N'20, đường Quang Trung, phường 2',N'Quận 12',N'Sạch','05-01-2023', 'ln003', 'nd004'),
('nt006', 8, 6000000, N'2, đường Hà Khiêm, phường 2',N'Quận 1',N'An toàn','05-01-2023', 'ln001', 'nd005'),
('nt007', 10, 2000000, N'02, đường Quang Trung, phường 2',N'Quận 11',N'Xinh','05-02-2023', 'ln003', 'nd006'),
('nt008', 11, 1000000, N'33, đường Quang Trung, phường 2',N'Quận 12',N'Mới','05-12-2023', 'ln003', 'nd007'),
('nt009', 20, 10000000, N'201, đường Quang Trung, phường 2',N'Quận 10',N'Siu to','05-01-2023', 'ln002', 'nd009'),
('nt010', 5, 400000, N'298, đường Quang Trung, phường 2',N'Quận 12',N'Siu rẻ','05-02-2023', 'ln003', 'nd010')

insert into danhgia
values
(1, '05-20-2023',N'Không thích',0,'nt010','nd001'),
(2, '05-19-2023',N'Tuyệt',1,'nt009','nd002'),
(3, '05-16-2023','ehe',1,'nt008','nd002'),
(4, '05-15-2023',N'Có ma',0,'nt004','nd004'),
(5, '05-13-2023',N'Sáng 1 mình tối 2 mình',0,'nt006','nd005'),
(6, '05-16-2023',N'Không có ma đâu',1,'nt004','nd006'),
(7, '05-17-2023',N'Ngủ ngon lắm', 1,'nt004','nd007'),
(8, '05-18-2023', N'Bị lừa', 0,'nt004','nd008'),
(9, '05-19-2023', N'Hahahaha', 1, 'nt007','nd007'),
(10,'05-20-2023', N'Trọ không đúng mô tả',0,'nt005','nd003')

select * from loainha;
select * from nhatro;
select * from nguoidung;
select * from danhgia;