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
		System.out.println("2 : BookRepository 객체를 전달하기 위한 getInstance 실행");
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
			System.out.println("데이터 베이스 연결 완료");
		} 
		catch (Exception e) 
		{
			System.out.println("데이터베이스 연결이 실패되었습니다.");
			System.out.println("SQLException : " + e.getMessage());
		}
		return conn;
	}
	
	
	//모든 책 dto를 ArrayList에 묶어서 가져오기
	public ArrayList<Book> getAllBooks()
	{
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
				String filename = rs.getString("filename");
				
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

		return listOfBooks;
	}
	
/*
	//id에 맞는 책 가져오기
	public Book getBookById(String bookId) 
	{
		Book bookById=null;
		
		for (int i=0; i<listOfBooks.size(); i++) 
		{
			Book book = listOfBooks.get(i);
			if(book != null && book.getBookId() != null && book.getBookId().equals(bookId)) 
			{
				bookById = book;
				break;
			}
		}
		return bookById;
	}
	
	*/
	//dao에 책 추가하기
	public void addBook(Book book)
	{
		//
		System.out.println("리파지터리의 addBook 함수실행");
		//데이터베이스 연결
		Connection conn = dbconn();
		//SQL전송
		PreparedStatement pstmt = null;
		
		String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
		
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

		
		
		
	}

}
