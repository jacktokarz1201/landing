<%@page import="com.ms3.landing.service.service.AnnouncementLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>


<portlet:actionURL var="addAnnouncement">
   <portlet:param name="action" value="addAnnouncement" />
</portlet:actionURL>


<%
	PortletServices portletServices = new PortletServices();
	List<Organization> customers = portletServices.getCustomers(renderRequest);
	User user = themeDisplay.getUser();
	String openTickets = (String)renderRequest.getAttribute("openTickets");
	String customerOrgId = (String)prefs.getValue("customerOrgId", "");
	String customerParentOrganizationId = prefs.getValue("customerParentOrganizationId", "");
	List<Announcement> announcements = AnnouncementLocalServiceUtil.getAnnouncements(0, AnnouncementLocalServiceUtil.getAnnouncementsCount());
	List<Announcement> yourAnnouncements = new ArrayList<Announcement>();
	for(Announcement announcement: announcements) {
		if(announcement.getAuthor().equals(customerOrgId) || announcement.getAuthor().equals("Everybody")) {
			yourAnnouncements.add(announcement);
		}
	}
%>

<div>Welcome <%= user.getFullName() %> of Organization <%= customerOrgId %></div>

<div>Logo!</div>

<div>Contract Summary</div>

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
<div class="tableTitle">Tickets</div>
<table>
	<thead>
		<tr>
			<th>Title</th>
			<th>Ticket</th>
		</tr>
	</thead>
	<tbody>
<%
//	for(Annoucement announcement: announcements) {
%>
		<tr>
			<td>Example Ticket</td>
			<td>This is an example that you are reading. Really, you don't need to keep reading this. You can stop anytime.</td>
		</tr>
<%
//	}
%> 
	</tbody>
</table>

<div>Open tickets: <%= openTickets %></div>

</div>

<div>Health Check</div>

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
