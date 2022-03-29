<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>Untact Pharmacy</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<!-- favicon 추가 -->
<link rel="shortcut icon" href="/images/favicon-16.ico" type="image/x-icon">
<link rel="icon" href="images/favicon-16.ico" type="image/x-icon">
<style>
body {
	background-color: #ffffff;
}

h1 {
	text-align: center;
	background-color: #ffffff;
}
nav{
min-width:600px;
}
</style>
</head>
<body>
	<header>
		<h1>
			<img src="images/mainLogo.png" width=1100 height=300>
		</h1>
	</header>
	<nav>
		<ul>
			<!-- <li><a href="user/login/form">로그인</a></li> -->
			<c:choose>
				<c:when test="${userId ne null}">
					<li><a href="<c:url value='/user/logout'/>">${userId}(로그아웃)
					</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="user/login/form">로그인</a></li>
				</c:otherwise>

			</c:choose>
			<li><a href="pharmacy/search/form">약국 검색</a></li>
			<li><a href="search/medSearchForm.jsp">약 검색</a></li>
			<li><a href="post/list">후기 게시판</a></li>
			<c:choose>
				<c:when test="${userId ne null}">
				<!-- 마이페이지 UI 추가  -->
					<li><a href="<c:url value='/user/mypage'> 
   						<c:param name='user_id' value='${userId}'/>
    					</c:url>">마이페이지
					</a></li>
				</c:when>
				<c:otherwise>
					<li>마이페이지</li>
					</a>
				</c:otherwise>

			</c:choose>
		</ul>
	</nav>
	<nav>
		<%@include file="/mainMedicineList.jsp"%>
	</nav>
	<footer>Untact Pharamcy 2020 수현하재 </footer>
</body>
</html>