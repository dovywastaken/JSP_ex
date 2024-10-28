<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter</title>
</head>
<body>
	<%
		String name = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("password");
	%>
	
	<p> 입력된 id 값: <%=name %>
	<p> 입력된 pw 값: <%=pw %>
</body>
</html>