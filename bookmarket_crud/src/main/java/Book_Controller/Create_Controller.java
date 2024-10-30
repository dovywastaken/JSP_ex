package Book_Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addBook")
public class Create_Controller  extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("Create_Controller의 doGet() 입장");
		//전처리
		
		//모델이동
		
		//뷰이동
		req.getRequestDispatcher("addBook.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("Create_Controller의 doPost() 입장");
	}

}
