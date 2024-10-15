package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class product_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//step 1 : 콘솔에 찍어서 매핑이 됐는지 확인
		System.out.println("/product 매핑 완료");
		
		//전처리
		
		
		
		
		//모델
		//ArrayList<Book> arr = BookRepository.getAllBooks();
		
		
		
		//이동
		//데이터 보낼때      키  , 값
		//req.setAttribute("arry", arr);
		RequestDispatcher rd = req.getRequestDispatcher("books.jsp");
		rd.forward(req, resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}

}
