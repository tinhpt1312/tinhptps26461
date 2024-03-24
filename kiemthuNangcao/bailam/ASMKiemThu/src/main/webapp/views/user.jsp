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
	<h4><input name="tt" id="tt" value="${message}" disabled="disabled"/></h4>
	<c:url var="url" value="/user" />
	<form action="${url}/index" method="post">
		<input value="${form.id}" name="id" type="text" placeholder="Username" class="id"> <br>
		<input value="${form.password}" name="password" type="text" placeholder="Password" class="pass"><br>
		<input value="${form.fullname}" name="fullname" type="text" placeholder="Fullname" class="fullname"><br>
		<input value="${form.email}" name="email" ="text" placeholder="Email Adress" class="email"><br>
		<input ${form.admin?'checked':''} type="radio" name="admin" value="true" id="1"> Admin
		<input ${form.admin?'':'checked'} type="radio" name="admin" value="false" id="2"> User
		<hr>
		<button formaction="${url}/create" name="create" class="create">Create</button>
		<button formaction="${url}/update" name="update">Update</button>
		<button formaction="${url}/delete" name="delete">Delete</button>
		<a href="${url}/index" name="reset">Reset</a>
	</form>
	<table border="1" style="width:100%">
	<c:forEach var="item" items="${items}">
	<tr>
		<td>${item.id}</td>
		<td>${item.password}</td>
		<td>${item.fullname}</td>
		<td>${item.email}</td>
		<td>${item.admin?'Admin':'User'}</td>
		<td><a href="${url}/edit/${item.id}" name="edit">Edit</a></td>
		<td><a href="${url}/delete/${item.id}">delete</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>