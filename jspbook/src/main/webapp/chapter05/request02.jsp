<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Enumeration en = request.getHeaderNames();
		while (en.hasMoreElements()) 
		{
			String headerName = (String) en.nextElement();
			String headerValue = request.getHeader(headerName);
	%>

	<%= headerName %> : <%= headerValue %> <br>

	<%
		}
	%>

	<a href ="index.jsp">Home</a>
</body>
</html>