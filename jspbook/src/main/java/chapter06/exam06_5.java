package chapter06;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/6_5")
public class exam06_5 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getRequestDispatcher("chapter06/form05.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setCharacterEncoding("utf-8");
		
		String id= req.getParameter("id");
		String passwd= req.getParameter("passwd");
		String name= req.getParameter("name");
		String phone1= req.getParameter("phone1");
		String phone2= req.getParameter("phone2");
		String phone3= req.getParameter("phone3");
		String sex= req.getParameter("sex");
		String hobby1= req.getParameter("hobby1");
		String hobby2= req.getParameter("hobby2");
		String hobby3= req.getParameter("hobby3");
		String comment= req.getParameter("comment");
		
		req.setAttribute("id", id);
		req.setAttribute("passwd", passwd);
		req.setAttribute("name", name);
		req.setAttribute("phone", phone1 + "-" + phone2 + "-" + phone3);
		req.setAttribute("sex", sex);
		req.setAttribute("hobby1", hobby1);
		req.setAttribute("hobby2", hobby2);
		req.setAttribute("hobby3", hobby3);
		req.setAttribute("comment", comment);
		
		req.getRequestDispatcher("chapter06/form05_result.jsp").forward(req, resp);
		
	}

}
