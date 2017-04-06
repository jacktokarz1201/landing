package com.ms3.landing.tickets;

public class Comment {
	private String commentBody;
	private String authorName;
	private String authorEmail;
	private String createdDate;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(String commentBody, String authorName, String authorEmail,
			String createdDate) {
		super();
		this.commentBody = commentBody;
		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.createdDate = createdDate;
	}

	public String getCommentBody() {
		try {
			if (commentBody.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public String getAuthorName() {
		
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		try {
			if (authorEmail.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getCreatedDate() {
		try {
			if (createdDate.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Comment [commentBody=" + commentBody + ", authorName="
				+ authorName + ", authorEmail=" + authorEmail
				+ ", createdDate=" + createdDate + "]";
	}

}
