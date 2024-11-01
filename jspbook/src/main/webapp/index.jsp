<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>실습리스트</h1>
	<p>
		<h2>챕터 2 스크립트 태그</h2>
		<a href="2_1">예제 2_1</a> 
		<a href="2_2">예제 2_2</a>
		<a href="2_3">예제 2_3</a>
		<a href="2_4">예제 2_4</a>
		<a href="2_5">예제 2_5</a>
		<a href="2_6">예제 2_6</a>
		<a href="2_7">예제 2_7</a>
		<a href="2_8">예제 2_8</a>
		
		<hr><hr>
		
		<h2>챕터 3 디렉티브 태그</h2>
		<a href="3_1">예제 3_1</a>
		<a href="3_2">예제 3_2</a>
		<a href="3_3">예제 3_3</a>
		<a href="3_4">예제 3_4</a>
		<a href="3_6">예제 3_6</a>
		<a href="3_7">예제 3_7</a>
		<a href="3_9">예제 3_9</a>
		<a href="3_11">예제 3_11</a>
		
		
		<hr><hr>
		
		<h2>챕터 4 액션태그</h2>
		
		<p>예제 4_0
		<form action = "4_0" method ="get">
			<input type ="text" name = "id"/>
			<br>
			<input type ="text" name = "name"/>
			<br>
			<input type ="submit" value = "전송">
		</form>
		
		<% 
			String id = "admin";
			String name = "Euishin";
		%>
		
		<p><a href="4_0?id = ${id}&name=<%=name%>"> 예제 4-0 </a></p>
		

		<a href="4_1">예제 4_1</a>
		<a href="4_2">예제 4_2</a>
		<a href="4_3">예제 4_3</a>
		<a href="4_4">예제 4_4</a>
		<a href="4_5">예제 4_5</a>
		<a href="4_6">예제 4_6</a>
		<a href="4_7">예제 4_7</a>
		<a href="4_8">예제 4_8</a>
		<a href="4_12">예제 4_12</a>
		
		<br>
		
		<hr><hr>
		
		<h2>챕터 5 내장 객체</h2>

		<a href ="5_1">예제 5_1</a>
		<a href ="5_2">예제 5_2</a>
		<a href ="5_3">예제 5_3</a>
		<a href ="5_4">예제 5_4</a>
		<a href = "5_5">예제 5_5</a>
		<a href = "5_7">예제 5_7</a>
		<a href = "5_8">예제 5_8</a>
		<a href = "5_9">예제 5_9</a>
		
		<hr><hr>
		<h2>챕터 6 폼태그</h2>
		<a href = "6_1">예제 6_1</a>
		<a href = "6_5">예제 6_5</a>
		
		
		<hr><hr>
		<h2>챕터 7 파일 업로드</h2>
		<a href = "7_1">예제 7_1</a>
		<a href = "7_2">예제 7_2</a>
		<a href = "7_3">예제 7_3</a>
		<a href = "7_4">예제 7_4</a>
		
		<hr><hr>
		<h2>챕터 8 유효성 검사</h2>
		<a href = "8_1">예제 8_1</a>
		<a href = "8_2">예제 8_2</a>
		<a href = "8_3">예제 8_2,8_3</a>
		<a href = "8_5">예제 8_5</a>
		
		<hr><hr>
		<h2>챕터 9 다국어 처리</h2>
		<a href = "9_1">예제 9_1</a>
		<a href = "9_2">예제 9_2</a>
		<a href = "9_3">예제 9_3</a>
		<a href = "9_4">예제 9_4</a>
		<a href = "9_5">예제 9_5</a>
		
		<hr><hr>
		<h2>챕터 10 시큐리티</h2>
		<a href = "10_1">예제 10_1</a>
		<a href = "10_2">예제 10_2</a>
		<a href = "10_3">예제 10_3</a>
		
		
		<hr><hr>
		<h2>챕터 11 예외처리</h2>
		<a href = "11_1">예제 11_1</a>
		<a href = "11_2">예제 11_2</a>
		<a href = "11_3">예제 11_3</a>
		<a href = "11_4">예제 11_4</a>
		<a href = "11_5">예제 11_5</a>
		
		
		<hr><hr>
		<h2>챕터 12 필터</h2>
		<a href = "12_1">예제 12_1</a>
		<a href = "12_2">예제 12_2</a>
		
		
		<hr><hr>
		<h2>챕터 13 세션</h2>
		<a href = "13">로그인</a>
		<a href = "13_2">예제 13_1</a>
		<a href = "13_2-2">예제 13_2</a>
		<a href = "13_3">예제 13_3</a>
		<a href = "13_4">예제 13_4</a>
		
				<hr><hr>
		<h2>챕터 14 쿠키</h2>
		<a href = "14_1">예제 14_1</a>
		<a href = "14_2">예제 14_2</a>
		<a href = "14_3">예제 14_3</a>
		
		<h2>챕터 16 JDBC로 데이터베이스 연동</h2>
		<a href = "16_1">예제 16_1</a>
		
		
		<h2>챕터 17 JSTL</h2>
		<a href = "17_1">예제 17_1</a>
		<a href = "17_2">예제 17_2</a>
		<a href = "17_3">예제 17_3</a>
		
</body>
</html>