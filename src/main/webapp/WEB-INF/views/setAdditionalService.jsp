<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부가 서비스 선택</title>
</head>
<body>


	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">발권</li>
			<li class="breadcrumb-item active">현장발권</li>
			<li class="breadcrumb-item active">구간운임선택</li>
			<li class="breadcrumb-item active">탑승자정보입력</li>
			<li class="breadcrumb-item">부가서비스선택</li>
		</ol>
	</nav>

	<div class="container align-self-center"
		style="margin-top: 30px; margin-bottom: 20px;">
		<div class="text-center">
			<h2>부가서비스</h2>
		</div>
		<form action="setAdditionalServiceAction" method="post">
			<div class="container">

				<div class="row justify-content-lg-center">
					<!-- 1인당 폼 -->

					<div>
						<span style="font-size: 2em;">탑승자1</span>&nbsp;&nbsp; 설문 참여&nbsp;
						YES<input type="radio" id="survey" name="survey" value='Y' checked="checked"> 
						NO<input type="radio" id="survey" name="survey" value='N'> 
					</div>
					<table class="table table-bordered "
						style="border-radius: 30px; margin-top: 30px; margin-bottom: 50px;">
						<thead class="thead-dark text-center" style="font-size: 15px">
							<tr class="text-md text-align-middle">
								<th colspan="4">구간 1</th>
								<!-- 구간2(왕복선택시) -->
							</tr>
						</thead>
						<tbody class="text-center"
							style="background-color: rgba(255, 255, 255, 0.7)">
							<tr>
								<td colspan="2">수화물</td>
								<td colspan="2"><select
									class="custom-select custom-select-sm" style="margin-top: 5px"
									name="luggage">
										<option value="1" selected>15kg 이하 (기본제공)</option>
										<option value="2">20kg (+10000)</option>
										<option value="3">25kg (+15000)</option>
										<option value="4">30kg (+20000)</option>
								</select></td>
							</tr>
							<!-- 사전좌석 어떤식으로 선택들어갈건지 -->
							<tr>
								<td colspan="2">좌석 선택</td>
								<td colspan="2"><select
									class="custom-select custom-select-sm" style="margin-top: 5px"
									name="seatOrNot">
									<option value="No" selected>선택안함</option>
										<option value="Yes">선택</option>
										
								</select></td>
							</tr>
						</tbody>
					</table>
					<!-- submit button -->

				</div>
				<div class="d-flex justify-content-center">
					<input type="submit" class="form-control col-md-2" value="다음">

				</div>

			</div>
			<input type="hidden" name="purchaseInfo" id="purchaseInfo">
			<input type="hidden" name="passengerInfo" id="passengerInfo">
			<input type="hidden" name="selectRouteCode" id="selectRouteCode">
			<input type="hidden" name="passengerId" id="passengerId">
		</form>
	</div>
	<div id="purchaseInfoText" style="display: none">${purchaseInfo}</div>
	<div id="selectRouteCodeText" style="display: none">${selectRouteCode}</div>
	<div id="passengerInfoText" style="display: none">${passengerInfo}</div>
	<div id="passengerIdText" style="display: none">${passengerId}</div>
	<!-- 		1.서버의 값을 받아주는 역할 -->


</body>
<script type="text/javascript">
	var purchaseInfo = $("#purchaseInfoText").text()
	$('#purchaseInfo').attr('value', purchaseInfo);
	console.log(purchaseInfo)
	var passengerInfo = $("#passengerInfoText").text()
	$('#passengerInfo').attr('value', passengerInfo);
	console.log(passengerInfo)
	var selectRouteCode = $("#selectRouteCodeText").text()
	$('#selectRouteCode').attr('value', selectRouteCode);
	var passengerId = $("#passengerIdText").text()
	$('#passengerId').attr('value', passengerId);
	
</script>
</html>	


