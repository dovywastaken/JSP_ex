package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/5_8")
public class exam05_8 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		
		//모델이동
		
		//이동
		RequestDispatcher rd = req.getRequestDispatcher("chapter05/out02.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
			req.setCharacterEncoding("utf-8");
			String userid = req.getParameter("id");
			String password = req.getParameter("passwd");
			

			
		//모델이동
		
		//이동
			req.setAttribute("userid", userid);
			req.setAttribute("passwd", password);
			RequestDispatcher rd = req.getRequestDispatcher("chapter05/out02_process.jsp");
			rd.forward(req, resp);
	}

}
