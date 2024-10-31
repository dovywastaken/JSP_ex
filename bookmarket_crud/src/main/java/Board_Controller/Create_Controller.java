package Board_Controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardWriteForm")
public class Create_Controller  extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Create_Controller의 doGet() 입장");
		//전처리
		HttpSession session = req.getSession(false);
		if(session==null) 
		{
			System.out.println("세션이 없어 member_login으로 리다렉션합니다");
			resp.sendRedirect("member_login");
		}
		//모델이동
		
		//뷰이동
		System.out.println("addBook으로 뷰를 이동합니다");
		req.getRequestDispatcher("writeForm.jsp").forward(req, resp);
		
	}

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("============================================================================");
        System.out.println("Create_Controller의 doPost() 입장");
        
        // 리디렉션
        System.out.println("books로 리다이렉션 합니다.");
        resp.sendRedirect("books");
    }

}
