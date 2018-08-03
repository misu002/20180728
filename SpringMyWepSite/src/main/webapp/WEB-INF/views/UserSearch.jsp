<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        
        div{
        	background: white;
            width: 1500px;
            margin: 20px auto;
            height: 2000px;
            position: relative;
        }
        
        input{
        	
        }
</style>
</head>
<body>
	<div>
	<form method="post">
	
		<input type="date" value="회원 생일 검색" name="firstDate"/>	 - <input type="date" value="회원 생일 검색" name="secondDate"/>	
		<input type="submit" value="검색" />
	</form>
	</div>
</body>
</html>