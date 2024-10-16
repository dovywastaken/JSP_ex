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
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
	%>
	
	아 이 디 : <%=id %> 
	비밀번호 : <%=pw %>
	<a href="chapter08/validation02.jsp">Home</a>
</body>
</html>