<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="container">
	<form action="/Fpoly3/staff" method="post" enctype="multipart/form-data">
		Họ và tên: <input name="fullname" class="form-control"><br> 
		Ngày sinh: <input name="birthday" class="form-control"><br> 
		Hình ảnh: <input name="photo_file" type="file" class="form-control"><br>
		Quốc tịch: <select name="country" class="form-control">
			<option value="VN">Việt Nam</option>
			<option value="US">United States</option>
		</select><br> 
		Giới tính: <input name="gender" type="radio" value="true">Nam
		<input name="gender" type="radio" value="false">Nữ<br> 
		TT hôn nhân: <input name="married" type="checkbox">Đã có gia đình?<br>
		 Sở thích: <input name="hobbies" type="checkbox" value="R">Đọc sách 
		 		<input name="hobbies" type="checkbox" value="T">Du lịch 
		 		<input name="hobbies" type="checkbox" value="M">Âm nhạc 
		 		<input name="hobbies" type="checkbox" value="O">Khác<br> 
		 		Ghi chú: <textarea name="notes" rows="3" cols="30"  class="form-control"></textarea>
		<hr>
		<button>Thêm mới</button>
	</form>
</body>
</html>