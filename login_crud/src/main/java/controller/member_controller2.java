package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.member_repository;
import dto.member_dto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readall")
public class member_controller2 extends HttpServlet
{
//목표 : 여러개의 dto를 읽어와서 뷰에 출력하는 것 (Read)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		
		
		
		//모델이동
		member_repository mr = member_repository.getInstance();
		try 
		{
			ArrayList<member_dto> arr = mr.getAllmember();
			
			req.setAttribute("list", arr);
			req.getRequestDispatcher("all.jsp").forward(req, resp);
		} 
		catch (Exception e) {e.printStackTrace();}
		
		
		//이동
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}
	
}
