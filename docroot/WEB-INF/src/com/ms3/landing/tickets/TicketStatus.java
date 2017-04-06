package com.ms3.landing.tickets;

public class TicketStatus
{
    private String ticketStatusDateTime;
    private String ticketStatus;
    private String ticketNumber;

    public String getTicketStatusDateTime ()
    {
    	try {
			if (ticketStatusDateTime.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
        return ticketStatusDateTime;
    }

    public void setTicketStatusDateTime (String ticketStatusDateTime)
    {
        this.ticketStatusDateTime = ticketStatusDateTime;
    }

    public String getTicketStatus ()
    {
    	try {
			if (ticketStatus.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
		return ticketStatus;
    }

    public void setTicketStatus (String ticketStatus)
    {
        this.ticketStatus = ticketStatus;
    }

    public String getTicketNumber ()
    {
    	try {
			if (ticketNumber.isEmpty()) {
				return "N/A";
			} 
		} catch (NullPointerException e) {
			return "N/A";
		}
        return ticketNumber;
    }

    public void setTicketNumber (String ticketNumber)
    {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString()
    {
        return "TicketStatus [ticketStatusDateTime = "+ticketStatusDateTime+", ticketStatus = "+ticketStatus+", ticketNumber = "+ticketNumber+"]";
    }
}
