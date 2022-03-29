<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	@SuppressWarnings("unchecked") 
	List<User> userList = (List<User>)request.getAttribute("userList");
	String curUserId = (String)request.getAttribute("curUserId");
--%>
<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>게시글 조회</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
function userRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
	</script>
	
</head>
<body>
<%@include file="/navbar.jsp" %>
<div class="container">   
	<br>
	<h4>게시글 조회</h4>
	<br>
	
	<table class="table table-bordered">
      <thead class="thead-inverse">
      	<tr>
		  <td>#</td>
		  <td>사용자 ID</td>
		  <td>약 이름</td>
		  <td>제목</td>
		  <td>작성일</td>
		</tr>
      </thead>
      <tbody>
				<c:forEach var="post" items="${post_list}">
					<tr>
						<td><a
							href="<c:url value='/post/view'>
						   <c:param name='post_id' value='${post.post_id}'/>
				 		 </c:url>">
								${post.post_id}</a></td>
						<td>${post.user_id}</td>
						<td>${post.med_id}</td>
						<td>${post.title}</td>
						<td>${post.post_date}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>		  	 
	<br>  
</div>
</body>
</html>