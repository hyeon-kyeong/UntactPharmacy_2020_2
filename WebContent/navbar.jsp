<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="<c:url value='/' />">Untact Pharmacy</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- Links -->
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#"><span
					class="sr-only">(current)</span></a></li>
			<%-- 
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/user/list' />" id="navbardrop" data-toggle="dropdown">
       	사용자 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='/user/list' />">사용자 목록</a>
        <a class="dropdown-item" href="<c:url value='/user/register/form' />">사용자 추가</a>
      </div>
    </li>
    --%>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle"
				href="<c:url value='/medicine/list' />" id="navbarDropdown"
				data-toggle="dropdown"> 상품 보기 </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="<c:url value='/medicine/list' />">전체 상품 리스트</a>
						<a class="dropdown-item" href="<c:url value='/medicine/listBySymptom.jsp' />">증상별 약 보기</a>
					<%-- 
        <a class="dropdown-item" href="<c:url value='/medicine/register/form' />">약 정보 등록</a>
        --%>
					<a class="dropdown-item" href="<c:url value='/search' />">약 검색</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle"
				href="<c:url value='/medicine/list' />" id="navbardrop"
				data-toggle="dropdown"> 게시판 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="<c:url value='/post/list' />">게시글
						목록</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle"
				href="<c:url value='/medicine/list' />" id="navbardrop"
				data-toggle="dropdown"> 예약 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="<c:url value='/reservation/list' />">
						예약 목록</a>
				</div></li>
				<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle"
				href="<c:url value='/reservation/list' />" id="navbardrop"
				data-toggle="dropdown"> 마이페이지 </a>
				<div class="dropdown-menu">
				<a class="dropdown-item" href="<c:url value='/reservation/listMyReservation'>
						   <c:param name='user_id' value='${userId}'/>
				 		 </c:url>"> 예약 조회</a>
					<a class="dropdown-item" href="<c:url value='/post/listMyPost'>
					 <c:param name='user_id' value='${userId}'/></c:url>">
						게시글 조회</a>
				</div></li>
				<li class="nav-item"><a class="nav-link btn-link"
				href="<c:url value="/pharmacy/search/form" />"> 약국 검색 </a> <c:if
					test="${userId ne null}">
					<li class="nav-item"><a class="nav-link btn-link"
						href="<c:url value='/user/logout'/>">${userId}(로그아웃) </a></li>
				</c:if>
		</ul>
	</div>
</nav>
