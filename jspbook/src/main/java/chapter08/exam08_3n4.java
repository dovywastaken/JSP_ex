package chapter08;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/8_3")
public class exam08_3n4 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("chapter08/validation03.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter08/validation03_result.jsp");
		rd.forward(req, resp);
	}
	
}
