package com.saurabh.dada.iq.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionsInConstructor {

	public ExceptionsInConstructor() throws IOException{
		FileInputStream fis = null;
		File dir = new File(".");//get current directory
		File fin = new File(dir.getCanonicalPath() + File.separator + "non-existing-file.txt");
		fis = new FileInputStream(fin);
		if(fis!=null){
			fis.close();
		}
	}
	
	public static void main(String[] args) {
		try{
			ExceptionsInConstructor constructor = new ExceptionsInConstructor();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
