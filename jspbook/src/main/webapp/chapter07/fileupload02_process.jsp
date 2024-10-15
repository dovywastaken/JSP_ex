<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<table border ="1">
		<tr>
			<th width="100">이름</th>
			<th width="100">제목</th>
			<th width="100">파일</th>
		</tr>
		
		<%
			String name1 = (String)request.getAttribute("name1");
			String name2 = (String)request.getAttribute("name2");
			String name3 = (String)request.getAttribute("name3");
			
			String subject1 = (String)request.getAttribute("subject1");
			String subject2 = (String)request.getAttribute("subject2");
			String subject3 = (String)request.getAttribute("subject3");
			
			String filename1 = (String)request.getAttribute("filename1");
			String filename2 = (String)request.getAttribute("filename2");
			String filename3 = (String)request.getAttribute("filename3");
		%>
		
			<tr><td> <%=name1%></td>
			<td><%= subject1%></td>
			<td><img width = "100%" height ="100%" src="img/<%=filename1%>"></td></tr>
			
			<tr><td> <%=name2%></td>
			<td><%= subject2%></td>
			<td><img width = "100%" height ="100%" src="img/<%=filename2%>"></td></tr>
			
			<tr><td> <%=name3%></td>
			<td><%= subject3%></td>
			<td><img width = "100%" height ="100%" src="img/<%=filename3%>"></td></tr>
		
	</table>
</body>
</html>