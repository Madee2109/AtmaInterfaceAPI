package org.bte.framework.ws;

import java.util.Date;

import org.primefaces.shaded.json.JSONObject;

public class WSRequestDTO {

	private String api_for;
	private int ws_req_id;
	private Date ws_req_date;
	private int ws_req_server_id;
	private int ws_req_service_id;
	private int ws_req_client_id;
	private int ws_req_status;
	private String ws_req_response;
	private String ws_req_text;
	private Date ws_req_response_time;
	private int ws_req_client_user_id;
	private int ws_req_token_id;
	
	
	private String ws_service_class;
	private String ws_req_client_ref_uid;
	private int ws_req_response_code;
	private String ws_service_name;
	private WSUserDTO userdto;
	private JSONObject req_json;
	private String ws_req_ipaddress;
	private String ws_req_session_id;
	
	
	public String getApi_for() {
		return api_for;
	}
	public void setApi_for(String api_for) {
		this.api_for = api_for;
	}
	
	public int getWs_req_id() {
		return ws_req_id;
	}
	public void setWs_req_id(int ws_req_id) {
		this.ws_req_id = ws_req_id;
	}
	public Date getWs_req_date() {
		return ws_req_date;
	}
	public void setWs_req_date(Date ws_req_date) {
		this.ws_req_date = ws_req_date;
	}
	public int getWs_req_server_id() {
		return ws_req_server_id;
	}
	public void setWs_req_server_id(int ws_req_server_id) {
		this.ws_req_server_id = ws_req_server_id;
	}
	public int getWs_req_service_id() {
		return ws_req_service_id;
	}
	public void setWs_req_service_id(int ws_req_service_id) {
		this.ws_req_service_id = ws_req_service_id;
	}
	public int getWs_req_client_id() {
		return ws_req_client_id;
	}
	public void setWs_req_client_id(int ws_req_client_id) {
		this.ws_req_client_id = ws_req_client_id;
	}
	public int getWs_req_status() {
		return ws_req_status;
	}
	public void setWs_req_status(int ws_req_status) {
		this.ws_req_status = ws_req_status;
	}
	public String getWs_req_response() {
		return ws_req_response;
	}
	public void setWs_req_response(String ws_req_response) {
		this.ws_req_response = ws_req_response;
	}
	public String getWs_req_text() {
		return ws_req_text;
	}
	public void setWs_req_text(String ws_req_text) {
		this.ws_req_text = ws_req_text;
	}
	public Date getWs_req_response_time() {
		return ws_req_response_time;
	}
	public void setWs_req_response_time(Date ws_req_response_time) {
		this.ws_req_response_time = ws_req_response_time;
	}
	public JSONObject getReq_json() {
		return req_json;
	}
	public void setReq_json(JSONObject req_json) {
		this.req_json = req_json;
	}
	public String getWs_service_class() {
		return ws_service_class;
	}
	public void setWs_service_class(String ws_service_class) {
		this.ws_service_class = ws_service_class;
	}
	
	public String getWs_req_client_ref_uid() {
		return ws_req_client_ref_uid;
	}
	public void setWs_req_client_ref_uid(String ws_req_client_ref_uid) {
		this.ws_req_client_ref_uid = ws_req_client_ref_uid;
	}
	public int getWs_req_response_code() {
		return ws_req_response_code;
	}
	public void setWs_req_response_code(int ws_req_response_code) {
		this.ws_req_response_code = ws_req_response_code;
	}
	public String getWs_service_name() {
		return ws_service_name;
	}
	public void setWs_service_name(String ws_service_name) {
		this.ws_service_name = ws_service_name;
	}
	public WSUserDTO getUserdto() {
		return userdto;
	}
	public void setUserdto(WSUserDTO userdto) {
		this.userdto = userdto;
	}
	public int getWs_req_client_user_id() {
		return ws_req_client_user_id;
	}
	public void setWs_req_client_user_id(int ws_req_client_user_id) {
		this.ws_req_client_user_id = ws_req_client_user_id;
	}
	public int getWs_req_token_id() {
		return ws_req_token_id;
	}
	public void setWs_req_token_id(int ws_req_token_id) {
		this.ws_req_token_id = ws_req_token_id;
	}
	public String getWs_req_session_id() {
		return ws_req_session_id;
	}
	public void setWs_req_session_id(String ws_req_session_id) {
		this.ws_req_session_id = ws_req_session_id;
	}
	public String getWs_req_ipaddress() {
		return ws_req_ipaddress;
	}
	public void setWs_req_ipaddress(String ws_req_ipaddress) {
		this.ws_req_ipaddress = ws_req_ipaddress;
	}
	
	
	
	
}
