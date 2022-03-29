<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 

<%-- <%
	@SuppressWarnings("unchecked") 
	List<Community> commList = (List<Community>)request.getAttribute("commList");
%> --%>
<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>약국 관리 - 목록</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
	<img src="../images/PharmacyListLogo.png" width=460 height=140>
	<br><br>
	<table class="table">
  <thead class="thead-light">
		<tr>
		  <td scope="col">약국 이름</td>
		  <td scope="col">약국 위치</td>
		</tr>
      </thead>
      <tbody>  	 
		<c:forEach var="pharmacy" items="${pharmacy_list}">
			<tr>
			  <td>
			  <a href="<c:url value='/pharmacy/view'>
						   <c:param name='pharm_name' value='${pharmacy.pharm_name}'/>
				 		 </c:url>">
				  ${pharmacy.pharm_name}</a>
			  </td>
			  <td>${pharmacy.position}</td>
			</tr>
		</c:forEach>
	  </tbody>
	</table>	  	 
	<br> 
		<% ses = request.getSession();
if (UserSessionUtils.isLoginUser("somsom", ses)) { %>
<a href="<c:url value='/pharmacy/createForm.jsp' />" class="btn btn-info">약국 생성</a> 
<%}else{ %>
	<a href="javascript:history.go(-1)" class="btn btn-outline-warning">뒤로가기</a> 
<%} %>  
	
</div>
</body>
</html>