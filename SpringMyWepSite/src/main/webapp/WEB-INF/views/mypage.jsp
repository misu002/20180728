<%@page import="BeanModel.userinfo"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>


<%@ include file="Menus.jsp" %>
<h2>${userinfo.id}님의 회원정보</h2>
<img src="<c:url value='/resources/uploadFile/memberPhoto/${userinfo.imgname}' />" style="width: 400px"/>

<table border="1">
		<tr>
		
		
			<td>Id</td>
			<td>PW</td>
			<td>Name</td>
			<td>Birthday</td>
			<td>Gender</td>
			<td>Phone Number</td>
			<td>Email</td>
		</tr>
		<tr>
			<td>${userinfo.id}</td>
			<td>${userinfo.pw}</td>
			<td>${userinfo.name}</td>
			<td>${userinfo.year}-${userinfo.month}-${userinfo.day}</td>
			<td>${userinfo.gender}</td>
			<td>${userinfo.phone}</td>
			<td>${userinfo.email}</td>
			<td> <a href="">수정
			</a><a href=""> 삭제</a>  </td>
		</tr>		
		
		</table>
	
<a href="<c:url value='/'/>">홈으로 돌아가기</a>
</body>

</html>