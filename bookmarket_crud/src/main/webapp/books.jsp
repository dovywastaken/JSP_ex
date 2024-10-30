<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="dao.BookRepository" %>

<%@ page import="java.util.*" %>
<%@ page import ="dto.Book" %>
<% System.out.println("4 : Books.jsp로 뷰가 이동함 "); %>
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
		<%
			ArrayList<Book> arr = (ArrayList<Book>)request.getAttribute("list");
			if(arr == null) System.out.println("5: 컨트롤러에서 받아온 list 값이 없음");
		%>
		
		<div class ="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class ="display-5 fw-bold">도서 목록</h1>
				<p class="col-md8 fs-4"> BookList</p>
			</div>
		</div>
		
		<div class="row align-items-md-stretch text-center">
		<%
			for(int i=0; i<arr.size(); i++)
			{
				Book bk = arr.get(i);
		%>
			<div class="col-md-4">
				<div class = "h-100 p-2 round-3">
					<img src="./resources/images/<%=bk.getFilename() %>" style="width : 250; height : 350"/>
					<h5><b><%=bk.getBookname() %></b></h5>
					<p> <%=bk.getAuthor() %>
					<br> <%=bk.getPublisher() %> | <%= bk.getUnitPrice() %>원
					<p> <%=bk.getBookdescription().substring(0,60) %>...
					<p> <%=bk.getUnitPrice() %>원
					<p> <a href="./book.jsp?id=<%=bk.getBookId()%>" class="btn btn-secondary" role="button" method="get"> 상세 정보 &raquo;</a>
				</div>
			</div>
			<%
				}
		
			%>
		</div>
		<%@ include file = "footer.jsp" %>
	</div>
</body>
</html>