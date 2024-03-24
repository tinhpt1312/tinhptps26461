<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>User Edition</h3>
<h3>${message}</h3>
<form action="/Fpoly4/UserServlet" method="post">
	<div class="mb-3 mt-3">
		<label for="email" class="form-label">Username: </label> <input
			type="text" class="form-control" value="${form.username}" name="username">
	</div>
	<div class="mb-3">
		<label for="pwd" class="form-label">Password:</label> <input
			type="text" class="form-control" value=""
			name="password">
	</div>
	<div class="form-check mb-3">
		<label class="form-check-label"> <input
			class="form-check-input" type="checkbox" name="remember" ${form.remember ? 'checked' : ''}>
			Remember me
		</label>
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>