
	/* Biến đổi kiểu: cast, convert */
	print 'today is ' + cast(getdate() as varchar(40))
	print 'today is ' + cast(varchar(40), getdate())

	/* Hàm chuỗi */
	select SUBSTRING('ngon ngu C', 6, 3)

	/* Hàm ngày tháng 
		datepart(part_type, date): trích thông tin ngày tháng
		dateadd(part_type, value, date)
		dateiff(part_type, start_date, end_date)
	*/

	select datepart(year, getdate())
	select datepart(month, getdate())
	select datepart(day, getdate())
	select datepart(week, getdate())

	select datename(month, getdate())
	select datename(weekday, getdate())

	/* 10 ngày sau của ngày hôm nay là ngày nào */
	select cast(dateadd(week, 10, getdate()) as date )
	/* 15 tháng sau của ngày hôm nay là */
	select dateadd(month, 15, getdate())

	/* 60 ngày sau của hôm nay */
	declare @d date
	set @d = dateadd(day, 60, getdate())
	select @d

	/* Từ hôm nay đến @d 18/7/23 có bao nhiêu tuần */
	select datediff(week, getdate(), @d)

