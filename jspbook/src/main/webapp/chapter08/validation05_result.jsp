<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<body>

	<%
		String info = request.getParameter("info");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email = request.getParameter("email");
	%>

	<p> 아 이 디 : <%=info%>
	<p> 비밀번호 : <%=pw%>
	<p> 이   름 : <%=name%>
	<p> 연 락 처 : <%="010-"+phone2 + "-" + phone3 %>
	<p> 이 메 일 : <%= email%>
	
	<a href="./index.jsp">Index Home</a>
</body>
</html>