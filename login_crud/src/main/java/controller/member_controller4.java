package controller;

import java.io.IOException;

import dao.member_repository;
import dto.member_dto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class member_controller4 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String id = req.getParameter("id");
		
		//모델
		member_repository mr = member_repository.getInstance();
		mr.getOnemember(id);
		member_dto dto = mr.getOnemember(id);
		//이동
		req.setAttribute("DTO", dto);
		req.getRequestDispatcher("updateform.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		
		
		//모델
		
		
		//이동
	}
	
}