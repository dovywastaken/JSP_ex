<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.Board"%>
<%@ page session="false" %>
<%@ page import="dto.Member" %>
<%
	int total_record = ((Integer) request.getAttribute("total_record")).intValue();
	int pageNum = ((Integer) request.getAttribute("pageNum")).intValue();
	int total_page = ((Integer) request.getAttribute("total_page")).intValue();
	ArrayList<Board> boardList = (ArrayList<Board>) request.getAttribute("boardlist");	
	String sessionId = null;
	String sessionName = null;
	
	HttpSession session = request.getSession(false);
	if(session != null)
	{
		System.out.println("세션을 만드셨습니다... 존재합니다");
		Member mb = (Member)session.getAttribute("member");
		if(mb != null)
		{
			sessionId = mb.getId();
			sessionName = mb.getName();
		}
	}
	else
	{
		System.out.println("누구세요?");	
	}
%>
<html>
<head>
<link rel="stylesheet" href="/bookmarket_crud/resources/css/bootstrap.min.css" />
<title>Board</title>
<script type="text/javascript">
	function checkForm() 
	{	
		if (${sessionId==null}) 
		{
			alert("로그인 해주세요.");
			return false;
		}
		location.href = "./BoardWriteForm.do?id=<%=sessionId%>"
	}
</script>
</head>
<body>
<div class="container py-4">
	<jsp:include page="./menu.jsp" />
	
	 <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">게시판</h1>
        <p class="col-md-8 fs-4">Board</p>      
      </div>
    </div>
	
	<div class="row align-items-md-stretch   text-center">	 	
		<form action="BoardListAction" method="post">
	
				<div class="text-end"> 
					<span class="badge text-bg-success">전체 <%=total_record%>건	</span>
				</div>
		
			<div style="padding-top: 20px">
				<table class="table table-hover text-center">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>조회</th>
						<th>글쓴이</th>
					</tr>
					<%
					if(boardList != null){
						for (int j = 0; j < boardList.size() ; j++){
							Board notice = (Board) boardList.get(j);
					%>
					<tr>
						<td><%=notice.getNum()%></td>
						<td><a href="BoardViewAction?num=<%=notice.getNum()%>&pageNum=<%=pageNum%>">
						<%=notice.getSubject()%>
						</a></td>
						<td><%=notice.getRegist_day()%></td>
						<td><%=notice.getHit()%></td>
						<td><%=notice.getName()%></td>
					</tr>
					<%
							}
						}
					%>
				</table>
			</div>
			<div align="center">
				<%
					for(int i=1; i<total_page; i++)
					{
				%>
				<a href="./BoardListAction?pageNum=${i}">
					<%if(pageNum==i)
					  { %> 
					<font color='4C5317'><b> [${i}]</b></font>
					<%}
					  else
					  { %>
						<font color='4C5317'> [${i}]</font>
					<%} %>
				</a>
				  <%} %>
			</div>
			
			<div class="py-3" align="right">							
				<a href="BoardWriteForm" class="btn btn-primary">&laquo;글쓰기</a>		
												<!-- 함수에서 false를 return해오면 a태그를 false시켜서 href가 작동안함onclick="checkForm(); return false;" -->			
			</div>			
			<div align="left">				
				<select name="items" class="txt">
					<option value="subject">제목에서</option>
					<option value="content">본문에서</option>
					<option value="name">글쓴이에서</option>
				</select> <input name="text" type="text" /> <input type="submit" id="btnAdd" class="btn btn-primary " value="검색 " />				
			</div>
			
		</form>			
	</div>
	<jsp:include page="./footer.jsp" />
</div>
</body>
</html>





