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
	<%@include file="/admin/navbar.jsp"%>

	<div class="container">
		<br> <img src="../../images/medicineLogo.png" width=400
			height=124> <br>
		<div align="right">
			<a href="<c:url value='/medicine/register/form' />"
				class="btn btn-outline-info">약품 추가 </a>
		</div>
		<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">이름</th>
					<th scope="col">가격</th>
					<th scope="col">제약회사</th>
					<th scope="col">관련 증상</th>
					<th scope="col">카테고리</th>
					<th scope="col">재고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="medicine" items="${medicine_list}">
					<tr>
						<form name="form" method="POST"
							action="<c:url value='/medicine/quantity/update'/>">
						<td><input type="hidden" name="med_id"
							value="${medicine.med_id}" />${medicine.med_id}</td>
						<td><a
							href="<c:url value='/medicine/view'>
						   <c:param name='med_id' value='${medicine.med_id}'/>
				 		 </c:url>"><input
								type="hidden" name="med_name" value="${medicine.med_name}" />
								${medicine.med_name}</a></td>
						<td><input type="hidden" name="price"
							value="${medicine.price}" />${medicine.price}</td>
						<td><input type="hidden" name="co_name"
							value="${medicine.co_name}" />${medicine.co_name}</td>
						<td><input type="hidden" name="symptom"
							value="${medicine.symptom}" />${medicine.symptom}</td>
						<td><input type="hidden" name="med_category"
							value="${medicine.med_category}" />${medicine.med_category}</td>
						<td><input type="text" name="quantity"
							class="form-group col-md-4" value="${medicine.quantity}">
							&nbsp; <input type="button" class="btn btn-outline-success"
							value="재고 수정" onClick="submit();"></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<br>
	</div>
</body>
</html>