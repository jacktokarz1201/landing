package com.ms3.landing.tickets;

import java.util.List;

public class AttachmentList {
	private List<Attachment> attachments;

	public AttachmentList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttachmentList(List<Attachment> attachments) {
		super();
		this.attachments = attachments;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "AttachmentList [attachment=" + attachments + "]";
	}
}
