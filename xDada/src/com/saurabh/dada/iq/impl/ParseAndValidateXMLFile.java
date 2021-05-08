package com.saurabh.dada.iq.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParseAndValidateXMLFile {

	public static void main(String[] args) {
		StringBuilder file = readXmlFile(".//data//person.xml");
		char[] carr = file.toString().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		Stack<String> stack2 = new Stack<String>();
		boolean inTag = false;
		
		for(char c:carr){
			if(c=='<'){
				inTag=true;
			}
			if(c=='>'){
				inTag=false;
				sb.append(""+c);
				stack.push(sb.toString());
				sb = new StringBuilder();
			}
			if(inTag){
				sb.append(""+c);
			}
		}
		
		System.out.println("stack: " + stack);			
		//System.out.println("stack2: " + stack2+"\n");
		
		while(!stack.isEmpty()){
			String item = stack.pop();
			if(item.contains("/"))
				stack2.push(removeForwardSlash(item));
			else
				stack2.push(item);
			while(!stack.isEmpty() && !stack2.isEmpty() && stack2.peek().equalsIgnoreCase(stack.peek())){
				if(stack2.peek().equalsIgnoreCase(stack.peek())){
					stack.pop();
					stack2.pop();
				}
			}

		}
		if(stack.isEmpty()&&stack2.isEmpty()){
			System.out.println("Validate Successful!");
		}
		else{
			System.out.println("Validation Failed!");
			System.out.println("stack: " + stack);			
			System.out.println("stack2: " + stack2+"\n");
		}
	}

	public static StringBuilder readXmlFile(String filePathRelative){
		StringBuilder sb = null;
		try{
			FileInputStream fstream = new FileInputStream(filePathRelative);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			sb = new StringBuilder();
			String strLine;

			while ((strLine = br.readLine()) != null)   {
			  sb.append(strLine);
			  if(strLine.isEmpty()){
				  break;
			  }
			}
			br.close();

		}
		catch(IOException e){
			e.printStackTrace();
		}
		return sb;
	}
	
	public static String removeForwardSlash(String str){		
		return new StringBuilder(str).deleteCharAt(1).toString();
	}
}
