<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현장발권</title>
</head>
<body>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">발권</li>
			<li class="breadcrumb-item active">현장 발권</li>
			<li class="breadcrumb-item active">구간 운임 선택</li>
			<li class="breadcrumb-item active">탑승자 정보 입력</li>
			<li class="breadcrumb-item active">부가 서비스 선택</li>
			<li class="breadcrumb-item active">현장발권 확인</li>
			<li class="breadcrumb-item active">결제</li>
			<li class="breadcrumb-item">티켓출력</li>
		</ol>
	</nav>
	<div class="container" style="margin-top: 100px">
		<div class="row justify-items-center">
			<div class="card bg text-black" style="border-radius: 100px">
				<img src="resources/images/main/ticket.jpg" class="card-img"
					style="border-radius: 30px">
				<div class="card-img-overlay">
					<br> <br> <br>
					<div class="row">
						<div class="col">
							<p class="card-subtitle" style="margin-left: 90px">${passengerInfo.lastNameEng}/${passengerInfo.firstNameEng}</p>
							<p class="card-subtitle" style="margin-left: 90px">${routeInfo.airportCodeDep}</p>
						</div>
						<div class="col">
							<p class="card-subtitle" style="margin-left: 250px">${passengerInfo.lastNameEng}/${passengerInfo.firstNameEng}</p>
							<p class="card-subtitle" style="margin-left: 250px">${routeInfo.airportCodeDep}</p>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<br>
							<p class="card-subtitle" style="margin-left: 90px">${routeInfo.timeDep}</p>
						</div>
						<div class="col">
							<p class="card-subtitle" style="margin-left: 250px">${routeInfo.airportCodeArr}</p>
							<p class="card-subtitle" style="margin-left: 250px">${routeInfo.dateDep}</p>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<p class="card-subtitle" style="margin-left: 80px">${routeInfo.routeCode}/${routeInfo.dateDep}</p>
						</div>
						<div class="col">
							<p class="card-subtitle">TO ${routeInfo.airportCodeArr}</p>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5">
							<p class="card-subtitle"
								style="margin-left: 140px; margin-top: 10px; font-size: 1rem">${routeInfo.timeDep}-30min</p>
						</div>
						<div class="col">
							<p class="card-subtitle" style="font-size: 2rem">${routeInfo.gate}</p>
						</div>
						<div class="col">
							<p class="card-subtitle"
								style="font-size: 1.5rem; margin-left: 150px">${passengerInfo.seatNumber}</p>
						</div>
						<div class="col">
							<p class="card-subtitle"
								style="font-size: 1.5rem; margin-left: 50px">${routeInfo.routeCode}</p>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<br> <br>
							<p class="card-subtitle"
								style="margin-left: 90px; font-size: 0.7rem">${passengerInfo.ticketNum}</p>
							<p class="card-subtitle"
								style="margin-left: 45px; font-size: 0.8rem">${passengerInfo.seatNumber}/${routeInfo.airportCodeDep}</p>
						</div>
						<div class="col">
							<br> <br>
							<p class="card-subtitle"
								style="margin-left: 300px; font-size: 1rem">${passengerInfo.ticketNum}</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="d-flex justify-content-center">
		<input type="submit" style="margin-top: 100px"
			class="form-control col-md-2" value="출력" id="submitButton">
	</div>
	<!-- Modal -->
		<div class="modal fade" id="ticketPrint" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">발권 완료</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">티켓 출력 완료!
					<button type="button" class="btn btn-primary col-lg-2"
							data-dismiss="modal" style="float: right;" id="nextButton">Next</button></div>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript">
	$('#submitButton').click(function() {
		$('#ticketPrint').modal();
	})
	
	$('#nextButton').click(function() {
		location.href = "mainUI";
	})
</script>

</html>