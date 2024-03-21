<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="poly-cart">
	<div class="card p-4">
		<form action="/Fpoly4/login" method="post">
			<div class="mb-3 mt-3">
				<label for="email" class="form-label">Username: </label> <input
					type="text" class="form-control" value="${username}"
					name="username">
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">Password:</label> <input
					type="password" class="form-control" value="${password}"
					name="password">
			</div>
			<div class="form-check mb-3">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>