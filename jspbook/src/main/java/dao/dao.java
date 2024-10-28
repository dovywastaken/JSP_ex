package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import dto.member_dto;

public class dao 
{
	private static dao rp = new dao();
	public static dao getInstance() {return rp;}
	//DB 연결하는 메서드
	public Connection DBConn() throws Exception
	{
		//Step 1 : JDBC 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("드라이버 로딩 완료");
		//Step 2 : Connection 객체 생성
		Connection conn = null;
		System.out.println("conn 참조 변수 생성");
		String database = "jdbc:mysql://localhost:3306/exam16";
		System.out.println("데이터베이스 주소 담기 완료 : " + database);
		String id = "root";
		System.out.println("id 담기 완료 : " + id);
		String password = "1234";
		System.out.println("pw 담기 완료 : " + password);
		conn = DriverManager.getConnection(database, id, password);
		System.out.println("conn 객체에 드라이버매니저 정보 담기 완료");
		System.out.println("데이터 베이스 연결 완료");
		return conn;
	}
	
	public void create(String id, String pw, String name) 
	{
		try 
		{
			Connection conn = DBConn();
			PreparedStatement pstmt = null;
			String sql = "insert into member(id, pass, name) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			System.out.println(sql);
			pstmt.executeUpdate();
			System.out.println("테이블 삽입 성공");
		} 
		catch (Exception e) {
			System.out.println("테이블 삽입 실패");
			e.printStackTrace();
			}
	}
}
