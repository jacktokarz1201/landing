package com.ms3.landing.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.ms3.landing.health.ApplicationHealth;
import com.ms3.landing.health.Integrations;
import com.ms3.landing.health.Resources;
import com.ms3.landing.tickets.Attachment;
import com.ms3.landing.tickets.AttachmentList;
import com.ms3.landing.tickets.Comment;
import com.ms3.landing.tickets.Fields;
import com.ms3.landing.tickets.NewComment;
import com.ms3.landing.tickets.OpenTickets;
import com.ms3.landing.tickets.RequestType;
import com.ms3.landing.tickets.RequestTypeList;
import com.ms3.landing.tickets.ServiceDesk;
import com.ms3.landing.tickets.ServiceDeskList;
import com.ms3.landing.tickets.TicketList;
import com.ms3.landing.tickets.TicketStatus;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class RestServices {
	private static OkHttpClient client = new OkHttpClient();
//	private static String ticketStatusEndPoint = "http://52.201.204.44:8081/trouble-ticket-api/ticketStatus?ticketNumber=";
//	private static String ticketListEndPoint = "http://52.201.204.44:8081/trouble-ticket-api/ticketList?serviceDeskID=";
//	private static String newTicketEndPoint = "http://52.201.204.44:8081/trouble-ticket-api/newTicket";
	public String apiEndPoint;
	public String apiEndPoint2;
	
	private RestTemplate restTemplate = new RestTemplate();

	public RestServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestServices(String apiEndPoint) {
		super();
		this.apiEndPoint = apiEndPoint;
	}
	
	public RestServices(String apiEndPoint, String apiEndPoint2) {
		super();
		this.apiEndPoint = apiEndPoint;
		this.apiEndPoint2 = apiEndPoint2;
	}

	public static Response getJSON(String url) throws IOException,
			IllegalArgumentException {
		try {
			Request request = null;
			Response response = null;
			//System.out.println("url serviceDesk: "+url);
			request = new Request.Builder().url(url).build();
			response = client.newCall(request).execute();
//			System.out.println("RESPONSE BODY STRING "+response);
			//System.out.println("codE: " + response.code());
			
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//Health check Stuff
	
	public ApplicationHealth checkHealth(String applicationId)
			throws IllegalArgumentException, IOException, JSONException, ParseException {
		
		/*
		String uri = apiEndPoint+"/health/"+applicationId;
		java.net.URI url = null;		
		try {
			url = new java.net.URI(uri);
		} catch (java.net.URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("url: " + url);
		ResponseEntity<String> healthCheckResult = restTemplate.getForEntity(url, String.class);
		
		*/
		String json = null;
		String uri = apiEndPoint+"/health/"+applicationId;
		System.out.println("uri: "+uri);
		try{
			Response response =getJSON(uri);
			json = response.body().string();
		}catch(Exception e){
			e.printStackTrace();
			json = "";
		}	

		//System.out.println("json: " + json);
			ApplicationHealth appHealth= new ApplicationHealth();
			JSONObject obj = new JSONObject(json);
			JSONArray jsonArray = null;
			
			int clientId = Integer.parseInt(obj.optString("clientId"));
			appHealth.setClientId(clientId);
			appHealth.setApplicationId(Integer.parseInt(obj.optString("applicationId")));
			appHealth.setLast_poll_time(obj.optString("lastPollTime"));

			jsonArray = obj.getJSONArray("integrations");
			List<Integrations> listIntegrations = new ArrayList<Integrations>();
			for(int y = 0; y < jsonArray.length(); y++) {
				Integrations integration = new Integrations();
				JSONObject ect = jsonArray.getJSONObject(y);
				
				integration.setType(ect.optString("type"));
				integration.setStatus(ect.optString("status"));
				integration.setName(ect.optString("name"));
				listIntegrations.add(integration);
			}
			
			appHealth.setIntegrations(listIntegrations);
			
			
			jsonArray = obj.getJSONArray("resources");
			List<Resources> listResources = new ArrayList<Resources>();
			
			for(int y = 0; y < jsonArray.length(); y++) {
				Resources resource = new Resources();
				JSONObject ect = jsonArray.getJSONObject(y);
				
				resource.setType(ect.optString("type"));
				resource.setStatus(ect.optString("status"));
				listResources.add(resource);
			}
			
			appHealth.setResources(listResources);
		
		return appHealth;
	}
	
	
	
	
//Ticket Stuff
	public String editDetails(Fields fields, String ticketId) {
		//System.out.println("RestServices.editDetails()");
		String status = null;
		Gson openTicketGson = new GsonBuilder().disableHtmlEscaping().create();
		String openTicketJson = openTicketGson.toJson(fields).replace('_','-');
		//System.out.println("JSON: " + openTicketJson);
		JSONObject fieldsObj = new JSONObject(fields);
		JSONObject ticketUpdate = new JSONObject();
		ticketUpdate.put("fields", fieldsObj);
		System.out.println("fields: " + ticketUpdate.toString());
		
		
		URL url = null;
		try {
			url = new URL(apiEndPoint + ticketId);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
         
        HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) url.openConnection();		
			conn.setDoOutput(true);
	        conn.setRequestMethod("PUT");
	        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	        String output;
	        String response = "";
	        // JSONPayload (candidate.toString();)
	        String input = ticketUpdate.toString();
	        //System.out.println("json: " + input);
	        OutputStream os = conn.getOutputStream();
	        os.write(input.getBytes());
	        os.flush();
	        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
	           //throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	        	 BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
	        	 //System.out.println("Error from Server .... \n");
	        	 while ((output = br.readLine()) != null) {
	 	            //System.out.println(output);	
	 	            response +=output;
	 	        }
	        	 conn.disconnect();
	        	 //System.out.println("response: " + response);
	        	
	        }
	        else {
	        	//System.out.println("read response: ");
	 	        BufferedReader br = new BufferedReader(new InputStreamReader(
	 	                (conn.getInputStream())));
	 	       
	 	        //System.out.println("Output from Server .... \n");
	 	        while ((output = br.readLine()) != null) {
	 	            //System.out.println(output);
	 	        }
	 	        
	 	       status = "SUCCESS";
	 	       conn.disconnect();		
	        }
	        		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public String newComment(NewComment comment) {
		//System.out.println("RestServices.newComment()");
		String status = null;
		Gson openTicketGson = new GsonBuilder().disableHtmlEscaping().create();
		String openTicketJson = openTicketGson.toJson(comment).replace('_','-');
		//System.out.println("JSON: " + openTicketJson);

		URL url = null;
		try {
			url = new URL(apiEndPoint);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
         
        HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) url.openConnection();		
			conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	        String output;
	        String response = "";
	        String input = openTicketJson;
	        //System.out.println("json: " + input);
	        OutputStream os = conn.getOutputStream();
	        os.write(input.getBytes());
	        os.flush();
	        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	           //throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	        	 BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
	        	// System.out.println("Error from Server .... \n");
	        	 while ((output = br.readLine()) != null) {
	 	            //System.out.println(output);	
	 	            response +=output;
	 	        }
	        	 conn.disconnect();
	        	 //System.out.println("response: " + response);
	        	
	        }
	        else {
	        	//System.out.println("read response: ");
	 	        BufferedReader br = new BufferedReader(new InputStreamReader(
	 	                (conn.getInputStream())));
	 	       
	 	       // System.out.println("Output from Server .... \n");
	 	        while ((output = br.readLine()) != null) {
	 	            //System.out.println(output);
	 	        }
	 	        
	 	       status = "SUCCESS";
	 	       conn.disconnect();		
	        }
	        		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}

	public String newEntry(OpenTickets openTickets) {
		//System.out.println("RestServices.newEntry()");
		String status = null;
		Gson openTicketGson = new GsonBuilder().disableHtmlEscaping().create();
		String openTicketJson = openTicketGson.toJson(openTickets).replace('_','-');
		//System.out.println("JSON: " + openTicketJson);

		URL url = null;
		try {
			url = new URL(apiEndPoint);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
         
        HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) url.openConnection();		
			conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
	        String output;
	        String response = "";
	        String input = openTicketJson;
	        //System.out.println("json: " + input);
	        OutputStream os = conn.getOutputStream();
	        os.write(input.getBytes());
	        os.flush();
	        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	           //throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	        	 BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
	        	 //System.out.println("Error from Server .... \n");
	        	 while ((output = br.readLine()) != null) {
	 	            //System.out.println(output);	
	 	            response +=output;
	 	        }
	        	 conn.disconnect();
	        	// System.out.println("response: " + response);
	        	
	        }
	        else {
	        	//System.out.println("read response: ");
	 	        BufferedReader br = new BufferedReader(new InputStreamReader(
	 	                (conn.getInputStream())));
	 	       
	 	        //System.out.println("Output from Server .... \n");
	 	        while ((output = br.readLine()) != null) {
	 	           //System.out.println(output);
	 	           response +=output;
	 	        }
	 	        
	 	       JSONObject json = new JSONObject(response);
	 	       String issueId = json.optString("new-ticket-number");	 	        
	 	       status = "SUCCESS@"+issueId;
	 	       conn.disconnect();		
	        }
	        		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	public TicketStatus getTicketStatus(String ticketNumber)
			throws IllegalArgumentException, IOException {

		String json = null;
		try {
			Response response = getJSON(apiEndPoint + "?ticketNumber=" + ticketNumber);
			json = response.body().string();
			//System.out.println("JSSSSSSSSSSSSSSSONL: "+json);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			json = "";
			//System.out.println("err0r");
		}

		Gson gson = new Gson();

		TicketStatus ts = gson.fromJson(json, TicketStatus.class);
		return ts;
	}
	
	public OpenTickets getTicketDetails(String ticketNumber) throws IllegalArgumentException, IOException{
		String json = null;
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		
		OpenTickets openTicket = new OpenTickets();
		try{
			Response response = getJSON(apiEndPoint + ticketNumber);
			json = response.body().string();
			if(response.code()!=500){
				openTicket.setAuthorized(true);
			}else{
				openTicket.setAuthorized(false);
			}
		}catch(Exception e){
			//e.printStackTrace();
			json = "";
		}
		
		
		
		jsonObject = new JSONObject(json);
		//System.out.println("---------"+jsonObject);
		
		
		
		openTicket.setJsd_requestType(jsonObject.optString("requestTypeId"));
		openTicket.setJsd_ticketID(jsonObject.optString("issueKey"));
		openTicket.setServiceDeskID(jsonObject.optString("serviceDeskId"));
		openTicket.setPriority(jsonObject.optString("priority"));
		jsonArray = jsonObject.getJSONArray("requestFieldValues");
		
		for(int x=0; x<jsonArray.length(); x++){
			JSONObject obj = jsonArray.getJSONObject(x);
			try {
			if(obj.optString("fieldId").equals("summary")){
				openTicket.setSupport_short_description(escape(obj.optString("value")));
			}
			if(obj.optString("fieldId").equals("description")){
				openTicket.setSupport_synopsis(escape(obj.optString("value")));
			}
			if(obj.optString("fieldId").equals("customfield_10300")){
				JSONObject valObj = new JSONObject(obj.optString("value"));
				openTicket.setCustomerUserName(valObj.optString("name"));
				openTicket.setCustomerEmail(valObj.optString("emailAddress"));
			}
			} catch(Exception e){
				
			}
		}
		
		return openTicket;
		
	}

	public List<OpenTickets> getTicketList(String serviceDeskID)
			throws IllegalArgumentException, IOException, JSONException, ParseException {

		String json = null;
		JSONArray jsonArray = null;
		JSONObject jsonObject = null;

		
		try{
			Response response =getJSON(apiEndPoint + "?serviceDeskID=" + serviceDeskID);
			json = response.body().string();
			//System.out.println("json: " + json);
		}catch(Exception e){
			//System.out.println("error reowireorweiruweioruweoruiweouroiweuroweur");
			e.printStackTrace();
			json = "";
		}	

		jsonObject = new JSONObject(json);
		//System.out.println(jsonObject);
		jsonArray = jsonObject.getJSONArray("openTickets");

		List<OpenTickets> listOpenTickets = new ArrayList<OpenTickets>();
		TicketList ticketList = new TicketList();

		for (int x = 0; x < jsonArray.length(); x++) {
			OpenTickets openTicket = new OpenTickets();
			JSONObject obj = jsonArray.getJSONObject(x);
			
			openTicket.setJsd_ticketID(obj.optString("ticketNumber"));
			openTicket.setCurrentStatus(obj.optString("currentStatus"));
			openTicket.setSupport_short_description(obj.optString("summary"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse(obj.optString("createdDate"));
			String formattedTime = output.format(d);
			openTicket.setCreatedDate(formattedTime);
			
			
			listOpenTickets.add(openTicket);
		}
		

		ticketList.setOpenTickets(listOpenTickets);

		// ticketList.toString();
		/*
		 * for (OpenTickets ot : listOpenTickets) {
		 * System.out.println("Ticket Number: " + ot.getTicketNumber());
		 * System.out.println("Current Status: " + ot.getCurrentStatus());
		 * System.out.println("Action Type: " + ot.getActionType());
		 * System.out.println("UID: " + ot.getUid());
		 * System.out.println("Service Desk ID: " + ot.getServiceDeskID());
		 * System.out.println("JSD Request Type: " + ot.getJsdRequestType());
		 * System.out.println("Support Short Description: " +
		 * ot.getSupportShortDescription());
		 * System.out.println("Support Synopsis: " + ot.getSupportSynopsis());
		 * System.out.println("Customer Username: " + ot.getCustomerUserName());
		 * System.out.println("Customer Email: " + ot.getCustomerEmail());
		 * System.out.println("Customer Phone: " + ot.getCustomerPhone());
		 * System.out.println("JSD Comment: " + ot.getJsdComment());
		 * System.out.println("JSD Comment Public Visible: " +
		 * ot.getJsdCommentPublicVisible());
		 * System.out.println("---------------------"); }
		 */

		// System.out.println(jsonArray);

		return listOpenTickets;

		// Gson gson = new Gson();

		// String tl = gson.toJson(jsonArray, TicketList.class);

		// return new String[] { "Ticket Number: " + tl};
	}
	
	public String deleteAttachment(String attachmentId)throws IllegalArgumentException, IOException{
		//System.out.println("RestServices.deleteAttachment()");
		String deleted = null;
		
		URL url = null;
		try {
			url = new URL(apiEndPoint + attachmentId);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
         
        HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) url.openConnection();		
			conn.setDoOutput(true);
	        conn.setRequestMethod("DELETE");
	        
	        if (conn.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
	           
	        	//System.out.println("DELETED code: " + conn.getResponseCode());
	        }
	        else {
	        	//System.out.println("code: " + conn.getResponseCode());
	        	deleted = "SUCCESS";
	 	       conn.disconnect();		
	        }
	        		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deleted;
	}
	
	public List<ServiceDesk> getServiceDesks() throws IllegalArgumentException, IOException, JSONException{
		
		String json = null;
		JSONArray jsonArray = null;

		try{
			Response response = getJSON(apiEndPoint);
			json = response.body().string();
		}catch(Exception e){
			e.printStackTrace();
			json = "";
		}
		
		jsonArray = new JSONArray(json);
		//System.out.println(jsonArray);
		List<ServiceDesk> listServiceDesks = new ArrayList<ServiceDesk>();
		ServiceDeskList serviceDeskList = new ServiceDeskList();

		for (int x = 0; x < jsonArray.length(); x++) {
			ServiceDesk serviceDesk = new ServiceDesk();
			JSONObject obj = jsonArray.getJSONObject(x);
			// System.out.println(obj);
			serviceDesk.setServiceDeskID(obj.optString("serviceDeskID"));
			serviceDesk.setServiceDeskDescriptionString(obj.optString("serviceDeskDescriptionString"));
			serviceDesk.setServiceDeskKeyString(obj.optString("serviceDeskKeyString"));
			// System.out.println("openticket: " + openTicket.toString());
			listServiceDesks.add(serviceDesk);
		}

		serviceDeskList.setServiceDesks(listServiceDesks);
		return listServiceDesks;
	}
	
	public List<RequestType> getRequestTypes(String serviceDeskID) throws IllegalArgumentException,
			IOException, JSONException {

		String json = null;
		JSONArray jsonArray = null;

		try{
			Response response = getJSON(apiEndPoint + serviceDeskID);
			json = response.body().string();
		}catch(Exception e){
			e.printStackTrace();
			json = "";
		}

		jsonArray = new JSONArray(json);
		//System.out.println(jsonArray);
		List<RequestType> listRequestTypes = new ArrayList<RequestType>();
		RequestTypeList requestTypeList = new RequestTypeList();

		for (int x = 0; x < jsonArray.length(); x++) {
			RequestType requestType = new RequestType();
			JSONObject obj = jsonArray.getJSONObject(x);
			// System.out.println(obj);
			
			requestType.setServiceDeskID(obj.optString("serviceDeskID"));
			requestType.setRequestsTypeName(obj.optString("requestsTypeName"));
			requestType.setRequestTypeDescription(obj.optString("requestTypeDescription"));
			requestType.setRequestTypeID(obj.optString("requestTypeID"));
			
			listRequestTypes.add(requestType);
		}

		requestTypeList.setRequestTypes(listRequestTypes);
		return listRequestTypes;
	}
	
	
	public List<Attachment> getAttachments(String ticketNumber) throws IllegalArgumentException, IOException, JSONException, SystemException, ParseException{
		
		String json = null;
		JSONArray jsonArray = null;
		JSONObject jsonObject = null;

		
		try{
			Response response = getJSON(apiEndPoint + ticketNumber);
			json = response.body().string();
		}catch(Exception e){
			e.printStackTrace();
			json = "";
		}	

		jsonObject = new JSONObject(json);
		//System.out.println(jsonObject);
		jsonArray = jsonObject.getJSONArray("attachment");

		List<Attachment> listAttachments = new ArrayList<Attachment>();
		AttachmentList attachmentList = new AttachmentList();

		for (int x = 0; x < jsonArray.length(); x++) {
			Attachment attachment = new Attachment();
			JSONObject obj = jsonArray.getJSONObject(x);
			
			
			attachment.setId(obj.optString("id"));
			attachment.setFilename(obj.optString("filename"));			
			attachment.setCreated(obj.optString("created"));
			attachment.setSize(obj.optLong("size"));
			attachment.setMimeType(obj.optString("mimeType"));
			attachment.setContent(obj.optString("content"));
			attachment.setThumbnail(obj.optString("thumbnail"));
			
			listAttachments.add(attachment);
		}
		

		attachmentList.setAttachments(listAttachments);

		
		return listAttachments;
		
	}
	
	
	
	public List<Comment> getComments(String ticketNumber)
			throws IllegalArgumentException, IOException, JSONException, SystemException {

		String json = null;
		JSONArray jsonArray = null;

		try{
			Response response = getJSON(apiEndPoint + ticketNumber);
			json = response.body().string();
		}catch(Exception e){
			e.printStackTrace();
			json = "";
		}

		jsonArray = new JSONArray(json);
		//System.out.println(jsonArray);

		// comment  
		List<Comment> cList = new ArrayList<Comment>();
		String regex = "At\\s([0-9]{2})/([0-9]{2})/([0-9]{4})\\s([0-9]{2}):([0-9]{2}):([0-9]{3})\\s[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}\\swrote:\\s";
		String regexCheckEmail = "[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}";
		Pattern checkRegEx = Pattern.compile(regex);
		Pattern checkRegExEmail = Pattern.compile(regexCheckEmail);
		boolean commentFromPortalFlag = false;
		JSONObject obj = new JSONObject();
		for (int y = 0; y < jsonArray.length(); y++) {
			commentFromPortalFlag = false;
			Comment newComment = new Comment();
			obj = jsonArray.getJSONObject(y);
			Matcher regexMatcher = checkRegEx.matcher(obj.optString("commentBody"));

			while (regexMatcher.find()) {
				if (regexMatcher.group().length() != 0) {
					commentFromPortalFlag = true;
					break;
				}
			}
			
			if(commentFromPortalFlag){
                //System.out.println(regexMatcher.group().trim());
                String foundRegEx = regexMatcher.group().trim();                    
                Matcher regexEmailMatcher = checkRegExEmail.matcher(foundRegEx);                    
                while(regexEmailMatcher.find()){
                    if(regexEmailMatcher.group().length()!=0){
                        //System.out.println("Email: " + regexEmailMatcher.group().trim());
                        newComment.setAuthorEmail(regexEmailMatcher.group().trim());
                        break;
                    }
                }
                
                
                
                newComment.setCommentBody(escape(obj.optString("commentBody").substring(regexMatcher.end())));                
            }else{
            	newComment.setAuthorEmail(obj.optString("authorEmail"));
                newComment.setCommentBody(escape(obj.optString("commentBody")));
            }
			
			String userName="";
        	List<User> user = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
        	for(User u : user){
        		if(u.getEmailAddress().toString().equals(newComment.getAuthorEmail())){
        			userName = u.getFullName();
        			break;
        		}
        		
        	}
        	if(!userName.equals("")){
        	newComment.setAuthorName(userName);
        	
        	} else {
        		newComment.setAuthorName("");
        	}
            newComment.setCreatedDate(obj.optString("createdDate"));
           // System.out.println(newComment);
            cList.add(newComment);
		}
		// end of comment
		return cList;
	}
	
	

	
	public static String escape(String s) {
	    StringBuilder builder = new StringBuilder();
	    boolean previousWasASpace = false;
	    for( char c : s.toCharArray() ) {
	        if( c == ' ' ) {
	            if( previousWasASpace ) {
	                builder.append("&nbsp;");
	                previousWasASpace = false;
	                continue;
	            }
	            previousWasASpace = true;
	        } else {
	            previousWasASpace = false;
	        }
	        switch(c) {
	            case '<': builder.append("&lt;"); break;
	            case '>': builder.append("&gt;"); break;
	            case '&': builder.append("&amp;"); break;
	            case '"': builder.append("&quot;"); break;
	            case '\n': builder.append("<br>"); break;
	            // We need Tab support here, because we print StackTraces as HTML
	            case '\t': builder.append("&nbsp; &nbsp; &nbsp;"); break;  
	            default:
	                if( c < 128 ) {
	                    builder.append(c);
	                } else {
	                    builder.append("&#").append((int)c).append(";");
	                }    
	        }
	    }
	    String converted = builder.toString();
        String str = "(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:\'\".,<>?«»“”‘’]))";
        Pattern patt = Pattern.compile(str);
        Matcher matcher = patt.matcher(converted);
        converted = matcher.replaceAll("<a href=\"$1\">$1</a>");
        return converted;
	}
}
