package com.ms3.landing.health;

public class ApplicationModel {
	
	String description;
	String api_url;
	boolean api_implemented;
	String status;
	String name;
	long client_id;
	int id;
	
	public ApplicationModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationModel(String description, String api_url,
			boolean api_implemented, String status, String name, long client_id,
			int id) {
		super();
		this.description = description;
		this.api_url = api_url;
		this.api_implemented = api_implemented;
		this.status = status;
		this.name = name;
		this.client_id = client_id;
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApi_url() {
		return api_url;
	}

	public void setApi_url(String api_url) {
		this.api_url = api_url;
	}

	public boolean getApi_implemented() {
		return api_implemented;
	}

	public void setApi_implemented(boolean api_implemented) {
		this.api_implemented = api_implemented;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getClient_id() {
		return client_id;
	}

	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ApplicationModel [description=" + description + ", api_url="
				+ api_url + ", api_implemented=" + api_implemented
				+ ", status=" + status + ", name=" + name + ", client_id="
				+ client_id + ", id=" + id + "]";
	}	
	
}
