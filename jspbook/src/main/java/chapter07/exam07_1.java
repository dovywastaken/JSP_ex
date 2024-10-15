package chapter07;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import java.util.*;
import java.io.*;

@WebServlet("/7_1")
public class exam07_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("chapter07/fileupload01.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String save = req.getServletContext().getRealPath("img");
		MultipartRequest multi = new MultipartRequest(req,save,5*1024*1024,"utf-8", new DefaultFileRenamePolicy());
		// 직접 하나씩 처리하는 경우
		String name = multi.getParameter("name");
		String subject = multi.getParameter("subject");
		
		String file = multi.getFilesystemName("filename");
		System.out.println(name);
		System.out.println(subject);
		System.out.println(file);
		System.out.println(save);
		//이동
		req.setAttribute("name",name );
		req.setAttribute("subject",subject );
		req.setAttribute("file",file );
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/fileupload01_process.jsp");
		ds.forward(req, resp);
	}

}
