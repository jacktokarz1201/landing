package com.ms3.landing.health;

import java.util.List;

public class ApplicationsResultModel {
	
	String clientId;
	List<ApplicationModel> applications;
	
	public ApplicationsResultModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationsResultModel(String clientId,
			List<ApplicationModel> applications) {
		super();
		this.clientId = clientId;
		this.applications = applications;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public List<ApplicationModel> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationModel> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "ApplicationsResultModel [clientId=" + clientId
				+ ", applications=" + applications + "]";
	}
	
}
