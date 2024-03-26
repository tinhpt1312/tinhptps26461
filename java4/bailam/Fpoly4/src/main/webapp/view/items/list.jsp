<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

</head>
<body>

	<div class="container row">
		<c:forEach var="item" items="${items}">
			<div class="card col-4 text-center">
				<div class="card-header">
					<b>${item.name}</b>
				</div>
				
				<div class="card-body">
				<img class="card-img-top" src="view/img/${item.image}">
					


				</div>
				<div class="card-footer">
					<strike>${item.price}</strike> <b> <c:set var="newprice"
							value="${item.price*(1-item.disscount)}" /> <fmt:formatNumber
							value="${newprice}" /><br>
					</b>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>