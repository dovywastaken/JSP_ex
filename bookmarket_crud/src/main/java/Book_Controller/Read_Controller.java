package Book_Controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class Read_Controller extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		//System.out.println("get 컨트롤러 입장");
		
		//모델
		BookRepository br = BookRepository.getInstance();
		ArrayList<Book> arr = br.getAllBooks();
		System.out.println(arr);
		//뷰이동
		req.setAttribute("list", arr);
		req.getRequestDispatcher("books.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}
}
