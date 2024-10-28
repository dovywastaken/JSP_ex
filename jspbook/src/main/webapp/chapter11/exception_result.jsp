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
	int a = (int)request.getAttribute("a");
	int b = (int)request.getAttribute("b");
	int c = (int)request.getAttribute("c");
	
	out.print(a + "/" + b + "=" + c);
	%>
	
	
	
</body>
</html>