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
	<title>예약 조회</title>
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
	<h4>예약 조회</h4>
	<br>
	
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
				 		 </c:url>">
							${reservation.reserv_id}</a></td>
						<td>${reservation.user_id}</td>
						<td>${reservation.med_id}</td>
						<td>${reservation.pharm_name}</td>
						<td>${reservation.reserv_date}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>		  	 
	<br>  
</div>
</body>
</html>