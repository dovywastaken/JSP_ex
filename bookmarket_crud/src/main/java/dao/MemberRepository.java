package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;

public class MemberRepository 
{
	private static MemberRepository mr = new MemberRepository();
	private MemberRepository() {}
	public static MemberRepository getMr() {
		return mr;
	}
	
	//DB연결 함수
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
	
	
	//Create
	public void create(Member mb) 
	{ System.out.println("[create 함수 입장]");
		//DataBase 연결
		Connection conn = dbconn();
		//SQL전송
		PreparedStatement pstmt = null;
		try 
		{
			String sql = "insert into Member values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPassword());
			pstmt.setString(3, mb.getName());
			pstmt.setString(4, mb.getGender());
			pstmt.setString(5, mb.getBirth());
			pstmt.setString(6, mb.getMail());
			pstmt.setString(7, mb.getPhone());
			pstmt.setString(8, mb.getAddress());
			pstmt.setTimestamp(9, mb.getRegist_day());
			pstmt.executeUpdate();
			System.out.println("[sql문을 executeUpdate 했습니다]");
			}
		catch(Exception e) {System.out.println("[에러발생 " + e.getMessage() + "]");}
		finally 
		{
			try 
			{
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}
			catch(Exception e) {System.out.println("[에러발생 " + e.getMessage() + "]");}
		}
		//ResultSet
		
	System.out.println("[create 함수 종료]");
	}
	//Read
	public Member getUser(String id, String password) 
	{
		System.out.println("[getUser 함수 입장]");
		Member returnData = new Member();
		//데이터베이스 연결
		Connection conn = dbconn();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=? and password=?";
		try 
		{
			//쿼리전송
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			//ResultSet 변환
			if(rs.next()) 
			{
				returnData.setId(rs.getString("id"));
				returnData.setPassword(rs.getString("password"));
				returnData.setName(rs.getString("name"));
				returnData.setGender(rs.getString("gender"));
				returnData.setBirth(rs.getString("birth"));
				returnData.setMail(rs.getString("mail"));
				returnData.setPhone(rs.getString("phone"));
				returnData.setAddress(rs.getString("address"));
				returnData.setRegist_day(rs.getTimestamp("regist_day"));
			}
		} 
		catch (Exception e) {System.out.println("[에러발생 : " + e.getMessage() + "]");}

		return returnData;
	}
	
	
	//Update
	
	//Delete
	
}