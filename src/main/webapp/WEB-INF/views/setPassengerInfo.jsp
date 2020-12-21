<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탑승자정보 입력</title>
</head>
<body>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">발권</li>
			<li class="breadcrumb-item active">현장발권</li>
			<li class="breadcrumb-item active">구간운임선택</li>
			<li class="breadcrumb-item">탑승자정보입력</li>
		</ol>
	</nav>
	<br>
	<br>
	<div class="d-flex justify-content-center">
		<h3 style="">구매자 정보 입력</h3>
	</div>
	<br>

	<form method="post" action="setPassengerInfoAction">
		<div class="row justify-content-end">
			<div class="col-4"></div>
			<div class="col-4">
				<input class="text-center" type="text" name="purchaseId"
					id="purchaseId" placeholder="회원아이디">&nbsp;&nbsp; <input
					type="button" value="조회" id="serachPurchaseId" >
			</div>
		</div>
		<br>

		<!-- 구매자 -->
		<div class="d-flex justify-content-center">
			<table class="text-center col-lg-8 table table-bordered "
				style="background-color: rgba(255, 255, 255, 0.7)">
				<thead class="thead-dark">
					<tr>
						<th>성/이름</th>
						<td><input class="text-center" type="text" name="lastNameEng"
							id="purchaseLastName" placeholder="Last Name" required="required">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
							class="text-center" name="firstNameEng" id="purchaseFirstName"
							placeholder="First Name" required="required"></td>
						<th>이메일</th>
						<td><input type="text" class="text-center" name="email"
							id="purchaseEmail" placeholder="E-mail" required="required"
							pattern="[0-9a-zA-Z]{3,15}*@[0-9a-zA-Z]{3,10}*.[a-zA-Z]{2,3}">
						</td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td colspan="3">
							<div class="input-group mb-3">
								<input type="text" class="text-center form-control col-sm-3"
									name="phoneNumber" placeholder="01012341234"
									required="required" id="purchasePhoneNumber"
									aria-label="phoneNumber" aria-describedby="button-addon2">
							</div> <br>
						</td>
					</tr>
				</thead>
			</table>
		</div>
		<br> <br>

		<!-- 탑승자 -->
		<div class="d-flex justify-content-center">
			<h3>탑승자 정보</h3>
		</div>
		<br>
		<div class="row justify-content-end" style="margin-right: 300px">
			<div class="col-4">
				<input type="checkbox" id="checkBox" name="passengerIdCheck">&nbsp;구매자와
				동일 <span style="display: inline-block; width: 50px"></span> <input
					class="text-center" type="text" name="passengerId" id="passengerId"
					placeholder="회원아이디">&nbsp;&nbsp; <input type="button" 
					value="조회" id="serachPassengerId" name="passengerId">

			</div>
		</div>
		<br>
		<div class="d-flex justify-content-center">
			<table class="text-center col-lg-8 table table-bordered rounded"
				style="background-color: rgba(255, 255, 255, 0.7)">
				<thead class="thead-dark">
					<tr>
						<th>성별</th>
						<td><select class="custom-select col-sm-8" id="gender"
							name="gender" required="required">
								<option selected>Choose...</option>
								<option value="MR">MR</option>
								<option value="MS">MS</option>
								<option value="MSTR">MSTR</option>
								<option value="MISS">MISS</option>
						</select></td>
						<th>성/이름</th>
						<td colspan="3"><input type="text" style="left: 10px"
							name="passengerFirstNameEng" placeholder="First Name"
							id="passengerLastName" required="required">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" style="left: 10px" placeholder="Last Name"
							name="passengerLastNameEng" id="passengerFirstName"
							required="required"></td>
					</tr>
					<tr>
						<th>국적</th>
						<td><select class="custom-select col-sm-8" id="nationality"
							name="nationality" required="required">
								<option selected>국적 입력</option>
								<option value="KOREA REPUBLIC OF">대한민국(KOREA, REPUBLIC OF)</option>
								<option value="CHINA">중국(CHINA)</option>
								<option value="GUAM">괌(GUAM)</option>
								<option value="FRANCE">프랑스(FRANCE)</option>
								<option value="PHILIPPINES">필리핀(PHILIPPINES)</option>
								<option value="UNITED STATES">미국(UNITED STATES)</option>
								<option value="CANADA">캐나다(CANADA)</option>
								<option value="UNITED KINGDOM">영국(UNITED KINGDOM)</option>
								<option value="CZECH REPUBLIC">체코(CZECH REPUBLIC)</option>
								<option value="MALAYSIA">말레이시아(MALAYSIA)</option>
								<option value="NORTHERN MARIANA ISLANDS">북마리아나
									제도(NORTHERN MARIANA ISLANDS)</option>
								<option value="SPAIN">스페인(SPAIN)</option>
								<option value="ITALY">이탈리아(ITALY)</option>
								<option value="AUSTRALIA">오스트레일리아(AUSTRALIA)</option>
						</select></td>
						<th>생년월일</th>
						<td><input class="text-center col-sm-9" type="date"
							name="birth" id="birth" required="required"></td>
					</tr>
					<tr>
						<th>여권번호</th>
						<td><input type="text" class="" placeholder="여권번호 "
							pattern="[A-Z]{1}+[0-9]{8}" name="passport" id="passport"
							required="required"></td>
					</tr>
				</thead>
			</table>
		</div>

		<div class="d-flex justify-content-center"
			style="margin-top: 50px; margin-bottom: 50px">
			<div class="d-flex justify-content-center" style="margin-bottom:">
				<button id="submit" onclick="verifyEmail()" class="form-control">제출</button>
			</div>
			<input type="hidden" name="purchaseInfo" id="purchaseInfo"> <input
				type="hidden" name="selectRouteCode" id="selectRouteCode">
		</div>
		<div id="purchaseInfoText" style="display: none">${purchaseInfo}</div>
		<div id="selectRouteCodeText" style="display: none">${selectRouteCode}</div>
	</form>

