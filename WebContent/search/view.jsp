<%-- 
<% response.sendRedirect(request.getContextPath() + "/user/list"); %>
--%>


<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	@SuppressWarnings("unchecked") 
	User user = (User)request.getAttribute("user");
--%>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="/navbar.jsp"%>
<div class="container">

	<br>
	<h4>약 검색</h4>
	
	<form class="col-md-6 col-lg-6" name="form" method="POST" action="<c:url value='/search/list' />">
	
	</form>
	
</div>

	
</body>
</html>