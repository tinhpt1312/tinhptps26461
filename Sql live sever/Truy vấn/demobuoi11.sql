
	/* tạo */
	create table temp
	(id int, ten varchar(30), phong int, luong float, diachi varchar(20));
	/* trigger
		DDL trigger */
	go
	create Table t1 (ma int)
	alter table t1 add ten varchar(30)
	drop table t1
	go
	/* DML trigger */
	/* triger thực hiện khi chèn/ xóa/ sửa
	Create Trigger <tên Trigger>
	On <tên Table>
	For Insert/Delete/Update
	As
		Đoạn code sql
	*/
	/* Trigger Insert */
	Create trigger insertTemp
	on temp
	for insert
	as
		select * from inserted
		select * from deleted
	go
	select * from temp;

	insert into temp values
	(1, 'tuan', 1, 6000, 'hcm');

	insert into temp values
	(2, 'lan', 1, 6500, 'hcm'),
	(3, 'binh', 2, 8500, 'hcm');
	go
	/* Update Trigger */
	Create trigger updateTemp
	on temp
	for update
	as
		select * from inserted
		select * from deleted
	go

	update temp set luong = 10000 where id = 2
	go

	/* Delete Trigger */
	Create trigger deleteTemp
	on temp
	for delete 
	as
		select * from inserted
		select * from deleted
	go

	delete from temp where id = 3;
	go

	/* Áp dụng */
	/* chỉ cho phép chèn lương > 5000 */
	Create trigger trig_kiemtraLuong
	on temp
	for insert
	as
		/* if(select luong from inserted) < 5000 */
		if(exists (select luong from inserted where luong < 5000))
		begin
			print N'Lương phải trên  5000'
			/* Hủy bỏ lệnh chèn */
			rollback transaction
		end;
	go
	
	insert into temp values (4, 'Hoa', 2, 4500, 'ha noi');
	insert into temp values (5, 'Hoang', 2, 8500, 'nghe an');

	insert into temp values
	(6, 'Tinh', 3, 10000, 'Nghe An'),
	(7, 'Tuyen', 4, 4500, 'Nghe An');
	select * from temp
	go

	/* Chỉ cho phép xóa nv ở HN */
	Create or alter trigger trig_deleteHN
	on temp
	for delete 
	as
		if('Nghe An' not in (select diachi from deleted))
		begin
			print N'Không thể xóa nhân viên không ở HN'
			rollback transaction
		end
	go

	delete from temp where diachi = 'nghe an';
	go

	/* Trigger thực hiện sau khi chèn / xóa / sửa
	Create Trigger <tên trigger>
	on <tên table>
	after Insert/ Delete/ Update
	As 
		đoạn code sql ...
	*/

	insert into temp values
	(3, 'lan' , 2 , 6000, 'hcm'),
	(9, 'hien', 2, 16000, 'ha noi'),
	(8, 'tung', 1, 22000, 'ha noi');
	go
	/* Tạo trigger tính tổng lương các nhân viên vừa chèn vào */
	create trigger trig_xemTongluong
	on temp
	after insert
	as	
		select sum(luong) as N'Tổng lương' from inserted
	go

	insert into temp values
	(11, 'quang', 2 , 7800, 'hue'), (12, 'dung', 1, 12000, 'hue');

