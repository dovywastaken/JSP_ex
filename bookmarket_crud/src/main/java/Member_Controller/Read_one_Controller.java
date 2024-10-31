package Member_Controller;

import java.io.IOException;

import dao.BookRepository;
import dao.MemberRepository;
import dto.Book;
import dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member_login")
public class Read_one_Controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Member_Read_one_controller의 doGet 입장");
		//전처리
		
		
		//모델이동

		
		//뷰이동
		System.out.println("loginMember.jsp로 이동합니다");
		req.getRequestDispatcher("loginMember.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Read_one_controller의 doPost 입장");
		
		//전처리
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		//모델이동
		MemberRepository mr = MemberRepository.getMr();
		Member mb = mr.getUser(id, password);
		if(mb != null) //dto가 존재함므로 회원이 맞음
		{
			//세션 생성 (로그인 정보를 보존하기 위해)
			HttpSession session = req.getSession(true);
			session.setAttribute("member", mb);
		}
		else 
		{
			resp.sendRedirect("member_login?error=1");
		}

		//뷰이동
		System.out.println("resultMember.jsp로 이동합니다");
		req.getRequestDispatcher("resultMember.jsp?msg=2").forward(req, resp);
	}

}
