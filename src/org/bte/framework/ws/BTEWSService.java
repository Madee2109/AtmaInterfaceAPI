package org.bte.framework.ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BTEWSService {

	static BTEWSManagerImpl wsman = new BTEWSManagerImpl();
	public static List<WSServiceDTO> getServiceList(Map<String,Object> map){
		return wsman.getServiceList(map);
	}
	public static List<WSRequestDTO> getRequestList(Map<String,Object> map){
		return wsman.getRequestList(map);
	}
	public static List<WSServiceDTO> getServiceList(int ws_service_id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ws_service_id", ws_service_id);
		return wsman.getServiceList(map);
	}
	public static List<WSServiceDTO> getServiceExample(int service_ex_id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ws_service_ex_id", service_ex_id);
		return wsman.getServiceListExample(map);
	}
	public static List<WSServiceDTO> getServiceListExample(int ws_service_id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ws_service_id", ws_service_id);
		return wsman.getServiceListExample(map);
	}
	public static List<WSParamDTO> getServiceParamList(int ws_service_id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ws_service_id", ws_service_id);
		return wsman.getServiceParamList(map);
	}
	public static List<WSServiceDTO> getWSAPI(String apifor){
		return wsman.getWSAPI(apifor);
	}
	public static  boolean saveWSRequest(WSRequestDTO obj) {
		return wsman.saveWSRequest(obj);
	}
	public static  boolean saveWSResponse(WSRequestDTO obj) {
		return wsman.saveWSResponse(obj);
	}
	public static boolean generatetoken(WSUserDTO userdto){
		return wsman.generatetoken(userdto);
	}
	public static Map<String,WSUserDTO> getActiveToken(){
		return wsman.getActiveToken();
	}
}
