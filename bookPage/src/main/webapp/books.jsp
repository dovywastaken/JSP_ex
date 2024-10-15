<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<!-- 객체 생성하지 않음 
<jsp:useBean id="bookDAO" class="dao.BookRepository" scope="session" />
-->

<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

<title>도서 목록</title>
</head>
<body>
<div class="container py-4">
   <%@ include file="menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">도서목록</h1>
        <p class="col-md-8 fs-4">BookList</p>      
      </div>
    </div>
	<%--  직접 접근처리하지 않음 컨트롤러에게 전달받음 
	    ArrayList<Book> listOfBooks = bookDAO.getAllBooks();
    --%>
    <%
        ArrayList<Book> listOfBooks = (ArrayList<Book>) request.getAttribute("booklist");
     %>
      
	 <div class="row align-items-md-stretch   text-center">	 	
	 <%
		for (int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
	  %>
     	<div class="col-md-4">
       		<div class="h-100 p-2">	
		
				<h5><b><%=book.getName()%></b></h5>
				<p><%=book.getAuthor()%>
				<br> <%=book.getPublisher()%> | <%=book.getReleaseDate()%>
				<p> <%=book.getDescription().substring(0,60)%>...
				<p><%=book.getUnitPrice()%>원
				<p><a href="Book?id=<%=book.getBookId()%>" class="btn btn-secondary" role="button"> 상세 정보 &raquo;</a>
			</div>	
		</div>			
		<%
			}
		%>
	
		</div>	
		<%@ include file="footer.jsp"%>   
  </div>
</body>
</html>
