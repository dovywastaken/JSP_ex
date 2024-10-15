package controller;

import java.io.IOException;


import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Book")
public class BookController2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리 : 넘오는 파라미터 없음
		String id = req.getParameter("id");
		//모델이동 : 리파지토리 연결 후 ArrayList 리턴받아야됨
		BookRepository br = BookRepository.getInstance();
		Book bk = br.getBookById(id);
		
		req.setAttribute("book", bk);
		RequestDispatcher ds = req.getRequestDispatcher("book.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}	
}
