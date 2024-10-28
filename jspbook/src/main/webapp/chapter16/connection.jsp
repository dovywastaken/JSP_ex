<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB연결 결과 확인</title>
</head>
<body>
	<form action="16_1" method="post">
		<p>아이디 : <input type="text" name="id">
		<p>비밀번호 : <input type="text" name="pw">
		<p>이름 : <input type="text" name="name">
		<p><input type="submit" value="전송">
	</form>
</body>
</html>