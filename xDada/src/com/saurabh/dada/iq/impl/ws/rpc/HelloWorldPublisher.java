package com.saurabh.dada.iq.impl.ws.rpc;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {

	public static void main(String[] args) {
		Endpoint ep = Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
		System.out.println("Webservice Published: " + ep.isPublished());
	}

	
}
