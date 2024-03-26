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
</head>
<body>
	<div class="container">
		<div class="poly-cart">
			<div class="card p-4">
			<div class="card-title text-uppercase text-center py-3">Đăng nhập</div>
			<h3>${message}</h3>
				<form action="/ASMPoly/UserServlet/login" method="post">
					<div class="mb-3 mt-3">
						<label class="form-label">Username: </label> 
						<input type="text" class="form-control" name="username">
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Password:</label> 
						<input type="password" class="form-control" name="password">
					</div>
					<div class="form-check mb-3">
						<label class="form-check-label"> 
						<input class="form-check-input" type="checkbox" name="remember">
							Remember me
						</label>
					</div>
					<button formaction="/ASMPoly/UserServlet/login" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>