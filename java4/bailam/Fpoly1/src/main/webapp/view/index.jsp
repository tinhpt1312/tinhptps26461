<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Java 4</h1>
	<h3>Phone: ${phone}</h3>
	<h3>FullName: ${hoten}</h3>
	<form action="/Fpoly1/helloservlet">
		<input name = "sdt">
		<input name = "fullname">
		<button>Submit</button>
	</form>
</body>
</html>