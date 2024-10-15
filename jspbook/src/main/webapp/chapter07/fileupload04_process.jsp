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
		String fileFieldName = (String)request.getAttribute("fileFieldName");
		String fileName = (String)request.getAttribute("fileName");
		String contentType = (String)request.getAttribute("contentType");
		String fileSize = (String)request.getAttribute("fileSize");
	%>

		<p> -------------------<br>
		<p>요청 파라미터 이름 : <%=fileFieldName %><br>
		<p>저장 파일 이름 : <%=fileName %><br>
		<p>파일 컨텐츠 유형 : <%=contentType %><br>
		<p>파일 크기 : <%=fileSize %>
</body>
</html>