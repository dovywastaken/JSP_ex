<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String userid = (String) request.getAttribute("userid");
		String passwd = (String) request.getAttribute("passwd");
	%>

	<p> 아 이 디 : <% out.println(userid); %>
	<p> 비밀번호 : <% out.println(passwd); %>
</body>
</html>