<%@include file="/html/init.jsp" %>

<%
	String error = prefs.getValue("error", "");
%>

<h1><%= error %></h1>