package Book_Controller;

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

@WebServlet("/addBook")
public class Create_Controller  extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Create_Controller의 doGet() 입장");
		//전처리
		
		//모델이동
		
		//뷰이동
		System.out.println("addBook으로 뷰를 이동합니다");
		req.getRequestDispatcher("addBook.jsp").forward(req, resp);
		
	}

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("============================================================================");
        System.out.println("Create_Controller의 doPost() 입장");
        
        // 전처리
        String realFolder = req.getServletContext().getRealPath("resources/images");
        System.out.println(" - 파일이 저장될 경로 : " + realFolder);
        
        int maxSize = 5 * 1024 * 1024;  // 5MB
        String encType = "utf-8";
        
        // MultipartRequest 생성
        MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
        
        // 일반 파라미터 받기
        String bookId = multi.getParameter("bookId");
        String name = multi.getParameter("name");
        String unitPrice = multi.getParameter("unitPrice");
        String author = multi.getParameter("author");
        String publisher = multi.getParameter("publisher");
        String releaseDate = multi.getParameter("releaseDate");
        String description = multi.getParameter("description");
        String category = multi.getParameter("category");
        String unitsInStock = multi.getParameter("unitsInStock");
        String condition = multi.getParameter("condition");
        
        // 파일 정보 받기
        String filename = multi.getFilesystemName("BookImage");
        
        // 가격 변환
        Integer price = unitPrice.isEmpty() ? 0 : Integer.valueOf(unitPrice);
        
        // 재고 변환
        long stock = unitsInStock.isEmpty() ? 0 : Long.valueOf(unitsInStock);
        
        // Book 객체 생성 및 설정
        Book bk = new Book();
        bk.setBookId(bookId);
        bk.setBookname(name);
        bk.setAuthor(author);
        bk.setPublisher(publisher);
        bk.setReleaseDate(releaseDate);
        bk.setBookdescription(description);
        bk.setCategory(category);
        bk.setBookcondition(condition);
        bk.setUnitPrice(price);
        bk.setUnitsInStock(stock);
        bk.setFilename(filename);  // 수정된 파일명 설정
        
        // 모델 저장
        BookRepository br = BookRepository.getInstance();
        br.addBook(bk);
        System.out.println(" - " + bk.getBookId()+ "가 도서 목록에 추가되었습니다");
        
        // 리디렉션
        System.out.println("books로 리다이렉션 합니다.");
        resp.sendRedirect("books");
    }

}
