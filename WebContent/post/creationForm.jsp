<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판 관리 - 게시글 등록</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
	function postCreate() {
		if (form.title.value == "") {
			alert("제목을 입력하십시오.");
			form.title.focus();
			return false;
		}
		if (form.med_id.value == "") {
			alert("약 이름을 입력하십시오.");
			form.med_id.focus();
			return false;
		}
		if (form.ingestion_start.value == "") {
			alert("내용을 입력하십시오.");
			form.ingestion_start.focus();
			return false;
		}
		if (form.ingestion_end.value == "") {
			alert("내용을 입력하십시오.");
			form.ingestion_end.focus();
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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script>
	$.datepicker.setDefaults({
		dateFormat : 'yy/mm/dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
				'10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년'
	});

	$(function() {
		$("#datepicker1, #datepicker2").datepicker();
	});
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
		<br> <img src="../images/reviewLogo.png" width=430 height=150>
		<br>
		<form name="form" method="POST" action="<c:url value='/post/create'/>">
			<div class="form-group row">
				<label for="title" class="col-lg-2 col-form-label">제목</label>
				<div class="col-lg-10">
					<input type="text" name="title" class="form-control"
						placeholder="제목">
				</div>
			</div>
			<input type="hidden" name="user_id" value="${userId}"/>
			<div class="form-group row">   
		        <label class="col-lg-2 col-form-label">작성자</label>
		        <div class="col-lg-10">
		        	<p class="form-control-static">${userId}</p> 
		        </div>
		    </div>
			<div class="form-group row">
				<label for="med_id" class="col-lg-2 col-form-label">복용 약</label>
				<div class="col-lg-10">
					<input type="text" name="med_id" class="form-control"
						placeholder="제품명">
				</div>
			</div>
			<pre>복용기간		     	 <input type="text" name="ingestion_start" id="datepicker1"> ~ <input
					type="text" name="ingestion_end" id="datepicker2">
			</pre>
			
			<div class="form-group row">
				<label for="content" class="col-lg-2 col-form-label">내용</label>
				<div class="col-lg-10">
					<input type="text" name="content" class="form-control"
						placeholder="내용을 입력하세요.">
				</div>
			</div>
			<br>
			<div class="form-group">
				<input type="button" class="btn btn-outline-primary" value="등록"
					onClick="postCreate()"> <a
					href="<c:url value='/post/list' />"
					class="btn btn-outline-secondary">게시판 목록 </a>
			</div>
		</form>
	</div>
</body>
</html>