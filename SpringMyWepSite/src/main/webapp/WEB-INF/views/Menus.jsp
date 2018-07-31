<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
        body {
            background: lightgray;
            font-family: 'Markazi Text', serif;
            font-family: 'Nanum Gothic', sans-serif;
        }

         #links{
            width: 1500px;
            margin: 20px auto;
        }     
        
        a{
            margin-right: 20px;
            text-decoration: none;
            color: black;            
            padding-left: 10px;
        }

</style>
</head>
<body>
    <div id="links">
    <c:choose>
    <c:when test="${id eq null}">
    <a href="<c:url value='/member/login/login'/>">로그인</a>
    <a href= "<c:url value='/GoRegister'/>" >회원가입</a>
    <a href="/mywebsite/MList.jsp">방명록</a>
    </c:when>
	<c:when test="${id eq 'misu002'}">
    <a href="<c:url value='/member/login/Logout' />">로그아웃</a>
    <a href="<c:url value='/member/Mypage' />" >마이페이지</a>
    <a href="/mywebsite/MList.jsp">방명록</a>
    <a href="<c:url value='/userinfolist'/>">회원리스트</a>
    <a href="<c:url value='/empList'/>">사원리스트</a>
    <a href="<c:url value='/empInsertForm'/>">사원등록</a>
    </c:when>
    <c:otherwise>
    	<a href="<c:url value='/member/login/Logout' />">로그아웃</a>
    	<a href="<c:url value='/member/Mypage' />" >마이페이지</a>
   		<a href="/mywebsite/MList.jsp">방명록</a>
   	</c:otherwise>
   	</c:choose>
        </div>
</body>
</html>