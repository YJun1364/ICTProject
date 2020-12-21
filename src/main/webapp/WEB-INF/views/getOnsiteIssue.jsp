<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.spacing {
	height: 40px;
}
</style>

<title>발권확인</title>
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
			<li class="breadcrumb-item">현장발권 확인</li>
		</ol>
	</nav>
	<br>
	<form method="post" action="getOnsiteIssueAction">
	<div class="container">
		<div class="row justify-content-md-center">
			<table class="table" style="margin-top: 50px">
				<thead class="thead-dark text-center" style="font-size: 25px">
					<tr class="text-md text-align-middle">
						<th colspan="2">승객정보</th>
						<th colspan="2">여정</th>

						<th colspan="2">항공권 운임정보</th>
						<th colspan="2">유형정보</th>
					</tr>
				</thead>
				<tbody style="background-color: rgba(255, 255, 255, 0.7)">
					<tr>
						<td>
							<ul class="list-unstyled">
								<li class="spacing" style="font-weight: bold">성</li>
								<li class="spacing" style="font-weight: bold">이름</li>
								<li class="spacing" style="font-weight: bold">성별</li>
								<li class="spacing" style="font-weight: bold">생년월일</li>
								<li class="spacing" style="font-weight: bold">국적</li>
								<li class="spacing" style="font-weight: bold">전화번호</li>
								<li class="spacing" style="font-weight: bold">여권번호</li>							
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing" id="lastNameEng"></li>
								<li class="spacing" id="firstNameEng"></li>
								<li class="spacing" id="gender"></li>
								<li class="spacing" id="birth"></li>
								<li class="spacing" id="nationality"></li>
								<li class="spacing" id="phoneNumber"></li>
								<li class="spacing" id="passport"></li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing" style="font-weight: bold">편명</li>
								<li class="spacing" style="font-weight: bold">출발지</li>
								<li class="spacing" style="font-weight: bold">출발일자</li>
								<li class="spacing" style="font-weight: bold">출발시간</li>
								<li class="spacing" style="font-weight: bold">도착지</li>
								<li class="spacing" style="font-weight: bold">도착일자</li>
								<li class="spacing" style="font-weight: bold">수화물</li>
								<li class="spacing" style="font-weight: bold">좌석</li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing" id="RouteCode"></li>
								<li class="spacing" id="airportCodeDep"></li>
								<li class="spacing" id="dateDep"></li>
								<li class="spacing" id="timeDep"></li>
								<li class="spacing" id="airportCodeArr"></li>
								<li class="spacing" id="dateArr"></li>
								<li class="spacing" id="luggage"></li>
								<li class="spacing" id="seatOrNot"></li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing" style="font-weight: bold">세금</li>
								<li class="spacing" style="font-weight: bold">부가서비스료</li>
								<li class="spacing" style="font-weight: bold">수수료</li>
								<li class="spacing" style="font-weight: bold">총 금액</li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing" id="tax"></li>
								<li class="spacing" id="addtionalFee"></li>
								<li class="spacing" id="commission"></li>
								<li class="spacing" id="totalFee"></li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing" style="font-weight: bold">수면</li>
								<li class="spacing" style="font-weight: bold">업무/대화</li>
								<li class="spacing" style="font-weight: bold">위생관리</li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing" id="sleep"></li>
								<li class="spacing" id="active"></li>
								<li class="spacing" id="clean"></li>
							</ul>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="d-flex justify-content-center" style="margin-top:50px">
				<input type="submit" class="form-control" value="다음">
			</div>
			
		</div>
	</div>	
		<input type="hidden" name="purchaseInfo" id="purchaseInfo"> 
		<input type="hidden" name="passengerInfo" id="passengerInfo"> 
		<input type="hidden" name="airRouteInfo" id="airRouteInfo">
		
		<input type="hidden" name="totalFee" id="totalFeeInput">
	</form>
	<div id="purchaseInfoText" style="display: none">${purchaseInfo}</div>
		<div id="selectRouteCodeText" style="display: none">${selectRouteCode}</div>
		<div id="passengerInfoText" style="display: none">${passengerInfo}</div>
		<div id="airRouteInfoText" style="display:none">${airRouteInfo}</div>	
</body>
<script type="text/javascript">
	var purchaseInfo = $("#purchaseInfoText").text()
	$('#purchaseInfo').attr('value', purchaseInfo);
	var passengerInfo = $("#passengerInfoText").text()
	$('#passengerInfo').attr('value', passengerInfo);
	var airRouteInfo = $("#airRouteInfoText").text()
	$('#airRouteInfo').attr('value', airRouteInfo)

	var passengerVO = JSON.parse(passengerInfo)
	var purchaseVO = JSON.parse(purchaseInfo)
	var airRouteVO = JSON.parse(airRouteInfo)

	var seat = null
	var seatFee = 0
	
	switch (passengerVO.seatOrNot) {
	case "No":
		seat = "좌석선택 안함"
		seatFee = 0;
		break;
	case "Yes":
		seat = "좌석선택"
		seatFee = 10000
	}
	
	var luggage = null
	var luggageFee = 0
	
	switch (passengerVO.luggage) {
	case 1:
		luggage = "15kg 이하(기본제공)"
		luggageFee = 0
		break;
	case 2:
		luggage = "20kg (+10000)"
		luggageFee = 10000
		break;
	case 3:
		luggage = "25kg (+15000)"
		luggageFee = 15000
		break;
	case 4:
		luggage = "30kg (+20000)"
		luggageFee = 20000
		break;
	}	

	$('#lastNameEng').text(passengerVO.firstNameEng)
	$('#firstNameEng').text(passengerVO.lastNameEng)
	$('#gender').text(passengerVO.gender)
	$('#birth').text(passengerVO.birth)
	$('#nationality').text(passengerVO.nationality)
	$('#phoneNumber').text(passengerVO.phoneNumber)
	$('#passport').text(passengerVO.passport)

	$('#RouteCode').text(airRouteVO.routeCode)
	$('#airportCodeDep').text(airRouteVO.airportCodeDep)
	$('#dateDep').text(airRouteVO.dateDep)
	$('#timeDep').text(airRouteVO.timeDep)
	$('#airportCodeArr').text(airRouteVO.airportCodeArr)
	$('#dateArr').text(airRouteVO.dateArr)
	$('#luggage').text(luggage)
	$('#seatOrNot').text(seat)

	//요금에 대한거 정리 못함
	$('#tax').text(airRouteVO.tax)
	$('#addtionalFee').text(luggageFee + seatFee)
	
	$('#commission').text(airRouteVO.commission)
	$('#totalFee').text(airRouteVO.totalRouteFare + luggageFee + seatFee)

	$('#clean').text(passengerVO.clean)
	$('#sleep').text(passengerVO.sleep)
	$('#active').text(passengerVO.active)

	
	$('#totalFeeInput').attr('value',airRouteVO.totalRouteFare + luggageFee + seatFee)
	
</script>
</html>


