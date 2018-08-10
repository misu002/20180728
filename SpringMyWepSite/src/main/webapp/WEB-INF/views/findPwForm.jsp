<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기</title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<c:url var="findPw" value="/findPw"/>
<!-- <script>
	function findPw(){
		var userId1=$('#userId').val();
		var email1=$('#email').val();
		$.ajax({
			type:"post",
			url: "${findPw}",
			data : {userId:userId1,email11:email1},
			success:function(data){
				alert(data);
				location.href="<c:url value='/' />";
			},
			error: function() {
				alert(userId1);
	            alert("비밀 번호가 담긴 메일을 보내지 못했습니다. 다시 시도해 주세요.");
	        } 
		})		
	}

</script> -->

</head>
<body>
	<form method="post">
	아이디 : <input type="text" name="userId"/>
	이메일 : <input type="text" name="email" />
	<input type="submit" value="비밀번호 찾기" />
	</form>
</body>
</html>