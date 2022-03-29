<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/user/list' />" id="navbardrop" data-toggle="dropdown">
       	사용자 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='/admin/list' />">사용자 목록</a>
        <a class="dropdown-item" href="<c:url value='/admin/register/form' />">사용자 추가</a>
      </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/medicine/list' />" id="navbardrop" data-toggle="dropdown">
       	약품 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='/medicine/admin/list' />">재고 관리</a>
        <a class="dropdown-item" href="<c:url value='/medicine/register/form' />">약품 등록</a>
      </div>
    </li>
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/pharmacy/list' />" id="navbardrop" data-toggle="dropdown">
       	약국 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='/pharmacy/create/form' />">약국 등록</a>
        <a class="dropdown-item" href="<c:url value='/pharmacy/list' />">등록된 약국 목록</a>
      </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="<c:url value='/medicine/list' />" id="navbardrop" data-toggle="dropdown">
       	게시판 관리
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="<c:url value='/post/list' />">게시글 조회</a>
      </div>
    </li>

    <c:if test="${userId ne null}">
      <li class="nav-item">
	    <a class="nav-link btn-link" href="<c:url value='/user/logout'/>">${userId}(로그아웃)</a>
	  </li>
    </c:if>
  </ul>
</nav>
