<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>예매 조회</title>
</head>
<body>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">발권</li>
			<li class="breadcrumb-item">예매조회</li>
		</ol>
	</nav>

	<form class="container" style="margin-top: 100px" method="post"
		action="searchBookingInfoAction">
		<div class="form-row d-flex justify-content-center">
			<div class="text-center col-md-3">
				<span style="font-size: 1.5em;">예약번호</span><input type="text"
					class="form-control" placeholder="예약 번호" name="purchaseNum">
			</div>
			<div class="text-center col-md-3">
				<span style="font-size: 1.5em;">예매자 성(영문)</span><input type="text"
					class="form-control" placeholder="Last name" name="lastNameEng">
			</div>
		</div>
		<br>
		<div class="form-row d-flex justify-content-center">
			<div class="text-center col-md-3">
				<span style="font-size: 1.5em;">출발일자</span> <input type="date"
					name="dateDep" class="form-control">
			</div>
			<div class="text-center col-md-3">
				<span style="font-size: 1.5em;">예매자 이름(영문)</span><input type="text"
					class="form-control" placeholder="First name" name="firstNameEng">
			</div>
		</div>
		<br> <br>
		<div class="row d-flex justify-content-center">
			<div class="col text-center">
				<button class="btn btn-secondary" type="submit">조회</button>
				<button class="btn btn-secondary" type="reset">취소</button>
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
							data-dismiss="modal" style="float: right;">Close</button></div>
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
</script>
</html>