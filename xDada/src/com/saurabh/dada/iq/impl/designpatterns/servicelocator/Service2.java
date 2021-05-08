package com.saurabh.dada.iq.impl.designpatterns.servicelocator;

public class Service2 implements Service {
	
	private static volatile Service2 service2;
	
	private Service2(){
		//
	}
	
	public void execute() {
		System.out.println("Executing Service2");
	}

	@Override
	public String getName() {
		return "Service2";
	}
	
	public static Service2 getInstance() {
        if (service2 == null) { // first time lock
            synchronized (Service2.class) {
                if (service2 == null) {  // second time lock
                	service2 = new Service2();
                }
            }
        }
        return service2;
    }
}
