<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>좌석선택</title>
<script type="text/javascript">
	function openCheck(ck) {
		var obj = document.getElementsByName("seatNumber");
		for (var i = 0; i < obj.length; i++) {
			if (obj[i] != ck) {
				obj[i].checked = false;
			}
		}
	}

	var seatDisabled = function(){
		var rs = ${reservationSeats};
		
		for(var i = 0; i<rs.length; i++){
			rs[i].disabled = true;
		}
	}
	var seatSection = function(){
		var al = ${activeLine};
		var sl = ${sleepLine};
		for(var j= sl+1; j<=sl+al; j++){
			document.getElementById("line"+j).style.background = "green";
			}
		for(var k= sl+al+1; k<=12; k++){
			document.getElementById("line"+k).style.background = "blue";
		}
		for(var i = 1; i<=sl; i++){
			document.getElementById("line"+i).style.background = "red";
		}
	}
	
	   window.onload = function(){
		   seatSection();
		   seatDisabled();
 		
	}  
	
</script>
</head>
<body>	

	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item active">메인</li>
			<li class="breadcrumb-item active">발권</li>
			<li class="breadcrumb-item active">예매조회</li>
			<li class="breadcrumb-item active">예매정보</li>
			<li class="breadcrumb-item active">예매정보확인</li>
			<li class="breadcrumb-item">자리선택</li>
		</ol>
	</nav>
<form id="seat" action="setSeatSelectionAction" method="post">
	<div class="container" style="margin-top: 250px; width: 80rem">
		<div class="row justify-items-center">
			<div class="col">
				<div class="jumbotron jumbotron-fluid col-lg-12"
					style="background-color: rgba(255, 255, 255, 0.7)">
					<table>
						<tr>
							<td>
								<!-- 자리배정 -->
								<dl>
									<dt>
										<a>A</a>&nbsp;
									</dt>
									<dt>
										<a>B</a>&nbsp;
									</dt>
									<dt>
										<a>C</a>&nbsp;
									</dt>
									<br>
									<dt>
										<a>D</a>&nbsp;
									</dt>
									<dt>
										<a>E</a>&nbsp;
									</dt>
									<dt>
										<a>F</a>&nbsp;
									</dt>
								</dl>
							</td>
							<td>
								<!-- 1열 -->
								<dl id="line1">
									<dt>
										<input type="checkbox" id="Z0" style="display:none">
										<input type="checkbox" name="seatNumber" id="A1" value="A1" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B1" value="B1" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C1" value="C1" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D1" value="D1" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E1" value="E1" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F1" value="F1" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>
								<!-- 2열 -->
								<dl id="line2">
									<dt>
										<input type="checkbox" name="seatNumber" id="A2" value="A2" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B2" value="B2" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C2" value="C2" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D2" value="D2" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E2" value="E2" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F2" value="F2" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>
								<!-- 3열 -->
								<dl id="line3">
									<dt>
										<input type="checkbox" name="seatNumber" id="A3" value="A3" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B3" value="B3" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C3" value="C3" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D3" value="D3" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E3" value="E3" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F3" value="F3" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>
								<!-- 4열 -->
								<dl id="line4">
									<dt>
										<input type="checkbox" name="seatNumber" id="A4" value="A4" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B4" value="B4" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C4" value="C4" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D4" value="D4" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E4" value="E4" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F4" value="F4" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td>
								<!-- 5열 -->
								<dl id="line5">
									<dt>
										<input type="checkbox" name="seatNumber" id="A5" value="A5" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B5" value="B5" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C5" value="C5" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D5" value="D5" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E5" value="E5" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F5" value="F5" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>
								<!-- 6열 -->
								<dl id="line6">
									<dt>
										<input type="checkbox" name="seatNumber" id="A6" value="A6" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B6" value="B6" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C6" value="C6" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D6" value="D6" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E6" value="E6" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F6" value="F6" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>
								<!-- 7열 -->
								<dl id="line7">
									<dt>
										<input type="checkbox" name="seatNumber" id="A7" value="A7" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B7" value="B7" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C7" value="C7" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D7" value="D7" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E7" value="E7" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F7" value="F7" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>
								<!-- 8열 -->
								<dl id="line8">
									<dt>
										<input type="checkbox" name="seatNumber" id="A8" value="A8" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B8" value="B8" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C8" value="C8" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D8" value="D8" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E8" value="E8" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F8" value="F8" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td>
								<!-- 9열 -->
								<dl id="line9">
									<dt>
										<input type="checkbox" name="seatNumber" id="A9" value="A9" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B9" value="B9" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C9" value="C9" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D9" value="D9" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E9" value="E9" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F9" value="F9" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>
								<!-- 10열 -->
								<dl id="line10">
									<dt>
										<input type="checkbox" name="seatNumber" id="A10" value="A10" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B10" value="B10" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C10" value="C10" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D10" value="D10" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E10" value="E10" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F10" value="F10" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>
								<!-- 11열 -->
								<dl id="line11">
									<dt>
										<input type="checkbox" name="seatNumber" id="A11" value="A11" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B11" value="B11" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C11" value="C11" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D11" value="D11" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E11" value="E11" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F11" value="F11" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
							<td>
								<!-- 12열 -->
								<dl id="line12">
									<dt>
										<input type="checkbox" name="seatNumber" id="A12" value="A12" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="B12" value="B12" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="C12" value="C12" onclick="openCheck(this);">
									</dt>
									<br>
									<dt>
										<input type="checkbox" name="seatNumber" id="D12" value="D12" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="E12" value="E12" onclick="openCheck(this);">
									</dt>
									<dt>
										<input type="checkbox" name="seatNumber" id="F12" value="F12" onclick="openCheck(this);">
									</dt>
								</dl>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row justify-content-lg-center" style="margin-left: 250px">
			<div class="col">
				<button type="submit" class="btn btn-primary col-md-8">자리선택완료</button>
			</div>
		</div>
	</div>
	</form>
<!-- Modal -->
	<div class="modal fade" id="errorModal" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog"
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
				<div class="modal-body"><span id="message"></span>
					<button type="button" class="btn btn-primary col-lg-2" id="modalSubmitButton"
						data-dismiss="modal" style="float: right;">다음</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$('#submitButton').click(
		function() {
			if ($("input:checkbox[name='seatNumber']").is(":checked") == false) {
				$('#message').text("자리를 선택해주세요!");
				$('#errorModal').modal();
				return;
			} else {
				var checkedNumber = $("input:checkbox[name='seatNumber']:checked").val()
				console.log(checkedNumber)
				$('#exampleModalLabel').text("좌석선택 완료")
				$('#message').text(checkedNumber + "번 좌석을 선택 하셨습니다.");
				$('#errorModal').modal();

			}
		})
$('#modalSubmitButton').click(function() {
	$('#setOnsiteSeatSelectionAction').submit();
})
</script>
</html>