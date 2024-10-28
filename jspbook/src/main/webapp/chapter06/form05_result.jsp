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
		String passwd = (String)request.getAttribute("passwd");
		String name = (String)request.getAttribute("name");
		String phone = (String)request.getAttribute("phone");
		String sex = (String)request.getAttribute("sex");
		String hobby1 = (String)request.getAttribute("hobby1");
		String hobby2 = (String)request.getAttribute("hobby2");
		String hobby3 = (String)request.getAttribute("hobby3");
		String comment = (String)request.getAttribute("comment");
	%>
	
	
	<p> 아이디: <%=id %>
	<p> 비밀번호: <%=passwd %>
	<p> 이름: <%=name %>
	<p> 연락처: <%=phone %>
	<p> 성별: <%=sex %>
	<p> 취미: <%=hobby1 + hobby2 + hobby3 %>
	<p> 가입인사: <%=comment %>
</body>
</html>