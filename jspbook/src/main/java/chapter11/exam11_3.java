package chapter11;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/11_3")
public class exam11_3 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getRequestDispatcher("chapter11/exception.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try 
		{
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			int a = Integer.parseInt(num1);
			int b = Integer.parseInt(num2);
			int c = a/b;
			
			req.setAttribute("a", a);
			req.setAttribute("b", b);
			req.setAttribute("c", c);
			req.getRequestDispatcher("chapter11/exception_result.jsp").forward(req, resp);
			
		} 
		catch (Exception e)
		{
			req.setAttribute("exception", e);
			req.getRequestDispatcher("chapter11/exception_error.jsp").forward(req, resp);
		}
		
	}

}
