package com.saurabh.dada.iq.impl.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL)
public interface IHelloWorld1 {
	
	@WebMethod
	 public String sayHello(String name);

}
