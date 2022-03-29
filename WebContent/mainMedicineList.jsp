<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
    <%@page import="java.util.*, model.*, model.service.*" %>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<% MedicineManager medicineManager = MedicineManager.getInstance();
List<Medicine> medicine_list = medicineManager.findMedicineList(); %>
<meta charset="UTF-8">
 <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title></title>
</head>
<body>
<table class="table">
<tr>
<% String path = "<c:url value='/upload/";%>
<% int i = 0;
for(i = 0; i < medicine_list.size(); i++){
	Medicine medicine = medicine_list.get(i); 
	request.setAttribute("medicine", medicine);%>
	<td>
<div class="card-group" style="width: 16rem;">
  <img class="card-img-top" src="<c:url value='/upload/${medicine.filename}' />" alt="이미지 삽입 필요" width="216px" height="120px">
  <div class="card-body">
    <h5 class="card-title"><%= medicine.getMed_name()%></h5>
    <p class="card-text"><%= medicine.getPrice()%> 원</p>
    <c:set var="med_id" value="<%= medicine.getMed_id()%>"/> 
    
    <a href="<c:url value='/medicine/view/detail'>
						   <c:param name='med_id' value='${med_id}' />
				 		 </c:url>" class="btn btn-info">Detail</a>
  </div>
</div>
</td>
<% if(i == 3 || ((i+1) % 4) == 0){%>
</tr>
<tr>
<%}
}%>
</table>
</body>
</html>