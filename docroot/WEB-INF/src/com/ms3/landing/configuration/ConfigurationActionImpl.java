package com.ms3.landing.configuration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction{
	
	@Override
	public void processAction(PortletConfig config, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception { 
			
		super.processAction(config, actionRequest, actionResponse);
			try{
					 
				String ticketStatusEndPoint = ParamUtil.getString(actionRequest,
						"ticketStatusEndPoint");
				String ticketListEndPoint = ParamUtil.getString(actionRequest,
						"ticketListEndPoint");
				String newTicketEndPoint = ParamUtil.getString(actionRequest,
						"newTicketEndPoint");
				String newCommentEndPoint = ParamUtil.getString(actionRequest,
						"newCommentEndPoint");
				
				String getCommentsEndPoint = ParamUtil.getString(actionRequest,
						"getCommentsEndPoint");
				String getTicketDetailsEndPoint = ParamUtil.getString(actionRequest,
						"getTicketDetailsEndPoint");
				String requestTypeEndPoint = ParamUtil.getString(actionRequest,
						"requestTypeEndPoint");
				String serviceDeskEndPoint = ParamUtil.getString(actionRequest,
						"serviceDeskEndPoint");
				String getAttachmentEndPoint = ParamUtil.getString(actionRequest,
						"getAttachmentEndPoint");
				String getAttachmentsByTicketIDEndPoint = ParamUtil.getString(actionRequest,
						"getAttachmentsByTicketIDEndPoint");
				String attachFileEndPoint = ParamUtil.getString(actionRequest,
						"attachFileEndPoint");
				String editTicketEndPoint = ParamUtil.getString(actionRequest,
						"editTicketEndPoint");
				String deleteAttachmentEndPoint = ParamUtil.getString(actionRequest,
						"deleteAttachmentEndPoint");
				
				String customerParentOrganizationId = ParamUtil.getString(actionRequest,
						"customerParentOrganizationId");
				
				String opsSupportOrganizationId = ParamUtil.getString(actionRequest,
						"opsSupportOrganizationId");
				
				String portletResource = ParamUtil.getString(actionRequest, "portletResource");			 
				PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);

				prefs.setValue("ticketStatusEndPoint", ticketStatusEndPoint);
				prefs.setValue("ticketListEndPoint", ticketListEndPoint);
				prefs.setValue("newTicketEndPoint", newTicketEndPoint);
				prefs.setValue("newCommentEndPoint", newCommentEndPoint);		
				prefs.setValue("getCommentsEndPoint", getCommentsEndPoint);
				prefs.setValue("getTicketDetailsEndPoint", getTicketDetailsEndPoint);
				prefs.setValue("requestTypeEndPoint", requestTypeEndPoint);
				prefs.setValue("serviceDeskEndPoint", serviceDeskEndPoint);
				prefs.setValue("getAttachmentEndPoint", getAttachmentEndPoint);
				prefs.setValue("getAttachmentsByTicketIDEndPoint", getAttachmentsByTicketIDEndPoint);
				prefs.setValue("attachFileEndPoint", attachFileEndPoint);
				prefs.setValue("editTicketEndPoint", editTicketEndPoint);
				prefs.setValue("deleteAttachmentEndPoint", deleteAttachmentEndPoint);
				prefs.setValue("opsSupportOrganizationId", opsSupportOrganizationId);		
				prefs.setValue("customerParentOrganizationId", customerParentOrganizationId);		
				prefs.store();
				
			  SessionMessages.add(actionRequest, config.getPortletName() + ".doConfigure");
			  //System.out.println("confugiration action: " + recruitmentApiEndPoint + employeeApiEndPoint + recruitToEmployeeApiEndPoint);
			  
			  SessionMessages.add(actionRequest, "config-stored");
			  System.out.println("Parent Org id: "+customerParentOrganizationId);
			  
			}
			catch(Exception e){
				SessionErrors.add(actionRequest, "error");
			}		  
			  
	}
/*
	public String render(PortletConfig portletConfig,RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		return "/WEB-INF/jsp/config.jsp";
	}
*/	

}