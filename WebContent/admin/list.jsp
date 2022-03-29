<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	@SuppressWarnings("unchecked") 
	User user = (User)request.getAttribute("user");
--%>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>사용자 리스트</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="/admin/navbar.jsp"%>

	<div class="container">
		<br>
		<h4>사용자 목록</h4>
		<div align="right">
		<a href="<c:url value='/admin/register/form' />"
			class="btn btn-outline-dark">사용자 추가 </a>
			</div>
			<br>
		<table class="table table-hover">
			<thead>
				<tr>
					<td>NO</td>
					<td>사용자 ID</td>
					<td>이름</td>
					<td>이메일</td>
					<td>회원등급</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.user_no}</td>
						<td>${user.user_id}
						</td>
						<td><a
							href="<c:url value='/admin/view'>
						   <c:param name='user_id' value='${user.user_id}'/>
				 		 </c:url>">
								${user.user_name}</a> <%-- <%=user.getName()%></a> --%></td>
						<td>${user.email} <%-- <%=user.getEmail()%> --%>
						</td>						<td>${user.user_level }</td>

					</tr>
				</c:forEach>
				<%--
		  }
		}
--%>
			</tbody>
		</table>
	</div>
	<br><br>
</body>
</html>