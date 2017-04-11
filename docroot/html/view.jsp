<%@include file="/html/init.jsp" %>


<portlet:actionURL var="addAnnouncement">
   <portlet:param name="action" value="addAnnouncement" />
</portlet:actionURL>


<%


//String serviceDeskID = prefs.getValue("serviceDeskID", "");
String serviceDeskID = "4";

	PortletServices portletServices = new PortletServices();
	List<Organization> customers = portletServices.getCustomers(renderRequest);
	User user = themeDisplay.getUser();
	String customerOrgId = (String)prefs.getValue("customerOrgId", "");
	String customerParentOrganizationId = prefs.getValue("customerParentOrganizationId", "");
	
	//announcement stuff
	List<Announcement> announcements = AnnouncementLocalServiceUtil.getAnnouncements(0, AnnouncementLocalServiceUtil.getAnnouncementsCount());
	List<Announcement> yourAnnouncements = new ArrayList<Announcement>();
	for(Announcement announcement: announcements) {
		if(announcement.getAuthor().equals(customerOrgId) || announcement.getAuthor().equals("Everybody")) {
			yourAnnouncements.add(announcement);
		}
	}
	
%>

<div>Welcome <%= user.getFullName() %> of Organization <%= customerOrgId %> looking at tickets for desk <%= serviceDeskID %></div>

<div>
<h3>Logo!</h3>
</div>

<div>
<h3>Contract Summary</h3>
</div>

<div class="tableHolder">
<div class="tableTitle">News and Announcements</div>
<table>
	<thead>
		<tr>
			<th>Title</th>
			<th>Content</th>
			<th>Date</th>
			<th>Author</th>
		</tr>
	</thead>
	<tbody>
<%
	for(Announcement announcement: yourAnnouncements) {
%>
		<tr>
			<td><%= announcement.getTitle() %></td>
			<td><%= announcement.getContent() %></td>
			<td><%= announcement.getSetDate() %></td>
			<td><%= announcement.getAuthor() %></td>
		</tr>
<%
	}
%> 
	</tbody>
</table>

<div id = "makeAnnouncementDialog" title = "Announcement Creation">
	<aui:form cssClass="inputForm" name="addAnnouncement" action="<%=addAnnouncement%>">
		<aui:input cssClass="normalInput" name="title" label="Title" type="text"/>
		<aui:input class="normalInput" name="content" label="Content" type="textarea"/>
		
		<input id="submitAnnouncement" type="submit" value="Create"/>
	</aui:form>
	
</div>

<button id = "opener">Make Announcement</button>

</div>


<div class="tableHolder">
<div class="tableTitle">Tickets - Remember to setup serviceDeskId!</div>
<table>
	<thead>
		<tr>
			<th>Customer Username</th>
			<th>Short Description</th>
			<th>Created Date</th>
			<th>Current Status</th>
		</tr>
	</thead>
	<tbody>
<%
//ticket stuff
RestServices restService = new RestServices(prefs.getValue("ticketListEndPoint", ""));
List<OpenTickets> openTickets = null;
openTickets= restService.getTicketList(serviceDeskID);

TicketStatus searchedTicket = new TicketStatus();

List<Comment> ticketComments = new ArrayList<Comment>();
List<Attachment> ticketAttachments = new ArrayList<Attachment>();

OpenTickets selectedOpenTicket = null;
String formattedDate = "";
String ticketStatus = "";

