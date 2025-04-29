package org.bte.framework.ws;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.bte.core.utils.CodeList;
import org.bte.core.utils.IDSequenceGenerator;
import org.primefaces.shaded.commons.io.IOUtils;
import org.primefaces.shaded.json.JSONException;
import org.primefaces.shaded.json.JSONObject;

public class BTEWSRun {
public static Map<String,WSUserDTO> activelogin= BTEWSService.getActiveToken();
	public static void run(ServletRequest req,ServletResponse res) {
		 HttpServletRequest request = (HttpServletRequest) req;
		 
			
			
		Date newdate = new Date();
		  String request_stream="";
		  WSRequestDTO wsreq = new WSRequestDTO();
		  int id = IDSequenceGenerator.getNextSequenceInt("tb_ws_request");
		  wsreq.setWs_req_id(id);
		  wsreq.setWs_req_date(newdate);
		  wsreq.setWs_req_ipaddress(req.getLocalAddr());
		  wsreq.setWs_req_session_id(request.getSession().getId());
		  
		try {
			
		
		request_stream = IOUtils.toString(req.getInputStream());
		 wsreq.setWs_req_text(request_stream);
		 
 	   JSONObject jsonmain = new JSONObject(request_stream); 
 	  if(!jsonmain.isNull("client_ref_uid")){
 		  wsreq.setWs_req_client_ref_uid(jsonmain.getString("client_ref_uid"));
 	  }
 	  wsreq.setApi_for(jsonmain.getString("api_for"));
 	  if(wsreq.getApi_for().equalsIgnoreCase("generate_access_token")){	
 		 
 		 generateToken(wsreq, res,jsonmain);
 		  return;
 	  }
 	 List<WSServiceDTO> apilist= BTEWSService.getWSAPI(wsreq.getApi_for());
 	 if(apilist==null || apilist.size()==0){
 		writeResult(wsreq, res,8,"");
 		return;
 	 }
 	
	wsreq.setWs_req_service_id(apilist.get(0).getWs_service_id());
	wsreq.setWs_service_class(apilist.get(0).getWs_service_class());
	
 	String client_aut_token = jsonmain.getString("client_aut_token");
 	String client_id = jsonmain.getString("client_id");
 	if(activelogin.get(client_aut_token)==null){
 		writeResult(wsreq, res,2,"Invalid Token");
 		return;
 	}
 	
 	
		WSUserDTO userdto= activelogin.get(client_aut_token);
		if(userdto.getClient_user_name().equals(client_id)==false){
			writeResult(wsreq, res,2,"Invalid Token");
	 		return;
		}
		wsreq.setWs_req_client_id(userdto.getClient_id());
	 	wsreq.setWs_req_token_id(userdto.getWs_token_id());
	 	wsreq.setWs_req_client_user_id(userdto.getClient_user_id());
	 	wsreq.setWs_req_server_id(userdto.getServer_id());
	 	
 	if(userdto.getLogin_end_time().before(newdate)){
 		writeResult(wsreq, res,3,"Session Time out");
 		return;
 	}
 	wsreq.setUserdto(userdto);
 	 wsreq.setReq_json(jsonmain);
 	
		BTEWSService.saveWSRequest(wsreq);
	/*	wsreq.setDb_password("@tmaDB");
		wsreq.setDb_username("root");
		wsreq.setDb_url("jdbc:mysql://localhost/arhdb8apr22?logger=com.mysql.cj.log.StandardLogger&profileSQL=true&autoReconnect=true");
		wsreq.setHost_url("http://localhost:8082/btecMC2Atma/wsservice");*/
		
		
		Class c = Class.forName(wsreq.getWs_service_class());
		 BTEWSInterface  inter = (BTEWSInterface)  c.newInstance();
		 inter.inital(wsreq, request, res);
		 inter.run();
		 inter.getResponse();
			BTEWSService.saveWSResponse(wsreq);
			inter.writeResult();
			
		}catch(JSONException e) {
			
		 	writeResult(wsreq, res,6,e.getMessage());
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public static void generateToken(WSRequestDTO wsreq,ServletResponse res, JSONObject req) {
		
				 	 	
			WSUserDTO userdto = new WSUserDTO();
			userdto.setClient_user_name(req.getString("client_id"));
			userdto.setClient_user_password(req.getString("client_password"));
			if(BTEWSService.generatetoken(userdto)){
				activelogin.put(userdto.getWs_token_key(), userdto);
				JSONObject jsonmain = new JSONObject();
				
				jsonmain.put("client_aut_token", userdto.getWs_token_key());
				
				
				writeResult(wsreq, res, 1, jsonmain);
			}else{
				writeResult(wsreq, res,2,"Login access denied");
			}
			
		 	 
		
		
	}
	public static void writeResult(WSRequestDTO wsreq,ServletResponse res,int response_code,String response_error ) {
		try {
			JSONObject jsonmain = new JSONObject();
			jsonmain.put("response_code", response_code);
			jsonmain.put("response_msg",CodeList.getAlternateIdFromCode("ws_req_response_code", response_code));
			jsonmain.put("response_msg_desc", response_error);
			jsonmain.put("ws_req_id", wsreq.getWs_req_id());
			
		 	  wsreq.setWs_req_response_time(new Date());
		 	 wsreq.setWs_req_response_code(response_code);
		 	wsreq.setWs_req_response(jsonmain.toString());
		 	 BTEWSService.saveWSRequest(wsreq);
			res.setContentType("application/json");
			res.getOutputStream().write(wsreq.getWs_req_response().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void writeResult(WSRequestDTO wsreq,ServletResponse res,int response_code,JSONObject jsonmain ) {
		try {
			
			jsonmain.put("response_code", response_code);
			jsonmain.put("response_msg",CodeList.getAlternateIdFromCode("ws_req_response_code", response_code));
			
			jsonmain.put("ws_req_id", wsreq.getWs_req_id());
			
		 	  wsreq.setWs_req_response_time(new Date());
		 	 wsreq.setWs_req_response_code(response_code);
		 	wsreq.setWs_req_response(jsonmain.toString());
		 	 BTEWSService.saveWSRequest(wsreq);
			res.setContentType("application/json");
			res.getOutputStream().write(wsreq.getWs_req_response().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
