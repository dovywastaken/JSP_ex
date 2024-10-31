package Board_Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardRepository;
import dao.BookRepository;
import dto.Board;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BoardListAction")
public class Read_Controller  extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Board_Create_Controller의 doGet() 입장");
		int Limit = 5; //한 페이지에 출력할 글의 갯수를 제한
		//전처리
		int pageNum = Integer.parseInt((req.getParameter("pageNum")));
		//모델이동
		BoardRepository br = BoardRepository.getInstance();
		ArrayList<Board> arr = (ArrayList<Board>)br.getAllBoard();
		int total_record = br.getTotalCount();
		int total_page = 0;
		if(total_record % Limit == 0) //더이상 출력할 페이지가 없으면
		{
			total_page = total_record / Limit; // 몫을 넣기
		}
		else 
		{
			total_page = (total_record / Limit)+1;
		}
		
		//뷰이동
		req.setAttribute("total_page", total_page); //출력할 페이지의 갯수
		req.setAttribute("total_record", total_record); //전체 글의 갯수
		req.setAttribute("pageNum", pageNum); //현재 페이지 번호
		req.setAttribute("list", arr); //전체 글을 담은 객체
		System.out.println("list.jsp로 뷰를 이동합니다");
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("============================================================================");
        System.out.println("Board_Create_Controller의 doPost() 입장");
        
      //전처리
      //모델이동
      //뷰이동

    }

}
