package com.saurabh.dada.iq.impl.ws.soap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.saurabh.dada.iq.impl.ws.rpc.IHelloWorld;

/**
 * Once you create the webservice, start the endpoint by running HelloWorldPublisher
 * and the wrapper classes (request/response com.saurabh.jax.ws.soap.jaxws.SayHello and com.saurabh.jax.ws.soap.jaxws.SayHelloResponse) will be automatically created for you.
 * Then code the client as shown below-
 * 
 */

public class HelloWorldClient1 {

	public static void main(String[] args) throws Exception{
		
		URL url = null;
        QName qname = null;

		try{
	
			//Soap style Webservice
			url = new URL("http://localhost:9999/ws/hello1?wsdl");
	        qname = new QName("http://soap.ws.impl.iq.dada.saurabh.com/", "HelloWorld1ImplService");
	 
	        Service service = Service.create(url, qname);
	        IHelloWorld1 hello = service.getPort(IHelloWorld1.class);
	        System.out.println(hello.sayHello("Priyanka"));
	        
	        //RPC style Webservice
	        url = new URL("http://localhost:9999/ws/hello?wsdl");
	        qname = new QName("http://rpc.ws.impl.iq.dada.saurabh.com/", "HelloWorldImplService");
	        service = Service.create(url, qname);
	        IHelloWorld hellos = service.getPort(IHelloWorld.class);
	        System.out.println(hellos.sayHello("Priyanka"));
	        
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
