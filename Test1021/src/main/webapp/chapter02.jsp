<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>sa</title>
</head>
<body>
	<% out.println("abc"); %>
	<br>
	<%= "abc" %>
		<br> <hr>

		
		
		
	<jsp:include page="forwarded.jsp" flush="false">
		<jsp:param value="parametre" name="title"/>
	</jsp:include>
	
	
</body>
</html>