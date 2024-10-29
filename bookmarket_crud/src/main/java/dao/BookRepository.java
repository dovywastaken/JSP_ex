package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Book;

public class BookRepository 
{
	//싱글턴 방식
	private static BookRepository bookrepository = new BookRepository();
	//싱글턴 방식
	public static BookRepository getInstance()
	{
		return bookrepository;
	}

	//생성자
	public BookRepository() 
	{
		/*
		Book book1= new Book("ISBN1234","C# 프로그래밍", 27000);
		book1.setAuthor("우재남");
		book1.setBookdescription("C#을 처음 접하는 독자를 대상으로 일대일 수업처럼 자세히 설명한 책이다. 꼭 알아야 할 핵심 개념은 기본 예제로 최대한 쉽게 설명했으며, 중요한 내용은 응용 예제, 퀴즈, 셀프 스터디, 예제 모음으로 한번 더 복습할 수 있다.");
		book1.setPublisher("한빛아카데미");
		book1.setCategory("IT모바일");
		book1.setUnitsInStock(1000);	
		book1.setReleaseDate("2022/10/06");
		book1.setFilename("ISBN1234.jpg");
		
		Book book2 = new Book("ISBN1235","자바마스터", 30000);
		book2.setAuthor("송미영");
		book2.setBookdescription("자바를 처음 배우는 학생을 위해 자바의 기본 개념과 실습 예제를 그림을 이용하여 쉽게 설명합니다. 자바의 이론적 개념→기본 예제→프로젝트 순으로 단계별 학습이 가능하며, 각 챕터의 프로젝트를 실습하면서 온라인 서점을 완성할 수 있도록 구성하였습니다.");
		book2.setPublisher("한빛아카데미");
		book2.setCategory("IT모바일");
		book2.setUnitsInStock(1000);		
		book2.setReleaseDate("2023/01/01");
		book2.setFilename("ISBN1235.jpg");
		
		Book book3= new Book("ISBN1236","파이썬 프로그래밍", 30000);
		book3.setAuthor("최성철");
		book3.setBookdescription(" 파이썬으로 프로그래밍을 시작하는 입문자가 쉽게 이해할 수 있도록 기본 개념을 상세하게 설명하며, 다양한 예제를 제시합니다. 또한 프로그래밍의 기초 원리를 이해하면서 파이썬으로 데이터를 처리하는 기법도 배웁니다.");
		book3.setPublisher("한빛아카데미");
		book3.setCategory("IT모바일");
		book3.setUnitsInStock(1000);	
		book3.setReleaseDate("2023/01/01");
		book3.setFilename("ISBN1236.jpg");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
		*/
	}
	
	public Connection dbconn()
	{
		Connection conn = null;
		System.out.println("conn 참조 변수 생성");
		try {
			String database = "jdbc:mysql://localhost:3306/BookMarketDB";
			System.out.println("데이터베이스 주소 담기 완료 : " + database);
			String id = "root";
			System.out.println("id 담기 완료 : " + id);
			String password = "1234";
			System.out.println("pw 담기 완료 : " + password);
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(database, id, password);
			System.out.println("conn 객체에 드라이버매니저 정보 담기 완료");
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
			System.out.println("sql 프린트"+sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				//DTO의 변수이름, Repository의 변수이름, Database 컬럼 이름을 같게 하면 좋음!!!!!!!!!!!!!!
				//변수 < DTO < ArrayList<DTO>
				String bookId = rs.getString("bookId");
				System.out.println(bookId);
				String bookname = rs.getString("bookname");
				System.out.println(bookname);
				int unitPrice = rs.getInt("unitPrice");
				System.out.println(unitPrice);
				String author = rs.getString("author");
				System.out.println(author);
				String bookdescription = rs.getString("bookdescription");
				System.out.println(bookdescription);
				String publisher = rs.getString("publisher");
				System.out.println(publisher);
				String category = rs.getString("category");
				System.out.println(category);
				long unitsInStock = rs.getLong("unitsInStock");
				System.out.println(unitsInStock);
				String releaseDate = rs.getString("releaseDate");
				System.out.println(releaseDate);
				String bookcondition = rs.getString("bookcondition");
				System.out.println(bookcondition);
				String filename = rs.getString("filename");
				System.out.println(filename);
				//int quantity = rs.getInt("quantity");
				
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
				//bk.setQuantity(quantity);
				
				listOfBooks.add(bk);
			}
		}
		catch(Exception e)
		{
			
			System.out.println("아무거나" + e.getMessage());
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
	//dao에 책 추가하기
	public void addBook(Book book)
	{
		listOfBooks.add(book);
	}
	*/
}
