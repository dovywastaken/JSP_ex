package chapter06;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/6_1")
public class exam06_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("chapter06/form01.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("id");
		String password = req.getParameter("passwd");
		String name = req.getParameter("name");
		String phone1 = req.getParameter("phone1"); String phone2 = req.getParameter("phone2"); String phone3 = req.getParameter("phone3");
		String sex = req.getParameter("sex");
		String[] hobby = req.getParameterValues("hobby");
		
		String comment = req.getParameter("comment");
		//모델이동
		
		//이동
		req.setAttribute("userid", userid);
		req.setAttribute("passwd", password);
		req.setAttribute("name", name);
		req.setAttribute("phone1", phone1 + "-" + phone2 + "-" + phone3);
		req.setAttribute("sex", sex);
		req.setAttribute("hobby", hobby);
		req.setAttribute("comment", comment);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter06/form01_result.jsp");
		rd.forward(req, resp);
		
		
	}

}
