package com.ms3.landing.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ms3.landing.health.ApplicationHealth;
import com.ms3.landing.service.model.Announcement;
import com.ms3.landing.service.service.AnnouncementLocalServiceUtil;
import com.ms3.landing.services.PortletServices;
import com.ms3.landing.services.RestServices;
import com.ms3.landing.tickets.Attachment;
import com.ms3.landing.tickets.Comment;
import com.ms3.landing.tickets.OpenTickets;
import com.ms3.landing.tickets.RequestType;
import com.ms3.landing.tickets.TicketList;
import com.ms3.landing.tickets.TicketStatus;


@Controller("CustomerLandingController")
@RequestMapping("VIEW")
public class LandingController extends MVCPortlet {
	
	@RenderMapping
	public String processRenderRequest(RenderRequest renderRequest,
			RenderResponse renderResponse, Model model) throws Exception {
		
System.out.println("loading page...");
		
		PortletServices portletServices = new PortletServices();
		RestServices restService;
		RestServices restService2;
		PortletPreferences prefs = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		System.out.println("User is default: "+user.isDefaultUser());
		if(user.isDefaultUser()) {
			prefs.setValue("error", "Log in to access this portlet");
			return "error";
		}
		
		String companyId = Long.toString(user.getCompanyId());
	if(companyId.isEmpty()) {
		System.out.println("no user company id");
		companyId = "20154";
	}
			prefs.setValue("companyId", companyId);
			String customerParentOrganizationId = prefs.getValue("customerParentOrganizationId", "");
	if(customerParentOrganizationId.isEmpty()) {
		System.out.println("no cust parent org id");
		customerParentOrganizationId= "39104";
	}
			prefs.setValue("customerParentOrganizationId", customerParentOrganizationId);
			prefs.store();
			long customerOrgId = portletServices.getClientId(user, 
					OrganizationLocalServiceUtil.getOrganization(Long.parseLong(customerParentOrganizationId)).getName(), renderRequest);					
			
			prefs.setValue("customerOrgId", Long.toString(customerOrgId));
		List<Organization> orgs = OrganizationLocalServiceUtil.getOrganizations(0, OrganizationLocalServiceUtil.getOrganizationsCount());
			Organization customerOrg = OrganizationLocalServiceUtil.getOrganization(customerOrgId);
			renderRequest.setAttribute("customerName", customerOrg.getName());
	//TO EDIT LATER
			String serviceDeskID = "";
			//String ticketNo =  renderRequest.getParameter("jsdticketID");
		//EDIT later
			String selectedStatus = renderRequest.getParameter("selectedStatus");
	serviceDeskID= "2";
	//String ticketNo = "2";
			//serviceDeskID = (String)customerOrg.getExpandoBridge().getAttribute("jiraServiceDeskId");
		prefs.setValue("serviceDeskID", serviceDeskID);
	//EDIT THIS!	
		String applicationId = "1";
		prefs.setValue("applicationId", applicationId);
		
		prefs.store();
		
		
// Health Check stuff!
	/* I moved it all into the view.html because that's where I'll need it anyway.

		String healthCheckApiEndpoint = prefs.getValue("healthCheckApiEndpoint", "");			
		//not sure how that's supposed to work...
		//String applicationId = renderRequest.getParameter("applicationId");
	
if(!healthCheckApiEndpoint.isEmpty()) {
	System.out.println("checking health...");
	try{
		restService = new RestServices(healthCheckApiEndpoint);
		
		ApplicationHealth healthResult = restService.checkHealth(applicationId);
		
		System.out.println(healthResult.toString());
	} catch (Exception e) {
		// TODO Auto-generated catch block			
		renderResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500");
		e.printStackTrace();
		System.out.println("api endpoint error.");
	}
	
}	
	*/
	
//Ticket Stuff!
		try {
		//EDIT LATER
		
			restService = new RestServices(prefs.getValue("ticketListEndPoint", ""));
		System.out.println("Request Type: "+prefs.getValue("requestTypeEndPoint", StringPool.BLANK));
			restService2 = new RestServices(prefs.getValue("requestTypeEndPoint", StringPool.BLANK));
			List<OpenTickets> openTickets = null;
			List<RequestType> requestTypes = null;
			try {
				openTickets = restService.getTicketList(serviceDeskID);
		//System.out.println("Open tickets are: "+openTickets);
				List<OpenTickets> openTicketFilteredByStatus = new ArrayList<OpenTickets>();
				try{
					
					System.out.println("selectedStatus: "+selectedStatus);
					
					if(!selectedStatus.isEmpty() && !selectedStatus.equals("null")){	
						//System.out.println("inside status filtration");
						//System.out.println("selectedStatus is not empty: "+selectedStatus);
						for(OpenTickets ticket: openTickets){
							//System.out.println("ticket.getCurrentStatus(): "+ticket.getCurrentStatus());
							if(ticket.getCurrentStatus().toLowerCase().contains(selectedStatus.toLowerCase())){									
								openTicketFilteredByStatus.add(ticket);
							}
						}
						openTickets = openTicketFilteredByStatus;							
						renderRequest.setAttribute("selectedStatus", selectedStatus);
					}
				}catch(Exception e){}
				//end filter by status
				
				requestTypes = restService2.getRequestTypes(serviceDeskID);
			} catch(Exception e){
				//to EDIT
				System.out.println("Uh-oh, you got caught!");
				//openTickets = new ArrayList<OpenTickets>();
				requestTypes = new ArrayList<RequestType>();
			}
			
			renderRequest.setAttribute("openTickets", openTickets);
			renderRequest.setAttribute("requestTypes", requestTypes);
			renderRequest.setAttribute("serviceDeskID", serviceDeskID);
			
			/*
			TicketStatus searchedTicket = new TicketStatus();
			
			List<Comment> ticketComments = new ArrayList<Comment>();
			List<Attachment> ticketAttachments = new ArrayList<Attachment>();
			
			OpenTickets selectedOpenTicket = null;
			String formattedDate = "";
			String ticketStatus = "";
			try{
				for(OpenTickets ticket: openTickets){
					String ticketNo = openTickets.get(0).getJsd_ticketID();
					if(!ticketNo.isEmpty()){
						if(ticket.getJsd_ticketID().equalsIgnoreCase(ticketNo)){
							selectedOpenTicket = ticket;
							try {
							restService = new RestServices(prefs.getValue("getTicketDetailsEndPoint", StringPool.BLANK));
							selectedOpenTicket = restService.getTicketDetails(ticketNo); // delete
							System.out.println("=====================" + selectedOpenTicket);
							
							restService = new RestServices(prefs.getValue("getCommentsEndPoint", StringPool.BLANK));
							ticketComments = restService.getComments(ticketNo);
							//System.out.println("=====================" + ticketComments);
							
							restService = new RestServices(prefs.getValue("getAttachmentsByTicketIDEndPoint", StringPool.BLANK));
							ticketAttachments = restService.getAttachments(ticketNo);
							//System.out.println("=========ATTACHMENTS============" + ticketAttachments);
							
							restService = new RestServices(prefs.getValue("ticketStatusEndPoint", StringPool.BLANK));
							searchedTicket = restService.getTicketStatus(ticketNo.toLowerCase().toUpperCase());	
							//System.out.println("=====================" + searchedTicket);
							}
							catch(Exception e){
								e.printStackTrace();
							}
							break;
						}						
					}
				
				ticketStatus = searchedTicket.getTicketStatus();
				String ms = searchedTicket.getTicketStatusDateTime();
				Date date = new Date(Long.parseLong(ms));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				formattedDate = sdf.format(date);
				
				renderRequest.setAttribute("ticketStatus", ticketStatus);
				renderRequest.setAttribute("formattedDate", formattedDate);
				renderRequest.setAttribute("ticketSelected", selectedOpenTicket.toString());
				renderRequest.setAttribute("ticketComments", ticketComments.toString());
				renderRequest.setAttribute("ticketAttachments", ticketAttachments.toString());
				
				//SessionMessages.add(renderRequest,PortalUtil.getPortletId(renderRequest)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			}
			
			}catch(Exception e){
				//e.printStackTrace();
				searchedTicket = null;
			}
			*/
	
	renderRequest.setAttribute("ticketAttachmentsEndPoint", prefs.getValue("getAttachmentEndPoint", StringPool.BLANK));
	
	
	
		} catch (NullPointerException e) {
			e.printStackTrace();
			prefs.setValue("error", "This user is not assigned to an Organization.");
			return "error";
			
		} 
	/*
		catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(renderRequest, "error");
			SessionErrors.add(renderRequest, "please-configure");
			SessionMessages.add(renderRequest,PortalUtil.getPortletId(renderRequest)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			List<OpenTickets> openTickets = new ArrayList<OpenTickets>();
			List<RequestType> requestTypes = new ArrayList<RequestType>();
			renderRequest.setAttribute("openTickets", openTickets.toString());
			renderRequest.setAttribute("requestTypes", requestTypes.toString());
			renderRequest.setAttribute("serviceDeskID", serviceDeskID);
			prefs.setValue("error", "There was an unexpected error.");
			return "error";
		}
	
	//set sort order by created date of search container
		
	 /*Why would they just set something the same as it is?
		
		try{		
		//System.out.println("orderByType: "+renderRequest.getParameter("orderByType"));
		renderRequest.setAttribute("orderByType", renderRequest.getParameter("orderByType"));			
	}catch(Exception e){}
	try{
		renderRequest.setAttribute("delta", renderRequest.getParameter("delta"));
		
	}catch(Exception e){}
	*/

		return "view";
		
	}
	
	
	
