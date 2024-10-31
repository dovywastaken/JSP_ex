package Member_Controller;

import java.io.IOException;
import java.util.Date;

import dao.MemberRepository;
import dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member_add")
public class Create_Controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Member.Create_Controller의 doGet() 입장");
		//전처리
		//모델이동
		//뷰이동
		System.out.println("addMember(회원가입 페이지)로 뷰를 이동합니다");
		req.getRequestDispatcher("addMember.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
        System.out.println("Create_Controller의 doPost() 입장");
      //전처리
    	req.setCharacterEncoding("UTF-8");

    	String id = req.getParameter("id");
    	String password = req.getParameter("password");
    	String name = req.getParameter("name");
    	String gender = req.getParameter("gender");
    	String year = req.getParameter("birthyy");
    	String month = req.getParameterValues("birthmm")[0];
    	String day = req.getParameter("birthdd");
    	String birth = year + "/" + month + "/" + day;
    	String mail1 = req.getParameter("mail1");
    	String mail2 = req.getParameterValues("mail2")[0];
    	String mail = mail1 + "@" + mail2;
    	String phone = req.getParameter("phone");
    	String address = req.getParameter("address");
    	System.out.println(" - 파라미터 담기 완료");
    	
    	Date currentDatetime = new Date(System.currentTimeMillis());
    	java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
    	java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDatetime.getTime());
    	System.out.println(" - 시간 정보 생성 완료");
    	
    	Member mb = new Member();
    	mb.setId(id);
    	mb.setPassword(password);
    	mb.setName(name);
    	mb.setGender(gender);
    	mb.setBirth(birth);
    	mb.setMail(mail);
    	mb.setPhone(phone);
    	mb.setAddress(address);
    	mb.setRegist_day(timestamp);
    	System.out.println(" - dto 담기 완료");
      //모델이동
    	MemberRepository mr = MemberRepository.getMr();
    	mr.create(mb);
    	
      //뷰이동
    	System.out.println("로그인 절차가 끝나 홈으로 리다렉션 합니다");
    	resp.sendRedirect("/bookmarket_crud");
    	
	}

}
