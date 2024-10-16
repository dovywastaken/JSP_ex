package chapter08;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/8_2")
public class exam08_2 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("chapter08/validation02.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter08/validation02_result.jsp");
		rd.forward(req, resp);
	}

}
