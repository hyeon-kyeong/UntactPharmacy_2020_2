<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>언택트 약국</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script>
	function login() {
		if (form.user_id.value == "") {
			alert("사용자 ID를 입력하십시오.");
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
#adminLogin {
	float: right;
}
.container{
padding:20px 0;
}
</style>
</head>
<body>
	<div class="container" >
		<a href="<c:url value='/admin/login/form' />"
			class="btn btn-outline-secondary" id="adminLogin">관리자 로그인</a>
		<div id="loginbox">
		<a href="<c:url value='/' />"><img src="<c:url value='/images/loginLogo.png' />" width=400 height=160></a>
			<br>

			<!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
			<div class="col-lg-12">
				<c:if test="${loginFailed}">
					<h6 class="text-danger">
						<c:out value="${exception.getMessage()}" />
					</h6>
				</c:if>
			</div>
			<!-- login form  -->
			<form class="col-md-6 col-lg-6" name="form" method="POST"
				action="<c:url value='/user/login' />">

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-default">User
							ID</span>
					</div>
					<input type="text" name="user_id" class="form-control"
						placeholder="사용자 ID" class="form-control" aria-label="Default"
						aria-describedby="inputGroup-sizing-default">
				</div>


				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-default">Password</span>
					</div>
					<input type="password" name="user_password" class="form-control"
						placeholder="비밀번호" class="form-control" aria-label="Default"
						aria-describedby="inputGroup-sizing-default">
				</div>


				<div class="form-group">
					<input type="button" class="btn btn-outline-success" value="로그인"
						onClick="login()"> <a
						href="<c:url value='/user/register/form' />"
						class="btn btn-outline-info">회원 가입 </a>
				</div>

			</form>
		</div>
	</div>
</body>
</html>