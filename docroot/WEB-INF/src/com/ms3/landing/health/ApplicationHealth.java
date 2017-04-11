package com.ms3.landing.health;

import java.util.List;

public class ApplicationHealth {
	
	int clientId;
	int applicationId;
	String lastPollTime;
	List<Resources> resources;
	List<Integrations> integrations;
	
	public ApplicationHealth() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationHealth(int clientId, int applicationId,
			String lastPollTime, List<Resources> resources,
			List<Integrations> integrations) {
		super();
		this.clientId = clientId;
		this.applicationId = applicationId;
		this.lastPollTime = lastPollTime;
		this.resources = resources;
		this.integrations = integrations;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getLast_poll_time() {
		return lastPollTime;
	}

	public void setLast_poll_time(String lastPollTime) {
		this.lastPollTime = lastPollTime;
	}

	public List<Resources> getResources() {
		return resources;
	}

	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}

	public List<Integrations> getIntegrations() {
		return integrations;
	}

	public void setIntegrations(List<Integrations> integrations) {
		this.integrations = integrations;
	}

	@Override
	public String toString() {
		return "ApplicationHealth [clientId=" + clientId + ", applicationId="
				+ applicationId + ", lastPollTime=" + lastPollTime
				+ ", resources=" + resources + ", integrations=" + integrations
				+ "]";
	}

	
	
}
