package chapter17;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/17_2")
public class exam17_2  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("17_2 컨트롤러 doGet 입장");
		RequestDispatcher rd = req.getRequestDispatcher("chapter17/core02.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("17_2 컨트롤러 doPost 입장");
		//전처리
		String number = req.getParameter("number");
		//모델이동
		
		//뷰이동
		req.setAttribute("num", number);
		req.getRequestDispatcher("chapter17/core02_result.jsp").forward(req, resp);
	}
}
