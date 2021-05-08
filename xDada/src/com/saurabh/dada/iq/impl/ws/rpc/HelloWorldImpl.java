package com.saurabh.dada.iq.impl.ws.rpc;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="com.saurabh.dada.iq.impl.ws.rpc.IHelloWorld")
public class HelloWorldImpl implements IHelloWorld {

	@Override
	@WebMethod
	public String sayHello(String name) {
		return "Hi, " + name + "!";
	}

}
