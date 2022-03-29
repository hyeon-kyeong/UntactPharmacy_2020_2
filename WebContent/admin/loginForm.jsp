<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>언택트 약국 - 관리자</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 	<script>
function login() {
	if (form.user_id.value == "") {
		alert("관리자 ID를 입력하십시오.");
		form.user_id.focus();
		return false;
	} 
	if (form.user_password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.user_password.focus();
		return false;
	}		
	form.submit();
}
	</script>
	
	<style>
	body{
	background:#343a40;
	}
	h4, label, p{
	color:white;
	}
	
	
	</style>
</head>
<body>
<div class="container" id = "loginbox">  
	<br>
	<h4>관리자 로그인</h4>
	<br>

	<!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	<div class="col-lg-12">
		<c:if test="${loginFailed}">
			<h6 class="text-danger"><c:out value="${exception.getMessage()}"/></h6>
		</c:if>
	</div>	  
	<!-- login form  -->
	<form class="col-md-6 col-lg-6" name="form" method="POST" action="<c:url value='/admin/login' />">
		
	
		<div class="form-group">   
	        <label for="user_id">사용자 ID</label>
	        <input type="text" name="user_id" class="form-control" placeholder="관리자 ID"> 
	    </div>       
	    <div class="form-group">  
	        <label for="user_password">비밀번호</label>
	        <input type="password" name="user_password" class="form-control" placeholder="비밀번호"> 
	    </div> 
		<div class="form-group">        
			<input type="button" class="btn btn-outline-light" value="로그인" onClick="login()"> 
		</div>   
		<p> somsom/somsom</p>
	</form> 
	
</div>
</body>
</html>