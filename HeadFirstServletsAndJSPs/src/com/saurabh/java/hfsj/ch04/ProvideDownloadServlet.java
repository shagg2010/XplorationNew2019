package com.saurabh.java.hfsj.ch04;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvideDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProvideDownloadServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			InputStream is=null;
			response.setContentType("application/jar");
			if(request.getParameter("file_name").toString().equals("j2ee_jar")){
				is = getServletContext().getResourceAsStream("/downloadables/j2ee-1.4.jar");
			}
			else if(request.getParameter("file_name").toString().equals("HFTSAJ_pdf")){
				is = getServletContext().getResourceAsStream("/downloadables/Head First to Servlets and JSP.pdf");
			}
			
			//InputStream is2 = getServletContext().getResourceAsStream("D:/workbench/workspace/WCD_ws/HeadFirstServletsAndJSPs/WebContent/downloadables-libs/j2ee-1.4.jar");
			
			int read=0;
			byte[] bytes = new byte[1024];
			
			OutputStream os = response.getOutputStream();
			while((read = is.read(bytes))!=-1){
				os.write(bytes,0,read);
			}
			os.flush();
			os.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
		
	}

}