	@ActionMapping(params = "action=addAnnouncement")
	public void addAnnouncement(ActionRequest request, ActionResponse response){
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		PortletPreferences prefs = request.getPreferences();
		
		try {
	//take all inputs into strings
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");

	//CHECK all fields are filled in.
			if(title.equals("") || content.equals("")){
				request.setAttribute("addAnnouncementError", "Make sure to fill in all of the fields.");
				return;
			}
			String author = "";
			author = request.getParameter("author");
			if(author==null){
				author = prefs.getValue("customerOrgId", "");
			}
			Date date= new Date();
			
			List<Announcement> announcementList = AnnouncementLocalServiceUtil.getAnnouncements(0, AnnouncementLocalServiceUtil.getAnnouncementsCount());
			long highestId = AnnouncementLocalServiceUtil.getAnnouncementsCount();
			for(Announcement announcement: announcementList) {
				
	//CHECK the entered title doesn't already exist.
				if(title.equals(announcement.getTitle())) {
					request.setAttribute("addAnnouncementError", "That title has already been used.");
					return;
				}
	//CHECK the new course id isn't used and is higher than the rest.
				if(highestId <= announcement.getID()) {
					highestId = announcement.getID() + 1;
				}
			}
			
			long ID = highestId;
	//set a new announcement with these values and add it to the table.
			Announcement announcement = AnnouncementLocalServiceUtil.createAnnouncement(ID);
			announcement.setTitle(title);
			announcement.setID(ID);
			announcement.setContent(content);;
			announcement.setAuthor(author);
			announcement.setSetDate(date);
			AnnouncementLocalServiceUtil.updateAnnouncement(announcement);
	System.out.println("Made announcement number: "+highestId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionErrors.add(request, "errorAddAnnouncement");
		}
	}
	
	
	@ActionMapping(params = "action=giveAnnouncement")
	public void giveAnnouncement(ActionRequest request, ActionResponse response){
	
		/*to build later
			essentially, it looks at the value of "authors", if it is not 'all' it assigns that value as the author.
			If it IS 'all' it sets that as the author... then I need to add in the display that it looks at the
			author, and only displays it in the table if that matches the user's organizationId, or if it is 'all'.
			
			On second thought, this doesn't need to be a second function. I'll just put in the above one, that if 
			'authors' != null, use that for the author value. Else, use organizationId.
		*/
	}
}