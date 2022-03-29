<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>게시판 리스트</title>
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
	<img src="../images/reviewListLogo.png" width=450 height=133>
	<br>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
	<th scope="col">작성자</th>
	<th scope="col">구매한 약</th>
		  <th scope="col">제목</th>
		  <th scope="col">작성일</th>
		</tr>
      </thead>
      <tbody> 
	  	
		<c:forEach var="post" items="${post_list}">  			  	
	  	    <tr>
			  <td>
			  	${post.post_id}       <%-- <%=post.getPost_id()%> --%>
			  </td>
			  <td>
				${post.user_id} 	 <%-- <%=post.getUser_id()%></a> --%>
			  </td>
			  <td>
				${post.med_id} 	 <%-- <%=post.getMed_id()%></a> --%>
			  </td>
			  <td>
				<a href="<c:url value='/post/view'>
						   <c:param name='post_id' value='${post.post_id}'/>
				 		 </c:url>">		
				${post.title}</a>
			  </td>
			  <td>
			    ${post.post_date}        <%-- <%=post.getPost_date()%> --%>
			  </td>
			</tr>
		 </c:forEach> 
	  </tbody>
	</table>		  	 
	<a href="<c:url value='/post/creationForm.jsp'/>" class="btn btn-outline-primary">게시글 등록 </a>        
</div>
<br><br>
</body>
</html>