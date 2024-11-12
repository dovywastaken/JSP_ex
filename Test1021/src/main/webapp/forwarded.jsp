<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello World
	
	<%= request.getParameter("title") %>
	
	<jsp:useBean id="cal" class="test.cal"/>
	
	<%
		int result = cal.plus(1,2);
	%>
	
	<p> 1+2 = <%= result %>
</body>
</html>