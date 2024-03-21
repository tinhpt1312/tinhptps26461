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
<title>Document</title>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form class="container card p-4" action="${pageContext.request.contextPath}/MailServlet" method = "post">
		<h3>Send Email</h3>
		<!-- <div class="form-floating mb-3">
            <input type="text" class="form-control" >
            <label for="floatingInput">From: </label>
        </div> -->
		<div class="form-floating mb-3">
			<input type="text" name="nguoinhan" class="form-control"> 
			<label for="floatingInput">To: </label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" class="form-control" name = "tieude"> 
			<label for="floatingInput">Subject: </label>
		</div>
		<div class="form-floating">
			<textarea class="form-control" placeholder="Leave a comment here"
				id="floatingTextarea2" style="height: 100px" name = "noidung"></textarea>
			<label for="floatingTextarea2">Comments</label>
		</div>
		<hr>
		<button class="btn btn-success col-1" type="submit">Send</button>
	</form>
</body>
</html>