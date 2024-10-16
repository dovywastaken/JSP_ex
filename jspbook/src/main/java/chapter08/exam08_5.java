package chapter08;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/8_5")
public class exam08_5 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("chapter08/validation05.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String info = req.getParameter("info");
		String pw = req.getParameter("pw");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String phone2 = req.getParameter("phone2");
		String phone3 = req.getParameter("phone3");
		String email = req.getParameter("email");
		
		
		req.setAttribute("info", info);
		req.setAttribute("pw", pw);
		req.setAttribute("id", id);
		req.setAttribute("name", name);
		req.setAttribute("phone2", phone2);
		req.setAttribute("phone3", phone3);
		req.setAttribute("email", email);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter08/validation05_result.jsp");
		rd.forward(req, resp);
	}
	
}
