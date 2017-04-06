package com.ms3.landing.tickets;

import java.util.List;

public class TicketList
{
    private List<OpenTickets> openTickets;

	public TicketList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketList(List<OpenTickets> openTickets) {
		super();
		this.openTickets = openTickets;
	}

	public List<OpenTickets> getOpenTickets() {
		return openTickets;
	}

	public void setOpenTickets(List<OpenTickets> openTickets) {
		this.openTickets = openTickets;
	}

	@Override
	public String toString() {
		return "TicketList [openTickets=" + openTickets + "]";
	}

   
}
