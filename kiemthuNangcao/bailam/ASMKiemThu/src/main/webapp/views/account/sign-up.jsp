<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="url" value="/account" />
	<form action="./sign-up" method="POST">
	${message} <br>
		<input value = "${form.id}" name="id">  <br>
		<input value = "${form.password}" name="password" type="password"> <br>
		<input value = "${form.fullname}" name="fullname"> <br>
		<input value = "${form.email}" name="email"> <br>
		<input value = "${form.admin}" name="admin" type="hidden" value="false"><br>
		<hr>
		<button >Đăng ký</button>
	</form>
</body>
</html>