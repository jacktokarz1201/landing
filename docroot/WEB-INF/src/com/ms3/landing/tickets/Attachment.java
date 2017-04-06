package com.ms3.landing.tickets;

public class Attachment {
	private String id;
	private String filename;
	private String created;
	private long size;
	private String mimeType;
	private String content;
	private String thumbnail;

	public Attachment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attachment(String id, String filename, String created, long size,
			String mimeType, String content, String thumbnail) {
		super();
		this.id = id;
		this.filename = filename;
		this.created = created;
		this.size = size;
		this.mimeType = mimeType;
		this.content = content;
		this.thumbnail = thumbnail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "Attachment [id=" + id + ", filename=" + filename + ", created="
				+ created + ", size=" + size + ", mimeType=" + mimeType
				+ ", content=" + content + ", thumbnail=" + thumbnail + "]";
	}

}
