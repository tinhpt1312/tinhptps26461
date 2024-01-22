/*Tạo database bài bất động sản - Lab4
	Ngày tạo: 16/11/2022
    Người thực hiện: Ps26461- Phạm Thế Tình
*/
-- Tạo database
	create database if not exists qlbds_ps26461;
    
-- Chỉ định cái DB được sử dụng
	use qlbds_ps26461;
-- Xóa db đang có
-- drop database qlbds_ps26461;

-- Tạo table văn phòng
	create table vanphong(
		MaVP int,
        DiaDiem varchar(255),
        constraint pk_vp primary key(MaVP)
	);
-- drop table vanphong;

-- Tạo table nhân viên
	create table nhanvien(
		MaNV int,
		TenNV varchar(50),
		MaVP int,
		constraint pk_nv primary key(MaNV),
        constraint fk_nv_vp foreign key(MaVP) references vanphong (mavp)
    );
    
-- Tạo table nhân thân
	create table nhanthan(
		MaNT int,
        MoiLH varchar(10),
        Ngaysinh date,
        Ten varchar(30),
        constraint fk_nt_nv foreign key(MoiLH) references nhanvien(manv)
    );
    
    -- Tạo table BĐS 
     create table bds(
		MaBDS int,
        Diachi varchar(50),
        constraint pk_bds primary key(mabds)
     );
    
    -- drop table bds
    
    -- Tạo table Chủ sở hữu
	 create table chusohuu(
		MaSohuu int,
        Diachi varchar(50),
        sdt int,
        TenCSH varchar(30),
        MaBDS int,
        constraint pk_csh primary key(masohuu),
        constraint fk_csh_bds foreign key(mabds) references bds(mabds)
     );
     
     -- drop table chusohuu
     
     -- Tạo table duanBDS
      create table duanbds(
		MaNV int,
        MaBDS int,
        Sogio int,
        SoBDS int,
        constraint pk_duanbds primary key(manv, mabds),
        constraint fk_duanbds_nv_bds foreign key(manv, mabds) references nhanvien_bds(manv, mabds)
      );
	-- drop table duanbds
    
    -- Tạo table truong phong
     create table truongphong(
		MaNV int,
        MaTP int,
        TenNV varchar(30),
        constraint pk_truongphong primary key(manv, matp),
        constraint fk_truongphong_nv foreign key(manv, matp) references nhanvien(manv)
     );
     
     -- drop table truong phong
    ALTER TABLE vanphong
    add column nv_tp int,
    add constraint fk_sp_nv_tp foreign key(nv_vp) references nhanvien(manv);
    
    alter table vanphong
    add constraint uni_nv_tp unique(nv_tp);
    
    -- Thêm cột số CMND vào table nhân viên và thêm ràng buộc unique
    alter table nhanvien
    add column SoCMND int,
    add constraint uni_nv_socmnd unique(cmnd);
    
    -- Đổi kiểu dữ liệu của cột MaNV
    alter table nhanvien
    modify column manv varchar(7);
    
    -- Thêm cột giới tính cho table nhân viên
    alter table nhanvien
    add column GioiTinh varchar(10);
    
    -- Xóa ràng buộc khóa ngoại của table Nhân thân với Nhân viên
    alter table nhanthan
    drop constraint fk_nt_nv;
    
    -- Xóa table nhân thân
    drop table nhanthan;
    