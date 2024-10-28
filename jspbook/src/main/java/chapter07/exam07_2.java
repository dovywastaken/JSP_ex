package chapter07;

import java.io.IOException;
import java.util.Enumeration;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_2")
public class exam07_2 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("chapter07/fileupload02.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String save = req.getServletContext().getRealPath("img");
		MultipartRequest multi = new MultipartRequest(req,save,5*1024*1024,"utf-8", new DefaultFileRenamePolicy());
		
		String name1 = multi.getParameter("name1");
		String subject1 = multi.getParameter("subject1");
		
		String name2 = multi.getParameter("name2");
		String subject2 = multi.getParameter("subject2");
		
		String name3 = multi.getParameter("name3");
		String subject3 = multi.getParameter("subject3");
		
		
		Enumeration files = multi.getFileNames();
		
		String file3 = (String)files.nextElement();
		String filename3 = multi.getFilesystemName(file3);
		
		String file2 = (String) files.nextElement();
		String filename2 = multi.getFilesystemName(file2);
		
		String file1 = (String)files.nextElement();
		String filename1 = multi.getFilesystemName(file1);
		
		
		req.setAttribute("file1",file1 );
		req.setAttribute("file2",file2 );
		req.setAttribute("file3",file3 );
		
		req.setAttribute("subject1",subject1 );
		req.setAttribute("subject2",subject2 );
		req.setAttribute("subject3",subject3 );
		
		req.setAttribute("filename1",filename1 );
		req.setAttribute("filename2",filename2 );
		req.setAttribute("filename3",filename3 );
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/fileupload02_process.jsp");
		ds.forward(req, resp);
		
	}

}
