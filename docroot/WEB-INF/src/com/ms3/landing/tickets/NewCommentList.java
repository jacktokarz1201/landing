package com.ms3.landing.tickets;

import java.util.List;

public class NewCommentList {
	private List<NewComment> comments;

	public NewCommentList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewCommentList(List<NewComment> comments) {
		super();
		this.comments = comments;
	}

	public List<NewComment> getComments() {
		return comments;
	}

	public void setComments(List<NewComment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "NewCommentList [comments=" + comments + "]";
	}

	
}
