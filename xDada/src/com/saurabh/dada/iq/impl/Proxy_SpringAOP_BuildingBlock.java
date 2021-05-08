package com.saurabh.dada.iq.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy_SpringAOP_BuildingBlock {

	public static void main(String[] args) {
		
		BasicClass basicClass = new BasicClass();
		basicClass.basicMethod();
		
		//AOP way
		BasicInterface basicClassProxy = (BasicInterface) Proxy.newProxyInstance(Proxy_SpringAOP_BuildingBlock.class.getClassLoader(), 
						basicClass.getClass().getInterfaces(), new BasicInvocationHandler(basicClass));
		
		
		basicClassProxy.basicMethod();

	}

}

interface BasicInterface{
	 public void basicMethod();       
}

class BasicClass implements BasicInterface{

	private String data="Hello, World!";
	@Override
	public void basicMethod() {
		System.out.println(data+" - Implemented BasicMethod!");		
	}
}
class BasicInvocationHandler implements InvocationHandler{
	
	private Object target;
	
	public BasicInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = method.invoke(target, args);
		return result;
	}
	
	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	
}