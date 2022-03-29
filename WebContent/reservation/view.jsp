<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 

<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>예약 관리 - 예약 조회</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
	function reservationRemove() {
		return confirm("정말 삭제하시겠습니까?");
	}
</script>
<%int sum = 0; %>
</head>
<body>
	<%@include file="/navbar.jsp"%>
	<div class="container">
		<br>
		<h4>예약 상세보기</h4>
		<br>
		<table class="table table-sm table-striped">
			<tbody>
				<tr>
					<th>#</th>
					<td>${reservation.reserv_id}</td>
				</tr>
				<tr>
					<th>사용자 ID</th>
					<td>${reservation.user_id}</td>
					<c:set var="user_id" value="${reservation.user_id}" ></c:set>
				</tr>
				<tr>
					<th>약 ID</th>
					<td>${reservation.med_id}</td>
				</tr>
				<tr>
					<th>선택 약국</th>
					<td>${reservation.pharm_name}</td>
				</tr>
				<tr>
					<th>예약일</th>
					<td>${reservation.reserv_date}</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${reservation.address}</td>
				</tr>
			</tbody>
		</table>
		<br>
		<h4>예약한 약품 목록</h4>
		<br>
		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<td>예약번호</td>
					<td>약 id</td>
					<td>가격</td>
					<td>수량</td>
					<td>합계</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lineitem" items="${lineitem_list}">
					<tr>
						<td>${lineitem.reserv_id}</td>
						<td>${lineitem.med_id}</td>
						<td>${lineitem.price}</td>
						<td>${lineitem.quantity}</td>
						<td>${lineitem.total_price}</td>
						<c:set var="total" value="${lineitem.total_price}" ></c:set>
						<% sum += (int)pageContext.getAttribute("total"); ;%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<%HttpSession ses = request.getSession();
String curUser =  (String)pageContext.getAttribute("user_id");
System.out.println("userID:" + curUser);
if (UserSessionUtils.isLoginUser(curUser, ses) || UserSessionUtils.isLoginUser("somsom", ses)) { %>
	<br><div align="right"><h5 >결제 예상 금액: <a style="color:blue;"><%=sum %> 원</a></h5></div>
	
<br><br><br> <a class="btn btn-outline-warning"
			href="<c:url value='/reservation/update' >
     		     <c:param name='reserv_id' value='${reservation.reserv_id}'/>
		 	  </c:url>">수정</a>
		<a class="btn btn-outline-dark"
			href="<c:url value='/reservation/delete'>
		     	 <c:param name='reserv_id' value='${reservation.reserv_id}'/>
	 	      </c:url>"
			onclick="return reservationRemove();">삭제</a> <a
			class="btn btn-success" href="<c:url value='/reservation/list' />">예약
			목록</a> <br>
<%}else{ %>
	<a href="javascript:history.go(-1)" class="btn btn-outline-warning">뒤로가기</a> 
<%} %>  
	</div>
	<br><br><br> 
</body>
</html>