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
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<style>
	#reSend{
	background : lightgray;
	border : none;		
	}
</style>
<c:url var="reSend" value="/reSend"/>
<script>
$(document).ready(function(){
	$('button').click(function(){
		$.ajax({
			type:"get",
			url: "${reSend}",
			success:function(data){
				alert(data);				
			},
			error: function() {
	            alert("메일을 보내지 못했습니다. 다시 시도해 주세요.");
	        } 
		})
	})
})

</script>
</head>
<body>
<%@ include file="Menus.jsp" %>

<h2>${Userinfo.id}님의 회원정보</h2>

			<c:if test="${Userinfo.imgname eq null}">
			<img src="<c:url value='/resources/imgs/aaaaa.png' />" style="width: 300px"/>
			</c:if>
			<c:if test="${Userinfo.imgname ne null}">
			<img src="<c:url value='/resources/uploadFile/memberPhoto/${Userinfo.imgname}'/>" style="width: 400px"/>
			</c:if>	
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
			<td>${Userinfo.id}</td>
			<td>${Userinfo.pw}</td>
			<td>${Userinfo.name}</td>
			<td>${Userinfo.birth}</td>
			<td>${Userinfo.gender}</td>
			<td>${Userinfo.phone}</td>
			<td>${Userinfo.email}</td>
			<td>${Userinfo.confirm}</td>
			<td> <a href="">수정
			</a><a href=""> 삭제</a>  </td>
		</tr>		
		
		</table>
	
<a href="<c:url value='/'/>">홈으로 돌아가기</a><br>
<button id="reSend">인증 메일 다시 보내기</button>
<%-- <a href="<c:url value='/reSend'/>">인증메일 다시 보내기</a> --%>
</body>

</html>