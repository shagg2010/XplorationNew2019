package com.saurabh.dada.iq.impl.designpatterns.servicelocator;

public class Service1 implements Service {
	
	private static volatile Service1 service1;
	
	private Service1(){
		//
	}
	
	public void execute() {
		System.out.println("Executing Service1");
	}

	@Override
	public String getName() {
		return "Service1";
	}
	
	public static Service1 getInstance() {
        if (service1 == null) { // first time lock
            synchronized (Service1.class) {
                if (service1 == null) {  // second time lock
                	service1 = new Service1();
                }
            }
        }
        return service1;
    }
}
