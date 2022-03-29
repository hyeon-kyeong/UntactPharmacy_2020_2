<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>약품 리스트</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="/navbar.jsp"%>

	<div class="container">
		<br> <img src="../images/medicineLogo.png" width=400 height=124>
		<br>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">이름</th>
					<th scope="col">가격</th>
					<th scope="col">카테고리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="medicine" items="${medicine_list}">
					<tr>
						<td><a
							href="<c:url value='/medicine/view/detail'>
						   <c:param name='med_id' value='${medicine.med_id}'/>
				 		 </c:url>">
								${medicine.med_name}</a></td>
						<td>${medicine.price}</td>
						<td>${medicine.med_category}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
	</div>
</body>
</html>