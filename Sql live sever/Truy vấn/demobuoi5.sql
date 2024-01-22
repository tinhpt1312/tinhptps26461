

	declare @n int;
	set @n = 4.56

	-- cast chuyển đổi biến từ int sang varchar
	print 'Gia tri n = ' +cast(@n as varchar(3));
	print cast(getdate() as time);

	-- convert có chức năng tương tự cast nhưng phương thức khác với cast
	print 'Today is ' + convert(varchar(30), getdate());

	declare @d date;
	set @d = GETDATE();
	print convert(varchar(30), @d, 107);

	-- Hàm chuỗi
	declare @s nvarchar(30) = 'Bài tap java';
	-- LTRIM(S), RTRIM(S), TRIM(S)
	select '"' + trim(@s) + '"';
	-- Hàm thay thế
	select REPLACE(cast(pi() as dec(9,2)), '.', ',');
	-- REPLACE (search, Find, replace)
	-- thay thế các ' ' trong @s thành '#'
	select REPLACE(@s, ' ', '#');
	-- Đổi @s sang bài Tập java
	select lower(left(@s, 4)) + upper(substring(@s, 5, 3)) + lower(right(@s, 5));
	-- Hàm tìm kiếm
	-- CHARINDEX(Find, search)
	-- Tìm vị trí của chữ tập trong @s
	select CHARINDEX('tap', @s);
	-- Đổi sang chữ hoa, chữ thường
	select upper(@s);
	select lower(@s);
	-- Chiều dài chuỗi
	select len(@s);
	-- Lấy ra chữ bài
	select LEFT(@s, 3);
	-- Lấy ra chữ java
	select RIGHT(@s, 4);
	-- Lấy ra chữ tập
	select SUBSTRING(@s, 5, 3);

	use QLDA;
	select tenda, CEILING(sum(thoigian)) as N'Tổng số giờ'
	from phancong pc inner join congviec cv on pc.mada = cv.mada inner join dean da on cv.mada = da.mada
	group by tenda;