<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@page import="java.util.List" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "javax.portlet.PortletPreferences" %>
<%@ page import= "com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import= "com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import= "com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import= "com.liferay.portal.model.User" %>
<%@page import="com.liferay.portal.model.Organization" %>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil" %>
<%@ page import= "com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import= "com.ms3.landing.service.model.Announcement" %>
<%@page import= "com.ms3.landing.service.service.AnnouncementLocalServiceUtil" %>
<%@ page import= "com.ms3.landing.services.PortletServices" %>

<%@include file="/html/scripts.jsp" %>

<portlet:defineObjects />

<%
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	PortletPreferences prefs = renderRequest.getPreferences();
%>