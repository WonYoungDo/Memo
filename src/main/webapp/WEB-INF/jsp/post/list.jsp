<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 리스트</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp"/>
		<section class="contents">
			<div class="memolist px-5">
				<!-- 제목 -->
				<div class="memolist-title text-center my-2">
					<h1>메모리스트</h1>
				</div>
				<!-- 제목 -->
				<!-- 메모 리스트 -->
				<div class="momolist-list">
					<table class="table text-center">
						<thead>
						<tr>
							<th>No.</th>
							<th>제목</th>
							<th>작성 시간</th>
						</tr>
						</thead>
						<tbody>
							<c:forEach var="post" items="${postList }">
							<tr>
								<td>${post.id }</td>
								<td><a href="/post/detail-view/${post.id }">${post.title }</a></td>
								<td><fmt:formatDate value="${post.createdAT }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- 메모 리스트 -->
				<!-- 작성 버튼 -->
				<div class="memolist-button d-flex justify-content-end">
					<a href="/post/create-view" class="btn btn-secondary">작성</a>			
				</div>
				<!-- 작성 버튼 -->
				
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</body>
</html>