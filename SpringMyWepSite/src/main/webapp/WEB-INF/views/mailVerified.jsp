<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인증되었습니다!</title>
<script>
alert("메일이 인증되었습니다. 이제 모든 서비스를 이용하실 수 있습니다.");
location.href="<c:url value='/' />";
</script>
</head>
<body>

</body>
</html>