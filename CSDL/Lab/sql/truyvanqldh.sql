use qldh_ps26461;

-- 1. Cho biết chi tiết đặt hàng của đơn đặt hàng DH01, hiển thị: MaHH, Tên hàng hóa, đơn vị tính, số lượng đặt, đơn giá.
-- cách 1: dùng phép tính
select hh.MAHH, TENHH, DVT, SLDAT, DONGIAHH
from hanghoa hh, chitietdathang ct
where hh.MAHH = ct.MAHH and MADAT = 'DH01';
-- cách 2: dùng join
select hanghoa.MAHH, TENHH, DVT, SLDAT, DONGIAHH
from hanghoa join chitietdathang on hanghoa.MAHH = chitietdathang.MAHH
where MADAT = 'DH01';

select hanghoa.MAHH, TENHH, DVT, SLDAT, DONGIAHH
from hanghoa inner join chitietdathang on hanghoa.MAHH = chitietdathang.MAHH;


-- 2. Cho biết thông tin những đơn đặt hành trong tháng 2 năm 2021. Hiển thị: Mã đặt hàng, Ngày đặt hàng, tên khách hàng.

-- 3. CHo biết hàng hóa nào có đơn giá hiện hành cao nhất, Hiển thị: tên hàng hóa, đơn giá hiện hành.

-- 4. Cho biết số lần đặt hàng của từng khách hàng, những khách hàng không đặt hàng thì phải hiển thị số lần đặt hàng bằng 0. Hiển thị: Mã khách hàng, tên khách hàng, số lần đặt hàng


-- select khachhang.MAKH, TENKH, count(MADAT) as 'Số lần đặt hàng'
-- from khachhang, dondathang
-- where khachhang.MAKH = dondathang.MAKH
-- group by MAKH;

-- 1. Lọc dnah sách khách hàng chưa mua hàng lần nào
select khachhang.MAKH, TENKH
from khachhang left join dondathang on khachhang.MAKH = dondathang.MAKH
where MADAT is null;
-- Cách 2
select MAKH, TENKH from khachhang
where MAKH not in(
	select MAKH from dondathang
);
-- 1a. Lọc danh sách khách hàng chưa mua hàng lần nào trong năm 2022
select *
from khachhang
where MAKH not in (
	select MAKH from dondathang where year(ngaydat) = 2022
);

-- 2. Thống kê số lượng đặt theo mã hàng: MAHH, TenHH, TongSLDat

select hanghoa.MAHH, TENHH, sum(SLDAT) as 'Tổng số lượng đặt'
from hanghoa join chitietdathang on hanghoa.MAHH = chitietdathang.MAHH
group by MAHH;

-- 3. Cho biết các hàng hóa có số lượng đặt nhiều nhất

select hanghoa.MAHH, TENHH, sum(SLDAT) as 'Tổng số lượng đặt'
from hanghoa join chitietdathang on hanghoa.MAHH = chitietdathang.MAHH
group by MAHH
order by sum(SLDAT) desc
limit 1;
-- cách 2
select hanghoa.MAHH, TENHH, sum(SLDAT) as 'Tổng số lượng đặt'
from hanghoa join chitietdathang on hanghoa.MAHH = chitietdathang.MAHH
group by MAHH
having sum(SLDAT) >= all(
	select sum(SLDAT)
    from chitietdathang
    group by MAHH
);

-- 4. CHo biết hàng hóa có slcon nhiều nhất
-- Cách 1
select mahh, tenhh, slcon
from hanghoa
where slcon = (select max(slcon) from hanghoa);

-- cách 2
select mahh, tenhh, slcon
from hanghoa
where slcon >= all (select slcon from hanghoa);