
/* Thủ tục có tham số tùy chọn */
create procedure sp_tongHaiso @a int , @b int = 10
	/* @b là tham số tùy chọn */
As
	select @a + @b
go

/* tổng 5 + 7 */
exec sp_tongHaiso 5,7
exec sp_tongHaiso 9

/* Các thủ tục hệ thống */
exec sp_databases -- Xem tất cả database

/* xem tất cả các thủ tục */
exec sp_stored_procedures

/* Xem danh sách các Table */
exec sp_tables

/* Xem thông tin sever */
exec sp_server_info

/* Xem thông tin về đối tượng nào đó */
use QLDA;
exec sp_help phongban
exec sp_help sp_tongHaiso

/* Đổi tên table thannhan thành nhanthan */
exec sp_rename 'thannhan', 'nhanthan'

/* Xem nội dung văn bản của đối tượng */
exec sp_helptext sp_tongHaiso
/* Xem nội dung của thủ tục sp_password */
exec sp_helptext sp_password
go
/* Viết thủ tục nhập vào số nguyên @n. in ra tổng và số lượng các số chẵn từ 1 đến n */
create procedure sp_tongDay @n int
As
	declare @tong int = 0, @sosochan int = 0;
	declare @i int = 0;
	while (@i <= @n) begin
		set @tong = @tong + @i
		set @i = @i + 2
		set @sosochan = @sosochan + 1
	end
	print N'Tổng = ' + cast(@tong as varchar(10))
	print N'Số số chẵn = ' + cast (@sosochan as varchar(10))
go
exec sp_tongDay 100
go

/* Viết thủ tục thêm pb, các giá trị được thêm dưới dạng tham số đầu vào, 
	kiểm tra nếu trùng lặp thì thêm thất bại và ngược lại */
select * from phongban
go
create or alter procedure sp_insertPhong
	@tenphong nvarchar(15), @maphg int, @trphg varchar(9), @ngay date
As
	/* kiểm tra xem phòng đã có chưa */
	if(@maphg in (select maphg from phongban)) 
		begin	print N'Thêm thất bại'
		end
	insert into phongban values
	(@tenphong, @maphg, @trphg, @ngay);
go
exec sp_insertPhong N'Công nghệ', 3, '006', '2023-12-13'
exec sp_insertPhong N'Tạp vụ', 1, '005', '2023-05-29'
go
/* tìm UCLN của a và b */
create procedure sp_Ucln @m int, @n int
as begin
	declare @a int = iif(@m > @n, @m, @n)
	declare @b int = iif(@n > @m, @m, @n)
	while (@a % @b != 0) begin
		declare @t int = @a
		set @a = @b
		set @b = @t % @b
	end
	return @b
end
 -- drop procedure sp_Ucln
/* sử dụng */
declare @k int
exec @k = sp_Ucln 21,18
print @k