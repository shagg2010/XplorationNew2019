package com.saurabh.dada.iq.impl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UpdateXMLfile {
	
	//public static final String ATTR_DOMAIN_DIRECTORY="DOMAIN_DIRECTORY";
	public static final String ATTR_DOMAIN_DIRECTORY= "C:\\workbench\\workspace\\Xploration_CTCI\\xDada";
	public static void main(String[] args) {
		try{
			//if(args!=null&&args.length>1){
				File file = new File("./resources-xml/servers.xml");
				//File file = new File(args[0]);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document document = dBuilder.parse(file);
				
				document.getDocumentElement().normalize();
				//System.out.println("Root element :" + document.getDocumentElement().getNodeName());
				
				NodeList nodeList = document.getElementsByTagName("server");
				boolean updated = false;
				for(int i=0;i<nodeList.getLength();i++){
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						String workspaceLocation = element.getAttribute(ATTR_DOMAIN_DIRECTORY);
						if(workspaceLocation!=null&&workspaceLocation.length()>0){
							element.setAttribute(ATTR_DOMAIN_DIRECTORY, args[1]);
							System.out.println("Old path: " + workspaceLocation + ", New path: " + args[1]);
							updated=true;
						}
					}
				}
				if(updated){
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(document);
					StreamResult result = new StreamResult(new File("servers_updated.xml"));
					transformer.transform(source, result);
					System.out.println("Completed Successfully. Please check 'servers_updated.xml' file.");
				}
				
			/*}
			else{
				System.out.println("Invalid arguments. Please refer to usage details below-");
				System.out.println("Usage: update_ws_path.bat <servers-file-to-updated> <new-workspace-location> ");
			} */
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
