package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.member_dto;

public class repository //1개만 존재해야 하므로 싱글턴으로 작성
{
	private static repository mr = new repository();
	public static repository getInstance() 
	{
		return mr;
	}
	
	//CRUD
	
	//데이터베이스 연결 메서드
	private Connection DBconn() throws Exception
	{
		//Step 1 : JDBC 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");//특정 클래스를 찾아주는 클래스 Class
		//forName() 메서드는 클래스 이름을 문자열로 받아 불러오는 역할을 함
		//Driver 클래스는 특정 데이터베이스와 통신할 수 있도록 해주는 역할을 함
		
		//Step 2 : Connection 객체 생성
		Connection conn = null;
		String database = "jdbc:mysql://localhost:3306/exam16";
		String id = "root";
		String password = "1234";
		conn = DriverManager.getConnection(database, id, password);
		System.out.println("데이터 베이스 연결 완료");
		return conn;
	}
	
	
	
	//Create
	
	public void member_create(member_dto dto) 
	{
		try 
		{
			//Step 2 : Connection 객체 생성
				//확인사항 1. 데이터 베이스 생성 여부 2. WEB-INF 폴더에 라이브러리 확인
			Connection conn = DBconn(); //Connection 객체는 db 연결을 하는 클래스
			//SQL쿼리를 전송 : 데이터베이스에 데이터를 삽입하는 절차
			Statement stmt = conn.createStatement(); //Statement 객체는 SQL을 실어나르는 클래스
			String user_id = dto.getId();
			String user_pw = dto.getPw();
			String user_age = dto.getName();
			
			//데이터 담아서 SQL(db)로 보내기
			String sql = "insert into member values(' "+user_id+"',' "+user_pw+"',' "+user_age+" ')";
			stmt.executeUpdate(sql);
		} 
		catch (Exception e) {System.out.println("데이터 베이스 연결오류");}
	}
}
