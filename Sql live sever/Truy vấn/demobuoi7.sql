
	
	declare @n int = 8
	if(@n%2 = 0)begin
		print cast(@n as varchar) + N' là số chẵn'
	end else
	begin
		print cast(@n as varchar) + N' là số lẻ'
	end;
	go

	-- điểm -> giỏi/ khá/ tb/ yếu
	declare @diem float = 9
	if(@diem >= 9) 
		print N' học lực giỏi'
	else if(@diem >= 7)
		print N' học lực khá'
			else if (@diem >=5)
				print N' học lực TB'
					else print N'học lực yếu'
	go

	-- nếu lương tb của toàn nhân viên > 40000 --> Lương TB cao ngược lại k cao
	use QLDA;
	-- declare @luong = select AVG(luong) from nhanvien;
	if((select AVG(luong) from nhanvien) > 40000)
		print N'Lương TB cao'
		else print N'Lương TB thấp'
	go

	-- Khai báo biến @phai nếu là nam xuất ds nam và ngược lại

	declare @phai nvarchar(4) = 'Nam'
	if(@phai like N'Nam') begin
		select * from nhanvien where phai = 'Nam'
	end else
	begin
		select * from nhanvien where phai = N'Nữ'
	end

	-- Xuất ra danh sách các nv có lương > 30000, nếu k có xuất ra k có
	if(exists(select * from nhanvien where luong > 60000)) begin
		select * from nhanvien where luong > 30000
	end else
	begin
		print N'Không có nhân viên nào'
	end

	/* Hàm iif(<điều kiện>, giá trị 1, giá trị 2)*/
	print iif(10<5, 'A', 'B');

	/* Xuất ra manv, tennv, phái. nếu phái nam thêm anh trước và ngược lại */
	
	select manv, iif(phai = 'Nam', 'Anh ' + tennv, N'Chị ' + tennv), phai
	from nhanvien;

	/* Cho biết số Nam, số Nữ của công ty */
	select SUM(iif(phai = 'Nam' , 1, 0)) as N'Số Nam', 
		   SUM(iif(phai = N'Nữ' , 1, 0)) as N'Số Nữ'
	from nhanvien;

	/* Cấu trúc case */
	/* Dạng 1
		case (biểu thức)
			when <giá trị 1> then giá trị trả về
			when <giá trị 2> then giá trị trả về
			...
			else <giá trị trả về>
		end
	*/

	declare @n int = 8;
	select case (@n % 2)
			when 1 then N'Số lẻ'
			when 0 then N'Số chẵn'
		end;
	/* Dạng 2
		case
			when (biểu thức logic) then giá trị trả về
			when (biểu thức logic) then giá trị trả về
			...
			else <giá trị trả về>
		end
	*/

	/* Case với update */
	create table phucapchucvu(
		ma int primary key,
		chucvu varchar(10),
		phucap float
	);
	insert into phucapchucvu values
	(1, 'ql' ,null),
	(2, 'nv' ,null),
	(3, 'tp' ,null),
	(4, 'nv' ,null);
	select * from phucapchucvu;
	/* sửa cột phụ cấp như sau : 
			ql --> 1000
			nv --> 200
			tp --> 500
	*/
	update phucapchucvu
	set phucap = case 
					when (chucvu = 'ql') then 1000
					when (chucvu = 'tp') then 500
					else 200
				end;
	go;
	/* Tính tổng 1 -> 10 */
	declare @n int = 0;
	declare @s int = 0;
	while(@n < 10)
	begin
		set @n = @n + 1;
		-- if @n = 5 break; => 10
		if @n = 5 continue;
		set @s = @s + @n;
	end
	print N'Tổng = ' + cast(@s as varchar);
	go

	begin try
		print 1 + 'sql';
		print 'Khong co loi';
	end try
	begin catch
		select ERROR_NUMBER(), ERROR_MESSAGE(), ERROR_LINE();
	end catch
	go

	-- Lab 4
	declare @chia float
	begin try
		set	@chia = 10/0
	end try
	begin catch 
		declare @err_mss nvarchar(2000)
		declare @err_state int
		declare @err_severity int
		select @err_mss = error_number(),
			   @err_severity = ERROR_SEVERITY(),
			   @err_state = ERROR_STATE()
		raiserror(@err_mss, @err_severity, @err_state)
	end catch
	go