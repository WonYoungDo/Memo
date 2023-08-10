<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 입력</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp"/>
		
		
		<section class="contents d-flex justify-content-center">
			<div class="memo-input col-8">
				<h1 class="text-center font-weight-bold pt-3 pb-2">메모 입력</h1>
				<div class="d-flex justify-content-center align-items-center pb-2">
					<h4 class="col-2 font-weight-bold mt-2">제목 : </h4>
					<input type="text" placeholder="제목을 입력하세요." class="form-control col-8" id="titleInput">
				</div>
				<div class="d-flex justify-content-center">
					<textarea class="col-10 form-control" placeholder="내용을 입력하세요." rows="10" id="contentsInput"></textarea>
				</div>
				<div class="pt-2">
					<div class="pl-5 pb-3">	
						 <input type="file" class="ml-3" id="fileInput">
					</div>
					<div class="d-flex justify-content-between pl-5 pr-5">
						<a href="/post/list-view" class="btn btn-secondary text-white ml-3">목록으로</a>
						<button type="button" class="btn btn-secondary mr-3" id="saveBtn">저장</button>
					</div>
				</div>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			
			$("#saveBtn").on("click", function() {
				let title = $("#titleInput").val();
				let contents = $("#contentsInput").val();
				let file = $("#fileInput")[0];
				
				// 유효성 검사
				if(title == "") {
					alert("제목을 입력해주세요.");
					return;
				}
				if(contents == "") {
					alert("작성할 내용을 입력해주세요.");
					return;
				}
				
				var formData = new FormData();
				formData.append("title", title);
				formData.append("contents", contents);
				formData.append("file", file.files[0]);
										
				
				$.ajax({
					type:"post"
					, url:"/post/create"
					, data:formData
					, processData:false // 파일 업로드 옵션
					, contentType:false // 파일 업로드 옵션
					, success:function(data) {
						if(data.result == "success") {
							location.href = "/post/list-view";
						} else {
							alert("저장 실패");
						}
					}
					, error:function() {
						alert("입력 에러");
					}
				});
			});	
		});
	</script>
</body>
</html>