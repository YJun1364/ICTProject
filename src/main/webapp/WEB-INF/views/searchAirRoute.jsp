<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현장발권</title>
</head>
<body>
	<nav id="nav"></nav>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">발권</li>
			<li class="breadcrumb-item active">현장발권</li>
			<li class="breadcrumb-item" >구간운임선택</li>
		</ol>
	</nav>
	<br>
	<br>
	<div class="jumbotron jumbotron-fluid col-md-8"
		style="background-color: rgba(255, 255, 255, 0.7); border-radius: 30px; margin-left: 300px; margin-top: 80px">

		<form method="post" action="selectAirRouteAction">

			<h1 style="text-align: center">노선검색</h1>
			<div class="container" style="margin-top:">
				<div class="row justify-content-md-left" style="margin-left: 200px">
					<div class="custom-control custom-radio col-md-2 col-lg-2">
						<input type="radio" id="categoryO" name="category"
							class="routeRadio" value="O" required="required">편도
					</div>
					<div></div>
					<div class="custom-control custom-radio col-md-2 col-lg-2">
						<input type="radio" id="categoryR" name="category"
							class="routeRadio" value="R" required="required">왕복
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row justify-content-md-center" style="margin-top: 10px">

					<div class="col col-sm-2 col-lg-2">
						출발지<select class="custom-select custom-select-sm"
							id="airportCodeDep" name="airportCodeDep" style="margin-top: 5px">
							<option selected>Departure</option>
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
						</select>
					</div>
					<div class="col col-sm-2 col-lg-2">
						도착지<select class="custom-select custom-select-sm"
							id="airportCodeArr" name="airportCodeArr" style="margin-top: 5px">
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
						</select>
					</div>
					<div class="col col-sm-2 col-lg-2">
						출발일<input type="date" class="form-control" name="dateDep" id="dateDep">
					</div>
					<div class="col col-sm-2 col-lg-2">
						<div id="dateArrDiv" style="display: none">
							도착일<input type="date" class="form-control" name="dateArr" id="dateArr">
						</div>
					</div>
				</div>
			</div>
			<br> <br>
			<div class="container">
				<div class="row justify-content-md-center">
					<div class="col-lg-8">
						<div class="row">
							<div class="col-sm-2">
								성인<input type="number" class="form-control" min="0" max="9" id="numAdult" name="numAdult" value='1' pattern="[0-9]{1}" onfocus="this.value='입력';" required="required">
							</div>
							<div class="col-sm-2 offset-sm-1">
								소아<input type="number" class="form-control" min="0" max="9" id="numChild" name="numChild" value='0' pattern="[0-9]{1}" required="required">
							</div>
							<div class="col-sm-2 offset-sm-1">
								유아<input type="number" class="form-control" min="0" max="9" id="numInfant" name="numInfant" value='0' pattern="[0-5]{1}" required="required">
							</div>
							<div class="col-sm-2 offset-sm-1" style="margin-top: 22px">
								<input type="button" class="form-control" value="조회" id="searchAirRoute">
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 출발 -->
			<div class="container" style="margin-top: 50px; display: none" id="departureTable">
				<div class="row justify-content-md-center">
					<div class="row">
						<span style="font-size: 2em;">가는편</span>
						<table class="text-center table table-bordered" id="TdepTable" style="background-color: rgba(255, 255, 255, 0.7)">
							<thead class="thead-dark col-lg-10">
								<tr>
									<th>선택</th>
									<th>편명</th>
									<th>출발시간</th>
									<th>도착시간</th>
									<th>출발지</th>
									<th>목적지</th>
									<th>총요금(1인/편도)</th>
									<th>예약가능여부</th>
								</tr>
							<tbody id="depTable">
							</tbody>

						</table>
					</div>
				</div>
			</div>
			<!-- 도착 -->
			<div class="container" style="margin-top: 50px; display: none" id="arrivalTable">
				<div class="row justify-content-md-center">
					<div class="row">
						<span style="font-size: 2em;">오는편</span>
						<table class="text-center table table-bordered" style="background-color: rgba(255, 255, 255, 0.7)">
							<thead class="thead-dark col-lg-10">
								<tr>
									<th>선택</th>
									<th>편명</th>
									<th>출발시간</th>
									<th>도착시간</th>
									<th>출발지</th>
									<th>목적지</th>
									<th>총요금(1인/편도)</th>
									<th>예약가능여부</th>
								</tr>
							<tbody id="arrTable">
							</tbody>

						</table>
					</div>

				</div>
			</div>

			<div class="d-flex justify-content-center">
				<input type="submit" class="form-control col-md-2" id="nextButton" value="다음" style="margin-top: 30px; display: none">
			</div>
		</form>
		
		<!-- Modal -->
		<div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">error</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">${message}	 
						<button type="button" class="btn btn-primary col-lg-2" data-dismiss="modal" style="float: right;">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="error" style="display: none">${error}</div>
	<div id="message" style="display: none">${message}</div>
