package com.ms3.landing.tickets;

import java.util.List;

public class ServiceDeskList {
	private List<ServiceDesk> serviceDesks;

	public ServiceDeskList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceDeskList(List<ServiceDesk> serviceDesks) {
		super();
		this.serviceDesks = serviceDesks;
	}

	public List<ServiceDesk> getServiceDesks() {
		return serviceDesks;
	}

	public void setServiceDesks(List<ServiceDesk> serviceDesks) {
		this.serviceDesks = serviceDesks;
	}

	@Override
	public String toString() {
		return "ServiceDeskList [serviceDesks=" + serviceDesks + "]";
	}
   
}
