package chapter14;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/14_1")
public class exam14_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		req.getRequestDispatcher("chapter14/cookie01.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String user_id = req.getParameter("id");
		String user_pw = req.getParameter("pw");
		
		req.setAttribute("id", user_id);
		req.setAttribute("pw", user_pw);

		req.getRequestDispatcher("chapter14/cookie01_result.jsp").forward(req, resp);
	}
	
}
