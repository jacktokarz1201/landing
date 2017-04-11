package com.ms3.landing.health;

public class Resources {

	String type;
	String status;
	
	public Resources() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resources(String type, String status) {
		super();
		this.type = type;
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Resources [type=" + type + ", status=" + status + "]";
	}
	
	
}
