package com.ms3.landing.tickets;

public class NewComment {
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
	private String jsd_comment;
	private boolean jsd_comment_public_visible;

	public NewComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewComment(String jsd_ticketID, String currentStatus,
			String actionType, String uid, String serviceDeskID,
			String jsd_requestType, String support_short_description,
			String support_synopsis, String customerUserName,
			String customerEmail, String customerPhone, String jsd_comment,
			boolean jsd_comment_public_visible) {
		super();
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
		this.jsd_comment = jsd_comment;
		this.jsd_comment_public_visible = jsd_comment_public_visible;
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
		try {
			if (actionType.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getUid() {
		try {
			if (uid.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public String getJsd_requestType() {
		try {
			if (jsd_requestType.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return jsd_requestType;
	}

	public void setJsd_requestType(String jsd_requestType) {
		this.jsd_requestType = jsd_requestType;
	}

	public String getSupport_short_description() {
		try {
			if (support_short_description.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return support_short_description;
	}

	public void setSupport_short_description(String support_short_description) {
		this.support_short_description = support_short_description;
	}

	public String getSupport_synopsis() {
		try {
			if (support_synopsis.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return support_synopsis;
	}

	public void setSupport_synopsis(String support_synopsis) {
		this.support_synopsis = support_synopsis;
	}

	public String getCustomerUserName() {
		try {
			if (customerUserName.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getCustomerEmail() {
		try {
			if (customerEmail.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		try {
			if (customerPhone.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getJsd_comment() {
		try {
			if (jsd_comment.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
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

	@Override
	public String toString() {
		return "Comment [jsd_ticketID=" + jsd_ticketID + ", currentStatus="
				+ currentStatus + ", actionType=" + actionType + ", uid=" + uid
				+ ", serviceDeskID=" + serviceDeskID + ", jsd_requestType="
				+ jsd_requestType + ", support_short_description="
				+ support_short_description + ", support_synopsis="
				+ support_synopsis + ", customerUserName=" + customerUserName
				+ ", customerEmail=" + customerEmail + ", customerPhone="
				+ customerPhone + ", jsd_comment=" + jsd_comment
				+ ", jsd_comment_public_visible=" + jsd_comment_public_visible
				+ "]";
	}

	
}
