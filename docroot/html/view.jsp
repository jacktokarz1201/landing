<%@include file="/html/init.jsp" %>


<portlet:actionURL var="addAnnouncement">
   <portlet:param name="action" value="addAnnouncement" />
</portlet:actionURL>

<%
	User user = themeDisplay.getUser();
	String openTickets = (String)renderRequest.getAttribute("openTickets");

%>

<div>Welcome <%= user.getFullName() %></div>

<div>Logo!</div>

<div>Contract Summary</div>

<div class="tableHolder">
<div class="tableTitle">News and Announcements</div>
<table>
	<thead>
		<tr>
			<th>Title</th>
			<th>Content</th>
		</tr>
	</thead>
	<tbody>
<%
//	for(Annoucement announcement: announcements) {
%>
		<tr>
			<td>Example Title</td>
			<td>This is an example that you are reading. Really, you don't need to keep reading this. You can stop anytime.</td>
		</tr>
<%
//	}
%> 
	</tbody>
</table>

<div id = "makeAnnouncementDialog" title = "Announcement Creation">
	<aui:form cssClass="inputForm" name="addAnnouncement" action="<%=addAnnouncement%>">
		<aui:input cssClass="normalInput" name="title" label="Title" type="text"/>
		<aui:input class="normalInput" name="content" label="Content" type="textarea"/>
		<aui:input name="provider" label="Provider" type="text"/>
		<aui:input name="listPrice" label="List Price" type="text"/>
		
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
