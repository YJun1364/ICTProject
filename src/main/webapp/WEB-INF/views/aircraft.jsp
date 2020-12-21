<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./header.jsp">
	<jsp:param name="name" value="${loginOK}" />
</jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">메인</a></li>
			<li class="breadcrumb-item active" aria-current="page">항공기 정보</li>
		</ol>
	</nav>

	<div class="container text-center">
		<div style="margin-top: 30px; margin-bottom: 30px">
			<span style="font-size: 3em;">항공기 정보</span>
		</div>
		<div class="container">
			<div class="row align-items-center">
				<div class="col align-self-center">
					<div id="carouselExampleCaptions"
						class="carousel slide carousel-fade" data-ride="carousel">

						<ol class="carousel-indicators" style="margin-left: 250px">
							<li data-target="#carouselExampleCaptions" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
							<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
						</ol>

						<div class="carousel-inner" style="height: auto; width: 1500px">
							<div class="carousel-item active"
								style="height: 100%; width: 1200px">
								<img src="resources/images/main/b737.png" class="d-block w-100"
									alt="..." onclick="onClick(this)">
								<div class="carousel-caption d-none d-md-block">
									<span style="font-size: 3em; color: black;">BOEING 737</span>
									<p></p>

								</div>
							</div>
							<div class="carousel-item" style="height: 100%; width: 1200px">
								<img src="resources/images/main/b747.png" class="d-block w-100"
									alt="..." onclick="onClick1(this)">
								<div class="carousel-caption d-none d-md-block">
									<span style="font-size: 3em; color: black;">BOEING 747</span>
									<p></p>
								</div>
							</div>
							<div class="carousel-item" style="height: 100%; width: 1200px">
								<img src="resources/images/main/A380.jpg" class="d-block w-100"
									alt="..." onclick="onClick2(this)">
								<div class="carousel-caption d-none d-md-block">
									<span style="font-size: 3em; color: black;">AIRBUS 380</span>
									<p></p>
								</div>
							</div>
						</div>
						<div>

						<a class="carousel-control-prev" href="#carouselExampleCaptions"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon offset-3" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon offset-10" aria-hidden="true"> </span> <span
							class="sr-only">Next</span>
						</a>
						<div id="modal01" class="w3-modal"
							onclick="this.style.display='none'">
							<span
								class="w3-button w3-hover-red w3-xlarge w3-display-topright">&times;</span>
							<div class="w3-modal-content w3-animate-zoom" id="img01"
								style="margin-top: 200px">
								<img src="resources/images/main/bb737.PNG" style="width: 90%">
							</div>
						</div>


						<div id="modal02" class="w3-modal"
							onclick="this.style.display='none'">
							<span
								class="w3-button w3-hover-red w3-xlarge w3-display-topright">&times;</span>
							<div class="w3-modal-content w3-animate-zoom" id="img02"
								style="margin-top: 200px">
								<img src="resources/images/main/bb747.PNG" style="width: 90%">
							</div>
						</div>
						<div id="modal03" class="w3-modal"
							onclick="this.style.display='none'">
							<span
								class="w3-button w3-hover-red w3-xlarge w3-display-topright">&times;</span>
							<div class="w3-modal-content w3-animate-zoom" id="img03"
								style="margin-top: 200px">
								<img src="resources/images/main/aa380.PNG" style="width: 90%">
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
		function onClick(element) {
			document.getElementById("img01").src = element.src;
			document.getElementById("modal01").style.display = "block";
		}
	</script>
	<script type="text/javascript">
		function onClick1(element) {
			document.getElementById("img02").src = element.src;
			document.getElementById("modal02").style.display = "block";
		}
	</script>
	<script type="text/javascript">
		function onClick2(element) {
			document.getElementById("img03").src = element.src;
			document.getElementById("modal03").style.display = "block";
		}
	</script>
</body>
</html>