</body>
<script>
$(document).ready(function(){
    if($('#error').text()){
    	$('#errorModal').modal();
    }
});
	$('#searchAirRoute')
			.click(
					function() {//화면에서 왼쪽 중간에 Test 버튼 
						$('#TdepTable > tbody').empty();
						var searchData = {
							"category" : $(".routeRadio").val(),
							"airportCodeDep" : $("#airportCodeDep").val(),
							"airportCodeArr" : $("#airportCodeArr").val(),
							"dateDep" : $("#dateDep").val(),
							"dateArr" : $("#dateArr").val(),
							"numAdult" : $("#numAdult").val(),
							"numChild" : $("#numChild").val(),
							"numInfant" : $("#numInfant").val()
						} //==>json 

						$
								.ajax({
									url : "searchAirRouteAction",
									data : searchData,
									method : 'post',
									datatype : 'json',
									success : function(data) {

										var parseData = JSON.parse(data) //받은 데이터를 객체로 파싱해준다 
										//console.log(searchData)
										//console.log(data)
										//console.log(parseData)
										var searchList = parseData.resultJSON;// 객체를 풀어서 리스트에 담아준다
										var str = '<tr>';
										//var selectRouteNumber = 1
										//console.log(typeof (selectRouteNumber))

									 $.each(searchList,	function(i) {

													str += '<td>'
															+ '<input type="radio" name="selectRouteCode" value="'
															+ searchList[i].routeCode + '" required="required" id="selectRouteCode" >'
															+ '</td><td>'
															+ searchList[i].routeCode
															+ '</td><td>'
															+ searchList[i].timeArr
															+ '</td><td>'
															+ searchList[i].timeDep
															+ '</td><td>'
															+ searchList[i].airportCodeDep
															+ '</td><td>'
															+ searchList[i].airportCodeArr
															+ '</td><td>'
															+ searchList[i].totalRouteFare
															+ '</td><td>'
															+ searchList[i].reservationSeat
															+ '<tr>'
														})
										$("#depTable").append(str);
									},

									error : function(request, status, error) {//무슨 에러인지 alert 에 보여주는 기능
										alert("code:" + request.status + "\n"
												+ "message:"
												+ request.responseText + "\n"
												+ "error:" + error);
									}

								})
					})

	$('#categoryO').click(function(){
 		$("#dateArrDiv").hide();
	});
	
 	$('#categoryR').click(function(){
 		$("#dateArrDiv").show();
 	});

	$("#searchAirRoute").on("click",function(){
		
		if($('#categoryO').is(':checked')){
			$("#arrivalTable").hide();
 			$("#departureTable").show();
		}
		if($('#categoryR').is(':checked')){
			$("#arrivalTable").show();
			$("#departureTable").show();		
		}		
		$("#nextButton").show(); //다음 버튼 보여주기
	});
	
	
</script>
</html>
