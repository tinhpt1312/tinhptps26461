<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 class="text-bg-primary" >Thông tin nhân viên</h1>
	<ul>
		<li>Họ và tên: <b>${bean.fullname}</b></li>
		<li>Ngày sinh: <b>${bean.birthday}</b></li>
		<li>Hình ảnh: <b>${bean.photo}</b></li>
		<li>Giới tính: <b>${bean.gender}</b></li>
		<li>Quốc tịch: <b>${bean.country}</b></li>
		<li>TT hôn nhân: <b>${bean.married}</b></li>
		<li>Sở thích: <b>${bean.hobbies}</b></li>
		<li>Ghi chú: <b>${bean.notes}</b></li>
	</ul>

</body>
</html>