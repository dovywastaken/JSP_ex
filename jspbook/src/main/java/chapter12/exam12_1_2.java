package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/12_1_2")
public class exam12_1_2  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		String name = req.getParameter("name");
		
		req.setAttribute("name1", name);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter12/filter01_result.jsp");
		rd.forward(req, resp);
	}
}
