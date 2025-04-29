package org.bte.framework.ws;

import java.util.List;
import java.util.Map;

public class BTEWSManagerImpl {
	BTEWSDAOImpl wsdao = new BTEWSDAOImpl();
	public  List<WSRequestDTO> getRequestList(Map<String,Object> map){
		return wsdao.getRequestList(map);
	}
	public  List<WSServiceDTO> getServiceList(Map<String,Object> map){
		return wsdao.getServiceList(map);
	}
	public  List<WSServiceDTO> getServiceListExample(Map<String,Object> map){
		return wsdao.getServiceListExample(map);
	}
	public  List<WSServiceDTO> getWSAPI(String apifor){
		return wsdao.getWSAPI(apifor);
	}
	public  boolean saveWSRequest(WSRequestDTO obj) {
		return wsdao.saveWSRequest(obj);
	}
	public  boolean saveWSResponse(WSRequestDTO obj) {
		return wsdao.saveWSResponse(obj);
	}
	public  boolean generatetoken(WSUserDTO userdto){
		return wsdao.generatetoken(userdto);
	}
	public Map<String,WSUserDTO> getActiveToken(){
		return wsdao.getActiveToken();
	}
	public  List<WSParamDTO> getServiceParamList(Map<String,Object> map){
		return wsdao.getServiceParamList(map);
	}
}
