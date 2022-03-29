<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>My page</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<!-- favicon 추가 -->
<link rel="shortcut icon" href="/images/favicon-16.ico" type="image/x-icon">
<link rel="icon" href="images/favicon-16.ico" type="image/x-icon">
 <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

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
div{
margin:0px 80px 0px 80px;
}
</style>
</head>
<body>
<%@include file="/navbar.jsp" %>
	<header>
		<h1>
			<img src="../images/mainLogo.png" width=1100 height=300>
		</h1>
	</header>
	<nav>
	<div>
	<h4>${user.user_id}님이 관심있으신 증상 "${user.symptom}"에 관련된 약품을 보여드립니다. &nbsp; &nbsp;
	 <a class="btn btn-outline-success" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='${user.symptom}'/>
				 		 </c:url>">보기</a></h4></div>
	</nav>
	<br><br>
	<nav>
	<div>
		<h4>나의 정보&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-outline-primary" 
    	href="<c:url value='/user/update/form' >
     		     <c:param name='user_id' value='${user.user_id}'/>
		 	  </c:url>">수정</a></h4>
		<table class="table table-bordered">
    	<tbody> 
	  	  <tr>
			<th>사용자 ID</th>
			<td>${user.user_id}</td>
		  </tr>
		  <tr>
			<th>이름</th>
			<td>${user.user_name}</td>
		  </tr>
		  <tr>
			<th>이메일 주소</th>
			<td>${user.email}</td>
		  </tr>		  
		  <tr>
			<th>전화번호</th>
			<td>${user.phone}</td>
		  </tr>	
		  <tr>
			<th>성별</th>
			<td>${user.gender}</td>
		  </tr>	
		  <tr>
			<th>생일</th>
			<td>${user.birth_date}</td>
		  </tr>	
		  <tr>
			<th>증상</th>
			<td>${user.symptom}</td>
		  </tr>	
		</tbody>
	</table></div>
	</nav><br>
	<nav><br>
<div><h4>내 예약 리스트&nbsp;&nbsp;&nbsp;&nbsp;<a href="<c:url value='/reservation/create/form' />" class="btn btn-outline-primary">예약하기</a><br></h4>
<table class="table table-bordered">
      <thead class="thead-inverse">
      	<tr>
		  <td>#</td>
		  <td>사용자 ID</td>
		  <td>약 ID</td>
		  <td>약국</td>
		  <td>예약일</td>
		</tr>
      </thead>
      <tbody>
				<c:forEach var="reservation" items="${reservation_list}">
					<tr>
						<td><a
							href="<c:url value='/reservation/view'>
						   <c:param name='reserv_id' value='${reservation.reserv_id}'/>
				 		 </c:url>">${reservation.reserv_id}</a></td>
						<td>${reservation.user_id}</td>
						<td>${reservation.med_id}</td>
						<td>${reservation.pharm_name}</td>
						<td>${reservation.reserv_date}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>	
	</div>	  	 
	</nav><br>
	<nav><br>
 <div><h4>내 게시물 &nbsp;&nbsp;&nbsp;&nbsp;<a href="<c:url value='/post/creationForm.jsp'/>" class="btn btn-outline-primary">글쓰기</a></h4>

		<table class="table table-bordered">
      <thead class="thead-inverse">
      	<tr>
		  <td>#</td>
		  <td>사용자 ID</td>
		  <td>약 이름</td>
		  <td>제목</td>
		  <td>작성일</td>
		</tr>
      </thead>
      <tbody>
				<c:forEach var="post" items="${post_list}">
					<tr>
						<td><a
							href="<c:url value='/post/view'>
						   <c:param name='post_id' value='${post.post_id}'/>
				 		 </c:url>">
								${post.post_id}</a></td>
						<td>${post.user_id}</td>
						<td>${post.med_id}</td>
						<td>${post.title}</td>
						<td>${post.post_date}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	</div>
	</nav>
	<br><br>
	<footer>Untact Pharamcy 2020 수현하재 </footer>
</body>
</html>