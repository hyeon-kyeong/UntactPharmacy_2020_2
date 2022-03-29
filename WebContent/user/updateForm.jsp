<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
	User user = (User)request.getAttribute("user");
--%>
<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>사용자 관리 - 회원 정보 수정</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 	<script>
function userModify() {
	if (form.user_password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}
	if (form.user_password.value != form.password2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.name.focus();
		return false;
	}
	if (form.user_name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.email.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if(phoneExp.test(form.phone.value)==false) {
		alert("전화번호 형식이 올바르지 않습니다.");
		form.phone.focus();
		return false;
	}
	form.submit();
}
	</script>
</head>
<body>
<%@include file="/navbar.jsp" %>

<div class="container">  
	<br>
	<h4>회원 정보 수정</h4>
	<br>
	<!-- Update Form  -->
	<form name="form" method="POST" action="<c:url value='/user/update' />">
		<input type="hidden" name="user_id" value="${user.user_id}"/>	  
		<div class="form-group row">   
	        <label class="col-lg-2 col-form-label">사용자 ID</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${user.user_id}</p> 
	        </div>
	    </div>       
	    <div class="form-group row">   
	        <label for="user_password" class="col-lg-2 col-form-label">비밀번호</label>
	        <div class="col-lg-10">
	            <input type="password" name="user_password" class="form-control" value="${user.user_password}"> 
	        </div>
	    </div>       
	    <div class="form-group row">  
	        <label for="password2" class="col-lg-2 col-form-label">비밀번호 확인</label>
	        <div class="col-lg-10">
	        	<input type="password" name="password2" class="form-control" value="${user.user_password}">
	        </div> 
	    </div> 
		<div class="form-group row">   
	        <label for="user_name" class="col-lg-2 col-form-label">이름</label>
	        <div class="col-lg-10">
	        	<input type="text" name="user_name" class="form-control" value="${user.user_name}">
	        </div>
	    </div>       
	    <div class="form-group row">  
	        <label for="email" class="col-lg-2 col-form-label">이메일 주소</label>
	        <div class="col-lg-10">
	        	<input type="text" name="email" class="form-control" value="${user.email}">
	        </div>
	    </div> 
		<div class="form-group row">  
	        <label for="phone" class="col-lg-2 col-form-label">전화번호</label>
	        <div class="col-lg-10">
	        	<input type="text" name="phone" class="form-control" value="${user.phone}">
	        </div>
	    </div> 
	    <div class="form-group row">
				<label for="gender" class="col-lg-2 col-form-label">성별</label>
				<div class="col-lg-10">
					<select name="gender" class="form-control"
						id="exampleFormControlSelect1" >
						<option>F</option>
						<option>M</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="birth_date" class="col-lg-2 col-form-label">생일</label>
				<div class="col-lg-10">
					<input type="text" name="birth_date" class="form-control" value="${user.birth_date}">
				</div>
			</div>
			

			<div class="form-group row">
				<label for="symptom" class="col-lg-2 col-form-label">증상</label>
				<div class="col-lg-10">
					<input type="text" name="symptom" class="form-control" value="${user.symptom}">
				</div>
			</div>
			
	   	<br>
		<div class="form-group">        
			<input type="button" class="btn btn-outline-success" value="수정" onClick="userModify()">
			<a href="<c:url value='/user/list' />" class="btn btn-outline-info">사용자 목록 </a>    		     
		</div>   
	</form>
</div>
</body>
</html>