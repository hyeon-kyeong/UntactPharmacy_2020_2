<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*, model.*, javax.servlet.*, controller.*" %> 

<%--
	@SuppressWarnings("unchecked") 
	Community community = (Community)request.getAttribute("community");
--%>
<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>약국 관리 - 약국 정보 조회</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
function PharmacyRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
	</script>
</head>
<body>
<%@include file="/navbar.jsp" %>
<img src="../../images/pharmacyLogo.png" width=400 height=136><div class="container">  
	<br>
	<h4>약국 정보 조회</h4>
	<br>
	<table class="table">
    	<tbody> 
	  	  <tr>
			<th>약국 이름</th>
			<td>${pharmacy.pharm_name}</td>
		  </tr>
		  <tr>
			<th>약국 위치</th>
			<td>${pharmacy.position}</td>
		  </tr>
		</tbody>
	</table>
	<br> 		   
	 
		<%HttpSession ses = request.getSession();
if (UserSessionUtils.isLoginUser("somsom", ses)) { %>
<a class="btn btn-outline-danger" 
   		href="<c:url value='/pharmacy/delete'>
		     	 <c:param name='pharm_name' value='${pharmacy.pharm_name}'/>
	 	      </c:url>" onclick="return PharmacyRemove();">삭제</a>
    <a class="btn btn-outline-secondary" href="<c:url value='/pharmacy/list' />">약국 목록</a> 	
<%}else{ %>
	<a href="javascript:history.go(-1)" class="btn btn-outline-warning">뒤로가기</a> 
<%} %>    
         
    <br>
	    
	<!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	<c:if test="${updateFailed}">
		<h6 class="text-danger"><c:out value="${exception.getMessage()}"/></h6>
    </c:if>  
</div>  
</body>
</html>