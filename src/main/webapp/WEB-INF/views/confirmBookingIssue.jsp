<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include><!DOCTYPE html>
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
			<li class="breadcrumb-item active">예매조회</li>
			<li class="breadcrumb-item active">예매정보</li>
			<li class="breadcrumb-item">예매정보확인</li>
		</ol>
	</nav>
	<br>
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
								<li class="spacing" style="font-weight: bold">예약번호</li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing">${passengerInfo.lastNameEng}</li>
								<li class="spacing">${passengerInfo.firstNameEng}</li>
								<li class="spacing">${passengerInfo.gender}</li>
								<li class="spacing">${passengerInfo.birth}</li>
								<li class="spacing">${passengerInfo.nationality}</li>
								<li class="spacing">${passengerInfo.phoneNumber}</li>
								<li class="spacing">${passengerInfo.passport}</li>
								<li class="spacing">${purchaseInfo.purchaseNum}</li>
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
								<li class="spacing" style="font-weight: bold">예약상태</li>
								<li class="spacing" style="font-weight: bold">수화물</li>
								<li class="spacing" style="font-weight: bold">좌석</li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing">${bookingRouteInfo.routeCode}</li>
								<li class="spacing">${bookingRouteInfo.airportCodeDep}</li>
								<li class="spacing">${bookingRouteInfo.dateDep}</li>
								<li class="spacing">${bookingRouteInfo.timeDep}</li>
								<li class="spacing">${bookingRouteInfo.airportCodeArr}</li>
								<li class="spacing">${bookingRouteInfo.dateArr}</li>
								<li class="spacing">${purchaseInfo.paymentStatus}</li>
								<li class="spacing">${passengerInfo.luggage}</li>
								<li class="spacing">${passengerInfo.seatNumber}</li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing" style="font-weight: bold">세금</li>
								<li class="spacing" style="font-weight: bold">부가서비스료</li>
								<li class="spacing" style="font-weight: bold">수수료</li>
								<li class="spacing" style="font-weight: bold">총 금액</li>
								<li class="spacing" style="font-weight: bold">결제정보</li>
							</ul>
						</td>
						<td>
							<ul class="list-unstyled">
								<li class="spacing">${bookingRouteInfo.tax}</li>
								<li class="spacing">${passengerInfo.luggageFee+passengerInfo.seatFee}</li>
								<li class="spacing">${bookingRouteInfo.commission}</li>
								<li class="spacing">${passengerInfo.passengerTotalPrice}</li>
								<li class="spacing">${purchaseInfo.paymentStatus}</li>
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
								<li class="spacing">${passengerInfo.sleep}</li>
								<li class="spacing">${passengerInfo.active}</li>
								<li class="spacing">${passengerInfo.clean}</li>
							</ul>
						</td>
					</tr>
				</tbody>
			</table>
			<form action="setSeatSelectionUI" method="post">
				<input type="hidden" name="seatNumber" value="${passengerInfo.seatNumber}">
				<button type="submit" class="btn btn-secondary btn-lg">다음</button>
			</form>
		</div>
	</div>
</body>
</html>