for(OpenTickets ticket: openTickets){
	String ticketNo = ticket.getJsd_ticketID();
	if(!ticketNo.isEmpty()){
		try {
			selectedOpenTicket = ticket;
			restService = new RestServices(prefs.getValue("getTicketDetailsEndPoint", StringPool.BLANK));
			selectedOpenTicket = restService.getTicketDetails(ticketNo); 
			
			restService = new RestServices(prefs.getValue("getCommentsEndPoint", StringPool.BLANK));
			ticketComments = restService.getComments(ticketNo);
			
			restService = new RestServices(prefs.getValue("getAttachmentsByTicketIDEndPoint", StringPool.BLANK));
			ticketAttachments = restService.getAttachments(ticketNo);
			
			restService = new RestServices(prefs.getValue("ticketStatusEndPoint", StringPool.BLANK));
			searchedTicket = restService.getTicketStatus(ticketNo.toLowerCase().toUpperCase());
%>
			<tr>
				<td><%= ticket.getCustomerUserName() %></td>
				<td><%= ticket.getSupport_short_description() %></td>
				<td><%= ticket.getCreatedDate() %></td>
				<td><%= ticket.getCurrentStatus() %></td>
			</tr>			
<%
	/*
			System.out.println("Details: "+selectedOpenTicket.toString());
			System.out.println("Comments: "+ticketComments.toString());
			System.out.println("Attachments: "+ticketAttachments.toString());
			System.out.println("Status: "+searchedTicket.toString());

			System.out.println("===========================================");
	*/
		} catch(Exception e){
			e.printStackTrace();
		}
	}						
}
%>
 
	</tbody>
</table>

<!--  
<div>Open tickets: <%= openTickets.toString() %></div>
-->

</div>

<div>

<%

String healthCheckApiEndpoint = prefs.getValue("healthCheckApiEndpoint", "");
String applicationId = prefs.getValue("applicationId", "");
//not sure how that's supposed to work...
//String applicationId = renderRequest.getParameter("applicationId");

if(!healthCheckApiEndpoint.isEmpty()) {
		System.out.println("checking health of application..."+applicationId);
	try{
		restService = new RestServices(healthCheckApiEndpoint);
		
		ApplicationHealth healthResult = restService.checkHealth(applicationId);
		
		//System.out.println(healthResult.toString()+"\n*********************************************");

%>

<div class="tableHolder">
<div class="tableTitle">Health Check - Remember to setup applicationId!</div>
<table>
	<thead>
		<tr>
			<th>Client ID</th>
			<th>Last Poll Time</th>
<%
			for(Resources resource: healthResult.getResources()) {
%>
			<th><%= resource.getType() %> Status</th>
<%
			}
			
			for(Integrations integration: healthResult.getIntegrations()) {
%>
				<th><%= integration.getName() %></th>
<%
			}
%>
		</tr>
	</thead>

	<tbody>
		<tr>
			<td><%= healthResult.getClientId() %></td>
			<td><%= healthResult.getLast_poll_time() %></td>
<%
			for(Resources resource: healthResult.getResources()) {
%>
			<th><%= resource.getStatus() %></th>
<%
			}
			
			for(Integrations integration: healthResult.getIntegrations()) {
%>
				<th><%= integration.getStatus() %> Status</th>
<%
			}
%>
		</tr>
	</tbody>
</table>



<%
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("api endpoint error.");
	}
}
%>
</div>

<div>
	<h2>This is for a different page, for the Admin</h2>

	<div id = "adminMakeAnnouncementDialog" title = "Announcement Creation">
		<aui:form cssClass="inputForm" name="giveAnnouncement" action="<%=addAnnouncement%>">
			<aui:input cssClass="normalInput" name="title" label="Title" type="text"/>
			<aui:input class="normalInput" name="content" label="Content" type="textarea"/>
			<aui:select name="author" label="Reader(s)">
				<aui:option label="Everybody" value="Everybody"></aui:option>
<%
			if(customers.size()>=1) {				
				for(Organization org: customers) {
%>
					<aui:option label="<%= org.getName() %>" value="<%= org.getOrganizationId() %>" />
<%
				}
			}
%>
			</aui:select>
			<input id="submitAnnouncement" type="submit" value="Create"/>
		</aui:form>
		
	</div>


<button id="adminMakeAnnouncementOpener">Give Announcement</button>

</div>
