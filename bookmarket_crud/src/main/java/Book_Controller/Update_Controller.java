package Book_Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateBook")
public class Update_Controller   extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Update_Controller의 doGet메서드로 입장");
		//전처리
		String id = req.getParameter("id");
		System.out.println(" - " + id + "에 대한 수정페이지를 보여줍니다");
		
		//모델이동
		BookRepository br = BookRepository.getInstance();
		Book bk = br.getBookById(id);
		
		
		//뷰이동
		req.setAttribute("dto", bk);
		System.out.println("updateBook.jsp로 이동");
		req.getRequestDispatcher("updateBook.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("============================================================================");
		System.out.println("Update_Controller의 doPost메서드로 입장");
		
		//전처리
	      req.setCharacterEncoding("UTF-8");
	      //String filename = "";
	      String realFolder = req.getServletContext().getRealPath("resources/images");
	      String encType = "utf-8"; //인코딩 타입
	      int maxSize = 5 * 1024 * 1024; //최대 업로드될 파일의 크기5Mb
	      
	      MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

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
	      //updateBook 페이지에서 선택한 dto에서 파라미터를 빼온다
	      
	      
	      //multi.getParameter()는 String을 반환하기 때문에 가격이나 재고 같은 정수로 나타내야 하는 데이터를 별도로 처리해야 한다
	      int price;

	      if (unitPrice.isEmpty())
	         price = 0;
	      else
	         price = Integer.valueOf(unitPrice);
	      //dto의 가격이 비어있으면 0으로 아니라면 입력한 가격대로 저장
	      
	      
	      long stock;

	      if (unitsInStock.isEmpty())
	         stock = 0;
	      else
	         stock = Long.valueOf(unitsInStock);
	    //dto의 재고가 비어있으면 0으로 아니라면 입력한 재고대로 저장
	      
	      String fileName = multi.getFilesystemName("bookImage");
	      
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
		      
		      bk.setFilename(fileName);
	      
		//모델이동
		BookRepository br = BookRepository.getInstance();
		br.updateBook(bk);
		
		//뷰이동
		System.out.println("books로 리다이렉션합니다.");
		resp.sendRedirect("books");
	}
}
