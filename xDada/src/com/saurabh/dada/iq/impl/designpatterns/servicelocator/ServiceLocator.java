package com.saurabh.dada.iq.impl.designpatterns.servicelocator;

public class ServiceLocator {
	private static ServiceCache cache;

	static {
		cache = new ServiceCache();
	}

	public static Service getService(String jndiName) {

		Service service = cache.getService(jndiName);

		if (service != null) {
			return service;
		}

		InitialContext context = new InitialContext();
		Service service1 = (Service) context.lookup(jndiName);
		cache.addService(service1);
		return service1;
	}
}
