<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include><!DOCTYPE html>
<html>
<head>

</head>
<body>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">발권</li>
			<li class="breadcrumb-item active">현장발권</li>
			<li class="breadcrumb-item active">구간운임선택</li>
			<li class="breadcrumb-item active">탑승자정보입력</li>
			<li class="breadcrumb-item active">부가서비스선택</li>
			<li class="breadcrumb-item active">현장발권확인</li>
			<li class="breadcrumb-item">결제</li>
		</ol>
	</nav>


	<div class="jumbotron align-self-center col-md"
		style="background-color: rgba(255, 255, 255, 0.7); margin: 150px auto; border-radius: 30px; padding: 30px; width: 700px">
		<form method="post" action="confirmPaymentAction" id="actionForm">
			<h2 class="text-center" style="font-weight: bold">일반결제정보</h2>
			<br>
			<h6>${purchaseName.lastNameEng}/${purchaseName.firstNameEng}</h6>
			항공편:
			<h6 id="routeCode"></h6>
			총금액:
			<h6 id="totalFare"></h6>
			<br>

			<h1 style="font-size: 1.3rem; font-weight: bold" aria-pressed="true">신용/체크
				카드 및 계좌이체</h1>
			<br>
			<button type="button" class="btn btn-outline-dark"
				aria-pressed="true" name="confirm" >신용카드</button>
			<button type="button" class="btn btn-outline-dark"
				aria-pressed="true" name="confirm">해외 신용카드</button>
			<button type="button" class="btn btn-outline-dark"
				aria-pressed="true" name="confirm" >실시간 계좌이체</button>

			<br> <br>
			<h1 style="font-size: 1.3rem; font-weight: bold">간편결제</h1>
			<button type="button" class="btn btn-outline-dark">
				<img src="resources/images/main/kakao.jpg" class="img-fluid">
			</button>
			<br> <br> <br> <br> <button onclick="paymentOK()"
				 type="button" class="btn btn-outline-dark btn-lg" id="payment"
				style="margin-left: 270px" aria-pressed="true" value="결제">결제</button> 
				<input
				type="hidden" name="purchaseInfo" id="purchaseInfo"> <input
				type="hidden" name="passengerInfo" id="passengerInfo"> <input
				type="hidden" name="airRouteInfo" id="airRouteInfo">

		</form>
		<!-- Modal -->
		<div class="modal fade" id=paymentOKModal data-backdrop="static"
			data-keyboard="false" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">결제 완료창</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						결제가 완료 되었습니다.
						<button type="button" class="btn btn-primary col-lg-2"
							onclick="submit()" data-dismiss="modal" style="float: right;">다음</button>
					</div>
				</div>
			</div>
		</div>
		<div id="purchaseInfoText" style="display: none">${purchaseInfo}</div>
		<div id="airRouteInfoText" style="display: none">${airRouteInfo}</div>
		<div id="passengerInfoText" style="display: none">${passengerInfo}</div>
	</div>
	
</body>
<script>
	
	var purchaseInfo = $("#purchaseInfoText").text();
	$('#purchaseInfo').attr('value', purchaseInfo);
	console.log(purchaseInfo);
	var passengerInfo = $("#passengerInfoText").text();
	$('#passengerInfo').attr('value', passengerInfo);

	var airRouteInfo = $("#airRouteInfoText").text();
	$('#airRouteInfo').attr('value', airRouteInfo);

	var passengerVO = JSON.parse(passengerInfo);
	var purchaseVO = JSON.parse(purchaseInfo);
	var airRouteVO = JSON.parse(airRouteInfo);

	$('#purchaseName').text(
			purchaseVO.firstNameEng + "/" + purchaseVO.lastNameEng);
	$('#routeCode').text(airRouteVO.routeCode);
	$('#totalFare').text(passengerVO.passengerTotalPrice);
	console.log(passengerVO.passengerTotalPrice)

	function paymentOK() {		
		$('#paymentOKModal').modal();		
	}
	function submit(){
		$('#actionForm').submit();
	}
</script>

</html>
