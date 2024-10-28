package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/5_4")
public class exam05_4 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("chapter05/response01.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("id");
		String password = req.getParameter("passwd");
		
		
		//이동
		if (userid.equals("관리자") && password.equals("1234"))
		{
			resp.sendRedirect ("chapter05/response01_success.jsp");
			
			
		}
		else
		{
			resp.sendRedirect ("chapter05/response01_failed.jsp");
		}
	}

}
