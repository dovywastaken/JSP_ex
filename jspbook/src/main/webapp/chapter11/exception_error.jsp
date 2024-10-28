<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage ="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Exception ex = (Exception)request.getAttribute("exception");
	%>

	<p> 오류가 발생했습니다
	<p> 예외 : <%=ex%>
	<p> toString() : <%=ex.toString() %>
	<p> getClass().getName() : <%=ex.getClass().getName() %>
	<p> getMessage() : <%= ex.getMessage() %>

</body>
</html>