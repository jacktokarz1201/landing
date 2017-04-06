package com.ms3.landing.tickets;

public class RequestType {
	private String serviceDeskID;
	private String requestTypeID;
	private String requestsTypeName;
	private String requestTypeDescription;

	public RequestType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestType(String serviceDeskID, String requestTypeID,
			String requestsTypeName, String requestTypeDescription) {
		super();
		this.serviceDeskID = serviceDeskID;
		this.requestTypeID = requestTypeID;
		this.requestsTypeName = requestsTypeName;
		this.requestTypeDescription = requestTypeDescription;
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

	public String getRequestTypeID() {
		try {
			if (requestTypeID.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return requestTypeID;
	}

	public void setRequestTypeID(String requestTypeID) {
		this.requestTypeID = requestTypeID;
	}

	public String getRequestsTypeName() {
		try {
			if (requestsTypeName.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return requestsTypeName;
	}

	public void setRequestsTypeName(String requestsTypeName) {
		this.requestsTypeName = requestsTypeName;
	}

	public String getRequestTypeDescription() {
		try {
			if (requestTypeDescription.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return requestTypeDescription;
	}

	public void setRequestTypeDescription(String requestTypeDescription) {
		this.requestTypeDescription = requestTypeDescription;
	}

	@Override
	public String toString() {
		return "RequestType [serviceDeskID=" + serviceDeskID
				+ ", requestTypeID=" + requestTypeID + ", requestsTypeName="
				+ requestsTypeName + ", requestTypeDescription="
				+ requestTypeDescription + "]";
	}

}
