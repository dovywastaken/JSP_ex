<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입하기</title>
</head>
<body>
	<form action="join" method="post">
		<p>ID : <input type="text" name="id">
		<p>PW : <input type="text" name="pw">
		<p>Age : <input type="text" name="age">
		<input type="submit" value="회원가입">
	</form>
	<a href="/login_crud">Home</a>
</body>
</html>