package com.saurabh.dada.iq.impl.ws.soap;

import javax.xml.ws.Endpoint;

import com.saurabh.dada.iq.impl.ws.rpc.HelloWorldImpl;

public class HelloWorldPublisher1 {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
		Endpoint e = Endpoint.publish("http://localhost:9999/ws/hello1", new HelloWorld1Impl());
		//System.out.println("Props: "+e.getImplementor());
	}

}
