package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.bte.framework.ws.WSRequestDTO;
import org.primefaces.shaded.json.JSONObject;

public class LabOrderGet extends BTEWSInterfaceDBSelectQuery{




	public void run() {
		// TODO Auto-generated method stub
		List list = new ArrayList();

		try {
			String sql="";
			int loh_id=0;
			if(!reqdto.getReq_json().isNull("loh_id")) {
				loh_id = reqdto.getReq_json().getInt("loh_id");
			}
			
			sql="SELECT loh_id, DATE_FORMAT(loh_date,'%Y-%m-%d %H:%i:%s') AS loh_date,enc_apptid AS appt_id "
					+ "FROM tb_lab_order_header l , tb_encounter e WHERE l.enc_id = e.enc_id AND loh_id = "+loh_id;
			Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			Statement stmt = conn.createStatement();
			//stmt.setInt(0, loh_id);
				ResultSet  rs = stmt.executeQuery(sql);
				JSONObject jarr =	converttoObject(finaljson, "lab_order_obj", rs);
			if(jarr!=null) {
				
				sql = "SELECT lab_id AS lab_order_test_code , lod_action AS lab_order_test_status ,lod_test_done AS lab_order_done "
						+ " FROM tb_lab_order_detail,tb_lab_tests_mtr  WHERE  lab_id = lod_test_id AND loh_id="+loh_id;
				
				 stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				converttoStringList(jarr, "lab_order_test_list", rs)	;
				sql = "SELECT DATE_FORMAT(lts_datetime,'%Y-%m-%d %H:%i:%s') AS lab_sample_taken_time,lts_name  AS lab_sample_code "
						+ " FROM tb_lab_test_sample WHERE lts_ref_id = "+loh_id;
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				converttoStringList(jarr, "lab_order_sample_list", rs)	;
			}
			
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}




}
