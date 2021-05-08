package com.saurabh.dada.iq.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileLinesOneByOne {

	public static void main(String[] args) {
		
		try{
			FileInputStream fstream = new FileInputStream(".//data//textdata.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  System.out.println (strLine);
			  if(strLine.isEmpty()){
				  break;
			  }
			}

			//Close the input stream
			br.close();

		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
