<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="container">
	<header class="row">
		<div class="col-6">
			<h1>Online shopping mall</h1>
			<h5>The center point of the professional programming</h5>
		</div>
		<div class="col-6  d-flex justify-content-end">
			<h1>logo</h1>
		</div>
	</header>
	<%@include file="menu.jsp"%>
	<div class="row mt-2">
		<article class="col-sm-9 row">
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="iphone" />
				<jsp:param name="image" value="1.jpg" />
				<jsp:param name="price" value="1000$" />
			</jsp:include>
			
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="iphone" />
				<jsp:param name="image" value="1.jpg" />
				<jsp:param name="price" value="1000$" />
			</jsp:include>
			
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="iphone" />
				<jsp:param name="image" value="1.jpg" />
				<jsp:param name="price" value="1000$" />
			</jsp:include>
			
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="iphone" />
				<jsp:param name="image" value="1.jpg" />
				<jsp:param name="price" value="1000$" />
			</jsp:include>
			
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="iphone" />
				<jsp:param name="image" value="1.jpg" />
				<jsp:param name="price" value="1000$" />
			</jsp:include>
			
			<jsp:include page="item.jsp">
				<jsp:param name="name" value="iphone" />
				<jsp:param name="image" value="1.jpg" />
				<jsp:param name="price" value="1000$" />
			</jsp:include>

		</article>
		<aside class="col-sm-3">
			<%@include file="login.jsp"%>
			<hr>
			<%@include file="category.jsp"%>
		</aside>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>