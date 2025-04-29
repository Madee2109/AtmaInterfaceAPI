package org.bte.framework.ws.wsapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bte.framework.ws.BTEWSInterfaceDBSelectQuery;
import org.bte.framework.ws.ClientServerDBConnection;
import org.bte.framework.ws.JSONUtil;
import org.bte.framework.ws.WSRequestDTO;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

public class LabSampleMaster extends BTEWSInterfaceDBSelectQuery{

	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			String sql="";
			sql=sql+"SELECT sample_print_no AS lab_sample_code,sample_name AS lab_sample_name  FROM tb_lab_samples_mtr";
			Connection conn = ClientServerDBConnection.getConnection(reqdto.getUserdto());
			 Statement stmt = conn.createStatement();
			ResultSet  rs = stmt.executeQuery(sql);
		
			converttoStringList(finaljson, "lab_sample_master_list", rs);
			
			
		} catch (Exception e) {

			
			markError(e);
			
			
		}

		
	}
}
