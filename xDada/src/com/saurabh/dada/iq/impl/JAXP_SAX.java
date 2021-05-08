package com.saurabh.dada.iq.impl;

import java.io.File;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.saurabh.dada.iq.impl.xml.obj.Employee;

public class JAXP_SAX {

	public static void main(String[] args) {
		try{
			File file = new File("./resources-xml/employee.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			JAXP_SAX_EmployeeHandler handler = new JAXP_SAX_EmployeeHandler();
			saxParser.parse(file, handler);
			List<Employee> empList = handler.getEmpList();
	        //print employee information
	        for(Employee emp : empList)
	        	System.out.println(emp);
		}
		catch(ParserConfigurationException e){
			e.printStackTrace();
		}
		catch(SAXException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
