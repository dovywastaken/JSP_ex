package Book_Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteBook")
public class Delete_Controller  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Delete_Controller의 doGet메서드로 입장");
		
		//전처리
		String id = req.getParameter("id");
		System.out.println(" - " + id + "를 삭제하는 절차를 시작합니다");
		
		//모델이동
		BookRepository br = BookRepository.getInstance();
		br.delBook(id);
		
		//뷰이동
		resp.sendRedirect("books");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Delete_Controller의 doPost메서드로 입장");

	}
}
