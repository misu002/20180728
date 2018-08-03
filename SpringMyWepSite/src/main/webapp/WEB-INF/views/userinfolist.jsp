<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java.util.List"%>
<%@page import="BeanModel.userinfo"%>
<%@page import="Services.GetUserService"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="member" scope="session" class="BeanModel.MemberInfo" />

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>

	<%@ include file="Menus.jsp"%>
	<h1>이 블로그의 전체 회원 정보</h1>
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
		<c:choose>
		<c:when test="${userlist.isEmpty()}">
		<h1>등록된 회원정보가 없습니다</h1>
		</c:when>
		<c:otherwise>
		<c:forEach var="i" items="${userlist}" >
		<tr>
			<td>${i.id}</td>
			<td>${i.pw}</td>
			<td>${i.name}</td>
			<td>${i.birth}</td>
			<td>${i.gender}</td>
			<td>${i.phone}</td>
			<td>${i.email}</td>
			<c:if test="${i.imgname eq null}">
			<td><img src="<c:url value='/resources/imgs/aaaaa.png' />" style="width: 30px"/></td>
			</c:if>
			<c:if test="${i.imgname ne null}">
			<td><img src="<c:url value='/resources/uploadFile/memberPhoto/${i.imgname}'/>" style="width: 50px"/></td>
			</c:if>	
			<td><a href="">수정 </a><a href=""> 삭제</a></td>
		</tr>
		</c:forEach>
		</c:otherwise>
</c:choose>

		<!-- 	}
		} catch (SQLException ex) {
			out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (rs != null)	try {rs.close();} catch (SQLException ex) {	}
			if (stmt != null)try {	stmt.close();} catch (SQLException ex) {}
			if (conn != null)try {	conn.close();} catch (SQLException ex) {}
	} -->




	</table>
	<a href="/index.jsp">홈으로 돌아가기</a>
</body>

</html>