<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 

<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>약국 관리 - 약국 정보 수정</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 	<script>
function commModify() {
	if (form.name.value == "") {
		alert("약국 이름을 입력하십시오.");
		form.name.focus();
		return false;
	} 
	if (form.desc.value == "") {
		alert("약국 위치를 입력하십시오.");
		form.desc.focus();
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
	<h4>약국 수정</h4>
	<br>
	<!-- Update Form  -->
	<form name="form" method="POST" action="<c:url value='/pharmacy/update' />">
		<input type="hidden" name="pharm_name" value="${pharm_name}"/>	  
	  	<div class="form-group row">   
	        <label class="col-lg-2 col-form-label">약국 이름</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${pharm_name}</p> 
	        	<input type="text" name="pharm_name" class="form-control" value="${pharm_name}">
	        </div>
	    </div>       
	    <div class="form-group row">   
	        <label for="name" class="col-lg-2 col-form-label">약국 위치</label>
	        <div class="col-lg-10">
	            <input type="text" name="position" class="form-control" value="${position}"> 
	        </div>
	    </div> 
	    <div class="form-group">        
			<input type="button" class="btn btn-primary" value="수정" onClick="updatePharmacy()"> 
			<a href="<c:url value='/pharmacy/list' />" class="btn btn-link">약국 목록 </a>    		     
		</div>       	 
	</form>
</div>
</body>
</html>