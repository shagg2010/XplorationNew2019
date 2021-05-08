package com.saurabh.dada.iq.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.saurabh.dada.iq.impl.xml.obj.Customer;
import com.saurabh.dada.iq.impl.xml.obj.CustomerMap;

public class JAXB {

	public static void main(String[] args) {
		
		try{
			List<Customer> customerList = new ArrayList<Customer>();
			Customer[] customers = {new Customer(10, "Saurabh" ,28), new Customer(26, "Priyanka", 28), new Customer(-1, "XYZ")};
			for(Customer cust:customers){
				customerList.add(cust);
			}
			CustomerMap customerMap = new CustomerMap();
			customerMap.setCustomerList(customerList);
			customerMap.setCompany("Samsung");
			
			File file = new File("./resources-xml/customers.xml");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(CustomerMap.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(customerMap, file);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			CustomerMap map = (CustomerMap)jaxbUnmarshaller.unmarshal(file);
			System.out.println("Company: " + map.getCompany());
			List<Customer> customerz = map.getCustomerList();
			Iterator<Customer> it = customerz.iterator();
			while(it.hasNext()){
				Customer c = it.next();
				System.out.println(c.getId() + ", " + c.getName() + ", " + c.getAge());
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
