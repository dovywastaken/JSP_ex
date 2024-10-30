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
		System.out.println("1 매핑되어서 doGet 실행");
		//전처리
		//모델
		BookRepository br = BookRepository.getInstance();
		if(br==null) 
		{
			System.out.println("2-1 : BookRepository 객체를 리턴받지 못함");
		}
		ArrayList<Book> arr = br.getAllBooks();
		if(arr==null) 
		{
			System.out.println("3 : 리스트 정보를 전달받지 못함");
		}
		System.out.println("3 : 리스트에 총 " + arr.size() + "개의 dto가 담겼습니다");
		//뷰이동
		req.setAttribute("list", arr);
		req.getRequestDispatcher("books.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}
}
