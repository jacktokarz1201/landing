package com.ms3.landing.tickets;

import java.util.List;

public class RequestTypeList {
	private List<RequestType> requestTypes;

	public RequestTypeList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestTypeList(List<RequestType> requestTypes) {
		super();
		this.requestTypes = requestTypes;
	}

	public List<RequestType> getRequestTypes() {
		return requestTypes;
	}

	public void setRequestTypes(List<RequestType> requestTypes) {
		this.requestTypes = requestTypes;
	}

	@Override
	public String toString() {
		return "RequestTypeList [requestTypes=" + requestTypes + "]";
	}
}
