<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-sm-4 poly-prod">
	<div class="card">
		<div class="card-footer">
			<h4 class="card-title text-center">${param.name}</h4>
		</div>
		<div class="card">
			<img src="img/${param.image}" alt="">
		</div>
		<div class="card-footer text-center">${param.price}</div>
	</div>
</div>