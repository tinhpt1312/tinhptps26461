<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Đăng ký</h1>

	<form action="/Fpoly2/DangKyServlet" method = "post">
		<label>Username: </label>
		<input name = "username"><br>
		<label>Password: </label>
		<input name = "password" type = "password"> <br>
		<label>Giới tính: </label>
		<input name = "gender" type="radio" value="true"> Nam
		<input name = "gender" type="radio" value="false"> Nữ <br>
		<input name = "married" type = "checkbox"> Đã có gia đình? <br>
		<label>Quốc tịch: </label>
		<select name = "country">
			<option value = "VN"> Việt Nam </option>
			<option value = "US"> United States </option>
		</select><br>
		<label for="">Sở thích</label>
    	<input type="checkbox" name="hobbies" value="R"> Đọc sách
    	<input type="checkbox" name="hobbies" value="T"> Du lịch
    	<input type="checkbox" name="hobbies" value="M"> Âm nhạc
    	<input type="checkbox" name="hobbies" value="O"> Khác <br>
		<label>Ghi Chú: </label>
		<textarea name = "notes" rows="3" cols="30"></textarea><hr>
		<button>Đăng ký</button>
	</form>
</body>
</html>