<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>예약 관리 - 예약 등록</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
	function reservationCreate() {
		if (form.user_id.value == "") {
			alert("사용자 ID를 입력하십시오.");
			form.user_id.focus();
			return false;
		}
		/* if (form.med_id.value == "") {
			alert("약 ID를 입력하십시오.");
			form.med_id.focus();
			return false;
		} */
		if (form.reserv_date.value == "") {
			alert("예약 날짜를 입력하십시오.");
			form.reserv_date.focus();
			return false;
		}
		if (form.pharm_name.value == "") {
			alert("약국 이름을 입력하십시오.");
			form.pharm_name.focus();
			return false;
		}
		if (form.reserv_date.value == "") {
			alert("예약일을 입력하십시오.");
			form.reserv_date.focus();
			return false;
		}
		if (form.address.value == "") {
			alert("주소를 입력하십시오.");
			form.address.focus();
			return false;
		}
		else
		      alert("약물 오남용 주의 : 약물 복용시 용법 용량을 준수하십시오. \n약물 부작용 주의 : 약물 복용시 약물 부작용 및 금기사항에 유의하십시오.")
		form.submit();
	}
</script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script>
	$(function() {
		$("#datepicker1").datepicker(
				{
					dateFormat : 'yy/mm/dd',
					prevText : '이전 달',
					nextText : '다음 달',
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					showMonthAfterYear : true,
					changeMonth : true,
					changeYear : true,
					yearSuffix : '년'
				});
	});
</script>
</head>
<body>
	<%@include file="/navbar.jsp"%>
	<div class="container">
		<br>
		<h4>예약 등록</h4>
		<br>
		<form name="form" method="POST"
			action="<c:url value='/reservation/create'/>">
			<input type="hidden" name="user_id" value="${user_id}"/>
		<div class="form-group row">   
	        <label for="user_id" class="col-lg-2 col-form-label">사용자 ID</label>
	        <div class="col-lg-10">
	        	<p class="form-control-static">${user_id}</p> 
	        </div>
	    </div>
			<div class="form-group row">
				<label for="pharm_name" class="col-lg-2 col-form-label">약국
					선택</label>
				<div class="col-lg-10">
					<select id="pharmSelect" name="pharm_name" class="form-control">
						<c:forEach var="pharm" items="${pharmacy_list}" varStatus="status">
							<option value="${pharm.pharm_name}">${pharm.pharm_name}(
								${pharm.position} )</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="reserv_date" class="col-lg-2 col-form-label">예약일</label>
				<div class="col-lg-10">
					<input type="text" id="datepicker1" name="reserv_date"
						class="form-control" placeholder="2020/01/01">
				</div>
			</div>

			<div class="form-group row">
				<label for="address" class="col-lg-2 col-form-label">주소</label>
				<div class="col-lg-10">
					<input type="text" name="address" class="form-control"
						placeholder="성북구 화랑로 13길 60">
				</div>
			</div>

			<div class="form-group">
				<label for="med_id" class="col-lg-2 col-form-label">약품 선택</label>

				<c:forEach var="med" items="${medicine_list}" varStatus="status">
					<div class="form-check">
						<input class="form-check-input" type="checkbox"
							value="${med.med_id}" name="med_id" id="${med.med_id}"> <label
							class="form-check-label" for="defaultCheck1">
							${med.med_id}, ${med.med_name}</label>
					</div>
				</c:forEach>
			</div>
			<div class="form-group">
				<input type="button" class="btn btn-primary" value="등록"
					onClick="reservationCreate()"> <a
					href="<c:url value='/reservation/list' />" class="btn btn-link">예약
					목록 </a>
			</div>
		</form>
	</div>

</body>
</html>