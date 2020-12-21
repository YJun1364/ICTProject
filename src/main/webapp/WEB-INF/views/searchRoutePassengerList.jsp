<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매현황</title>
</head>
<body>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item" >예매현황</li>
		</ol>
	</nav>
	<br>
	<br>
	<div class="container" style="margin-top: 150px">
		<div class="row justify-content-center">

			<div class="card text-center"
				style="width: 30rem; border-radius: 30px;">
				<div class="card-body">
					<h3 class="card-title" style="font-weight: bold">예매리스트현황</h3>
					<br>
					<form method="post" action="searchRoutePassengerListAction">
						<div class="form-group col-md-8 offset-2">
							<input type="text" class="form-control text-center"
								name="routeCode" placeholder="편명" required="required">
						</div>
						<br>
						<button type="submit" class="btn btn-primary col-md-8">검색</button>
					</form>
					<br>
					<h5 class="card-subtitle mb-2 text-muted">CastleWater</h5>
				</div>
			</div>
		</div>
	</div>
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
</body>
<script>
$(document).ready(function(){
    if($('#error').text()){
    	$('#errorModal').modal();
    }
});
</script>
</html>


