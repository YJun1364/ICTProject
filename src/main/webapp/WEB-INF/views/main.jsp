<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인메뉴</title>
</head>
<body>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a>메인</a></li>
		</ol>
	</nav>
	<form>
		<div class="d-flex justify-content-center" style="margin-top: 100px">
			<div class="card-deck col-md-10 d-flex justify-content-center">
				<div class="card" style="background-color: rgba(255, 255, 255, 0.7)">
					<div class="card-header">
						<h5 class="card-title text-center">예매 현황</h5>
					</div>
					<img src="resources/images/main/d.png"
						class="card-img-top rounded-circle" alt="...">
					<div class="card-body"></div>
					<div class="card-footer text-center">
						<a href="searchRoutePassengerListUI"
							class="btn btn-primary btn-lg">예매 승객 조회</a>
					</div>
				</div>
				<div class="card" style="background-color: rgba(255, 255, 255, 0.7)">
					<div class="card-header">
						<h5 class="card-title text-center">노선 정보</h5>
					</div>
					<div class="card-body">
						<br> <br> <img src="resources/images/main/a.png"
							class="card-img-top rounded-circle" alt="...">
					</div>
					<div class="card-footer text-center">
						<a href="getAirRouteInfoUI" class="btn btn-primary btn-lg">노선
							조회</a>
					</div>
				</div>
				<div class="card" style="background-color: rgba(255, 255, 255, 0.7)">
					<div class="card-header">
						<h5 class="card-title text-center">발권</h5>
					</div>
					<div class="card-body">
						<br> <br> <br> <img
							src="resources/images/main/b.png" class="card-img-top rounded"
							alt="...">
					</div>
					<div class="card-footer text-center">
						<a href="searchBookingInfoUI" class="btn btn-primary btn-lg">예매
							발권</a> <a href="searchAirRouteUI" class="btn btn-primary btn-lg">현장
							발권</a>
					</div>
				</div>
				<div class="card" style="background-color: rgba(255, 255, 255, 0.7)">
					<div class="card-header">
						<h5 class="card-title text-center">항공기 정보</h5>
					</div>

					<div class="card-body">
						<br> <br> <img src="resources/images/main/c.jpg"
							class="card-img-top rounded" alt="...">
					</div>
					<div class="card-footer text-center">
						<a href="aircraftUI" class="btn btn-primary btn-lg">항공기 조회</a>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- Modal -->
	<div class="modal fade" id="errorModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">error</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">${message}
					<button type="button" class="btn btn-primary col-lg-2"
						data-dismiss="modal" style="float: right;">Close</button>
				</div>
			</div>
		</div>
	</div>
	<div id="error" style="display: none">${error}</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
    if($('#error').text()){
    	$('#errorModal').modal();
    }
});
</script>
</html>