<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container card text-center">
		<div class="card">
			<div class="card-header">
				<b>${item.name}</b>
			</div>
			<img class="card-img-top" src="view/img/${item.image}">
			<div class="card-body">
				Giá gốc: <strike>${item.price}</strike> <br>
				Giá mới:
				<c:set var="newprice" value="${item.price*(1-item.disscount)}" />
				<fmt:formatNumber value="${newprice}" /><br>
				Mức giá:
				<c:choose>
					<c:when test="${newprice< 10}">Giá thấp</c:when>
					<c:when test="${newprice> 100}">Giá cao</c:when>
					<c:otherwise>Bình thường</c:otherwise>
				</c:choose>
			</div>
			<div class="card-footer">
				Ngày: ${item.date}
			</div>
		</div>
	</div>
</body>
</html>