<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp"/>
		<section class="contents d-flex justify-content-center">
			<div class="join-box">
				<h1 class="text-center mt-4 mb-4">로그인</h1>
				<div class="pt-5">
					<input type="text" placeholder="아이디" class="form-control mt-4" id="idInput">
					<input type="password" placeholder="비밀번호" class="form-control mt-4" id="passwordInput">
					<button type="button" class="btn btn-secondary btn-block mt-4" id="loginBtn">가입</button>
				</div>
			</div>
		</section>
		<jsp:include page="footer.jsp"/>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			$("#loginBtn").on("click", function() {
				let id = $("#idInput").val();
				let password = $("#passwordInput").val();
				
				// 유효성 검사
				if(id == "") {
					alert("아이디를 입력하세요.")
					return;
				}
				if(id == "") {
					alert("비밀번호를 입력하세요.")
					return;
				}
				
				
				
				
			});
		});
	</script>



</body>
</html>