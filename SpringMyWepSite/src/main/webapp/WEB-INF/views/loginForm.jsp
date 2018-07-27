<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

<%
	Cookie[] cookies = request.getCookies();
	String id = "";
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("id")) {
				id = cookies[i].getValue();
			}
		}
	}
%>

</head>
<body>
	<div id="page">
		<h1 id="banner">NAVER</h1>
		<form action="LoginAccess" onsubmit="return chk();">
			<div id="content">
				<input type="text" name="id" placeholder="아이디"> <label
					class="idLabel"></label> <input type="password" name="password"
					placeholder="비밀번호"> <label class="pwLabel"></label>
				<button type="submit">로그인</button>
				<input type="checkbox" id="remeber" name="remember"> <label
					for="remember">아이디저장</label>
				<div class="links">
					<a href="">아이디찾기</a> <a href="">비밀번호찾기</a> <a
						href="/NaverAgree.jsp">회원가입</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>