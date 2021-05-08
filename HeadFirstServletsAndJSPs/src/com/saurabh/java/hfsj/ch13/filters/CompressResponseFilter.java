package com.saurabh.java.hfsj.ch13.filters;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch13.filters.CompressedServletResponse;

public class CompressResponseFilter implements Filter {
	
	private FilterConfig fc;
	private ServletContext ctx;

    public CompressResponseFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
		fc = fConfig;
		ctx = fConfig.getServletContext();
		ctx.log(">>> >>> " + fc.getFilterName() +" initialized");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		ctx.log(">>> >>> " + fc.getFilterName() +" verfiying if compression allowed!");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String valid_encodings = request.getHeader("Accept-Encoding");
		if(valid_encodings.indexOf("gzip") > -1){
			CompressedServletResponse compressedResponse = new CompressedServletResponse(response);
			compressedResponse.setHeader("Content-Encoding", "gzip");
			chain.doFilter(request, compressedResponse);
			GZIPOutputStream gzos = compressedResponse.getGzipOutputStream();
			
			compressedResponse.getWriter().print("SomeMessage");
			
			gzos.finish();
			ctx.log(">>> >>> " + fc.getFilterName() +" finished compressing the contents!");
		}
		else{
			ctx.log(">>> >>> " + fc.getFilterName() +", no compression was performed by this Filter!");
			chain.doFilter(request, response);
		}
	}
	
	public void destroy() {
		
	}

}
