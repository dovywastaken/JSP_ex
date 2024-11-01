<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<%@ page import ="dao.BookRepository" %>
<%@ page import="java.util.*" %>
<%@ page import ="dto.Book" %>
<% System.out.println("@@@@Books.jsp 이동 완료!!"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
</head>
<body>
<div class="container py-4">
    <%@ include file = "menu.jsp" %>
    <% ArrayList<Book> arr = (ArrayList<Book>)request.getAttribute("list");
       if(arr == null) System.out.println("%%%%컨트롤러에서 받아온 list 값이 없음"); %>
    <div class ="p-5 mb-4 bg-body-tertiary rounded-3">
        <div class="container-fluid py-5">
            <h1 class ="display-5 fw-bold">도서 목록</h1>
            <p class="col-md8 fs-4">BookList</p>
        </div>
    </div>
    <div class="row align-items-md-stretch text-center">
        <% for (int i = 0; i < arr.size(); i++) {
           Book bk = arr.get(i); %>
        <div class="col-md-4">
            <div class="h-100 p-2 rounded-3">
                <img src="./resources/images/<%= bk.getFilename() %>" style="width: 250px; height: 350px; object-fit: cover;" alt="Book Image"/>
                <h5><b><%= bk.getBookname() %></b></h5>
                <p><%= bk.getAuthor() %><br><%= bk.getPublisher() %> | <%= bk.getUnitPrice() %>원</p>
                <p><%= bk.getBookdescription().substring(0,60) %>...</p>
                <p><%= bk.getUnitPrice() %>원</p>
                <p><a href="book?id=<%= bk.getBookId() %>" class="btn btn-secondary" role="button">상세 정보 &raquo;</a></p>
            </div>
        </div>
        <% } %>
    </div>
    <%@ include file = "footer.jsp" %>
</div>
</body>
</html>
