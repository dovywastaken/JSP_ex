package chapter07;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;


@WebServlet("/7_3")
public class exam07_3 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		
		
		//모델 이동
		
		
		//이동
		RequestDispatcher rd = req.getRequestDispatcher("chapter07/fileupload03.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String save = req.getServletContext().getRealPath("img");
		String fileUploadPath = save; //파일 경로 저장
		System.out.println(save);
		DiskFileUpload upload = new DiskFileUpload(); //객체 생성
		List items;
		
		
		try 
		{
			items = upload.parseRequest(req);
			Iterator params = items.iterator();
			
			while(params.hasNext()) 
			{
				FileItem fileItem=(FileItem)params.next();
				if(!fileItem.isFormField()) 
				{
					String fileName = fileItem.getName();
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
					File file = new File(fileUploadPath + "/" + fileName);
					fileItem.write(file);
					System.out.println(fileItem);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		//모델 이동
		
		
		//이동
		
	}
	
}
