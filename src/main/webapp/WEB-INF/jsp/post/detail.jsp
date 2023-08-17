<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp"/>
		<section class="contents d-flex justify-content-center">
			<div class="memo-input col-8">
				<h1 class="text-center font-weight-bold pt-3 pb-2">메모 보기</h1>
				<!-- title -->
				<div class="d-flex justify-content-center align-items-center pb-2">
					<h4 class="col-2 font-weight-bold mt-2">제목 : </h4>
					<input type="text" placeholder="제목을 입력하세요." class="form-control col-8" id="titleInput" value="${post.title }">
				</div>
				<!-- /title -->
				<!-- contents -->
				<div class="d-flex justify-content-center">
					<textarea class="col-10 form-control" placeholder="내용을 입력하세요." rows="5" id="contentsInput">${post.contents }</textarea>
				</div>
				<!-- /contents -->
				<!-- image -->
				<c:if test="${post.imagePath != null}">
					<div class="detail-image text-center px-5 pt-2">
						<img height="200" width="640" alt="${post.title }" src="${post.imagePath }">
					</div>
				</c:if>
				<!-- /image -->
				<!-- button -->
				<div class="pt-2">
					<div class="pl-5 pb-2">	
						 <button type="button" class="btn btn-danger ml-3" data-post-id="${post.id }" id="deleteBtn">삭제</button>
					</div>
					<div class="d-flex justify-content-between px-5 pb-2">
						<a href="/post/list-view" class="btn btn-secondary text-white ml-3">목록으로</a>
						<button type="button" class="btn btn-secondary mr-3" data-post-id="${post.id }" id="saveBtn">수정</button>
					</div>
				</div>
				<!-- /button -->
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			// 삭제 버튼 클릭 이벤트
			$("#deleteBtn").on("click", function() {
				let postId = $(this).data("post-id");
				
				$.ajax({
					type:"delete"
					, url:"/post/delete"
					, data:{"postId":postId}
					, success:function(data) {
						if(data.result == "success") {
							location.href="/post/list-view";
						} else {
							alert("삭제 실패");
						}
					}
					, error:function() {
						alert("삭제 에러");
					}
				});
			});	
			
			// 수정 버튼 클릭 이벤트
			$("#saveBtn").on("click", function() {
				// 제목, 메모 내용, 이미지
				let	title = $("#titleInput").val();
				let	contents = $("#contentsInput").val();
				let postId = $(this).data("post-id");
				
				if(title == "") {
					alert("제목을 입력하세요");
					return;
				}
				if(contents == "") {
					alert("내용을 입력하세요");
					return;
				}
				
				$.ajax({
					type:"put"
					, url:"/post/update"
					, data:{"postId":postId, "title":title, "contents":contents}
					, success:function(data) {
						if(data.result == "success") {
							location.href="/post/list-view";
						} else {
							alert("수정 실패");
						}
					}
					, error:function() {
						alert("수정 에러");
					}
				});
			});
		});
	</script>

</body>
</html>