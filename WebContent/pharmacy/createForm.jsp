<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>약국 등록 - 약국 정보 입력</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
function PharmacyCreate() {
	if (form.pharm_name.value == "") {
		alert("약국 검색을 먼저 해주세요.");
		form.pharm_name.focus();
		return false;
	} 
	if (form.position.value == "") {
		alert("약국 검색을 먼저 해주세요.");
		form.position.focus();
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
	<img src="../../images/PharmacyRegiLogo.png" width=460 height=140>
		<br><br>
		<a href="<c:url value='/pharmacy/searchForm.jsp' />"
			class="btn btn-secondary btn-lg btn-block">약국 검색하기</a>
<br> 
		<!-- registration form  -->
		<form name="form" method="POST"
			action="<c:url value='/pharmacy/register'/>">
		<div class="input-group mb-3">
		<div class="input-group-prepend">
		 <span class="input-group-text" id="inputGroup-sizing-default">약국 명</span>
		  <input type="hidden" class="form-control" name="pharm_name" value= "${pharmacy.pharm_name}"
		   aria-label="Default" aria-describedby="inputGroup-sizing-default"> &nbsp;&nbsp;${pharmacy.pharm_name}
		</div></div>
		
		<div class="input-group mb-3">
		<div class="input-group-prepend">
		 <span class="input-group-text" id="inputGroup-sizing-default">약국 위치</span>
		  <input type="hidden" class="form-control" name="position" value= "${pharmacy.position}"
		   aria-label="Default" aria-describedby="inputGroup-sizing-default">&nbsp;&nbsp; ${pharmacy.position}
		</div></div>
		
			<br>
			<%ses = request.getSession();
if (UserSessionUtils.isLoginUser("somsom", ses)) { %>
<div class="form-group">
				<input type="button" class="btn btn-outline-info" value="등록"
					onClick="PharmacyCreate()">
						<a href="<c:url value='/pharmacy/list' />" class="btn btn-outline-warning">등록된 약국 리스트 보기</a> 
<%}else{ %>
	<a href="<c:url value='/pharmacy/list' />" class="btn btn-outline-warning">등록된 약국 리스트 보기</a> 
<%} %>
			
		
			</div>
		</form>
	</div>
</body>
</html>