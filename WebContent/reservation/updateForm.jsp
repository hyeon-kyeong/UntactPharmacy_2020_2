<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko-kr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>예약 관리 - 예약 수정</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 	<script>
function reservationModify() {
	if (form.pharm_name.value == "") {
		alert("약국을 입력하십시오.");
		form.pharm_name.focus();
		return false;
	}
	if (form.address.value == "") {
		alert("주소를 입력하십시오.");
		form.reserv_address.focus();
		return false;
	}
	form.submit();
}
// reserv_id, user_id, med_id, pharm_name, reserv_date
	</script>
</head>
<body>
<%@include file="/navbar.jsp"%>
<div class="container">  
	<br>
	<h4>예약 수정</h4>
	<br>
	<!-- Update Form  -->
	<form name="form" method="POST" action="<c:url value='/reservation/update' />">
		<input type="hidden" name="reserv_id" value="${reservation.reserv_id}"/>
		<div class="form-group row">   
	        <label class="col-lg-2 col-form-label">#</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${reservation.reserv_id}</p> 
	        </div>
	    </div>
	    <input type="hidden" name="user_id" value="${reservation.user_id}"/>
		<div class="form-group row">   
	        <label class="col-lg-2 col-form-label">사용자 ID</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${reservation.user_id}</p> 
	        </div>
	    </div>
		<div class="form-group row">   
	        <label class="col-lg-2 col-form-label">약 ID</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${reservation.med_id}</p> 
	        </div>
	    </div>
	    <div class="form-group row">  
	        <label for="pharm_name" class="col-lg-2 col-form-label">선택 약국</label>
	        <div class="col-lg-10">
	        	<input type="text" name="pharm_name" class="form-control" value="${reservation.pharm_name}">
	        </div> 
	    </div>  
	    <div class="form-group row">   
	        <label for="address" class="col-lg-2 col-form-label">주소</label>
	        <div class="col-lg-10">
	            <input type="text" name="address" class="form-control" value="${reservation.address}"> 
	        </div>
	    </div>       
	   	<br>
		<div class="form-group">        
			<input type="button" class="btn btn-outline-warning" value="수정" onClick="reservationModify()">
			<a href="<c:url value='/reservation/list' />" class="btn btn-outline-info">예약 목록 </a>    		     
		</div>   
	</form>
</div>
</body>
</html>