</body>
<script type="text/javascript">

	var purchaseInfo = $("#purchaseInfoText").text()				
	$('input[id=purchaseInfo]').attr('value', purchaseInfo);

	var selectRouteCode = $("#selectRouteCodeText").text()
	$('input[id=selectRouteCode]').attr('value', selectRouteCode);

	//구매자 정보조회 클릭
	$('#serachPurchaseId').click(
			function() {
				$.ajax({
					url : "searchMember",
					data : {
						"purchaseId" : $('#purchaseId').val()
					},
					method : 'post',
					datatype : 'json',
					success : function(data) {
						var parseData = JSON.parse(data)						
						$('input[id=purchaseLastName]').attr('value',parseData.resultJSON.lastNameEng);// 밸류로 넣어줘야 들어감!!
						$('input[id=purchaseFirstName]').attr('value',parseData.resultJSON.firstNameEng);
						$('input[id=purchasePhoneNumber]').attr('value',parseData.resultJSON.phoneNumber);
						$('input[id=purchaseEmail]').attr('value',parseData.resultJSON.email);
					}
				})
			})

	//탑승자==구매자 checkbox 클릭
	$('#checkBox').click(
			function() {
				$.ajax({
					url : "searchMember",
					data : {
						"purchaseId" : $('#purchaseId').val()
					},
					method : 'post',
					datatype : 'json',
					success : function(data) {
						var parseData = JSON.parse(data)
						console.log(parseData)
						console.log(parseData.resultJSON)
						console.log(parseData.resultJSON.lastNameEng)
						//$('#purchaseLastName').html(parseData.resultJSON.lastNameEng) 이건 안들어감
						$('#passengerLastName').attr('value',parseData.resultJSON.lastNameEng);// 밸류로 넣어줘야 들어감!!
						$('#passengerFirstName').attr('value',parseData.resultJSON.firstNameEng);
						$('#birth').attr('value',parseData.resultJSON.birth.substring(0, 10)); //날짜 형식때문에 substring()으로 자리수 조정함 	
						$('#nationality').val(parseData.resultJSON.nationality).change();
						$('#gender').val(parseData.resultJSON.gender).change();

					}
				})
			})
	//탑승자 회원 조회
	$('#serachPassengerId').click(
			function() {
				$.ajax({
					url : "searchMember",
					data : {
						"purchaseId" : $('#passengerId').val()
					},
					method : 'post',
					datatype : 'json',
					success : function(data) {
						var parseData = JSON.parse(data)
						console.log(parseData)
						console.log(parseData.resultJSON)
						console.log(parseData.resultJSON.lastNameEng)
						//$('#purchaseLastName').html(parseData.resultJSON.lastNameEng) 이건 안들어감
						$('input[id=passengerLastName]').attr('value',parseData.resultJSON.lastNameEng);// 밸류로 넣어줘야 들어감!!
						$('input[id=passengerFirstName]').attr('value',parseData.resultJSON.firstNameEng);
						$('input[id=birth]').attr('value',parseData.resultJSON.birth.substring(0, 10)); //날짜 형식때문에 substring()으로 자리수 조정함 	
						$('#nationality').val(parseData.resultJSON.nationality).change();
						$('#gender').val(parseData.resultJSON.gender).change();

					}
				})
			})

	$('#checkBox').click(function() {
		var purchaseId = $('#purchaseId').val();
		$('#passengerId').attr('value',purchaseId);	
	})
</script>
</html>


