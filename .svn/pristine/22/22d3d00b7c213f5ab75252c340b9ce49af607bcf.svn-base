package org.bte.bean.ws;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.bte.framework.ws.BTEWSService;
import org.bte.framework.ws.WSServiceDTO;
@ManagedBean ( name = "APIList" )
@ViewScoped
public class APIList {

	private List<WSServiceDTO> list = new ArrayList<WSServiceDTO>();

	BTEWSService ws = new BTEWSService();
	public APIList() {
		setList(ws.getServiceList(null));
	}
	public List<WSServiceDTO> getList() {
		return list;
	}
	public void setList(List<WSServiceDTO> list) {
		this.list = list;
	}
}
