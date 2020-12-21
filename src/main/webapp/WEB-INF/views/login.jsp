<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<style>
body {
	background-image: url('resources/background/airplane.jpg');
	background-color: #B9B9FF;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<title>로그인</title>
</head>
<body>
	<div class="container" style="margin-top: 300px">
		<div class="row justify-content-center">

			<div class="card text-center" style="width: 30rem; border-radius: 30px;">
				<div class="card-body">
					<h3 class="card-title" style="font-weight:bold">항공 체크인 카운터 시스템</h3>
					<br>
					<form method="post" action=loginAction> 
						<div class="form-group col-md-8 offset-2">
							<input type="text"
								class="form-control text-center" name="staffNum" placeholder="사번">
						</div>
						<div class="form-group col-md-8 offset-2">
							<input type="password"
								class="form-control text-center" name="pw" placeholder="비밀번호">
						</div>
						<br>
						<button type="submit" class="btn btn-primary col-md-8">Submit</button>
					</form>
					<br>
					<h5 class="card-subtitle mb-2 text-muted">CastleWater</h5>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
