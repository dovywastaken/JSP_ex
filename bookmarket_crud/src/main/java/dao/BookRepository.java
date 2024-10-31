package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Book;

public class BookRepository 
{
	//싱글턴 방식
	private static BookRepository bookrepository = new BookRepository();
	//싱글턴 방식
	public static BookRepository getInstance()
	{
		System.out.println("[싱글턴 방식으로 BookRepository를 불러왔습니다]");
		return bookrepository;
	}

	//생성자
	public BookRepository() {}
	
	public Connection dbconn()
	{
		Connection conn = null;
		//System.out.println("conn 참조 변수 생성");
		try {
			String database = "jdbc:mysql://localhost:3306/BookMarketDB";
			//System.out.println("데이터베이스 주소 담기 완료 : " + database);
			String id = "root";
			//System.out.println("id 담기 완료 : " + id);
			String password = "1234";
			//System.out.println("pw 담기 완료 : " + password);
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(database, id, password);
			//System.out.println("conn 객체에 드라이버매니저 정보 담기 완료");
			System.out.println("[데이터 베이스 연결 완료]");
		} 
		catch (Exception e) 
		{
			System.out.println("[데이터베이스 연결이 실패되었습니다]");
			System.out.println("[SQLException : " + e.getMessage() + "]");
		}
		return conn;
	}
	
	
	//모든 책 dto를 ArrayList에 묶어서 가져오기
	public ArrayList<Book> getAllBooks()
	{
		System.out.println("[getAllBooks 함수가 실행되었습니다]");
		ArrayList<Book> listOfBooks = new ArrayList<Book>();
		//Book 객체 묶음
		//Step 1: 데이터 베이스 연결
		Connection conn = dbconn();
		//Step 2 : 쿼리 전송
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			String sql = "select * from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//후처리
			while(rs.next()) 
			{
				//DTO의 변수이름, Repository의 변수이름, Database 컬럼 이름을 같게 하면 좋음!!!!!!!!!!!!!!
				//변수 < DTO < ArrayList<DTO>
				String bookId = rs.getString("bookId");
				String bookname = rs.getString("bookname");
				int unitPrice = rs.getInt("unitPrice");
				String author = rs.getString("author");
				String bookdescription = rs.getString("bookdescription");
				String publisher = rs.getString("publisher");
				String category = rs.getString("category");
				long unitsInStock = rs.getLong("unitsInStock");
				String releaseDate = rs.getString("releaseDate");
				String bookcondition = rs.getString("bookcondition");
				String filename = rs.getString("fileName");
				
				Book bk = new Book();
				bk.setBookId(bookId);
				bk.setBookname(bookname);
				bk.setUnitPrice(unitPrice);
				bk.setAuthor(author);
				bk.setBookdescription(bookdescription);
				bk.setPublisher(publisher);
				bk.setCategory(category);
				bk.setUnitsInStock(unitsInStock);
				bk.setReleaseDate(releaseDate);
				bk.setBookcondition(bookcondition);
				bk.setFilename(filename);
				
				listOfBooks.add(bk);
			}
		}
		catch(Exception e)
		{
			System.out.println("예외처리 발생" + e.getMessage());
		}
		System.out.println("[getAllBooks 함수가 무사히 실행되어 총 " + listOfBooks.size() + "개의 dto를 가져옵니다]");
		return listOfBooks;
	}
	
	//id에 맞는 책dto 가져오기
	public Book getBookById(String bookId) 
	{
		System.out.println("[getBookByID 함수 입장]");
		Book bookById = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//데이터 베이스 연결
		Connection conn = dbconn();
		//쿼리 전송
		String sql = "select * from book where bookid=?";
		System.out.println("[ 다음 SQL문을 데이터베이스로 보냅니다 " + sql + " ]");
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			rs = pstmt.executeQuery();
			
			//ResultSet을 객체로 전환
			if(rs.next()) {
				String dbbookId = rs.getString("bookId");
				String bookname = rs.getString("bookname");
				int unitPrice = rs.getInt("unitPrice");
				String author = rs.getString("author");
				String bookdescription = rs.getString("bookdescription");
				String publisher = rs.getString("publisher");
				String category = rs.getString("category");
				long unitsInStock = rs.getLong("unitsInStock");
				String releaseDate = rs.getString("releaseDate");
				String bookcondition = rs.getString("bookcondition");
				String filename = rs.getString("filename");

				Book bk = new Book();
				bk.setBookId(dbbookId);
				bk.setBookname(bookname);
				bk.setUnitPrice(unitPrice);
				bk.setAuthor(author);
				bk.setBookdescription(bookdescription);
				bk.setPublisher(publisher);
				bk.setCategory(category);
				bk.setUnitsInStock(unitsInStock);
				bk.setReleaseDate(releaseDate);
				bk.setBookcondition(bookcondition);
				bk.setFilename(filename);
				
				bookById = bk;
			}
		} catch (Exception e) 
		{
			System.out.println("%%%%예외처리 발생" + e.getMessage());
		}
		System.out.println("[getBookById 함수가 무사히 실행을 마치고 " + bookId +"에 해당하는 dto를 가져옵니다]");
		return bookById;
	}
	
	//dao에 책 추가하기
	public void addBook(Book book)
	{
		//
		System.out.println("[addBook 함수 입장]");
		//데이터베이스 연결
		Connection conn = dbconn();
		//SQL전송
		PreparedStatement pstmt = null;
		
		String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println("[ 다음 SQL문을 데이터베이스로 보냅니다 " + sql + " ]");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId()); 
			pstmt.setString(2, book.getBookname());
			pstmt.setInt(3, book.getUnitPrice()); 
			pstmt.setString(4, book.getAuthor()); 
			pstmt.setString(5, book.getBookdescription()); 
			pstmt.setString(6, book.getPublisher()); 
			pstmt.setString(7, book.getCategory()); 
			pstmt.setLong(8, book.getUnitsInStock()); 
			pstmt.setString(9, book.getReleaseDate()); 	
			pstmt.setString(10, book.getBookcondition()); 
			pstmt.setString(11, book.getFilename()); 
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			}
		finally 
		{
			if(pstmt!=null) 
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
				
			
		}
		System.out.println("[addBook 함수가 종료되었습니다]");
	}

	//하나의 책dto 삭제
	public void delBook(String bookId) 
	{
		System.out.println("[delBook 함수 입장]");
		//데이터 베이스 연결
		Connection conn = dbconn();
		//SQL 전송
		PreparedStatement pstmt = null;
		String sql = "delete from book where bookid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[delBook 함수 종료]");
	}
	
	//하나의 책DTO를 수정한다
	public void updateBook(Book book) 
	{
		System.out.println("[updateBook 함수에 입장했습니다]");
		//데이터 베이스 연결
		Connection conn = dbconn();
		//SQL 전송
		PreparedStatement pstmt = null;
		String sql = null;
	      try {
	          String filename= book.getFilename();
	          if(filename != null) {   //filename을 포함한 나머지를 전부 sql문으로 보냄
	        	 System.out.println("[첨부하신 파일 " + filename + "을 포함하고 있습니다]");
	             sql = "UPDATE book SET bookname=?, unitPrice=?, author=?, bookdescription=?, publisher=?, category=?, unitsInStock=?, releaseDate=?, bookcondition=?, fileName=? WHERE bookid=?";   
	             pstmt = conn.prepareStatement(sql);
	             pstmt.setString(1, book.getBookname()); 
	             pstmt.setInt(2, book.getUnitPrice()); 
	             pstmt.setString(3, book.getAuthor()); 
	             pstmt.setString(4, book.getBookdescription()); 
	             pstmt.setString(5, book.getPublisher()); 
	             pstmt.setString(6, book.getCategory()); 
	             pstmt.setLong(7, book.getUnitsInStock()); 
	             pstmt.setString(8, book.getReleaseDate());    
	             pstmt.setString(9, book.getBookcondition()); 
	             pstmt.setString(10, book.getFilename()); 
	             pstmt.setString(11, book.getBookId());
	             System.out.println("[sql문을 데이터베이스로 전송합니다]");
	          }
	          else { //filename 제외한 나머지를 전부 sql문으로 보냄
	        	 System.out.println("[첨부한 파일이 없습니다. 그 외 데이터만 수정등록 합니다]");
	             sql = "UPDATE book SET bookname=?, unitPrice=?, author=?, bookdescription=?, publisher=?, category=?, unitsInStock=?, releaseDate=?, bookcondition=? WHERE bookid=?";   
	             pstmt = conn.prepareStatement(sql);
	             pstmt.setString(1, book.getBookname()); 
	             pstmt.setInt(2, book.getUnitPrice()); 
	             pstmt.setString(3, book.getAuthor()); 
	             pstmt.setString(4, book.getBookdescription()); 
	             pstmt.setString(5, book.getPublisher()); 
	             pstmt.setString(6, book.getCategory()); 
	             pstmt.setLong(7, book.getUnitsInStock()); 
	             pstmt.setString(8, book.getReleaseDate());    
	             pstmt.setString(9, book.getBookcondition()); 
	             pstmt.setString(10, book.getBookId()); 
	             System.out.println("[sql문을 데이터베이스로 전송합니다]");
	          }
	          pstmt.executeUpdate();
	       }catch(Exception e) {
	    	   System.out.println("[%%%에러발생 " + e.getMessage() + "]");
	       }
	      System.out.println("[updateBook 함수를 종료합니다]");
	}
}
