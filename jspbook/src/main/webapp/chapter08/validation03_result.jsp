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
	
	<h3>입력에 성공했습니다.</h3>
	<p>아 이 디 : <%=id %> 
	<p>비밀번호 : <%=pw %>
	<p><a href="chapter08/validation03.jsp">Home</a>
</body>
</html>