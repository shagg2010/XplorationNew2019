package com.saurabh.dada.iq.impl.designpatterns.servicelocator;

import java.util.ArrayList;
import java.util.List;

public class ServiceCache {

	   private List<Service> services;

	   public ServiceCache(){
	      services = new ArrayList<Service>();
	   }

	   public Service getService(String serviceName){
	   
	      for (Service service : services) {
	         if(service.getName().equalsIgnoreCase(serviceName)){
	            System.out.println("Returning cached  " + serviceName + " object");
	            return service;
	         }
	      }
	      return null;
	   }

	   public void addService(Service newService){
	      boolean exists = false;
	      
	      for (Service service : services) {
	         if(service.getName().equalsIgnoreCase(newService.getName())){
	            exists = true;
	         }
	      }
	      if(!exists){
	         services.add(newService);
	      }
	   }
	}