package chapter11;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/11_5")
public class exam11_5 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getRequestDispatcher("chapter11/exceptionType.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		int c = a/b;
		
		req.setAttribute("num1", a);
		req.setAttribute("num2", b);
		req.setAttribute("result", c);
		
		req.getRequestDispatcher("chapter11/exceptionType_result.jsp").forward(req, resp);
	}

}
