<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
<body>

	<c:url var="url" value="/account" />
	
	<form action="${url}/sign-in" method="POST">
	<h4><input name="tt" id="tt" value="${message}" disabled="disabled"/></h4>	
<br>
	<input name="username">
	<input name="password">
	<button name="login">Submit</button>
	</form>
</body>
</html>