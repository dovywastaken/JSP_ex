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

@WebServlet("/editBook")
public class Edit_Controller extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Edit_Controller doGet함수 입장");
		
		//전처리
		String edit = req.getParameter("edit");
		System.out.println(" - 파라미터 edit=" + edit + "를 받아왔습니다");
		//모델이동
		BookRepository br = BookRepository.getInstance();
		ArrayList<Book> arr = br.getAllBooks();
		
		//뷰이동
		req.setAttribute("list", arr);
		req.setAttribute("edit", edit);
		System.out.println("editBook으로 뷰를 이동합니다");
		req.getRequestDispatcher("editBook.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
	
}