package Book_Controller;

import java.io.IOException;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class Read_one_Controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Read_one_controller의 doGet 입장");
		//전처리
		String bookId = req.getParameter("id");
		
		//모델이동
		BookRepository br = BookRepository.getInstance();
		System.out.println(" - ID로 dto를 불러오기위해 getBookById 함수를 호출합니다");
		Book bk = br.getBookById(bookId);
		
		//뷰이동
		req.setAttribute("dto", bk);
		System.out.println("[book으로 뷰를 이동합니다]");
		req.getRequestDispatcher("book.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Read_one_controller의 doPost 입장");
	}

}
