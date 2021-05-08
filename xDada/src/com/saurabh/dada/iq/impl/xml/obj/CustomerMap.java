package com.saurabh.dada.iq.impl.xml.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="customers",namespace = "com.saurabh.xml.jaxb.model")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerMap {
	
    private String companyId;
	
	@XmlElementWrapper(name = "customerList")
	@XmlElement(name = "customer")
	private List<Customer> customerList = new ArrayList<Customer>();
	
	@XmlAttribute
	private String company;
 
    public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

}
