<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	@SuppressWarnings("unchecked") 
	List<User> userList = (List<User>)request.getAttribute("userList");
	String curUserId = (String)request.getAttribute("curUserId");
--%>
<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>사용자 관리 - 정보 조회</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
function userRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
	</script>
	
</head>
<body>
<%@include file="/navbar.jsp" %>
<div class="container">  
	<br>
	<h4>사용자 정보 조회</h4>
	<br>
	<table class="table">
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
	</table>
	<br> 		     
    <a class="btn btn-outline-warning" 
    	href="<c:url value='/user/update/form' >
     		     <c:param name='user_id' value='${user.user_id}'/>
		 	  </c:url>">수정</a>    
    <br>	   
	    
	<!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	<c:if test="${updateFailed || deleteFailed}">
		<h6 class="text-danger"><c:out value="${exception.getMessage()}"/></h6>
    </c:if>  
</div>  
</body>
</html>