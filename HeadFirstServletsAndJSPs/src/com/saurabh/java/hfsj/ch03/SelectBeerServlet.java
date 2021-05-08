package com.saurabh.java.hfsj.ch03;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectBeerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectBeerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String beerColor = request.getParameter("color").toString();
		getServletConfig().getServletContext().log(beerColor);
		
		//Version -2
		displayRequestDetails(request);
		List<String> brands = new BeerExpert().getBrands(beerColor);
		request.setAttribute("brands", brands);
		request.setAttribute("fromServlet", Boolean.TRUE);
		System.out.println("log1");
		request.getRequestDispatcher("/jsps/beeroptions.jsp").forward(request, response);
		System.out.println("log2");
		
		//Version - 1
		
		/*PrintWriter out = response.getWriter();
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("Selected Beer color is: " + beerColor);
		
		bodyBuffer.append("<br>Suggestions for your choice are: <br>");
		List<String> brands = new BeerExpert().getBrands(beerColor);
		int i=0;
		for(String brand: brands){
			bodyBuffer.append("<br>\n"+(++i)+". " + brand);
		}
		
		out.println(GlobalHTMLTags.doStartHTMLBody("Beer Selection Advice",bodyBuffer));
		out.print(GlobalHTMLTags.doEndHTMLBody());*/
	}
	
	private void displayRequestDetails(HttpServletRequest request){
		try{
			System.out.println("User-Agent: "+request.getHeader("User-Agent"));
			System.out.println("Host: " + request.getHeader("Host"));
			System.out.println("Accept: "+ request.getHeader("Accept"));
			System.out.println("Accept-Charset: "+request.getHeader("Accept-Charset"));
			System.out.println("Accept-Encoding: "+request.getHeader("Accept-Encoding"));
			System.out.println("Max-Forwards: "+request.getIntHeader("Max-Forwards"));
			System.out.println("Content-Lenght: "+request.getIntHeader("Content-Lenght"));
			
			System.out.println("RemotePort: "+request.getRemotePort());
			System.out.println("ServerPort: "+request.getServerPort());
			System.out.println("LocalPort: "+request.getLocalPort());
			System.out.println("Session Id: "+request.getSession().getId());
			System.out.println("QueryString: "+request.getQueryString());
			System.out.println("Protocol: "+request.getProtocol());
			System.out.println("AuthType: "+request.getAuthType());
			System.out.println("ServerName: "+request.getServerName());
			
			System.out.println("Method: "+request.getMethod());
			
			if(request.getCookies()!=null){
				System.out.println("Cookies: "+request.getCookies());
				Cookie[] cookies = request.getCookies();
				for(Cookie cookie: cookies){
					System.out.println("Cookie's Name: " + cookie.getName());
					System.out.println("Cookie's Value: " + cookie.getValue());
					System.out.println("Cookie's Max Age: " + cookie.getMaxAge());
					System.out.println("Cookie's Version: " + cookie.getVersion());
					System.out.println("Cookie's Path: " + cookie.getPath());
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
