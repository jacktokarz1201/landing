package com.ms3.landing.tickets;

public class ServiceDesk {
	private String serviceDeskID;
	private String serviceDeskKeyString;
	private String serviceDeskDescriptionString;

	public ServiceDesk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceDesk(String serviceDeskID, String serviceDeskKeyString,
			String serviceDeskDescriptionString) {
		super();
		this.serviceDeskID = serviceDeskID;
		this.serviceDeskKeyString = serviceDeskKeyString;
		this.serviceDeskDescriptionString = serviceDeskDescriptionString;
	}

	public String getServiceDeskID() {
		try {
			if (serviceDeskID.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return serviceDeskID;
	}

	public void setServiceDeskID(String serviceDeskID) {
		this.serviceDeskID = serviceDeskID;
	}

	public String getServiceDeskKeyString() {
		try {
			if (serviceDeskKeyString.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return serviceDeskKeyString;
	}

	public void setServiceDeskKeyString(String serviceDeskKeyString) {
		this.serviceDeskKeyString = serviceDeskKeyString;
	}

	public String getServiceDeskDescriptionString() {
		try {
			if (serviceDeskDescriptionString.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return serviceDeskDescriptionString;
	}

	public void setServiceDeskDescriptionString(
			String serviceDeskDescriptionString) {
		this.serviceDeskDescriptionString = serviceDeskDescriptionString;
	}

	@Override
	public String toString() {
		return "ServiceDesk [serviceDeskID=" + serviceDeskID
				+ ", serviceDeskKeyString=" + serviceDeskKeyString
				+ ", serviceDeskDescriptionString="
				+ serviceDeskDescriptionString + "]";
	}
}
