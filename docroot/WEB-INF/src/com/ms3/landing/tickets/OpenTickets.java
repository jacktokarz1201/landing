package com.ms3.landing.tickets;

public class OpenTickets {
	private boolean authorized;
	private String jsd_ticketID;
	private String currentStatus;
	private String actionType;
	private String uid;
	private String serviceDeskID;
	private String jsd_requestType;
	private String support_short_description;
	private String support_synopsis;
	private String customerUserName;
	private String customerEmail;
	private String customerPhone;
	private String priority;
	private String jsd_comment;
	private boolean jsd_comment_public_visible;
	private String severity;
	private String createdDate;

	public OpenTickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpenTickets(boolean authorized, String jsd_ticketID,
			String currentStatus, String actionType, String uid,
			String serviceDeskID, String jsd_requestType,
			String support_short_description, String support_synopsis,
			String customerUserName, String customerEmail,
			String customerPhone, String priority, String jsd_comment,
			boolean jsd_comment_public_visible, String severity,
			String createdDate) {
		super();
		this.authorized = authorized;
		this.jsd_ticketID = jsd_ticketID;
		this.currentStatus = currentStatus;
		this.actionType = actionType;
		this.uid = uid;
		this.serviceDeskID = serviceDeskID;
		this.jsd_requestType = jsd_requestType;
		this.support_short_description = support_short_description;
		this.support_synopsis = support_synopsis;
		this.customerUserName = customerUserName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.priority = priority;
		this.jsd_comment = jsd_comment;
		this.jsd_comment_public_visible = jsd_comment_public_visible;
		this.severity = severity;
		this.createdDate = createdDate;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public String getJsd_ticketID() {
		return jsd_ticketID;
	}

	public void setJsd_ticketID(String jsd_ticketID) {
		this.jsd_ticketID = jsd_ticketID;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getServiceDeskID() {
		return serviceDeskID;
	}

	public void setServiceDeskID(String serviceDeskID) {
		this.serviceDeskID = serviceDeskID;
	}

	public String getJsd_requestType() {
		return jsd_requestType;
	}

	public void setJsd_requestType(String jsd_requestType) {
		this.jsd_requestType = jsd_requestType;
	}

	public String getSupport_short_description() {
		return support_short_description;
	}

	public void setSupport_short_description(String support_short_description) {
		this.support_short_description = support_short_description;
	}

	public String getSupport_synopsis() {
		return support_synopsis;
	}

	public void setSupport_synopsis(String support_synopsis) {
		this.support_synopsis = support_synopsis;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getJsd_comment() {
		return jsd_comment;
	}

	public void setJsd_comment(String jsd_comment) {
		this.jsd_comment = jsd_comment;
	}

	public boolean isJsd_comment_public_visible() {
		return jsd_comment_public_visible;
	}

	public void setJsd_comment_public_visible(boolean jsd_comment_public_visible) {
		this.jsd_comment_public_visible = jsd_comment_public_visible;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "OpenTickets [authorized=" + authorized + ", jsd_ticketID="
				+ jsd_ticketID + ", currentStatus=" + currentStatus
				+ ", actionType=" + actionType + ", uid=" + uid
				+ ", serviceDeskID=" + serviceDeskID + ", jsd_requestType="
				+ jsd_requestType + ", support_short_description="
				+ support_short_description + ", support_synopsis="
				+ support_synopsis + ", customerUserName=" + customerUserName
				+ ", customerEmail=" + customerEmail + ", customerPhone="
				+ customerPhone + ", priority=" + priority + ", jsd_comment="
				+ jsd_comment + ", jsd_comment_public_visible="
				+ jsd_comment_public_visible + ", severity=" + severity
				+ ", createdDate=" + createdDate + "]";
	}

	

}