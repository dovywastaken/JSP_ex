<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="fileForm" method="post" enctype="multipart/form-data" action="7_2">
		<p> 이 름 1 : <input type="text" name="name1">
			제 목 1 : <input type="text" name ="subject1">
			파 일 1 : <input type="file" name ="filename1">
			
		<p> 이 름 2 : <input type="text" name="name2">
			제 목 2 : <input type="text" name ="subject2">
			파 일 2 : <input type="file" name ="filename2">
			
		<p> 이 름 3 : <input type="text" name="name3">
			제 목 3 : <input type="text" name ="subject3">
			파 일 3 : <input type="file" name ="filename3">
			
		<p> <input type = "submit" value="파일 올리기">
	</form>
</body>
</html>