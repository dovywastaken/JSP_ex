package chapter09;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/9_1")
public class exam09_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Locale locale = req.getLocale();
		Date currentDate = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL,locale);
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		
		String country = locale.getDisplayCountry();
		String date = dateFormat.format(currentDate);
		String number = numberFormat.format(12345.67);
		
		
		req.setAttribute("country", country);
		req.setAttribute("date", date);
		req.setAttribute("number", number);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter09/locale01.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}

}
