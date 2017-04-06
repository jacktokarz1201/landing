package com.ms3.landing.tickets;

public class TroubleTicketUsers {

	private long id;
	private String screenName;
	private String fullName;
	private String serviceDeskId;

	public TroubleTicketUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TroubleTicketUsers(long id, String screenName, String fullName,
			String serviceDeskId) {
		super();
		this.id = id;
		this.screenName = screenName;
		this.fullName = fullName;
		this.serviceDeskId = serviceDeskId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getServiceDeskId() {
		return serviceDeskId;
	}

	public void setServiceDeskId(String serviceDeskId) {
		this.serviceDeskId = serviceDeskId;
	}

	@Override
	public String toString() {
		return "TroubleTicketUsers [id=" + id + ", screenName=" + screenName
				+ ", fullName=" + fullName + ", serviceDeskId=" + serviceDeskId
				+ "]";
	}
}
