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
	function changePw(){
		var recentPw1=$('#recentPw').val();
		var changePw1=$('#changePw').val();
		
		$.ajax({
			type:"post",
			url: "${findPw}",
			data : {recentPw:recentPw1,changePw:changePw1},
			success:function(data){
				alert(data);
				location.href="<c:url value='/' />";
			},
			error: function() {
	            alert("비밀 번호가 담긴 메일을 보내지 못했습니다. 다시 시도해 주세요.");
	        } 
		})		
	}

</script>
 -->
</head>
<body>
	<h1>새로운 비밀 번호 지정</h1>
	<form method="post">
	임시비밀번호 : <input type="text" name="recentPw"/>
	새로운 비밀번호 : <input type="text" name="changePw" />
	<input type="submit" value="비밀번호 찾기" />
	</form>
</body>
</html>