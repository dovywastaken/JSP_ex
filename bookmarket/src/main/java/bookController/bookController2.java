package bookController;

import java.io.IOException;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class bookController2 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리 : 넘오는 파라미터 없음
		String id = req.getParameter("id");
		//모델이동 : 리파지토리 연결 후 ArrayList 리턴받아야됨
		BookRepository br = BookRepository.getInstance();
		Book bk = br.getBookById(id);
		
		req.setAttribute("book", bk);
		RequestDispatcher ds = req.getRequestDispatcher("book.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setCharacterEncoding("UTF-8");
		
		String bookId = req.getParameter("bookId");
		String name = req.getParameter("name");
		String unitPrice = req.getParameter("unitPrice");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String releaseDate = req.getParameter("releaseDate");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		String unitsInStock = req.getParameter("unitsInStock");
		String condition = req.getParameter("condition");
		
		Integer price;
		
		if(unitPrice.isEmpty()) 
		{
			price = 0;
		}
		else 
		{
			price = Integer.valueOf(unitPrice);
		}
		
		long stock;
		
		
		if (unitsInStock.isEmpty()) 
		{
			stock = 0;
		}
		else 
		{
			stock = Long.valueOf(unitsInStock);
		}
		
		BookRepository dao = BookRepository.getInstance();
		
		
		Book newBook = new Book();
		newBook.setName(name);
		newBook.setUnitPrice(price);
		newBook.setAuthor(author);
		newBook.setPublisher(publisher);
		newBook.setPublisher(releaseDate);
		newBook.setDescription(description);
		newBook.setCategory(category);
		newBook.setUnitsInStock(stock);
		newBook.setCondition(condition);
		
		dao.addBook(newBook);
		
		
		resp.sendRedirect("books.jsp");
	
	}

}
