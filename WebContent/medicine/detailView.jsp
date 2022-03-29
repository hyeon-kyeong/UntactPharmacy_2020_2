<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>제품 관리 - 약품 정보 조회</title>
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
		<br> <br>
		<div class="card" style="width: 60rem">
<img class="card-img-top" src="<c:url value='/upload/${medicine.filename}' />" alt="이미지 삽입 필요" width="10"				height="500"/>
			<div class="card-body">
				<h5 class="card-title">${medicine.med_name}</h5>
				<p class="card-text">${medicine.symptom}관련 약품입니다.</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">분류: ${medicine.med_category}</li>
				<li class="list-group-item">제조회사: ${medicine.co_name}</li>
				<li class="list-group-item">가격: ${medicine.price} 원</li>
			</ul>
		</div>
		<br>
<c:choose>
				<c:when test="${medicine.quantity == 0}">
				<a style=color:red;>&nbsp; 재고가 없습니다.</a>
				</c:when>
				<c:otherwise>
					<a class="btn btn-outline-warning"
			href="<c:url value='/reservation/create/form'>
     		     <c:param name='med_id' value='${medicine.med_id}'/>
		 	  </c:url>">예약</a>
				</c:otherwise>
			</c:choose>
		
		<a class="btn btn-outline-secondary" href="javascript:history.go(-1)">뒤로가기</a>
		<br>

		<!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
		<c:if test="${updateFailed || deleteFailed}">
			<h6 class="text-danger">
				<c:out value="${exception.getMessage()}" />
			</h6>
		</c:if>
	</div>
</body>
</html>