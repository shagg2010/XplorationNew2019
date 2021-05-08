package com.saurabh.java.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JavaDomParser {

	public static void main(String[] args) {
		
		File file = new File("./resources/domMyProduct.xml");
		try{
			if(file.exists()){
				DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
				DocumentBuilder dB = dBF.newDocumentBuilder();
				Document document = dB.parse(file);
				document.getDocumentElement().normalize();
				System.out.println("Root: "+ document.getDocumentElement().getNodeName() + "\n");
				NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getNodeName());
				for(int i=0;i<nodeList.getLength();i++){
					Node node = nodeList.item(i);
					if(node.getNodeType() == Node.ELEMENT_NODE){
						Element productElement = (Element) node;
						NodeList productIdList = productElement
						.getElementsByTagName("ProductId");
						Element productIdElement = (Element) productIdList.item(0);
						NodeList productId = productIdElement.getChildNodes();
						System.out.println("Product ID : "
						+ ((Node) productId.item(0)).getNodeValue());
					}
				}
			}
			else{
				System.out.println("File does not exists: " + file.getAbsolutePath());
			}
		}
		catch(ParserConfigurationException e){
			e.printStackTrace();
		}
		catch(SAXException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		

	}

}
