package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class BoardRepository 
{
	//싱글턴
	private static BoardRepository br = new BoardRepository();
	//기본생성자
	private BoardRepository(){}
	//싱글턴 리턴
	public static BoardRepository getInstance() {return br;}
	
	//전역변수 선언
	Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	//db연결 메서드
	public Connection dbconn()
	{
		conn = null;
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

	
	//행의 갯수를 리턴하는 함수
	public int getTotalCount() 
	{
		int count= 0;
		//DB
		conn = dbconn();
		//SQL
		String sql = "select count(*) from board";
		try 
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//ResultSet
			if(rs.next()) 
			{
				count = rs.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return count;
		
	}
	
	
	
	
	//C
	public void create() 
	{
		//db
		Connection conn = dbconn();
		//SQL
		
		//ResultSet
	}
	
	
	
	
	//R
	public ArrayList<Board> getAllBoard() 
	{
		ArrayList<Board> arr = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//db
		Connection conn = dbconn();
		//SQL
		try 
		{
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			//ResultSet
			rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				Board bd = new Board();
				bd.setNum(rs.getInt("num"));
				bd.setId(rs.getString("id"));
				bd.setName(rs.getString("name"));
				bd.setSubject(rs.getString("subject"));
				bd.setContent(rs.getString("content"));
				bd.setRegist_day(rs.getTimestamp("regist_day"));
				bd.setHit(rs.getInt("int"));
				bd.setIp(rs.getString("num"));
				
				arr.add(bd);
			}
		} 
		catch (SQLException e) {System.out.println("[에러가 발생했습니다" + e.getMessage()+ "]");}

		return arr;
	}
	
	/*
	public Board getOneBoard() 
	{
		//db
		Connection conn = dbconn();
		//SQL
		
		//ResultSet
		return ;
	}
	*/
	//U
	public void update() 
	{
		//db

		//SQL
		
		//ResultSet
	}
	
	
	
	
	//D
	public void delete() 
	{
		//db

		//SQL
		
		//ResultSet
	}
	
	
	
	
	
	
}
