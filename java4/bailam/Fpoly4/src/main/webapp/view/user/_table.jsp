<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>User List</h3>
<table border="1" style="width: 100%;" class="table table-bordered text-center">
	<thead>
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Remember?</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${items[0].username}</td>
			<td>${items[0].password}</td>
			<td>${items[0].remember ? 'Yes' : 'No'}</td>
		</tr>
		
		<tr>
			<td>${items[1].username}</td>
			<td>${items[1].password}</td>
			<td>${items[1].remember ? 'Yes' : 'No'}</td>
		</tr>
		
		<tr>
			<td>${items[2].username}</td>
			<td>${items[2].password}</td>
			<td>${items[2].remember ? 'Yes' : 'No'}</td>
		</tr>
	
	</tbody>
</table>