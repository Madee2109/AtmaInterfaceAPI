package org.bte.framework.ws.wsapi;

import java.util.HashMap;
import java.util.Map;

import org.bte.framework.ws.BTEWSInterfaceReport;
import org.bte.framework.ws.WSRequestDTO;
import org.primefaces.shaded.json.JSONObject;

public class LabResultPDF extends BTEWSInterfaceReport {

	
	public void run() {
		String name="LAB ALL TEST RESULT";
		 JSONObject req_json =reqdto.getReq_json(); ;
		if(!req_json.isNull("report_name"))
		{
			name = req_json.getString("report_name");
		}
		Map param = new HashMap();
		param.put("org_id", 2);
		
		param.put("LAB_ORDER_ID",req_json.getInt("loh_id"));
		generateReport("pdf", name, param);
		
	}

}
