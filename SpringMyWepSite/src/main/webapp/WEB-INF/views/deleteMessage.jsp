<%@page import="Services.InvalidMessagePassowrdException"%>
<%@page import="Services.DeleteMessageService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<%--     <%
    //해당 메세지를 작성한 사람의 이름과 messageId와 비교하기
    //메세지 아이디안의 이름 비교하기
        	int messageId = Integer.parseInt(request.getParameter("messageId"));
        	String GuestName=request.getParameter("name");
        	boolean invalidPassowrd = false;
        	try {
        		DeleteMessageService deleteService = DeleteMessageService.getInstance();
        		deleteService.deleteMessage(messageId, GuestName);
        	} catch (InvalidMessagePassowrdException ex) {
        		invalidPassowrd = true;
        	}
        %> --%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
<c:if test="${resultCnt>0}">
메시지를 삭제하였습니다.
</c:if>
<c:if test="${resultCnt eq 0}">
메세지를 작성한 회원이 아닙니다.
</c:if>
<br/>
<a href="<c:url value='/MList'/>">[목록 보기]</a>
<a href="<c:url value='/'/>">[홈으로 돌아가기]</a>
</body>
</html>