<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>증상별 약 찾기</title>
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
	<br><img src="../images/medicineLogo.png" width=400 height=124>
	<div>
	<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='감기'/>
				 		 </c:url>">감기</a>
  </li>
  <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='발열'/>
				 		 </c:url>">발열</a>
  </li>
   <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='통'/>
				 		 </c:url>">두통, 복통, 생리통</a>
  </li>
   <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='상처'/>
				 		 </c:url>">상처</a>
  </li>
  <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='아토피'/>
				 		 </c:url>">아토피</a>
  </li>
  <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='여드름'/>
				 		 </c:url>">여드름</a>
  </li>
  <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='피임'/>
				 		 </c:url>">피임</a>
  </li>
    <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='화상'/>
				 		 </c:url>">화상</a>
  </li>
    <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='위'/>
				 		 </c:url>">위 건강</a>
  </li>
   <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='장'/>
				 		 </c:url>">장 건강</a>
  </li>
  <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='변비'/>
				 		 </c:url>">변비</a>
  </li>
  <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='구강'/>
				 		 </c:url>">구강 건강</a>
  </li>
    <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='관절'/>
				 		 </c:url>">관절 건강</a>
  </li>
   <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='숙취'/>
				 		 </c:url>">숙취</a>
  </li>
   <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='금연'/>
				 		 </c:url>">금연</a>
  </li>
   <li>
  <a class="nav-link" href="<c:url value='/search/symptomList'>
						   <c:param name='symptom' value='마스크'/>
				 		 </c:url>">마스크</a>
  </li>
</ul>
	</div>
	<div class="container">
		<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">이름</th>
					<th scope="col">가격</th>
					<th scope="col">카테고리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="medicine" items="${medicine_list}">
					<tr>
						<td><a
							href="<c:url value='/medicine/view/detail'>
						   <c:param name='med_id' value='${medicine.med_id}'/>
				 		 </c:url>">
								${medicine.med_name}</a></td>
						<td>${medicine.price}</td>
						<td>${medicine.med_category}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>