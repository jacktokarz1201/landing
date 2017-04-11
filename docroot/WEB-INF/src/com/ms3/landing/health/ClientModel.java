package com.ms3.landing.health;

public class ClientModel {
	
	String description;
	String status;
	long date;
	String name;
	int id;
	
	public ClientModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientModel(String description, String status, long date,
			String name, int id) {
		super();
		this.description = description;
		this.status = status;
		this.date = date;
		this.name = name;
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ClientsResultModel [description=" + description + ", status="
				+ status + ", date=" + date + ", name=" + name + ", id=" + id
				+ "]";
	}
	

}
