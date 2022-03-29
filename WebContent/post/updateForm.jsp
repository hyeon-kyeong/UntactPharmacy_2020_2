<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>게시판 관리 - 게시글 수정</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 	<script>
function postModify() {
	if (form.title.value == "") {
		alert("제목을 입력하십시오.");
		form.title.focus();
		return false;
	}
	if (form.content.value == "") {
		alert("내용을 입력하십시오.");
		form.content.focus();
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
	<h4>게시글 수정</h4>
	<br>
	<!-- Update Form  -->
	<form name="form" method="POST" action="<c:url value='/post/update' />">
		<input type="hidden" name="post_id" value="${post.post_id}"/>
		<div class="form-group row">   
	        <label class="col-lg-2 col-form-label">게시판 ID</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${post.post_id}</p> 
	        </div>
	    </div>
	    <input type="hidden" name="user_id" value="${post.user_id}"/>
		<div class="form-group row">   
	        <label class="col-lg-2 col-form-label">사용자 ID</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${post.user_id}</p> 
	        </div>
	    </div>
	    <input type="hidden" name="post_date" value="${post.post_date}"/>
		<div class="form-group row">   
	        <label class="col-lg-2 col-form-label">작성 날짜</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${post.post_date}</p> 
	        </div>
	    </div>
	    <input type="hidden" name="med_id" value="${post.med_id}"/>
		<div class="form-group row">   
	        <label class="col-lg-2 col-form-label">복용 약</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${post.med_id}</p> 
	        </div>
	    </div>
	    <div class="form-group row">  
	        <label for="title" class="col-lg-2 col-form-label">제목</label>
	        <div class="col-lg-10">
	        	<input type="text" name="title" class="form-control" value="${post.title}">
	        </div> 
	    </div>  
	    <div class="form-group row">   
	        <label for="content" class="col-lg-2 col-form-label">내용</label>
	        <div class="col-lg-10">
	            <input type="text" name="content" class="form-control" value="${post.content}"> 
	        </div>
	    </div>       
	   	<br>
		<div class="form-group">        
			<input type="button" class="btn btn-outline-warning" value="수정" onClick="postModify()">
			<a href="<c:url value='/post/list' />" class="btn btn-outline-info">게시글 목록 </a>    		     
		</div>   
	</form>
</div>
</body>
</html>