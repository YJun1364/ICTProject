<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
body {
	background-image: url('resources/background/airplane.jpg');
	background-color: #B9B9FF;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<title>현장발권</title>
</head>
<body>
 
<%
    String name = request.getParameter("name");  
%> 
	<nav class="navbar navbar-expand-lg navbar-light bg-light" id="nav">
		<a class="navbar-brand"><span>CW solution</span></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<!-- 			<span class="navbar-toggler-icon"></span> -->
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><form method="get" action="mainUI"
						 id="main">
						<a class="nav-link" id="n1" href="#">Main <span class="sr-only">(current)</span>
						</a>
					</form></li>
				<li class="nav-item"><form method="get"
						action="searchRoutePassengerListUI"
						id="searchRoutePassengerListUI">
						<a class="nav-link" data-toggle="collapse" href="#"
							data-target="#collapse" id="n2">예매현황</a>
					</form></li>
				<li class="nav-item"><form method="get"
						action="getAirRouteInfoUI" id="getAirRouteInfoUI">
						<a class="nav-link" id="n3" href="#">노선정보</a>
					</form></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 발권 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<form method="get" action="searchAirRouteUI" id="searchAirRouteUI">
							<a class="dropdown-item" id="n4" href="#">현장발권</a>
						</form>
						<form method="get" action="searchBookingInfoUI"
							id="searchBookingInfoUI">
							<a class="dropdown-item" id="n5" href="#">예매승객발권</a>
						</form>

					</div></li>
				<li class="nav-item"><form method="get" action="aircraftUI"
						id="aircraft">
						<a class="nav-link" id="n6" href="#">항공기정보</a>
					</form></li>

			</ul>
			<form method="get" action="logout" class="form-inline my-2 my-lg-0">
				<a><%=name %> </a>&nbsp;&nbsp;&nbsp;
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">로그아웃</button>		
			</form>
		</div>
	</nav>
</body>
</html>
<script>
	$('#n1').click(function() {
		$('#main').submit();
	});
	$('#n2').click(function() {
		$('#searchRoutePassengerListUI').submit();
	});
	$('#n3').click(function() {
		$('#getAirRouteInfoUI').submit();
	});
	$('#n4').click(function() {
		$('#searchAirRouteUI').submit();
	});
	$('#n5').click(function() {
		$('#searchBookingInfoUI').submit();
	});
	$('#n6').click(function() {
		$('#aircraft').submit();
	});
</script>

