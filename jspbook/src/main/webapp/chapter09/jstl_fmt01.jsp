<%@ page import="java.util.ResourceBundle"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> ----------기본로케일----------
		<fmt:setLocale value = "ko"/>
		<fmt:setBundle basename = "chapter09.bundle.myBundle" var="resourceBundle" />
	<p> 제목: <fmt:message key="title" bundle = "${resourceBundle}" />
	<p> <fmt:message key = "username" var = "userMsg" bundle = "${resourceBundle}"/>
		이름 : ${userMsg}
		
		
	<p> ----------영문 로케일----------
		<fmt:setLocale value = "en"/>
		<fmt:setBundle basename = "chapter09.bundle.myBundle" var="resourceBundle" />
	<p> 제목: <fmt:message key="title" bundle = "${resourceBundle}" />
	<p> 이름: <fmt:message key="username" bundle = "${resourceBundle}" />
	
	
		<p> ----------노어 로케일----------
		<fmt:setLocale value = "ru"/>
		<fmt:setBundle basename = "chapter09.bundle.myBundle" var="resourceBundle" />
	<p> 제목: <fmt:message key="title" bundle = "${resourceBundle}" />
	<p> 이름: <fmt:message key="username" bundle = "${resourceBundle}" />
</body>
</html>