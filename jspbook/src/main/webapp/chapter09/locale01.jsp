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
	
	String country = (String)request.getAttribute("country");
	String date = (String)request.getAttribute("date");
	String number = (String)request.getAttribute("number");
	
	%>

	<h3>현재 로케일의 국가, 날짜, 통화</h3>
	<p> 국 가 : <%=country %>
	<p> 날 짜 : <%=date %>
	<p> 숫자 (12345.67) : <%=number %>
</body>
</html>