package com.saurabh.java.hfsj.ch13.filters;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class GZIPServletOutputStream extends ServletOutputStream{
	
	GZIPOutputStream internalGzipOS;
	
	public GZIPServletOutputStream(ServletOutputStream out) throws IOException{
		this.internalGzipOS = new GZIPOutputStream(out);
	}
	
	@Override
	public void write(int b) throws IOException {
		internalGzipOS.write(b);
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
