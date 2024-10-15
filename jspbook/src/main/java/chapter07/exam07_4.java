package chapter07;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/7_4")
public class exam07_4 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		
		//모델 이동
		
		//이동
		RequestDispatcher rd = req.getRequestDispatcher("chapter07/fileupload04.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		String save = req.getServletContext().getRealPath("img");
		String path = save;
		DiskFileUpload upload = new DiskFileUpload();
		upload.setSizeMax(1000000);
		upload.setSizeThreshold(4096);
		upload.setRepositoryPath(path);
		

		
		try 
		{

            List items = upload.parseRequest(req);
            Iterator params = items.iterator();

            while(params.hasNext()) 
            {
                FileItem item = (FileItem) params.next();
                if(item.isFormField()) 
                {
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    System.out.println(name + " = " + value + "<br>");
                } 
                else
                {
                	String fileFieldName = item.getFieldName();
                	String fileName = item.getName();
                	String contentType = item.getContentType();
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    long fileSize = item.getSize();
                    File file = new File(path + "/" + fileName);
                    item.write(file);
                    System.out.println("Saved file: " + file.getAbsolutePath());
                }
            }

        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		
		//모델 이동
		
		
		//이동
//        req.setAttribute("fileFieldName", fileFieldName);
//        req.setAttribute("fileName", fileName);
//        req.setAttribute("contentType", contentType);
//        req.setAttribute("fileSize", fileSize);

        RequestDispatcher rd = req.getRequestDispatcher("chapter07/fileupload04_process.jsp");
        rd.forward(req, resp);
	}

}
