package filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AuthenFilter implements Filter
{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		System.out.println("Filter01 초기화");
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException 
	{
		System.out.println("Filter01.jsp 수행");
		String name = req.getParameter("name");
		System.out.println(name);
		
		if(name ==null || name.equals("")) 
		{
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset = UTF8");
			PrintWriter writer = resp.getWriter();
			System.out.println(writer);
			String message = "입력된 name 값은 null 입니다.";
			System.out.println(message);
			writer.println(message);
			return;
		}
		filterChain.doFilter(req, resp);
	}
	
	@Override
	public void destroy() 
	{
		System.out.println("Filter01 종료");
	}
}
