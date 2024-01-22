/* 
	Lab 7 - cơ sở dữ liệu
    Ps26461 - Phạm Thế Tình
    Ngày lập 3/12/2022
    
*/

	use ps26461_lab5;

-- 1.  Thêm 1 khách hàng mới (thông tin tự cho).
insert into khachhang values
('NK001','Pham The','Tinh','NgheAn','','0869175278');

 -- 2. Thêm 3 sản phẩm mới (search tìm thông tin sản phẩm)
 insert into sanpham values
 ('SP0013','Nokia1280','290000','100',''),
 ('SP0011','samsung A9','800000','200',''),
 ('SP0012','Vsmart joy3 ','700000','100','');
 
 -- 3. Thêm 1 hóa đơn mới cho khách hàng mới thêm
 insert into hoadon values
 ('HD0001',2/12/2022, '200000','Đã thanh toán','NV001','Nk001');
 
 
  -- 4.  Thêm hóa đơn chi tiết của hóa đơn vừa nhập mua 3 sản phẩm bất kỳ
  insert into hoadonchitiet values
  ('HD006','SP0013','5'),
  ('HD006','SP0011','5'),
  ('HD006','SP0012','4');
  
  -- 5. Tạo 1 bảng có tên KhachHang_Q1 chứa thông tin tin đầy đủ vềcác khách hàng ở Quận 1
  create table KhachHang_Q1
  select *
  from khachhang 
  where DiaChi= 'Quận 1';
  
  -- 6. Cập nhật lại thông tin số điện thoại của khách hàng có mã ‘KH002’ có giá trị mới là ‘16267788989’
  
  update khachhang
  set dienthoai =16267788989
  where maKh= 'KH002';
  
  -- 7. Tăng số lượng mặt hàng có mã ‘SP003’ lên thêm ‘200’ đơn vị
  update sanpham 
  set soluong = soluong +200
   where masp ='SP003';
   
   
   -- 8. Giảm giá cho tất cả sản phẩm giảm 5%
update sanpham
set giasp= giasp - (giasp * 0.5);

 -- 9. Tăng số lượng của mặt hàng bán chạy nhất trong tháng 2/2019 lên 100 đơn vị
 update sanpham
 set SoLuong=SoLuong+100
 where MaSP in(
 select MaSP
 from hoadon join hoadonchitiet on hoadon.MaHD= hoadonchitiet.MaHD
 where month(ngaylaphd)= 2 and year(ngaylaphd)=2019
  group by MaSP
  having  sum(SoLuongMua)>= all (select sum(soluongmua) tongsl
  from hoadon join hoadonchitiet on hoadon.MaHD= hoadonchitiet.MaHD
  where month(ngaylaphd)= 2 and year(ngaylaphd)=2019
  group by MaSP));
  
  -- 10. Giảm giá 10% cho 2 sản phẩm bán ít nhất trong năm 2019
  update sanpham
  set giasp = Giasp * 0.9
  where MaSP in (select masp from(
  select MaSP 
   from  hoadon join hoadonchitiet on hoadon.MaHD= hoadonchitiet.MaHD
   where year(ngaylaphd)=2019
   group by MaSP
   order by sum(SoLuongMua)
   limit 2) as temp);
   
   -- 11. Cập nhật lại trạng thái “chưa thanh toán” cho hoá đơn có mã ‘HD001’
   update hoadon
   set trangthai ='Chưa thanh toán'
   where mahd = 'HD001';
   
   -- 12. Xoá mặt hàng có mã sản phẩm là ‘SP001’ ra khỏi hoá đơn ‘HD001’ 
   delete from sanpham
   where MaSP in(
   select hoadon.MaHD
   from hoadonchitiet join hoadon on hoadon.MaHD= hoadonchitiet.MaHD
   where MaSP = 'SP001' and hoadon.MaHD ='HD001');
   
   -- 13. Xoá khách hàng chưa từng mua hàng kể từ ngày “1-1-2019”
   
   delete from khachhang
   where makh in(
	select *
    from khachhang join hoadon on hoadon.makh = khachhang.makh
    where makh not in (
		select *
        from khachhang join hoadon on hoadon.makh = khachhang.makh
        where makh = 01 and ngaylaphd > '2019-01-01'
    )
   );
   
   

  