<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">발권</li>
			<li class="breadcrumb-item active">예매조회</li>
			<li class="breadcrumb-item active">예매정보</li>
			<li class="breadcrumb-item">설문</li>
		</ol>
	</nav>
	<form method="post" action="setSurveyResultAction">
		<div class="container">
			<h1 style="text-align: center; margin-top: 80px">유형파악설문지</h1>
			<div class="row">


				<div class="jumbotron align-self-center col-md-4"
					style="background-color: rgba(255, 255, 255, 0.3); margin: 100px auto; border-radius: 30px; padding: 30px; width: 700px">
					<h3 style="text-align: center">탑승자 1</h3>

					<div class="jumbotron"
						style="background-color: rgba(255, 255, 255, 0.7); border-radius: 30px;">

						<div style="text-align: center; font-size: 1.3rem;">비행 중 화장실
							사용주기</div>
						<div class="col-sm">
							<input class="form-check-input position-static" type="radio"
								name="clean" id="restroom" value="2" aria-label="...">&nbsp;30분
						</div>
						<div class="col-sm">
							<input class="form-check-input position-static" type="radio"
								name="clean" id="restroom" value="1" aria-label="...">&nbsp;1시간
						</div>
						<div class="col-sm">
							<input class="form-check-input position-static" type="radio"
								name="clean" id="restroom" value="0.7" aria-label="...">&nbsp;1시간30분
						</div>
						<div class="col-sm">
							<input class="form-check-input position-static" type="radio"
								name="clean" id="restroom" value="0.5" aria-label="...">&nbsp;2시간
						</div>
						<div class="col-sm">
							<input class="form-check-input position-static" type="radio"
								name="clean" id="restroom" value="0.3" aria-label="...">&nbsp;2시간이상
						</div>

					</div>
					<div class="jumbotron"
						style="background-color: rgba(255, 255, 255, 0.7); border-radius: 30px">

						<div style="text-align: center; font-size: 1.3rem;">비행 중 수면
							비율</div>
						<div class="d-flex justify-content-center"
							style="margin-top: 30px">
							<input type="text" class="" name="sleep" style="width: 80px">&nbsp;%
						</div>

					</div>
					<div class="jumbotron"
						style="background-color: rgba(255, 255, 255, 0.7); border-radius: 30px;">

						<div style="text-align: center; font-size: 1.3rem;">비행 중
							업무/대화 비율</div>
						<div class="text-center" style="margin-top: 30px">
							<input type="text" class="" name="active" style="width: 80px">&nbsp;%
						</div>
						
					</div>
					<div class="d-flex justify-content-center"
							style="margin-bottom: 50px">
							<input type="submit" class="form-control col-md-2" value="다음">
						</div>
				</div>
			</div>
			</div>
	</form>
</body>
</html>


