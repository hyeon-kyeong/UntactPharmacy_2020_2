<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>약품 리스트</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="/navbar.jsp" %>

<div class="container">   
	<br>
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
				<a href="<c:url value='/medicine/view'>
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
	<a href="<c:url value='/search' />" class="btn btn-outline-primary">검색 화면으로 돌아가기 </a>    		     
</div>
</body>
</html>