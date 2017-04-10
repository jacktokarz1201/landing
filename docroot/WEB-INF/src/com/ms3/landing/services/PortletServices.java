package com.ms3.landing.services;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
public class PortletServices {
    
    public String getClientName(User user, String parentOrgName) throws PortalException, SystemException, NullPointerException{
        
        List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(user.getUserId(), 0, QueryUtil.ALL_POS, null);
        Long companyId = CompanyThreadLocal.getCompanyId();
        Organization customerParentOrg = OrganizationLocalServiceUtil.getOrganization(companyId, parentOrgName);
                    
        for(Organization org: organizations){
            //System.out.println("Organization: "+org.toString());
            if(org.getParentOrganizationId()==customerParentOrg.getOrganizationId()){                   
                return org.getName();               
            }
        }   
        
        System.out.println("user is not part of a customer organization");
        //user is not a customer
        throw new NullPointerException();
    }
    
    public long getClientId(User user, String parentOrgName, RenderRequest renderRequest) throws PortalException, SystemException, NullPointerException{
        
    	PortletPreferences prefs = renderRequest.getPreferences();
    	
        List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(user.getUserId(), 0, QueryUtil.ALL_POS, null);
        Long companyId = Long.parseLong(prefs.getValue("companyId", ""));
        Organization customerParentOrg = OrganizationLocalServiceUtil.getOrganization(companyId, parentOrgName);
                    //this seems excessive? don't we already have the Org in the line above?
        for(Organization org: organizations){
            //System.out.println("Organization: "+org.toString());
            if(org.getParentOrganizationId()==customerParentOrg.getOrganizationId()){                   
                return org.getOrganizationId();             
            }
        }   
        
        System.out.println("user is not part of a customer organization");
        //user is not a customer
        throw new NullPointerException();
    }
    
    public boolean checkIfOpsSupport(PortletRequest request){
        
        try{
        
            PortletPreferences pref = request.getPreferences(); 
            String opsSupportOrganizationId = pref.getValue("opsSupportOrganizationId", "");
            long opsOrgId = Long.parseLong(opsSupportOrganizationId);
            
            //System.out.println("opsOrgId: "+opsOrgId);
            
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            User user = themeDisplay.getUser(); 
            
            List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(user.getUserId(), 0, QueryUtil.ALL_POS, null);
            
            
            if(organizations.contains(OrganizationLocalServiceUtil.getOrganization(opsOrgId))){             
                //System.out.println("contaains: is ops support");
                return true;
            }else{
                //System.out.println("contaains: is not ops support");
                return false;
            }
            
        }catch(Exception e){
            System.out.println("is not ops support, ops support not defined in config page");
            System.out.println(e);
            return false;
        }
    }
    
    public List<Organization> getCustomers(RenderRequest request) throws SystemException{
   //revised by Jack. Shortened.
        PortletPreferences prefs = request.getPreferences();
        String customerParentOrganizationId = prefs.getValue("customerParentOrganizationId", "");
        List<Organization> organizations= OrganizationLocalServiceUtil.getOrganizations(0, OrganizationLocalServiceUtil.getOrganizationsCount());
        List<Organization> customers = new ArrayList<Organization>();
        for(Organization org: organizations) {
        	if(org.getParentOrganizationId()==Long.parseLong(customerParentOrganizationId)) {
        		customers.add(org);
        	}
        }
         //   		 getSuborganizations(Long.parseLong(prefs.getValue("companyId", "")), Long.parseLong(customerParentOrganizationId));	
        
        return customers;
    }
}