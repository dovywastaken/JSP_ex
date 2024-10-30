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
		System.out.println("Create_Controller의 doGet() 입장");
		//전처리
		
		//모델이동
		
		//뷰이동
		req.getRequestDispatcher("addBook.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("Create_Controller의 doPost() 입장");
		//전처리
		req.setCharacterEncoding("utf-8"); //한글 깨짐 방지
		String realFolder = req.getServletContext().getRealPath("resources/images");
		//일반 텍스트와 이미지 데이터가 섞여있으므로 분리가능한 객체가 필요하기 때문에 선언
		System.out.println(realFolder);
		
		int maxSize = 5*1024*1024;
		String encType ="utf-8";
		
		MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String unitPrice = multi.getParameter("unitPrice");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher"); //출판사
		String releaseDate = multi.getParameter("releaseDate"); //출판일
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String unitsInStock = multi.getParameter("unitsInStock");
		String condition = multi.getParameter("condition");
		String fileName = multi.getFilesystemName("BookImage");
		
		
		//price 정수
		Integer price;
		
		if (unitPrice.isEmpty()) 
		{
			price = 0;
		}
		else 
		{
			price=Integer.valueOf(unitPrice);
		}
		
		
		//stock 정수
		long stock;
		
		if(unitsInStock.isEmpty()) 
		{
		    stock = 0;
		}
		else 
		{
		    stock = Long.valueOf(unitsInStock);
		}
		//여기까지가 일반 텍스트 전처리
		String filename = multi.getParameter("BookImage");
		
		
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
		bk.setFilename(filename);
		
		//모델이동
		BookRepository br = BookRepository.getInstance();
		br.addBook(bk);
		
		//뷰이동 : CUD는 보여줄 뷰어가 없음
		resp.sendRedirect("books");
		
	}

}
