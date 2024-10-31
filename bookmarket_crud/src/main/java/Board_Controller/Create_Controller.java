package Board_Controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
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
      System.out.println("Board Create_Controller의 doGet()입장");
      //전처리
      HttpSession session = req.getSession(false);
      RequestDispatcher rs=null;
      System.out.println(" - " + session);
      if(session != null) {
         if(session.getAttribute("member") == null) {
            System.out.println(" - 세션존재 멤버 없음 이동한다");
            rs = req.getRequestDispatcher("member_login");
         }
      }
      else {
    	  System.out.println(" - 세션존재 멤버 존재");
         rs = req.getRequestDispatcher("writeForm.jsp");
      }
      System.out.println("뷰 이동");
      rs.forward(req, resp);
      //모델이동
      //뷰이동
      
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("Create_Controller의 doPost()");
      //전처리
      request.setCharacterEncoding("UTF-8"); //한글아 깨지지마!
      //String realFolder = "C:\\Users\\user\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BookMarket\\resources\\images";
       // 일반 텍스트와 이미지 데이터가 썩여있으므로 분리가능한 객체가 필요하다.
      String realFolder = request.getServletContext().getRealPath("resources/images"); 
      String encType = "utf-8"; //인코딩 타입
      int maxSize = 5 * 1024 * 1024; //최대 업로드될 파일의 크기5Mb
      MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
      String bookId = multi.getParameter("bookId");
      String name = multi.getParameter("name");
      String author = multi.getParameter("author");
      String publisher = multi.getParameter("publisher");
      String releaseDate = multi.getParameter("releaseDate");   
      String description = multi.getParameter("description");   
      String category = multi.getParameter("category");
      String condition = multi.getParameter("condition");
      // 아래의 두개의 값은 갯수를 뜻하므로 정수로 변경되어야함
      String unitPrice = multi.getParameter("unitPrice");
      String unitsInStock = multi.getParameter("unitsInStock");
      
      int price;

      if (unitPrice.isEmpty()) {
         price = 0;         
      }
      else {
         price = Integer.valueOf(unitPrice);         
      }

      long stock;

      if (unitsInStock.isEmpty()) {
         stock = 0;         
      }
      else {
         stock = Long.valueOf(unitsInStock);
      }
      //여기까지가 일반텍스트 전처리
      // 저장된 이미지의 이름을 변수에 저장
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
      br.addBook(bk);
      //뷰이동 : CUD는 보여줄 뷰어가 없음
      resp.sendRedirect("books");      
   }
}
