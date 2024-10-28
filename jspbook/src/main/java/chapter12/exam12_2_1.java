package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/12_2_1")
public class exam12_2_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		req.setAttribute("id", id);
		req.setAttribute("password", pw);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter12/filter02_result.jsp");
		rd.forward(req, resp);
	}

}
