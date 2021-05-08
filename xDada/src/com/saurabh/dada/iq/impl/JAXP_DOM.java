package com.saurabh.dada.iq.impl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JAXP_DOM {

	public static void main(String[] args) {
		
		try{
			File file = new File("./resources-xml/employee.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(file);
			
			document.getDocumentElement().normalize();
			System.out.println("Root element :" + document.getDocumentElement().getNodeName());
			
			NodeList nodeList = document.getElementsByTagName("Employee");
			 
			System.out.println("----------------------------");
			for (int temp = 0; temp < nodeList.getLength(); temp++) {
				Node node = nodeList.item(temp);
				//System.out.println("\nCurrent Element :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.print("Id : " + element.getAttribute("id"));
					System.out.print("\tName : " + element.getElementsByTagName("name").item(0).getTextContent());
					System.out.print("\tAge : " + element.getElementsByTagName("age").item(0).getTextContent());
					System.out.print("\tGender : " + element.getElementsByTagName("gender").item(0).getTextContent());
					System.out.println("\tRole : " + element.getElementsByTagName("role").item(0).getTextContent());
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
