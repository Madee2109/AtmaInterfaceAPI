package org.bte.framework.ws.wsapi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.bte.framework.ws.BTEWSInterface;
import org.bte.framework.ws.WSRequestDTO;
import org.bte.framework.ws.WSUserDTO;
import org.primefaces.shaded.commons.io.IOUtils;
import org.primefaces.shaded.json.JSONObject;

public class RedirectToClientServer implements BTEWSInterface{

	int response_code = 1;
	JSONObject response = new JSONObject();
	String error_msg;
	 HttpServletRequest req;
	 ServletResponse res;
	 public  WSRequestDTO reqdto=null;
	 public boolean inital(WSRequestDTO reqdto,HttpServletRequest req,ServletResponse res) {
		 this.reqdto = reqdto;
			this.req =req;
			this.res = res;
			return true;
	}


	public void getResponse() {
		response.put("ws_req_id", reqdto.getWs_req_id());
		if(response_code==1) {
			
		}else {
			response.put("response_code", response_code);
			response.put("response_msg", error_msg);
			
		}
		reqdto.setWs_req_response_code(response_code);
		reqdto.setWs_req_response(response.toString());
		
	}
	
	public void run() {

		try {
			 WSUserDTO userdto =reqdto.getUserdto();
		URLConnection connection = new URL(userdto.getHost_url()).openConnection();
		
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json" );
		JSONObject jsonmain = reqdto.getReq_json();
		jsonmain.put("ws_req_id", reqdto.getWs_req_id());
		jsonmain.put("ws_req_user_id", userdto.getClient_user_server_person_id());
		jsonmain.put("ws_req_user_name", userdto.getHost_username());
		jsonmain.put("ws_req_user_password", userdto.getHost_password());
		String re = jsonmain.toString();
		
			OutputStream output = connection.getOutputStream();
		    output.write(re.getBytes());	
		

		InputStream response_stream = connection.getInputStream();
		String result = IOUtils.toString(response_stream);
		response = new JSONObject(result); 
		}catch(java.net.ConnectException e) {
			response_code = 4;
			error_msg = e.getMessage();
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}

	
	public void writeResult() {
		try {
			res.setContentType("application/json");
			res.getOutputStream().write(reqdto.getWs_req_response().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	


	
}
