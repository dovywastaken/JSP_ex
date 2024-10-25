package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.member_dto;

public class member_repository //1개만 존재해야 하므로 싱글턴으로 작성
{
	private static member_repository mr = new member_repository();
	public static member_repository getInstance() 
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
		String database = "jdbc:mysql://localhost:3306/login_crud";
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
			int user_age = dto.getAge();
			
			//데이터 담아서 SQL(db)로 보내기
			String sql = "insert into member values(' "+user_id+"',' "+user_pw+"',' "+user_age+" ')";
			stmt.executeUpdate(sql);
		} 
		catch (Exception e) 
		{
			System.out.println("데이터 베이스 연결오류");
		}
		

		//Step 3 : SQL 전송객체 생성 및 전송
		
		
		//Step 4 : 리턴이 있다면 ResultSet객체에 담기 - CUD 는 상관 없음
	}
	
	
	
	//Read
	public ArrayList<member_dto> getAllmember () throws Exception
	{	
			ArrayList<member_dto> arr = new ArrayList<member_dto>();
			ResultSet rs = null;
			try 
			{
				Connection conn = DBconn();
				Statement stmt = conn.createStatement();
				String sql = "select * from member";
				rs = stmt.executeQuery(sql);
				while(rs.next()) 
				{
					String id = rs.getString("id"); //괄호안에는 컬럼명이 들어감
					String pw = rs.getString("pw");
					int age = rs.getInt("age");
					
					member_dto dto = new member_dto();
					
					dto.setId(id);
					dto.setPw(pw);
					dto.setAge(age);
					arr.add(dto);
					
					/*
					이렇게도 가능
						member_dto dto = new member_dto();
						dto.setId(rs.getString("id"));
						dto.setPw(rs.getString("pw"));
						dto.setAge(rs.getInt("age"));
					*/
				}
			} 
		catch (Exception e) {e.printStackTrace();}
		
		return arr;
	}
	
	public member_dto getOnemember(String user_id) 
	{
		//Step 1 : DB연결

		member_dto dto = new member_dto();
		ResultSet rs = null;
		try 
		{
			//Step 1 DB 연결
			Connection conn = DBconn();
			
			//Step 2 Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "select * from member where id='"+user_id+"'";
			rs = stmt.executeQuery(sql);

			if(rs.next()) 
			{
				String id = rs.getString("id"); //괄호안에는 컬럼명이 들어감
				String pw = rs.getString("pw");
				int age = rs.getInt("age");

				dto.setId(id);
				dto.setPw(pw);
				dto.setAge(age);
			}
		} 
		catch (Exception e) {e.printStackTrace();}

		return dto;

	}
	
	
	//Update
	
	public void update_member(member_dto dto) 
	{
		try 
		{		
			//Step 1 DB 연결
			Connection conn = DBconn();
			//Step 2 Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = 
			"update member set pw='"+dto.getPw()+"',age='"+dto.getAge()+"' where id='"+dto.getId()+"' ";
			stmt.executeUpdate(sql);
		} 
		catch (Exception e) {e.printStackTrace();}
	}
	
	
	//Delete
	public void deleteuser(String id) 
	{
		//Step 1 DB 연결
		try 
		{
			Connection conn = DBconn();
			//Step 2 Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "delete from member where id='" + id+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} 
		catch (Exception e) {e.printStackTrace();}
		
		
		
		
		
		
		
		
		
		
	}
	
}
