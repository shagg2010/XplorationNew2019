package com.saurabh.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saurabh.java.spring.interfaces.HelloWorldInterface;

public class SpringMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HelloWorldInterface h1 = (HelloWorldInterface) context.getBean("helloWorldOne");
		HelloWorldInterface h2 = (HelloWorldInterface) context.getBean("helloWorldTwo");
		
		System.out.println(h1.getMessage());
		System.out.println(h2.getMessage());

	}

}
