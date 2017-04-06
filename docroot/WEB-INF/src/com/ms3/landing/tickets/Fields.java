package com.ms3.landing.tickets;

public class Fields {
	private String summary;
	private String description;
	private Priority priority;

	public Fields() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fields(String summary, String description, Priority priority) {
		super();
		this.summary = summary;
		this.description = description;
		this.priority = priority;
	}

	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Priority getPriority() {
		return priority;
	}



	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Fields [summary=" + summary + ", description=" + description
				+ ", priority=" + priority + "]";
	}

	public class Priority{
		String name;

		public Priority() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Priority(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Priority [name=" + name + "]";
		}
	}
}


