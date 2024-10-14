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
		String userid = (String)request.getAttribute("userid");
		String password = (String)request.getAttribute("passwd");
		String name = (String)request.getAttribute("name");
		String phone1 = (String)request.getAttribute("phone1");
		String sex = (String)request.getAttribute("sex");
		String hobby1 = (String)request.getAttribute("hobby1");
	%>


	<p> 아이디 : <%out.println(userid); %>
	<p> 비밀번호 : <% out.println(password);%>
	<p> 이름 : <% out.println();%>
	<p> 연락처 : <% out.println();%>
	<p> 성별 : <% out.println();%>
	<p> 취미 : <% out.println();%>
</body>
</html>