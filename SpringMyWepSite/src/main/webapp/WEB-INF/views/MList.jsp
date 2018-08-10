<%@page import="Services.GetUserService"%>
<%@page import="Services.GetMessageListService"%>
<%@page import="BeanModel.Message"%>
<%@page import="BeanModel.MessageListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
    
<%--     <%
    	String id=(String)session.getAttribute("id");
    	String pageNumberStr=request.getParameter("page");
    	int pageNumber=1;
    	if(pageNumberStr!=null){
    		pageNumber = Integer.parseInt(pageNumberStr);
    	}
    
    	GetMessageListService messageListService =GetMessageListService.getInstance();
    	MessageListView viewData = messageListService.getMessageList(pageNumber);
    	
    	GetUserService getUser=GetUserService.getInstance();    	
    	String name= getUser.getUserName(id);
    	
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GuestBook</title>
<style>
	div{
	
	}
	table{
		width: 
	}
</style>
</head>
<body>	

	<a href="<c:url value='/MWrite'/>">방명록에 글남기기</a>
	<c:choose>
	<c:when test="${viewData.isEmpty()}">
	
	<h1>등록된 메세지가 없습니다.</h1>
	</c:when>
	<c:otherwise>
	<div>
	<table>
	<c:forEach var="message" items="${viewData.messageList}">
		<tr>
			<td>메시지 번호: ${message.message_id} <br /> 
			손님 이름: ${message.guest_name }<br /> 
			메시지: ${message.message} <br /> 
			<a href=<c:url value='/deleteMessage'>
			<c:param name='guest_name' value='${message.guest_name}'></c:param>
			<c:param name='message_id' value='${message.message_id}'></c:param>
			</c:url>
			>[삭제하기]</a>
			</td>
		</tr>	
	</c:forEach>
	</table></div>
	<br>
	<c:forEach var="i" begin="1" end="${viewData.pageTotalCount}">
	<a href=<c:url value='/MList'>
	<c:param name='page' value='${i}'></c:param></c:url>>[${i}]</a>	
	</c:forEach>
	</c:otherwise>
	</c:choose>
	<br>
	<a href="<c:url value='/'/>">[홈으로 돌아가기]</a>
</body>
</html>