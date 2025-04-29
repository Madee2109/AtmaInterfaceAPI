package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.bte.framework.ws.JSONUtil;
import org.bte.framework.ws.WSRequestDTO;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;

public class LabTestMaster extends BTEWSInterfaceDBSelectQuery{



	public void run() {
	
		try {
			
			String sql="";
			sql="SELECT m.lab_id AS lab_test_code, m.lab_node AS lab_test_name ,p.lab_node AS lab_group_name "
					+ " FROM tb_lab_tests_mtr m,tb_lab_tests_mtr p "
					+ " WHERE p.lab_id = m.lab_parentid AND m.lab_active =1 AND m.lab_type = 1 ";
			
		Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
		PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet  rs = stmt.executeQuery();
			 JSONArray jarr =	converttoStringList(finaljson, "lab_test_master_list", rs);
			sql="SELECT prop_name AS test_prop_name,prop_unit AS test_prop_unit,prop_normalvalue AS test_prop_normal,prop_id AS test_prop_code"
					+ " FROM tb_lab_test_properties "
					+ " WHERE prop_status = 1 AND prop_lab_id = ? ORDER BY prop_sequence ";
			for(int i=0;i<jarr.length();i++) {
				JSONObject ob=jarr.getJSONObject(i);
				 stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ob.getInt("lab_test_code"));
				  rs = stmt.executeQuery();
				  converttoStringList(ob, "lab_test_prop_list", rs);
				
			}
			
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}



}
