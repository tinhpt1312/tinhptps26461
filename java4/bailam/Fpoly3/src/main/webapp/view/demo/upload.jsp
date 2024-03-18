<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Upload</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="row col-sm-6">
	     
	</div>
		<div class="row col-sm-6">
			<div class="col">
				<form action="/Fpoly3/upload1"  enctype="multipart/form-data" method="post">
					<div class="custom-file mb-4">
						<label for="image" class="custom-file-label">Image</label> 
						<input type="file" class="custom-file-input" id="image" name="image"/>
					</div>
				
					<div class="custom-file mb-4">
						<label for="document" class="custom-file-label">Document</label> 
						<input type="file" class="custom-file-input" id="document" name="document" />
					</div> 
					<hr/>
					<button class="btn btn-danger">Upload</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>