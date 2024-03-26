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
<title>ASM Java 4</title>
</head>
<body>
	<div class="container">
		<header>
			<div id="demo" class="carousel slide" data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#demo" data-bs-slide-to="0"
						class="active"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/ASMPoly/img/bg1.png" class="d-block" style="width: 100%">
					</div>
					<div class="carousel-item">
						<img src="/ASMPoly/img/bg2.png" class="d-block" style="width: 100%">
					</div>
					<div class="carousel-item">
						<img src="/ASMPoly/img/bg3.jpg" style="width: 100%">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#demo" data-bs-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#demo" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
			</div>
		</header>

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item "><a class="nav-link" href="#">Trang
								chủ</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Giới
								thiệu</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown">Tài khoản</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="/ASMPoly/view/user/login.jsp">Đăng nhập</a></li>
								<li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>
								<li><a class="dropdown-item" href="#">Đăng ký thành
										viên</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="#">Đăng xuất</a></li>
								<li><a class="dropdown-item" href="#">Đổi mật khẩu</a></li>
								<li><a class="dropdown-item" href="#">Cập nhật hồ sơ</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="row">
			<article class="col-9">
                <h3>List Video</h3>
                <div class="row">
                    
                    <div class="col-4">
                        <h3>Video Title</h3>
                        <div class="card">
                        <img src="#" alt="">
                        </div>
                        <div class="d-flex justify-content-between">
                            <h5>0 views</h5>
                            <h5>0 share</h5>
                        </div>
                    </div>

                    <div class="col-4">
                        <h3>Video Title</h3>
                        <div class="card">
                        <img src="#" alt="">
                        </div>
                        <div class="d-flex justify-content-between">
                            <h5>0 views</h5>
                            <h5>0 share</h5>
                        </div>
                    </div>

                    <div class="col-4">
                        <h3>Video Title</h3>
                        <div class="card">
                        <img src="#" alt="">
                        </div>
                        <div class="d-flex justify-content-between">
                            <h5>0 views</h5>
                            <h5>0 share</h5>
                        </div>
                    </div>
                    
                </div>
            </article>

			<aside class="col-3"></aside>
			
		</div>
		
	</div>
</body>
</html>