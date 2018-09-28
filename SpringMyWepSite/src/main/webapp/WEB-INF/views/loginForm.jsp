<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<style>
body {
	margin: 0;
	font-family: 'Nanum Gothic', sans-serif;
}

#page {
	margin: 10px;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

#banner {
	text-align: center;
	margin: 60px auto;
	font-size: 70px;
	color: green;
}

#content {
	margin: 0 auto;
	width: 500px;
	height: 1000px;
}

input[type=text], input[type=password] {
	width: 450px;
	height: 25px;
	margin: 10px;
	padding: 10px;
}

button {
	display: block;
	width: 475px;
	height: 60px;
	margin-left: 10px;
	margin-top: 20px;
	border: none;
	background: #02ad02;
	color: white;
	font-size: 25px;
	line-height: 50px;
}

input[type=checkbox] {
	margin-top: 20px;
	margin-left: 20px;
}

.links {
	border-top: 1px solid #ebebeb;
	padding: 20px;
	margin: 35px auto;
	text-align: center;
}

a {
	margin-left: 15px;
	text-decoration: none;
	color: #bababa;
}
</style>
    <script>
    	$(document).ready(function(){
    		$('input[name=id]').focusout(function(){
    			if($(this).val()==""){
    				 $('#remove1').remove();
                     $('<span id="remove1"  style="color:red">필수입력 정보입니다.</span>').appendTo('.idLabel');
    			}    			
    		});
    		
    		$('input[name=password]').focusout(function(){
    			if($(this).val()==""){
    				 $('#remove2').remove();
                     $('<span id="remove2"  style="color:red">필수입력 정보입니다.</span>').appendTo('.pwLabel');
    			}    			
    		});
    	});
    function chk(){
    	if($('input[name=id]').val()==""){
    		alert("입력되지 않은 정보가 있습니다.")
    		return false;
    	}else if($('input[name=password]').val()==""){
    		alert("입력되지 않은 정보가 있습니다.")
    		return false;
    }
    	
    }
    
    
    </script>
</head>
<body>  
	<div id="page">
		<h1 id="banner">Catering</h1>
		<form action="<c:url value='/member/login/LoginAccess'/>" onsubmit="return chk();">
			<div id="content">
			<c:choose>
				<c:when test="${CookieId eq null }">
				<input type="text" name="id" placeholder="아이디"> <label	class="idLabel"></label> 
				</c:when>
				<c:when test="${CookieId eq '0'}">
				<input type="text" name="id" placeholder="아이디"> <label	class="idLabel"></label> 
				</c:when>
				<c:otherwise>
				<input type="text" name="id" value="${CookieId }" placeholder="아이디"> <label	class="idLabel"></label> 
				</c:otherwise>
			</c:choose>
				<input type="password" name="password" placeholder="비밀번호"> <label class="pwLabel"></label>
				<button type="submit">로그인</button>
				<c:choose>
				<c:when test="${CookieId eq null }">
				<input type="checkbox" id="remeber" name="remember"> <label for="remember">아이디저장</label>
				</c:when>
				<c:when test="${CookieId eq '0'}">
				<input type="checkbox" id="remeber" name="remember"> <label for="remember">아이디저장</label>
				</c:when>
				<c:otherwise>
				<input type="checkbox" id="remeber" name="remember" checked> <label for="remember">아이디저장</label>
				</c:otherwise>
				</c:choose>
				<div class="links">
					<a href="">아이디찾기</a> <a href="<c:url value='/findPw'/>">비밀번호찾기</a> <a
						href="<c:url value='/goAgreeForm'/>">회원가입</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>