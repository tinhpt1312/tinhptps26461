<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. Hình: ${img.name}</h2>
	<img src="/Fpoly3/files/${img.name}" height="100">
	<h2>2. Tài liệu: ${doc.name}</h2>
	<a href="/Fpoly3/files/${doc.name}">Tải về</a>
</body>
</html>