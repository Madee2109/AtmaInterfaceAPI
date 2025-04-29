package org.bte.bean.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.bte.framework.ws.BTEWSService;
import org.bte.framework.ws.WSRequestDTO;
import org.bte.framework.ws.WSServiceDTO;
@ManagedBean ( name = "RequestView" )
@ViewScoped
public class RequestView {

	private List<WSRequestDTO> list = new ArrayList<WSRequestDTO>();
 
	private Date fromdate = new Date();
	private Date todate;
	private Integer ws_req_no;
	private String client_ref_no="";
	private String api="";
	private WSRequestDTO select = new WSRequestDTO();
	public RequestView() {
		search();
	}
	public void search(){
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("req_from", fromdate);
		map.put("req_to", todate);
		if(ws_req_no!=null && ws_req_no!=0)
		map.put("ws_req_id", ws_req_no);
		if(client_ref_no.length()!=0)
		map.put("client_ref_no", client_ref_no);
		if(api.length()!=0)
		map.put("api", api);
		setList(BTEWSService.getRequestList(map));
	}
	public void onselect(WSRequestDTO select) {
		this.select = select;
	}
	
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public Integer getWs_req_no() {
		return ws_req_no;
	}
	public void setWs_req_no(Integer ws_req_no) {
		this.ws_req_no = ws_req_no;
	}
	public String getClient_ref_no() {
		return client_ref_no;
	}
	public void setClient_ref_no(String client_ref_no) {
		this.client_ref_no = client_ref_no;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	
	public List<WSRequestDTO> getList() {
		return list;
	}
	public void setList(List<WSRequestDTO> list) {
		this.list = list;
	}
	public WSRequestDTO getSelect() {
		return select;
	}
	public void setSelect(WSRequestDTO select) {
		this.select = select;
	}
}
