package controller;

import java.io.IOException;

import dao.member_repository;
import dto.member_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//목표 : 데이터를 데이터베이스에 입력하는 것 (Create)
@WebServlet("/join")
public class member_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("./join.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int age = Integer.parseInt(req.getParameter("age"));
		
		member_dto dto = new member_dto();
		dto.setId(id);
		dto.setPw(pw);
		dto.setAge(age);
		
		//모델 이동
		member_repository mr = member_repository.getInstance();
		mr.member_create(dto);
		
		
		//이동
		resp.sendRedirect("readall");
		
	}
	
}
