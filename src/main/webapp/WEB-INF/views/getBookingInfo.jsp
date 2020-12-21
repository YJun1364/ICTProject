<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>예매정보확인</title>
</head>
<body>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">발권</li>
			<li class="breadcrumb-item active">예매조회</li>
			<li class="breadcrumb-item">예매정보</li>
		</ol>
	</nav>
	<br>
	<form method="post" action="setSurveyAction">
	<c:forEach items="${bookingInfo}" var="passenger" varStatus="vs"> 
	<div class="container d-flex justify-content-center">
		<div class="row">
			<div class="col-lg-4 col-md-4" style="">
				<table class="table table-bordered"	style="background-color: rgba(255, 255, 255, 0.7);">
					
					<tr>
						<th colspan="2">승객정보</th>
					</tr>
					
					<tr>
						<th>성</th>
						<td>${passenger.lastNameEng}</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${passenger.firstNameEng}</td>
					</tr>
					<tr>
						<th>성별</th>
						<td>${passenger.gender}</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>${passenger.birth}</td>
					</tr>
					<tr>
						<th>국적</th>
						<td>${passenger.nationality}</td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td>${passenger.phoneNumber}</td>
					</tr>
					<tr>
						<th>승객구분</th>
						<td>${passenger.gender}</td>
					</tr>
					<tr>
						<th>구매번호</th>
						<td>${purchaseInfo.purchaseNum}</td>
					</tr>
					<tr>
						<th>구매일자</th>
						<td>${purchaseInfo.purchaseDate}</td>
					</tr>
					
				</table>
			</div>
			<div class="col-lg-5 col-md-5" style="">
				<table class="table table-bordered"
					style="background-color: rgba(255, 255, 255, 0.7);">
					<tr>
						<th colspan="5">여정</th>
					</tr>
					<tr>
						<th>편명</th>
						<td colspan="2">${bookingRouteInfo.routeCode}</td>
					</tr>
					<tr>
						<th>출발</th>
						<td>${bookingRouteInfo.airportCodeDep}</td>
						<td>${bookingRouteInfo.dateDep},${bookingRouteInfo.timeDep}</td>
					</tr>
					<tr>
						<th>도착</th>
						<td>${bookingRouteInfo.airportCodeArr}</td>
						<td>${bookingRouteInfo.dateArr},${bookingRouteInfo.timeArr}</td>
					</tr>
					<tr>
						<th>수화물</th>
						<td colspan="2">${passenger.luggage}</td>
					</tr>
					<tr>
						<th>좌석</th>
						<td colspan="2">${passenger.seatNumber}</td>
					</tr>
				</table>
				<table class="table table-bordered"
					style="background-color: rgba(255, 255, 255, 0.7);">
					<tr>
						<th colspan="3">항공권 운임 정보</th>
					</tr>
					<tr>
						<th>세금</th>
						<td>${bookingRouteInfo.tax}</td>
					</tr>
					<tr>
						<th>부가서비스료</th>
						<td>${passenger.luggageFee+passenger.seatFee}</td>
					</tr>
					<tr>
						<th>수수료</th>
						<td>${bookingRouteInfo.commission}</td>
					</tr>
					<tr>
						<th>총금액</th>
						<td>${passenger.passengerTotalPrice}</td>
					</tr>
				</table>
			</div>
			<div class="col-lg-3 col-md-3" style="">

				<table class="table table-bordered"
					style="background-color: rgba(255, 255, 255, 0.7);">
					<tr>
						<th colspan="3">유형정보</th>
					</tr>
					<tr>
						<th>수면</th>
						<td>${passenger.sleep}</td>
					</tr>
					<tr>
						<th>업무/대화</th>
						<td>${passenger.active}</td>
					</tr>
					<tr>
						<th>화장실</th>
						<td>${passenger.clean}</td>
					</tr>
				</table>
				<div class="text-center"
					style="background-color: rgba(255, 255, 255, 0.7);">
					여권번호 입력 <input type="text" name="passport${vs.index}" id="passportId"  placeholder="여권번호">
				</div>
				<div class="card text-center" style="width: 15rem;">
					<div class="card-header">유형 정보를 위한 설문 과정 선택</div>
					<div class="card-body">
						<input type="radio" name="survey${vs.index}" value="survey${vs.index}">&nbsp;유형 설문<br>
						<input type="radio" name="survey${vs.index}" value="ticket${vs.index}" checked="checked">&nbsp;발권 확인
						</div>
					<div class="card-footer">
						<input type="submit" value="다음">
					</div>
				</div>
				<br>
				<br>
			</div>
		</div>
	</div>
</c:forEach>
</form>

</body>
</html>