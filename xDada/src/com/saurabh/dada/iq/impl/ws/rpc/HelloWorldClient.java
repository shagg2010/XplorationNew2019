package com.saurabh.dada.iq.impl.ws.rpc;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Once you create the webservice, start the endpoint by running HelloWorldPublisher
 * and then run 
 * 		D:\workbench\workspace\Hibernate_v3_5\Webservice1-JAX-WS-RPC\src>wsimport -s . http://localhost:9999/ws/hello?wsdl
 * and stubs will be created for you.
 * Then code the client as shown below-
 * 
 */

public class HelloWorldClient {

	public static void main(String[] args) {

		try{
			
			//this kind of ws-invocation requires proxy/stub classes
			HelloWorldImplService helloService = new HelloWorldImplService();
			IHelloWorld hello = helloService.getHelloWorldImplPort();
	 
			System.out.println(hello.sayHello("Priyanka"));
			
			
			//or you can do this as well which does not require any proxy/stub classes to be generated
			
			URL url = new URL("http://localhost:9999/ws/hello?wsdl");
			//1st argument service URI, refer to wsdl document above
			//2nd argument is service name, refer to wsdl document above
		    QName qname = new QName("http://rpc.ws.impl.iq.dada.saurabh.com/", "HelloWorldImplService");
		    
		    Service service = Service.create(url, qname);
		    
	        IHelloWorld hello1 = service.getPort(IHelloWorld.class);
	        System.out.println(hello1.getClass());
	        System.out.println(hello1.sayHello("Saurabh"));
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
