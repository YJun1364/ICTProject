<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노선정보조회화면</title>
</head>
<body>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item">노선정보 조회</li>
		</ol>
	</nav>
	<br>
	<div class="container">
		<div class="row">
			<div class="col" style="margin-top: 100px">
				<div class="container">
					<div class="row justify-content-md-center">
						<div class="col">
							출발지 <select class="custom-select col-sm-2" name="airportCodeDep"
								id="airportCodeDep">
								<option value="ICN">인천(ICN)</option>
								<option value="PVG">상하이(PVG)</option>
								<option value="CJU">제주(CJU)</option>
								<option value="GUM">괌(GUM)</option>
								<option value="CDG">파리(CDG)</option>
								<option value="GMP">김포(GMP)</option>
								<option value="CEB">세부(CEB)</option>
								<option value="JFK">뉴욕(JFK)</option>
								<option value="YVR">밴쿠버(YVR)</option>
								<option value="LHR">런던(LHR)</option>
								<option value="PRG">프라하(PRG)</option>
								<option value="BKI">코타키나발루(BKI)</option>
								<option value="KWJ">광주(KWJ)</option>
								<option value="SPN">사이판(SPN)</option>
								<option value="BCN">바르셀로나(BCN)</option>
								<option value="FCO">로마(FCO)</option>
								<option value="SYD">시드니(SYD)</option>
								<option value="TAE">대구(TAE)</option>

							</select> 도착지 <select class="custom-select col-sm-2" name="airportCodeArr"
								id="airportCodeArr">
								<option value="ICN">인천(ICN)</option>
								<option value="PVG">상하이(PVG)</option>
								<option value="CJU">제주(CJU)</option>
								<option value="GUM">괌(GUM)</option>
								<option value="CDG">파리(CDG)</option>
								<option value="GMP">김포(GMP)</option>
								<option value="CEB">세부(CEB)</option>
								<option value="JFK">뉴욕(JFK)</option>
								<option value="YVR">밴쿠버(YVR)</option>
								<option value="LHR">런던(LHR)</option>
								<option value="PRG">프라하(PRG)</option>
								<option value="BKI">코타키나발루(BKI)</option>
								<option value="KWJ">광주(KWJ)</option>
								<option value="SPN">사이판(SPN)</option>
								<option value="BCN">바르셀로나(BCN)</option>
								<option value="FCO">로마(FCO)</option>
								<option value="SYD">시드니(SYD)</option>
								<option value="TAE">대구(TAE)</option>
							</select> 출발일자 <input type="date" name="dateDep" id="dateDep"
								class="col-sm-2">
							<button id="search">조회</button>
						</div>
					</div>
				</div>
				<br> <br>
				<div class="container">
					<div class="row justify-content-md-center">
						<div class="col" style="text-align: center">
							<table class="table table-bordered"
								style="background-color: rgba(255, 255, 255, 0.7)">
								<thead class="thead-dark">
									<th>편명</td>
									<th>출발일자</th>
									<th>출발시간</th>
									<th>출발지</th>
									<th>도착일자</th>
									<th>도착시간</th>
									<th>도착지</th>
									<th>상태</th>
									<th>탑승게이트</th>
									<th>잔여좌석</th>
								</thead>
								<tbody id="airRouteList">
									<c:forEach items="${airRouteInfoList}" var="airRoute">
										<tr>
											<td>${airRoute.routeCode}</td>
											<td>${airRoute.dateDep}</td>
											<td>${airRoute.timeDep}</td>
											<td>${airRoute.airportCodeDep}</td>
											<td>${airRoute.dateArr}</td>
											<td>${airRoute.timeArr}</td>
											<td>${airRoute.airportCodeArr}</td>
											<td>${airRoute.flightStatus}</td>
											<td>${airRoute.gate}</td>
											<td>${airRoute.reservationSeat}</td>
										</tr>
									</c:forEach>
									<tr>
										<td><div class="airRouteList"></div></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>

//	$(function() {
		$("#search").on("click",function() {
					var airportCodeDep = $("#airportCodeDep").val();
					var airportCodeArr = $("#airportCodeArr").val();
					var dateDep = $("#dateDep").val();
					//console.log(airportCodeDep+airportCodeArr+dateDep)
					$.ajax({
						url : "getAirRouteInfoAction",
						data : {
							"airportCodeDep" : airportCodeDep,
							"airportCodeArr" : airportCodeArr,
							"dateDep" : dateDep
						},
						method : "POST",
						datatype : "json",
						success : function(resData) {
							var parseData=JSON.parse(resData)
							var airRouteList=parseData.resultJSON

							var list = "";
							for ( var i in airRouteList) {
								if(airRouteList[i].flightStatus==null)
									airRouteList[i].flightStatus="";
								
								list += "<tr><td>" + airRouteList[i].routeCode
										+ "</td>"
								list += "<td>" + airRouteList[i].dateDep
										+ "</td>"
								list += "<td>" + airRouteList[i].timeDep
										+ "</td>"
								list += "<td>" + airRouteList[i].airportCodeDep
										+ "</td>"
								list += "<td>" + airRouteList[i].dateArr
										+ "</td>"
								list += "<td>" + airRouteList[i].timeArr
										+ "</td>"
								list += "<td>" + airRouteList[i].airportCodeArr
										+ "</td>"
								list += "<td>" + airRouteList[i].flightStatus
										+ "</td>"
								list += "<td>" + airRouteList[i].gate + "</td>"
								list += "<td>"
										+ airRouteList[i].reservationSeat
										+ "</td></tr>"
							}
							$("#airRouteList").html(list);
						}
					});
				});
//});
	</script>
</body>
</html>

	
