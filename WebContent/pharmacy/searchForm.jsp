<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 

<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>약국 등록 - 약국 정보 입력</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	 	<script>
function PharmacySearch() {
	if (form.province.value == "") {
		alert("검색할 시/도 를 입력해주세요.");
		form.province.focus();
		return false;
	} 
	if (form.city.value == "") {
		alert("검색할 시/군/구를 입력해주세요.");
		form.city.focus();
		return false;
	}	
	form.submit();
}
	</script>
</head>

<body>
<%HttpSession ses = request.getSession();
if (UserSessionUtils.isLoginUser("somsom", ses)) { %>
<%@include file="/admin/navbar.jsp" %>
<%}else{ %>
<%@include file="/navbar.jsp"%>
<%} %>
<div class="container">  
	<br>
	<img src="<c:url value='/images/pharmacyLogo.png' />" width=400 height=136>
	<br><br>
	  
	<!-- 약국 검색 form  -->
	<form name="form" method="POST" action="<c:url value='/pharmacy/search'/>">
		<input type="hidden" name="name" value="${pharmacy.name}"/>	  
		<div class="form-group row">   
	        <label for="province" class="col-lg-2 col-form-label">시/도</label>
	        <div class="col-lg-10">
	            <input type="text" name="province" class="form-control" placeholder="검색할 시/도 입력 (예: 서울특별시)"> 
	        </div>
	    </div>       
	    <div class="form-group row">   
	        <label for="city" class="col-lg-2 col-form-label">시/군/구</label>
	        <div class="col-lg-10">
	            <input type="text" name="city" class="form-control" placeholder="검색할 시/군/구 입력 (예: 성북구)"> 
	        </div>
	    </div>       
	    <br>
		<div class="form-group">        
			<input type="button" class="btn btn-outline-info" value="검색" onClick="PharmacySearch()"> 		     
		</div> 
		<br>
		<img src="<c:url value='/images/pharmacyResultLogo.png' />" width=190 height=60>
		<br><br>
	<table class="table table-hover">
      <thead>
		<tr>
		  <td>약국 명</td>
		  <td>약국 주소</td>
		</tr>
      <tbody>  	 
		<c:forEach var="pharmacy" items="${pharmacy_list}">
			<tr>
			  <td><a href="<c:url value='/pharmacy/view/create'>
						      <c:param name='pharm_name' value='${pharmacy.pharm_name}'/>
						      <c:param name='position' value='${pharmacy.position}'/>
						   </c:url>">
				  ${pharmacy.pharm_name}</a>
			  </td>
			  <td>${pharmacy.position}</td>
			</tr>
		</c:forEach>
	  </tbody>
	</table>	  	 
	  
	</form> 
</div>
</body>    
</html>