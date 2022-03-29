<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 
<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>게시판 관리 - 게시글 조회</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
function postRemove() {
	return confirm("정말 삭제하시겠습니까?");		
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
	<h4>제목 : ${post.title}</h4>
	<br>
	<table class="table">
    	<tbody> 
    	<tr>
			<th>#</th>
			<td>${post.post_id}</td>
		  </tr>
	  	  <tr>
			<th>작성자</th>
			<td>${post.user_id}</td>
			<c:set var="user_id" value="${post.user_id}" ></c:set>
		  </tr>
		  <tr>
			<th>구매 약</th>
			<td>${post.med_id}</td>
		  </tr>
		  <tr>
			<th>작성일</th>
			<td>${post.post_date}</td>
		  </tr>
		  <tr>
			<th>복용기간</th>
			<td>${post.ingestion_start}  ~  ${post.ingestion_end}</td>
		  </tr>	
		  <tr>
			<th>제목</th>
			<td>${post.title}</td>
		  </tr>
		  <tr>
			<th>내용</th>
			<td>${post.content}</td>
		  </tr>	
		  	  
		</tbody>
	</table>
	<br> 		     
    <%ses = request.getSession();
String curUser =  (String)pageContext.getAttribute("user_id");
System.out.println("userID:" + curUser);
if (UserSessionUtils.isLoginUser(curUser, ses) || UserSessionUtils.isLoginUser("somsom", ses)) { %>
<br>  <a class="btn btn-outline-warning" 
       href="<c:url value='/post/update' >
                <c:param name='post_id' value='${post.post_id}'/>
            </c:url>">수정</a>
    <a class="btn btn-outline-dark" 
         href="<c:url value='/post/delete'>
               <c:param name='post_id' value='${post.post_id}'/>
             </c:url>" onclick="return postRemove();">삭제</a>
    <a class="btn btn-outline-success" href="<c:url value='/post/list' />">게시글 목록</a>      
<%}else{ %>
   <a href="javascript:history.go(-1)" class="btn btn-outline-warning">뒤로가기</a> 
<%} %>
</div>  
</body>
</html>