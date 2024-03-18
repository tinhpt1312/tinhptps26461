<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhamTheTinh-Lab2</title>
</head>
<body>

	<h1>Tam Giác</h1> <br>
	<form action="/Fpoly2/TamGiacServlet" method="post">
		<input name="a" placeholder="canh a?"><br>
		<input name="b" placeholder="canh b?"><br>
		<input name="c" placeholder="canh c?"><hr>
		<button formaction = "/Fpoly2/dientich">Tinh Dien tich</button>
		<button formaction = "/Fpoly2/chuvi">Tinh Chu vi</button>
	</form>
	<h3>${message}</h3>
</body>
</html>