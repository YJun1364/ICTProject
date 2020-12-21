<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include>	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>승객리스트 조회</title>
</head>
<body>
	
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">예매현황</li>
			<li class="breadcrumb-item">승객리스트 조회</li>
		</ol>
	</nav>
	<br>
	<br>
	<table class="text-center col-lg-9 table table-bordered" style="left: 240px; margin-top:70px">
		<thead class="thead-dark">
			<tr>
				<th>편명</th>
				<th>출발일자</th>
				<th>출발시간</th>
				<th>출발지</th>
				<th>도착일자</th>
				<th>도착시간</th>
				<th>도착지</th>
				<th>상태</th>
				<th>탑승게이트</th>
				<th>잔여좌석</th>
			</tr>
			<tbody style="background-color: rgba(255, 255, 255, 0.7)">
			<tr>
				<td>${routeInfo.routeCode}</td>
				<td>${routeInfo.dateDep}</td>
				<td>${routeInfo.timeDep}</td>
				<td>${routeInfo.airportCodeDep}</td>
				<td>${routeInfo.dateArr}</td>
				<td>${routeInfo.timeArr}</td>
				<td>${routeInfo.airportCodeArr}</td>
				<td>${routeInfo.flightStatus}</td>
				<td>${routeInfo.gate}</td>
				<td>${routeInfo.reservationSeat}</td>
			</tr>
		</tbody>
	</table>
	<br>
	<br>
	<table class="text-center col-lg-9 table table-bordered" style="left: 240px">
		<thead class="thead-dark">
			<tr>
				<th colspan="9">승객리스트 현황</th>
			</tr>
		</thead>
		<tbody style="background-color: rgba(255, 255, 255, 0.7)">
			<tr class="text-center">
				<th>탑승자 번호</th>
				<th>이름</th>
				<th>성별</th>
				<th>항공권 번호</th>
				<th>생년월일</th>
				<th>휴대전화</th>
				<th>체크인상태</th>
				<th>체크인</th>
			</tr>
			<c:forEach items="${passengerList}" var="passenger" varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td>${passenger.lastNameEng}/${passenger.firstNameEng}</td>
				<td>${passenger.gender}</td>
				<td>${passenger.ticketNum}</td>
				<td>${passenger.birth}</td>
				<td>+ ${passenger.phoneNumber}</td>
				<td>${passenger.checkIn}</td>
				<td>
				<c:if test="${passenger.checkIn=='N'}">
				<form method="post" action="checkInRoutePassengerAction">
				<input type="hidden" name="routeCode" value="${routeInfo.routeCode}">
				<input type="hidden" name="ticketNum" value="${passenger.ticketNum}">
				<input type="submit" value="체크인">
				</form>
				</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>