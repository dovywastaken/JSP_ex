<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String name = (String)request.getAttribute("name");
		String subject = (String)request.getAttribute("subject");
		String file = (String)request.getAttribute("file");
	%>

	이름 : <%= name %> <br>
	제목 : <%= subject %> <br>
	파일 : <%= file %> <br>
	<img src="img/<%=file %>">
</body>
</html>