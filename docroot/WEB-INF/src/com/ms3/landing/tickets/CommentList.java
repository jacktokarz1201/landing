package com.ms3.landing.tickets;

import java.util.List;

public class CommentList {
	private List<Comment> comments;

	public CommentList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentList(List<Comment> comments) {
		super();
		this.comments = comments;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "CommentList [comments=" + comments + "]";
	}

	
}
