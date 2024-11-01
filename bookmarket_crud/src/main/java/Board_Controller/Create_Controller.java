package Board_Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardRepository;
import dao.BookRepository;
import dto.Board;
import dto.Book;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardWriteForm")
public class Create_Controller extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("==============================================================");
	   System.out.println("Board Create_Controller의 doGet()입장");
      //전처리
      HttpSession session = req.getSession(false);
      RequestDispatcher rs=null;
      System.out.println(session);
      if(session == null) {
         rs = req.getRequestDispatcher("member_login");
      }
      else if(session != null)
      {
         Member mb = (Member)session.getAttribute("member");
         if(session.getAttribute("member") == null) {
            System.out.println(" - 세션존재 멤버 없음/member_login 페이지로 뷰를 이동합니다");
            rs = req.getRequestDispatcher("member_login");
         }
         else {
        	System.out.println(" - 세션존재 멤버 있음/writeForm.jsp 페이지로 뷰를 이동합니다");
            rs = req.getRequestDispatcher("writeForm.jsp");            
         }
      }
      
      rs.forward(req, resp);
      //모델이동
      
      //뷰이동
      
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  System.out.println("==============================================================");
	  System.out.println("Board_Create_Controller의 doPost()");
      //전처리
      HttpSession session = req.getSession(false);
      Member mb = (Member)session.getAttribute("member");
      String id = mb.getId();
      String name = req.getParameter("name");
      String subject = req.getParameter("subject");
      String content = req.getParameter("content");
      
      Date currentDatetime = new Date(System.currentTimeMillis());
      java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
      Timestamp regist_day = new Timestamp(currentDatetime.getTime());
      
      int hit = 0;
      String ip = req.getRemoteAddr();
      
      Board bd = new Board();
      bd.setId(id);
      bd.setName(name);
      bd.setSubject(subject);
      bd.setContent(content);
      bd.setRegist_day(regist_day);
      bd.setHit(hit);
      bd.setIp(ip);
      System.out.println("dto담기 완료");
      //모델이동
      BoardRepository br = BoardRepository.getInstance();
      br.create(bd);

      //뷰이동
      resp.sendRedirect("BoardListAction");
   }
}
