<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>제품 관리 - 약품 정보 조회</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
function medicineRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
	</script>
</head>
<body>
<%@include file="/admin/navbar.jsp" %>

<div class="container">  
	<br>
	<h4>약 정보 조회</h4>
	<br>
	<table class="table">
    	<tbody> 
	  	  <tr>
			<th>약품 ID</th>
			<td>${medicine.med_id}</td>
		  </tr>
		  <tr>
			<th>약품 이름</th>
			<td>${medicine.med_name}</td>
		  </tr>
		  <tr>
			<th>제약회사 명</th>
			<td>${medicine.co_name}</td>
		  </tr>	
		  <tr>
			<th>관련 증상(효능, 효과)</th>
			<td>${medicine.symptom}</td>
		  </tr>	
		  <tr>
			<th>카테고리</th>
			<td>${medicine.med_category}</td>
		  </tr>		  
		  <tr>
			<th>약품 가격</th>
			<td>${medicine.price}</td>
		  </tr>	
		  <tr>
			<th>약품 수량</th>
			<td>${medicine.quantity}</td>
		  </tr>		  
		</tbody>
	</table>
	<br> 		     
    <a class="btn btn-outline-warning" 
    	href="<c:url value='/medicine/update' >
     		     <c:param name='med_id' value='${medicine.med_id}'/>
		 	  </c:url>">수정</a>
    <a class="btn btn-outline-danger" 
   		href="<c:url value='/medicine/delete'>
		     	 <c:param name='med_id' value='${medicine.med_id}'/>
	 	      </c:url>" onclick="return medicineRemove();">삭제</a>
    <a class="btn btn-outline-secondary" href="<c:url value='/medicine/admin/list' />">약품 목록</a> 	    
    <br>	   
	    
	<!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	<c:if test="${updateFailed || deleteFailed}">
		<h6 class="text-danger"><c:out value="${exception.getMessage()}"/></h6>
    </c:if>  
</div>  
</body>
</html>