<%@include file="/html/init.jsp" %>

<%
String selectedUser="";
String ticketStatusEndPoint = portletPreferences.getValue("ticketStatusEndPoint", StringPool.BLANK);
String ticketListEndPoint = portletPreferences.getValue("ticketListEndPoint", StringPool.BLANK);
String newTicketEndPoint = portletPreferences.getValue("newTicketEndPoint", StringPool.BLANK);
String newCommentEndPoint = portletPreferences.getValue("newCommentEndPoint", StringPool.BLANK);

String getCommentsEndPoint = portletPreferences.getValue("getCommentsEndPoint", StringPool.BLANK);
String getTicketDetailsEndPoint = portletPreferences.getValue("getTicketDetailsEndPoint", StringPool.BLANK);
String requestTypeEndPoint = portletPreferences.getValue("requestTypeEndPoint", StringPool.BLANK);
String serviceDeskEndPoint = portletPreferences.getValue("serviceDeskEndPoint", StringPool.BLANK);

String getAttachmentEndPoint = portletPreferences.getValue("getAttachmentEndPoint", StringPool.BLANK);
String getAttachmentsByTicketIDEndPoint = portletPreferences.getValue("getAttachmentsByTicketIDEndPoint", StringPool.BLANK);
String attachFileEndPoint = portletPreferences.getValue("attachFileEndPoint", StringPool.BLANK);

String editTicketEndPoint = portletPreferences.getValue("editTicketEndPoint", StringPool.BLANK);
String deleteAttachmentEndPoint = portletPreferences.getValue("deleteAttachmentEndPoint", StringPool.BLANK);

String customerParentOrganizationId = portletPreferences.getValue("customerParentOrganizationId", StringPool.BLANK);
String opsSupportOrganizationId = portletPreferences.getValue("opsSupportOrganizationId", StringPool.BLANK);

	List<Organization> companyOrganizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Organization> customers = (List<Organization>)request.getAttribute("customers");
%>

<liferay-portlet:actionURL var="configurationURL" portletConfiguration="true" />
<liferay-ui:success key="config-stored" message="Configuration Saved Successfully. Please refresh the page for updates to take effect." />
<liferay-ui:success key="user-assigned" message="Successfully assigned user. Please refresh the page for updates to take effect." />
<liferay-ui:success key="usergroup-assigned" message="Successfully assigned usergroup. Please refresh the page for updates to take effect. " />
<liferay-ui:error key="error" message="User assignment failed." />


<aui:row> <%-- start of main row --%>	
	<aui:col span="12"> <%-- API Endpoints column --%>
	<aui:form action="<%=configurationURL%>" name="fm">
		<aui:row>
			<aui:col span="6">
				<h3>API EndPoints</h3>
					<aui:fieldset>
					
						<aui:input label="Ticket Status API EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/ticketStatus</small>" id="ticketStatusEndPoint" style="width:70%" name="ticketStatusEndPoint" value="<%=ticketStatusEndPoint%>" type="text">
						</aui:input>
				
						<aui:input label="Ticket List API EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/ticketList</small>" id="ticketListEndPoint" style="width:70%" name="ticketListEndPoint" value="<%=ticketListEndPoint%>" type="text">
						</aui:input>
				
						<aui:input label="New Ticket API EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/newTicket</small>" id="newTicketEndPoint" style="width:70%" name="newTicketEndPoint" value="<%=newTicketEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="New Comment API EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/newComment</small>" id="newCommentEndPoint" style="width:70%" name="newCommentEndPoint" value="<%=newCommentEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="Get Comments API EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/comments/</small>" id="getCommentsEndPoint" style="width:70%" name="getCommentsEndPoint" value="<%=getCommentsEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="Get Ticket Details API EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/ticketDetails/</small>" id="getTicketDetailsEndPoint" style="width:70%" name="getTicketDetailsEndPoint" value="<%=getTicketDetailsEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="Request Type API EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/requestTypes/</small>" id="requestTypeEndPoint" style="width:70%" name="requestTypeEndPoint" value="<%=requestTypeEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="Service Desk API EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/serviceDesks</small>" id="serviceDeskEndPoint" style="width:70%" name="serviceDeskEndPoint" value="<%=serviceDeskEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="Get Attachment EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/attachment/</small>" id="getAttachmentEndPoint" style="width:70%" name="getAttachmentEndPoint" value="<%=getAttachmentEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="Get Attachments EndPoint by Ticket ID<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/getAttachmentsByTicketId/</small>" id="getAttachmentsByTicketIDEndPoint" style="width:70%" name="getAttachmentsByTicketIDEndPoint" value="<%=getAttachmentsByTicketIDEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="Attach File EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/attachFile/</small>" id="attachFileEndPoint" style="width:70%" name="attachFileEndPoint" value="<%=attachFileEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="Edit Ticket EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/editTicket/</small>" id="editTicketEndPoint" style="width:70%" name="editTicketEndPoint" value="<%=editTicketEndPoint%>" type="text">
						</aui:input>
						
						<aui:input label="Delete Attachment EndPoint<br><small>Example: http://52.201.204.44:8081/trouble-ticket-api/deleteAttachment/</small>" id="deleteAttachmentEndPoint" style="width:70%" name="deleteAttachmentEndPoint" value="<%=deleteAttachmentEndPoint%>" type="text">
						</aui:input>
						
						
						
		<aui:input label="Important Organization Name" name="parentOrgName" ></aui:input>
						
						<aui:button-row>
							<aui:button type="submit" value="Save"></aui:button>
						</aui:button-row>
						
					</aui:fieldset> <%-- basig apil sa form --%>
			</aui:col>
		</aui:row>
	</aui:form>
	</aui:col>
</aui:row>