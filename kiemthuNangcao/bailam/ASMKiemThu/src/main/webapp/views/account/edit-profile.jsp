<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${message}
	<c:url var="url" value="/account"/>
	<form action="${url}/edit-profile" method="POST">
		Username: <input name="id" value="${user.id}"> <br>
		Password: <input name="password" value="${user.password}"><br>
		Fullname: <input name="fullname" value="${user.fullname}"><br>
		Email: <input name="email" value="${user.email}"><br>
		<input name="admin" type="hidden" value="${user.admin}"><br>
		<button formaction="${url}/edit-profile">Submit</button>
</form>	
</body>
</html>