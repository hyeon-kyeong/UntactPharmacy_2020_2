<%-- 
<% response.sendRedirect(request.getContextPath() + "/user/list"); %>
--%>
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
<title>index</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
function medSearch() {
	if (form.select.value == "") {
		alert("검색할 항목을 선택 ");
		form.search.focus();
		return false;
	}
	if (form.search.value == "") {
		alert("검색할 내용을 입력하십시오.");
		form.search.focus();
		return false;
	}
	
	form.submit();
}
</script>
</head>
<body>
	<%@include file="/navbar.jsp"%>
	<div class="container">

		<br>
		<h4>약 검색</h4>
		<div class="col-lg-12">
			<c:if test="${medicineNotFound}">
				<h6 class="text-danger">
					<c:out value="${exception.getMessage()}" />
				</h6>
			</c:if>
		</div>

		<form class="form-inline" name="form" method="GET"
			action="<c:url value='/search/list' />">
			<div class="input-group mb-3">
  <div class="input-group-prepend">
				<select class="custom-select" id="inputGroupSelect04" name="select">
					<option value="name">이름</option>
					<option value="id">약 id</option>
					<option value="category">카테고리</option>
					<option value="symptom">증상</option>
				</select>
				<div class="input-group-append">
					<input type="text" name="search" class="form-control" style="width:600px;">
				</div>
				<div class="input-group-append">
					&nbsp; <button class="btn btn-primary" type="button" value="search" onclick="medSearch()">검색</button>
				</div>
			</div>


		</form>

	</div>
	<br>
	<div class="container">
	<h4>검색 결과</h4>
	<br>

	<table class="table table-bordered">
      <thead class="thead-inverse">
      	<tr>
		  <td>약품 ID</td>
		  <td>이름</td>
		  <td>가격</td>
		  <td>카테고리</td>
		  <%-- 
		  <td>장바구니</td>
		  --%>
		</tr>
      </thead>
      <tbody> 
	  	
		<c:forEach var="medicine" items="${medicine_list}">  			  	
	  	    <tr>
			  <td>
			  	${medicine.med_id}      
			  </td>
			  <td>
				<a href="<c:url value='/medicine/view/detail'>
						   <c:param name='med_id' value='${medicine.med_id}'/>
				 		 </c:url>">
				  ${medicine.med_name}</a>	 
			  </td>
			  <td>
			    ${medicine.price}      
			  </td>
			  <td>
				${medicine.med_category}
			  </td>
			  <%-- 
			  <td>
			  <a class="btn  btn-outline-primary">추가</a>
			  </td>
			  --%>
			</tr>
		 </c:forEach> 
	  </tbody>
	</table>		  	 
	<br>   
</div>
</body>
</html>