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
		String[] hobby = (String[])request.getAttribute("hobby");
		String comment = (String)request.getAttribute("comment");
	%>

	<p> 아이디 : <%out.println(userid); %>
	<p> 비밀번호 : <% out.println(password);%>
	<p> 이름 : <% out.println(name);%>
	<p> 연락처 : <% out.println(phone1);%>
	<p> 성별 : <% out.println(sex);%>
	<p> 취미 : <%
				    if(hobby != null) 
				    {
				        for(int i = 0; i < hobby.length; i++) 
				        {
				            out.println(" " + hobby[i]);
				        }
				    }
				%>
	<p> 		
	
	<p> 가입인사 : <%= comment %>
</body>
</html>